package org.learn.controller;

import org.learn.domain.Article;
import org.learn.domain.ArticleType;
import org.learn.domain.vo.ArticleSortsVo;
import org.learn.service.IArticleService;
import org.learn.service.ITArticleTypeService;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: frame
 * @description: 文章管理
 * @author: MiaoWei
 * @create: 2021-09-17 17:21
 **/
@Controller
@RequestMapping("/system/article")
public class ArticleController {
    @Autowired
    private IArticleService articleService;
    @Autowired
    private ITArticleTypeService articleTypeService;

    /**
     * 后台页面
     *
     * @return {@link ModelAndView}
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        //前端查询选择框的文章类型查询
        List<ArticleType> list = articleTypeService.findAll();
        view.addObject("types", list);
        //这是文章管理页面跳转
        view.setViewName("/article/article");
        return view;
    }

    /**
     * 查询列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageBean<Article> queryList(Article article) {
        return articleService.findList(article);
    }

    /**
     * 删除数据
     *
     * @return {@link AjaxResult}
     */
    @RequestMapping("/del")
    @ResponseBody
    public AjaxResult delData(@RequestParam(required = false) Long id, HttpServletRequest req) {
        return articleService.removeById(id, req);
    }

    /**
     * 保存和编辑
     *
     * @param article 文章
     * @return {@link AjaxResult}
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public AjaxResult save(Article article, HttpServletRequest req) throws Exception {
        return articleService.save(article, req);
    }


}
