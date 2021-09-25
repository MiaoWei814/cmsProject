package org.learn.controller;

import org.learn.domain.dto.LoginUserDto;
import org.learn.service.ISlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @program: frame
 * @description: 系统后台
 * @author: MiaoWei
 * @create: 2021-09-23 20:54
 **/
@Controller
@RequestMapping("/system")
public class SystemController {
    @Autowired
    private ISlideService slideService;

    @RequestMapping("/index")
    public String index(){
        //跳转首页
        return "index";
    }

    @RequestMapping("/quit")
    public String quitOut(HttpSession session){
        //退出清除session,然后重定向
        session.invalidate();
        return "redirect:/system/index";
    }
}
