package org.learn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.text.CharSequenceUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.learn.domain.Faq;
import org.learn.domain.dto.FaqQueryListDto;
import org.learn.domain.dto.FaqQuerySaveDto;
import org.learn.exception.CMSRuntimeException;
import org.learn.mapper.FaqMapper;
import org.learn.service.IFaqService;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Service
public class FaqServiceImpl implements IFaqService {
    @Autowired
    private FaqMapper faqMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Faq selectFaqById(Long id) {
        return faqMapper.selectFaqById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param faq 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Faq> selectFaqList(Faq faq) {
        return faqMapper.selectFaqList(faq);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param faq 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFaq(Faq faq) {
        return faqMapper.insertFaq(faq);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param faq 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFaq(Faq faq) {
        return faqMapper.updateFaq(faq);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteFaqByIds(Long[] ids) {
        return faqMapper.deleteFaqByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteFaqById(Long id) {
        return faqMapper.deleteFaqById(id);
    }

    /**
     * 查询页面
     *
     * @param dto dto
     * @return {@link PageBean}<{@link Faq}>
     */
    @Override
    public PageBean<Faq> queryPage(FaqQueryListDto dto) {
        List<Faq> allList = faqMapper.queryPage(dto);
        dto.setCurrentPage(null).setPageSize(null);
        int count = faqMapper.queryPage(dto).size();
        return new PageBean<>(count, allList);
    }

    /**
     * 保存
     *
     * @param dto dto
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult save(FaqQuerySaveDto dto) {
        boolean isFlag;
        try {
            if (CharSequenceUtil.isEmpty(dto.getTitle())) {
                throw new CMSRuntimeException("标题不能为空!");
            }
            if (CharSequenceUtil.isEmpty(dto.getContent())) {
                throw new CMSRuntimeException("文章内容不能为空!");
            }
        } catch (CMSRuntimeException e) {
            return AjaxResult.error(e.getMessage());
        }
        //添加
        if (dto.getId() == null) {
            Faq faq = new Faq().setTitle(dto.getTitle()).setContent(dto.getContent());
            isFlag = faqMapper.insertFaq(faq) > 0;
        } else {
            //编辑
            Faq faq = faqMapper.selectFaqById(Convert.toLong(dto.getId()));
            if (BeanUtil.isEmpty(faq)) {
                return AjaxResult.error("数据不存在,不能进行编辑等相关操作!");
            }
            faq.setContent(dto.getContent()).setTitle(dto.getTitle());
            isFlag = faqMapper.updateFaq(faq) > 0;
        }

        if (!isFlag) {
            return AjaxResult.error("操作失败!");
        }
        return AjaxResult.success();
    }

    /**
     * 删除
     *
     * @param id      id
     * @param request 请求
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult del(Long id, HttpServletRequest request) {
        Faq faq = faqMapper.selectFaqById(id);
        if (BeanUtil.isEmpty(faq)) {
            return AjaxResult.error("不存在该数据,请重新检查下!");
        }
        String realPath = request.getServletContext().getRealPath("\\");
        //删除内容中的图片
        String content = faq.getContent();
        Document doc = Jsoup.parse(content);
        Elements links = doc.select("img");
        for (Element link : links) {
            String src = link.attr("src");
            File imgFile = new File(realPath, src);
            if (imgFile.exists()) {
                imgFile.delete();
            }
        }
        //删除数据
        int delById = faqMapper.deleteFaqById(id);
        if (delById > 0) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error("删除失败");
        }
    }

    /**
     * 首页常见问题
     *
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult indexQueryList() {
        List<Faq> faqList = faqMapper.selectFaqList(new Faq().setCreateDate(null));
        return AjaxResult.success(faqList);
    }
}