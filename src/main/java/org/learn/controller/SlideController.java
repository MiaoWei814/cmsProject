package org.learn.controller;

import org.learn.domain.Slide;
import org.learn.domain.dto.SlideDto;
import org.learn.service.ISlideService;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: frame
 * @description: 轮播图管理
 * @author: MiaoWei
 * @create: 2021-09-22 19:59
 **/
@Controller
@RequestMapping("/system/slide")
public class SlideController {
    @Autowired
    private ISlideService slideService;
    /**
     * 首页
     *
     * @return {@link String}
     */
    @RequestMapping("/index")
    public String index() {
        return "/side/side";
    }

    /**
     * 列表
     *
     * @param dto dto
     * @return {@link PageBean}<{@link Slide}>
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageBean<Slide> list(SlideDto dto) {
        return slideService.findAll(dto);
    }

    /**
     * 保存跟编辑
     *
     * @param slide 幻灯片
     * @return {@link AjaxResult}
     */
    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(Slide slide, MultipartFile photo,HttpServletRequest request) throws IOException {
        return slideService.save(slide, request, photo);
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
        return slideService.remove(id, request);
    }
}
