package org.learn.service.impl;

import org.learn.domain.TNavigationTypeBar;
import org.learn.mapper.TNavigationTypeBarMapper;
import org.learn.service.ITNavigationTypeBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TNavigationTypeBarServiceImpl implements ITNavigationTypeBarService
{
    @Autowired
    private TNavigationTypeBarMapper tNavigationTypeBarMapper;

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
}