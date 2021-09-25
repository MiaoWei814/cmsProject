package org.learn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.learn.domain.Article;
import org.learn.domain.ArticleSorts;
import org.learn.domain.dto.LoginUserDto;
import org.learn.domain.vo.ArticleResultBrowseVo;
import org.learn.domain.vo.ArticleSortsVo;
import org.learn.mapper.ArticleMapper;
import org.learn.service.IArticleService;
import org.learn.util.AjaxResult;
import org.learn.util.FreeMarkerUtil;
import org.learn.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: frame
 * @description: 实现类
 * @author: MiaoWei
 * @create: 2021-09-17 17:56
 **/
@Service
public class ArticleImpl implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 找到列表
     *
     * @return {@link List}<{@link Article}>
     */
    @Override
    public PageBean<Article> findList(Article article) {
        List<Article> list = articleMapper.findList(article);
        Integer totals = articleMapper.selectCount(article);
        return new PageBean<>(totals, list);
    }

    /**
     * 删除通过id
     *
     * @param id  id
     * @param req
     */
    @Override
    public AjaxResult removeById(Long id, HttpServletRequest req) {
        Article article = articleMapper.queryById(id);
        //删除随机生成的HTML
        String path = req.getServletContext().getRealPath("\\");
        File file = new File(path, article.getUrl());
        if (file.exists()) {
            file.delete();
        }
        //删除内容中的图片
        String content = article.getContent();
        Document doc = Jsoup.parse(content);
        Elements links = doc.select("img");
        for (Element link : links) {
            String src = link.attr("src");
            File imgFile = new File(path, src);
            if (imgFile.exists()) {
                imgFile.delete();
            }
        }
        //删除数据
        int delById = articleMapper.delById(id);

        if (delById > 0) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error("删除失败");
        }
    }

    /**
     * 保存
     *
     * @param article 文章
     * @param req     请求
     * @return {@link AjaxResult}
     * @throws Exception 异常
     */
    @Override
    public AjaxResult save(Article article, HttpServletRequest req) throws Exception {
        //不能空白提交
        if (StrUtil.isBlank(article.getTitle())) {
            return AjaxResult.error("文章标题不能为空");
        }
        if (StrUtil.isBlank(article.getContent())) {
            return AjaxResult.error("文章内容不能为空");
        }

        //无论编辑还是添加,都是修改了数据那么模板也要更新
        boolean isFlag;
        //添加数据
        if (article.getId() == null) {
            //先生成获取id,然后在生成模板再修改
            if (articleMapper.add(article) > 0) {
                //生成模板
                setTemplateAndGen(article, req);
            }
            //在调用修改
            isFlag = articleMapper.edit(article) > 0;
        } else {
            //编辑
            Article selectsOne = articleMapper.queryById(article.getId());
            if (BeanUtil.isEmpty(selectsOne)) {
                throw new RuntimeException("该记录不存在,不能编辑");
            }
            //查询url是否存在,不存在则不创建
            if (CharSequenceUtil.isNotEmpty(selectsOne.getUrl())) {
                //编辑之前必先删除
                String path = req.getServletContext().getRealPath("\\");
                File file = new File(path, selectsOne.getUrl());
                if (file.exists()) {
                    file.delete();
                }
            }

            //生成模板
            setTemplateAndGen(article, req);
            isFlag = articleMapper.edit(article) > 0;
        }

        if (isFlag) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error("操作失败");
        }
    }

    /**
     * set模板和创建
     *
     * @param article 文章
     * @param req     要求的事情
     * @throws Exception 异常
     */
    private void setTemplateAndGen(Article article, HttpServletRequest req) throws Exception {
        String templatePath = req.getServletContext().getRealPath("\\static\\templates");
        String templateName = "article.ftl";
        String genFilePath = FreeMarkerUtil.generateTemplate(templatePath, templateName, article);
        article.setUrl(genFilePath);
    }

    /**
     * 查询分类文章
     */
    @Override
    public ArticleSortsVo articleQuery() {
        //技术文章
        List<ArticleSorts> technologys = Collections.emptyList();
        //行业新闻
        List<ArticleSorts> industry = Collections.emptyList();
        //学科咨询
        List<ArticleSorts> subject = Collections.emptyList();

        ArticleSortsVo vo = new ArticleSortsVo();
        vo.setTechnology(technologys).setTechnology(industry).setSubject(subject);

        //查询所有的文章
        List<ArticleSorts> findCountList = articleMapper.querySortArticles();
        if (CollectionUtils.isEmpty(findCountList)) {
            return vo;
        }
        //技术文章
        List<ArticleSorts> technologySortsList = findCountList.stream().filter(x -> x.getTypeId().compareTo(1) == 0).limit(5).collect(Collectors.toList());
        //行业新闻
        List<ArticleSorts> industrySortsList = findCountList.stream().filter(x -> x.getTypeId().compareTo(2) == 0).limit(5).collect(Collectors.toList());
        //学科咨询
        List<ArticleSorts> subjectSortsList = findCountList.stream().filter(x -> x.getTypeId().compareTo(3) == 0).limit(5).collect(Collectors.toList());

        vo.setTechnology(technologySortsList).setIndustry(industrySortsList).setSubject(subjectSortsList);
        return vo;
    }

    /**
     * 文章浏览数
     *
     * @param id
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult articleBrowseCount(Long id) {
        //查询数据库
        Article article = articleMapper.queryById(id);
        if (BeanUtil.isEmpty(article)) {
            return AjaxResult.error("暂无该文章");
        }
        Integer anInt = Convert.toInt(article.getClickCount(), 0);
        //点击+1
        article.setClickCount(anInt + 1);
        //修改
        Integer edit = articleMapper.edit(article);
        if (edit > 0) {
            return AjaxResult.success(new ArticleResultBrowseVo(article.getClickCount()));
        }
        return AjaxResult.error("次数浏览出现错误!");
    }
}
