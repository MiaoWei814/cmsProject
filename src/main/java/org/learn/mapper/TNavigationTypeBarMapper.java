package org.learn.mapper;

import org.learn.domain.TNavigationBar;
import org.learn.domain.TNavigationTypeBar;
import org.learn.domain.dto.NavigationListDto;
import org.learn.domain.vo.TNavigationBarQueryListVo;

import java.util.List;

public interface TNavigationTypeBarMapper
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTNavigationTypeBarById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTNavigationTypeBarByIds(Long[] ids);

    /**
     * 选择所有列表
     *
     * @param dto dto
     * @return {@link List}<{@link TNavigationBar}>
     */
    List<TNavigationBarQueryListVo> selectAllList(NavigationListDto dto);
}