package org.learn.service;

import org.learn.domain.Slide;
import org.learn.domain.dto.SlideDto;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 轮播图接口
 *
 * @author MiaoDaWei
 * @date 2021/09/22
 */
public interface ISlideService {


    /**
     * 找到所有
     *
     * @param dto dto
     * @return {@link PageBean}<{@link Slide}>
     */
    PageBean<Slide> findAll(SlideDto dto);

    /**
     * 保存
     *
     * @param slide 幻灯片
     * @param request
     * @param photo
     * @return {@link AjaxResult}
     */
    AjaxResult save(Slide slide, HttpServletRequest request, MultipartFile photo) throws IOException;

    /**
     * 删除
     *
     * @param id      id
     * @param request 请求
     * @return {@link AjaxResult}
     */
    AjaxResult remove(@RequestParam Long id, HttpServletRequest request);

    /**
     * 选择旋转木马
     *
     * @return {@link List}<{@link Slide}>
     */
    List<Slide> selectCarousel();
}
