package org.learn.controller;

import org.learn.domain.TUser;
import org.learn.domain.vo.QueryUserDto;
import org.learn.domain.vo.QueryUserVo;
import org.learn.service.ITUserService;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: frame
 * @description: 用户管理
 * @author: MiaoWei
 * @create: 2021-09-24 14:21
 **/
@RequestMapping("/system/user")
@Controller
public class UserController {
    @Autowired
    private ITUserService userService;

    /**
     * 首页
     *
     * @return {@link String}
     */
    @RequestMapping("/index")
    public String index() {
        return "/user/user";
    }

    /**
     * 查询
     *
     * @param dto dto
     * @return {@link PageBean}<{@link QueryUserVo}>
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageBean<QueryUserVo> query(QueryUserDto dto) {
        return userService.queryAll(dto);
    }

    /**
     * 删除
     *
     * @param id id
     * @return {@link AjaxResult}
     */
    @GetMapping("/del")
    @ResponseBody
    public AjaxResult remove(Long id) {
        return userService.remove(id);
    }

    /**
     * 保存或编辑
     *
     * @return {@link AjaxResult}
     */
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult saveOrEdit(TUser user) {
        return userService.save(user);
    }
}
