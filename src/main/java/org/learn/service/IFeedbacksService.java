package org.learn.service;

import org.learn.domain.Feedbacks;
import org.learn.domain.dto.FeedbacksQueryListDto;
import org.learn.domain.vo.FeedbacksQueryListVo;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface IFeedbacksService
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
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteFeedbacksByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteFeedbacksById(Long id);

    /**
     * 查询页面
     *
     * @param fe 菲
     * @return {@link PageBean}<{@link FeedbacksQueryListVo}>
     */
    PageBean<FeedbacksQueryListVo> queryPage(FeedbacksQueryListDto fe);

    /**
     * 保存
     *
     * @param file   文件
     * @param enable 启用
     * @param request
     * @return {@link AjaxResult}
     */
    AjaxResult save(Integer id, MultipartFile file, Integer enable, HttpServletRequest request) throws IOException;

    /**
     * 删除
     *
     * @param id      id
     * @param request 请求
     * @return {@link AjaxResult}
     */
    AjaxResult del(Integer id, HttpServletRequest request);

    AjaxResult indexQueryList();
}