package org.learn.mapper;

import org.apache.ibatis.annotations.Param;
import org.learn.domain.TNavigationBar;
import org.learn.domain.vo.IndexNavigationListSideVo;

import java.util.List;

public interface TNavigationBarMapper
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTNavigationBarById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTNavigationBarByIds(Long[] ids);

    /**
     * 选择顶部导航列表
     *
     * @param typeId 类型id
     * @param naxIndexNavigation
     * @return {@link List}<{@link String}>
     */
    List<String> selectTopNavigationList(@Param("typeId") Integer typeId,@Param("limitCount") Integer naxIndexNavigation);

    /**
     * 选择侧导航列表
     *
     * @param typeId             类型id
     * @param naxIndexNavigation nax指数导航
     * @return {@link List}<{@link IndexNavigationListSideVo}>
     */
    List<IndexNavigationListSideVo> selectSideNavigationList(@Param("typeId") Integer typeId,@Param("limitCount") Integer naxIndexNavigation);
}