package org.learn.service;

import org.learn.domain.TNavigationBar;
import org.learn.domain.TNavigationTypeBar;
import org.learn.domain.dto.NavigationListDto;
import org.learn.domain.vo.TNavigationBarQueryListVo;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface ITNavigationTypeBarService
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TNavigationTypeBar selectTNavigationTypeBarById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tNavigationTypeBar 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TNavigationTypeBar> selectTNavigationTypeBarList(TNavigationTypeBar tNavigationTypeBar);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tNavigationTypeBar 【请填写功能名称】
     * @return 结果
     */
    public int insertTNavigationTypeBar(TNavigationTypeBar tNavigationTypeBar);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tNavigationTypeBar 【请填写功能名称】
     * @return 结果
     */
    public int updateTNavigationTypeBar(TNavigationTypeBar tNavigationTypeBar);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTNavigationTypeBarByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTNavigationTypeBarById(Long id);

    /**
     * 选择列表
     *
     * @param dto dto
     * @return {@link PageBean}<{@link TNavigationBar}>
     */
    PageBean<TNavigationBarQueryListVo> selectList(NavigationListDto dto);

    /**
     * 保存
     *
     * @param dto  dto
     * @param file 文件
     * @param request
     * @return {@link AjaxResult}
     */
    AjaxResult save(NavigationListDto dto, MultipartFile file, HttpServletRequest request) throws IOException;

    /**
     * 删除
     *
     * @param id      id
     * @param request 请求
     * @return {@link AjaxResult}
     */
    AjaxResult remove(Long id, HttpServletRequest request);
}