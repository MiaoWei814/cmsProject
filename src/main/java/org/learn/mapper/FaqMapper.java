package org.learn.mapper;

import org.learn.domain.Faq;
import org.learn.domain.dto.FaqQueryListDto;

import java.util.List;

public interface FaqMapper
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Faq selectFaqById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param faq 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Faq> selectFaqList(Faq faq);

    /**
     * 新增【请填写功能名称】
     * 
     * @param faq 【请填写功能名称】
     * @return 结果
     */
    public int insertFaq(Faq faq);

    /**
     * 修改【请填写功能名称】
     * 
     * @param faq 【请填写功能名称】
     * @return 结果
     */
    public int updateFaq(Faq faq);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteFaqById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFaqByIds(Long[] ids);

    List<Faq> queryPage(FaqQueryListDto dto);
}