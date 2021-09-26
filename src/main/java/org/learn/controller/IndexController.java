package org.learn.controller;

import org.learn.domain.Slide;
import org.learn.domain.vo.ArticleSortsVo;
import org.learn.service.IArticleService;
import org.learn.service.ISlideService;
import org.learn.service.ITNavigationBarService;
import org.learn.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: frame
 * @description: 首页相关的web访问
 * @author: MiaoWei
 * @create: 2021-09-17 16:50
 **/
@Controller
@RequestMapping("/client")
public class IndexController {
    @Autowired
    private ISlideService slideService;
    @Autowired
    private IArticleService articleService;
    @Autowired
    private ITNavigationBarService NavigationBarService;

    /**
     * 找到所有轮播图
     *
     * @return {@link List}<{@link Slide}>
     */
    @RequestMapping("/indexCarousel")
    @ResponseBody
    public List<Slide> findAll() {
        return slideService.selectCarousel();
    }

    /**
     * 首页的文章
     */
    @RequestMapping("/articleList")
    @ResponseBody
    public ArticleSortsVo article() {
        return articleService.articleQuery();
    }

    /**
     * 首页文章浏览次数
     *
     * @return {@link ArticleSortsVo}
     */
    @RequestMapping("/addViews")
    @ResponseBody
    public AjaxResult viewCount(@RequestParam Long id) {
        return articleService.articleBrowseCount(id);
    }

    @RequestMapping("/Navigation")
    @ResponseBody
    public AjaxResult navigation(){
        return NavigationBarService.navigationList();
    }
}
