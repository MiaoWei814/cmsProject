package org.learn.controller;

import org.learn.domain.dto.FeedbacksQueryListDto;
import org.learn.domain.vo.FeedbacksQueryListVo;
import org.learn.service.IFeedbacksService;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: oneProject
 * @description: 好评如潮
 * @author: MiaoWei
 * @create: 2021-09-26 15:04
 **/
@Controller
@RequestMapping("/system/feedbacks")
public class FeedbacksController {
    @Autowired
    private IFeedbacksService feedbacksService;

    /**
     * 首页
     *
     * @return {@link String}
     */
    @RequestMapping("/index")
    public String index() {
        return "feedbacks/feedbacks";
    }

    /**
     * 查询页面
     *
     * @param fe 菲
     * @return {@link PageBean}<{@link FeedbacksQueryListVo}>
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageBean<FeedbacksQueryListVo> queryPage(FeedbacksQueryListDto fe) {
        return feedbacksService.queryPage(fe);
    }

    /**
     * 保存
     *
     * @param id      id
     * @param file    文件
     * @param enable  启用
     * @param request 请求
     * @return {@link AjaxResult}
     * @throws IOException ioexception
     */
    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(Integer id, MultipartFile file, Integer enable, HttpServletRequest request) throws IOException {
        return feedbacksService.save(id,file, enable, request);
    }

    /**
     * 删除
     *
     * @param id      id
     * @param request 请求
     * @return {@link AjaxResult}
     * @throws IOException ioexception
     */
    @RequestMapping("/del")
    @ResponseBody
    public AjaxResult del(Integer id, HttpServletRequest request) throws IOException {
        return feedbacksService.del(id,request);
    }


}
