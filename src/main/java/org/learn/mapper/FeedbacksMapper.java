package org.learn.mapper;

import org.learn.domain.Feedbacks;
import org.learn.domain.dto.FeedbacksQueryListDto;
import org.learn.domain.vo.FeedbacksQueryListVo;

import java.util.List;

public interface FeedbacksMapper
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Feedbacks selectFeedbacksById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param feedbacks 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Feedbacks> selectFeedbacksList(Feedbacks feedbacks);

    /**
     * 新增【请填写功能名称】
     * 
     * @param feedbacks 【请填写功能名称】
     * @return 结果
     */
    public int insertFeedbacks(Feedbacks feedbacks);

    /**
     * 修改【请填写功能名称】
     * 
     * @param feedbacks 【请填写功能名称】
     * @return 结果
     */
    public int updateFeedbacks(Feedbacks feedbacks);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteFeedbacksById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFeedbacksByIds(Long[] ids);

    /**
     * 查询页面
     *
     * @param fe 菲
     * @return {@link List}<{@link FeedbacksQueryListVo}>
     */
    List<FeedbacksQueryListVo> queryPage(FeedbacksQueryListDto fe);
}