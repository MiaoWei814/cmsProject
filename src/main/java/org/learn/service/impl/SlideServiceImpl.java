package org.learn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.learn.domain.Slide;
import org.learn.domain.dto.SlideDto;
import org.learn.mapper.SlideMapper;
import org.learn.service.ISlideService;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.learn.util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: frame
 * @description: 轮播图的实现类
 * @author: MiaoWei
 * @create: 2021-09-22 20:40
 **/
@Service
public class SlideServiceImpl implements ISlideService {
    @Autowired
    private SlideMapper slideMapper;
    /**
     * 找到所有
     *
     * @param dto dto
     * @return {@link PageBean}<{@link Slide}>
     */
    @Override
    public PageBean<Slide> findAll(SlideDto dto) {
        //查询所有
        List<Slide> all= slideMapper.findAll(dto);
        all = all.stream().sorted(Comparator.comparing(Slide::getId).reversed()).collect(Collectors.toList());
        //查询总数
        dto.setCurrentPage(null).setPageSize(null);
        Integer count = slideMapper.findAll(dto).size();
        return new PageBean<>(count, all);
    }

    /**
     * 保存或修改
     *
     * @param slide 幻灯片
     * @param request
     * @param photo
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult save(Slide slide, HttpServletRequest request, MultipartFile photo) throws IOException {
        boolean isFlag;
        if (BeanUtil.isEmpty(slide)) {
            return AjaxResult.error("请求参数不能为空");
        }
        //id不存在表示是新增
        if (slide.getId() == null) {
            if (photo==null) {
                return AjaxResult.error("请上传轮播图");
            }

            //上传文件
            String uploadFile = UploadFileUtil.uploadFile(photo, request);
            //添加数据库
            slide.setName(photo.getOriginalFilename()).setPath(uploadFile);
            isFlag = slideMapper.insert(slide) > 0;
        }else{
            //编辑
            //获取存在的图片然后删除,然后将上传的图片进行上传到本地,将地址进行替换
            Slide queryOneSlide=slideMapper.queryById(slide.getId());
            if (BeanUtil.isEmpty(queryOneSlide)) {
                return AjaxResult.error("不存在该数据,无法对其进行操作");
            }
            //获取地址删除
            if (photo != null) {
                deleteFile(queryOneSlide.getPath(), request);
                //获取新的文件
                String uploadFile = UploadFileUtil.uploadFile(photo, request);
                queryOneSlide.setPath(uploadFile).setName(photo.getOriginalFilename());
            }
            queryOneSlide.setEnable(slide.getEnable());
            isFlag = slideMapper.update(queryOneSlide) > 0;
        }

        if (isFlag) {
            return AjaxResult.success();
        }else{
            return AjaxResult.error("操作失败");
        }
    }

    /**
     * 删除文件
     *
     * @param path    路径
     * @param request 请求
     */
    public void deleteFile(String path, HttpServletRequest request) {
        String oldPath = request.getServletContext().getRealPath("\\") + path;
        File file = new File(oldPath);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 删除
     *
     * @param id      id
     * @param request 请求
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult remove(Long id, HttpServletRequest request) {
        Slide query = slideMapper.queryById(id);
        if (BeanUtil.isEmpty(query)) {
            return AjaxResult.error("暂无该数据");
        }
        Integer dele=slideMapper.deleteById(query.getId());
        if (dele > 0) {
            deleteFile(query.getPath(), request);
            return AjaxResult.success();
        }

        return AjaxResult.error("删除失败");
    }

    @Override
    public List<Slide> selectCarousel() {
        return slideMapper.selectCarousel();
    }

}
