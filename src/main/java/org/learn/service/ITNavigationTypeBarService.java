package org.learn.service;

import org.learn.domain.TNavigationTypeBar;

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
}