package org.learn.controller;

import org.learn.domain.Faq;
import org.learn.domain.dto.FaqQueryListDto;
import org.learn.domain.dto.FaqQuerySaveDto;
import org.learn.service.IFaqService;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: oneProject
 * @description: 常见问题
 * @author: MiaoWei
 * @create: 2021-09-26 13:23
 **/
@Controller
@RequestMapping("/system/problem")
public class ProblemController {
    @Autowired
    private IFaqService facqService;

    /**
     * 首页
     *
     * @return {@link String}
     */
    @RequestMapping("/index")
    public String index(){
        return "problem/problem";
    }

    /**
     * 查询页面
     *
     * @param dto dto
     * @return {@link PageBean}<{@link Faq}>
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageBean<Faq> queryPage(FaqQueryListDto dto){
        return facqService.queryPage(dto);
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(FaqQuerySaveDto dto){
        return facqService.save(dto);
    }

    /**
     * 删除
     *
     * @param dto dto
     * @return {@link AjaxResult}
     */
    @RequestMapping("/del")
    @ResponseBody
    public AjaxResult remove(Long id, HttpServletRequest request){
        return facqService.del(id,request);
    }

}
