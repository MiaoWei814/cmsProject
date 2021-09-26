package org.learn.service;

import org.learn.domain.Faq;
import org.learn.domain.dto.FaqQueryListDto;
import org.learn.domain.dto.FaqQuerySaveDto;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author MiaoWei
 * @date 2021-09-26
 */
public interface IFaqService 
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
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteFaqByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteFaqById(Long id);

    /**
     * 查询页面
     *
     * @param dto dto
     * @return {@link PageBean}<{@link Faq}>
     */
    PageBean<Faq> queryPage(FaqQueryListDto dto);

    /**
     * 保存
     *
     * @param dto dto
     * @return {@link AjaxResult}
     */
    AjaxResult save(FaqQuerySaveDto dto);

    /**
     * 删除
     *
     * @param id      id
     * @param request 请求
     * @return {@link AjaxResult}
     */
    AjaxResult del(Long id, HttpServletRequest request);

    /**
     * 索引的查询列表
     *
     * @return {@link AjaxResult}
     */
    AjaxResult indexQueryList();
}