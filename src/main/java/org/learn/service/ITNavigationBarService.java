package org.learn.service;

import org.learn.domain.TNavigationBar;
import org.learn.util.AjaxResult;

import java.util.List;

public interface ITNavigationBarService
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TNavigationBar selectTNavigationBarById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tNavigationBar 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TNavigationBar> selectTNavigationBarList(TNavigationBar tNavigationBar);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tNavigationBar 【请填写功能名称】
     * @return 结果
     */
    public int insertTNavigationBar(TNavigationBar tNavigationBar);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tNavigationBar 【请填写功能名称】
     * @return 结果
     */
    public int updateTNavigationBar(TNavigationBar tNavigationBar);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTNavigationBarByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTNavigationBarById(Long id);

    /**
     * 导航列表
     *
     * @return {@link AjaxResult}
     */
    AjaxResult navigationList();

}