package org.learn.controller;

import org.learn.domain.TUser;
import org.learn.domain.vo.QueryUserDto;
import org.learn.domain.vo.QueryUserVo;
import org.learn.service.ITUserService;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

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

    /**
     * 导出
     *
     * @param username 用户名
     * @return {@link AjaxResult}
     */
    @PostMapping("/exportExcel")
    public String export(ModelMap map, String username) throws Exception {
         return userService.export(username, map);
    }
    /**
     * 导入
     *
     * @return {@link AjaxResult}
     */
    @PostMapping("/import")
    @ResponseBody
    public AjaxResult importExcel(MultipartFile excel) throws Exception {
         return userService.importExcel(excel);
    }


}
