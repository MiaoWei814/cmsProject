package org.learn.service.impl;
import java.io.File;
import java.util.Date;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.text.CharSequenceUtil;
import org.learn.domain.TNavigationBar;
import org.learn.domain.TNavigationTypeBar;
import org.learn.domain.dto.NavigationListDto;
import org.learn.domain.vo.TNavigationBarQueryListVo;
import org.learn.exception.CMSRuntimeException;
import org.learn.mapper.TNavigationBarMapper;
import org.learn.mapper.TNavigationTypeBarMapper;
import org.learn.service.ITNavigationTypeBarService;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.learn.util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Service
public class TNavigationTypeBarServiceImpl implements ITNavigationTypeBarService
{
    @Autowired
    private TNavigationTypeBarMapper tNavigationTypeBarMapper;
    @Autowired
    private TNavigationBarMapper navigationBarMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public TNavigationTypeBar selectTNavigationTypeBarById(Long id)
    {
        return tNavigationTypeBarMapper.selectTNavigationTypeBarById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tNavigationTypeBar 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TNavigationTypeBar> selectTNavigationTypeBarList(TNavigationTypeBar tNavigationTypeBar)
    {
        return tNavigationTypeBarMapper.selectTNavigationTypeBarList(tNavigationTypeBar);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tNavigationTypeBar 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTNavigationTypeBar(TNavigationTypeBar tNavigationTypeBar)
    {
        return tNavigationTypeBarMapper.insertTNavigationTypeBar(tNavigationTypeBar);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tNavigationTypeBar 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTNavigationTypeBar(TNavigationTypeBar tNavigationTypeBar)
    {
        return tNavigationTypeBarMapper.updateTNavigationTypeBar(tNavigationTypeBar);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTNavigationTypeBarByIds(Long[] ids)
    {
        return tNavigationTypeBarMapper.deleteTNavigationTypeBarByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTNavigationTypeBarById(Long id)
    {
        return tNavigationTypeBarMapper.deleteTNavigationTypeBarById(id);
    }

    /**
     * 选择列表
     *
     * @param dto dto
     * @return {@link PageBean}<{@link TNavigationBar}>
     */
    @Override
    public PageBean<TNavigationBarQueryListVo> selectList(NavigationListDto dto) {
        List<TNavigationBarQueryListVo> queryAll=tNavigationTypeBarMapper.selectAllList(dto);
        dto.setCurrentPage(null).setPageSize(null);
        int count = tNavigationTypeBarMapper.selectAllList(dto).size();
        return new PageBean<>(count, queryAll);
    }

    /**
     * 保存
     *
     * @param dto  dto
     * @param file 文件
     * @param request
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult save(NavigationListDto dto, MultipartFile file, HttpServletRequest request) throws IOException {
        boolean isFlag = false;
        //数据校验
        try {
            if (BeanUtil.isEmpty(dto)) {
                throw new CMSRuntimeException("上传参数不能为空!");
            }
            if (CharSequenceUtil.isEmpty(dto.getName())) {
                throw new CMSRuntimeException("上传导航栏名称不能为空!");
            }
            if (Validator.isEmpty(dto.getTypeId())) {
                throw new CMSRuntimeException("请选择导航栏!");
            }
        } catch (CMSRuntimeException e) {
            return AjaxResult.error(e.getMessage());
        }
        //添加
        if (dto.getId() == null) {
            if (dto.getTypeId().compareTo(2L) == 0 && file==null) {
                return AjaxResult.error("请上传图标!");
            }
            String fileName=CharSequenceUtil.EMPTY;
            String uploadFilePath = CharSequenceUtil.EMPTY;
            //选择了侧边导航.解析文件
            if (dto.getTypeId().compareTo(2L) == 0) {
                //只能上传 IOC格式的
                fileName = file.getOriginalFilename();
                String suffix = FileNameUtil.getSuffix(fileName);
                if (!"ico".equals(suffix)) {
                    return AjaxResult.error("上传图标后缀只能为ICO");
                }
                //上传文件
                 uploadFilePath = UploadFileUtil.uploadFile(file, request);
            }
            TNavigationBar bar = new TNavigationBar();
            bar.setName(dto.getName());
            bar.setUrl(uploadFilePath);
            bar.setIcon(fileName);
            bar.setTypeId(dto.getTypeId());

            //添加
            isFlag=navigationBarMapper.insertTNavigationBar(bar)>0;
        }else{
            TNavigationBar bar = new TNavigationBar();
            bar.setName(dto.getName()).setId(bar.getId()).setTypeId(dto.getTypeId());
            String fileName;
            String uploadFilePath;
            //编辑
            TNavigationBar selectOne = navigationBarMapper.selectTNavigationBarById(Convert.toLong(dto.getId()));
            //先判断是否是侧边栏还是导航栏
            //侧边栏
            if (dto.getTypeId().compareTo(2L) == 0) {
                String url = selectOne.getUrl();
                //如果数据库有,前端传,进行替换 ,不传 保持
                //如果数据没有,前端传,添加,如果前端也不传 报错
                if (CharSequenceUtil.isNotEmpty(url)) {
                    if (file != null) {
                        //只能上传 IOC格式的
                        fileName = file.getOriginalFilename();
                        String suffix = FileNameUtil.getSuffix(fileName);
                        if (!"ico".equals(suffix)) {
                            return AjaxResult.error("上传图标后缀只能为ICO");
                        }
                        //替换
                        //1.获取原来的进行删除
                        deleteFile(url, request.getServletContext().getRealPath("\\"));
                        //2.获取新的
                         uploadFilePath = UploadFileUtil.uploadFile(file, request);
                        //3.数据库
                        bar.setName(fileName).setUrl(uploadFilePath);
                        isFlag = navigationBarMapper.updateTNavigationBar(bar) > 0;
                    }else{
                        //保持原样
                        isFlag = navigationBarMapper.updateTNavigationBar(bar) > 0;
                    }
                } else if (CharSequenceUtil.isEmpty(url)) {
                    if (file != null) {
                        //添加
                        //只能上传 IOC格式的
                        fileName = file.getOriginalFilename();
                        String suffix = FileNameUtil.getSuffix(fileName);
                        if (!"ico".equals(suffix)) {
                            return AjaxResult.error("上传图标后缀只能为ICO");
                        }
                        //替换
                        //1.获取原来的进行删除
                        deleteFile(url, request.getServletContext().getRealPath("\\"));
                        //2.获取新的
                        uploadFilePath = UploadFileUtil.uploadFile(file, request);
                        //3.数据库
                        bar.setName(fileName).setUrl(uploadFilePath);
                        isFlag = navigationBarMapper.updateTNavigationBar(bar) > 0;
                    }else {
                        return AjaxResult.error("请上传图标!");
                    }
                }
            }else{
                //导航栏
                //1.导航栏不准上传图标
                if (file != null) {
                    return AjaxResult.error("导航栏不能上传图标!");
                }
                //2.检查导航栏数据库,若存在,则删除
                String oneUrl = selectOne.getUrl();
                if (CharSequenceUtil.isNotEmpty(oneUrl)) {
                    deleteFile(oneUrl, request.getServletContext().getRealPath("\\"));
                }
                //3.修改
                bar.setIcon(null).setUrl(null);
                isFlag = navigationBarMapper.updateTNavigationBar(bar) > 0;
            }

        }
        if (!isFlag) {
            return AjaxResult.error("操作失败!");
        }
        // TODO: 2021/9/26 这里代码是可以优化的,但是为了省时间暂时先这样!
        return AjaxResult.success();
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
        TNavigationBar bar = navigationBarMapper.selectTNavigationBarById(id);
        if (BeanUtil.isEmpty(bar)) {
            return AjaxResult.error("数据不存在,不能重复操作!");
        }
        if (CharSequenceUtil.isNotEmpty(bar.getUrl())) {
            deleteFile(bar.getUrl(), request.getServletContext().getRealPath("\\"));
        }
        int byId = navigationBarMapper.deleteTNavigationBarById(id);
        if (byId > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.error("删除失败!");
    }
    /**
     * 删除文件
     *
     * @param urlPath     url路径
     * @param contextPath 上下文路径
     */
    private void deleteFile(String urlPath, String contextPath) {
        File file = new File(contextPath, urlPath);
        if (file.exists()) {
            file.delete();
        }
    }
}