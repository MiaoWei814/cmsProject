package org.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: oneProject
 * @description: 问题反馈
 * @author: MiaoWei
 * @create: 2021-09-26 16:16
 **/
@RequestMapping("/system/freeback")
@Controller
public class FeedbackController {

    /**
     * 首页
     *
     * @return {@link String}
     */
    @RequestMapping("/index")
    public String index() {
        return "feedbacks/feedbacks";
    }



}
