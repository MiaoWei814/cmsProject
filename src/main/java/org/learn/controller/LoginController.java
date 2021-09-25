package org.learn.controller;

import org.learn.domain.dto.LoginUserDto;
import org.learn.service.IArticleService;
import org.learn.service.ITUserService;
import org.learn.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: frame
 * @description: 登录
 * @author: MiaoWei
 * @create: 2021-09-23 20:37
 **/
@Controller
@RequestMapping("/system")
public class LoginController {
    @Autowired
    private IArticleService articleService;
    @Autowired
    private ITUserService userService;

    /**
     * 登录
     *
     * @return {@link String}
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 开始登录
     *
     * @param login    登录
     * @param session  会话
     * @param response 响应
     * @return {@link AjaxResult}
     * @throws Exception 异常
     */
    @RequestMapping("/startLogin")
    @ResponseBody
    public AjaxResult startLogin(LoginUserDto login, HttpSession session, HttpServletResponse response) throws Exception{
        return userService.startLogin(login, session, response);
    }

}
