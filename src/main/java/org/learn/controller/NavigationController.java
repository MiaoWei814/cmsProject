package org.learn.controller;

import org.learn.domain.TNavigationBar;
import org.learn.domain.TNavigationTypeBar;
import org.learn.domain.dto.NavigationListDto;
import org.learn.domain.vo.TNavigationBarQueryListVo;
import org.learn.service.ITNavigationTypeBarService;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @program: oneProject
 * @description: 导航栏
 * @author: MiaoWei
 * @create: 2021-09-26 09:35
 **/
@Controller
@RequestMapping("/system/navigation")
public class NavigationController {
    @Autowired
    private ITNavigationTypeBarService navigationTypeBarService;

    /**
     * 指向页面
     *
     * @param model 模型
     * @return {@link String}
     */
    @RequestMapping("/index")
    public String index(Model model) {
        //查询出导航栏类型
        List<TNavigationTypeBar> list = navigationTypeBarService.selectTNavigationTypeBarList(new TNavigationTypeBar());
        model.addAttribute("types", list);
        return "/navigation/navigation";
    }

    /**
     * 查询列表
     *
     * @param dto dto
     * @return {@link PageBean}<{@link TNavigationBar}>
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageBean<TNavigationBarQueryListVo> queryList(NavigationListDto dto) {
        return navigationTypeBarService.selectList(dto);
    }

    /**
     * 保存
     *
     * @param dto     dto
     * @param file    文件
     * @param request 请求
     * @return {@link AjaxResult}
     * @throws IOException ioexception
     */
    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(NavigationListDto dto, MultipartFile file, HttpServletRequest request) throws IOException {
        return  navigationTypeBarService.save(dto,file, request);
    }
    /**
     * 删除
     *
     * @param id      id
     * @param request 请求
     * @return {@link AjaxResult}
     * @throws IOException ioexception
     */
    @ResponseBody
    @RequestMapping("/remove")
    public AjaxResult remove(@RequestParam Long id, HttpServletRequest request) throws IOException {
        return navigationTypeBarService.remove(id, request);
    }
}
