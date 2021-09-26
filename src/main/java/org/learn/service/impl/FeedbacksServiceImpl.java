package org.learn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.file.FileNameUtil;
import org.learn.domain.Feedbacks;
import org.learn.domain.dto.FeedbacksQueryListDto;
import org.learn.domain.vo.FeedbacksQueryListVo;
import org.learn.mapper.FeedbacksMapper;
import org.learn.service.IFeedbacksService;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.learn.util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbacksServiceImpl implements IFeedbacksService {
    @Autowired
    private FeedbacksMapper feedbacksMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Feedbacks selectFeedbacksById(Long id) {
        return feedbacksMapper.selectFeedbacksById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param feedbacks 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Feedbacks> selectFeedbacksList(Feedbacks feedbacks) {
        return feedbacksMapper.selectFeedbacksList(feedbacks);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param feedbacks 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFeedbacks(Feedbacks feedbacks) {
        return feedbacksMapper.insertFeedbacks(feedbacks);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param feedbacks 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFeedbacks(Feedbacks feedbacks) {
        return feedbacksMapper.updateFeedbacks(feedbacks);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteFeedbacksByIds(Long[] ids) {
        return feedbacksMapper.deleteFeedbacksByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteFeedbacksById(Long id) {
        return feedbacksMapper.deleteFeedbacksById(id);
    }

    /**
     * 查询页面
     *
     * @param fe 菲
     * @return {@link PageBean}<{@link FeedbacksQueryListVo}>
     */
    @Override
    public PageBean<FeedbacksQueryListVo> queryPage(FeedbacksQueryListDto fe) {
        List<FeedbacksQueryListVo> all = feedbacksMapper.queryPage(fe);
        fe.setPageSize(null).setCurrentPage(null);
        int count = feedbacksMapper.queryPage(fe).size();
        return new PageBean<>(count, all);
    }

    /**
     * 保存
     *
     * @param file    文件
     * @param enable  启用
     * @param request
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult save(Integer id, MultipartFile file, Integer enable, HttpServletRequest request) throws IOException {
        boolean isFlag = false;
        if (file == null) {
            return AjaxResult.error("图片不能为空!");
        }
        String filename = file.getOriginalFilename();
        String suffix = FileNameUtil.getSuffix(filename);
        if (!"png".equals(suffix)) {
            return AjaxResult.error("图片上传只能是PNG格式的!");
        }
        //添加
        if (id == null) {
            String uploadFile = UploadFileUtil.uploadFile(file, request);
            isFlag = feedbacksMapper.insertFeedbacks(new Feedbacks().setName(filename).setPath(uploadFile).setEnable(enable)) > 0;
        } else {
            //获取删除
            if (getResult(id, request)) return AjaxResult.error("获取数据失败,不能进行删除!");
            String uploadFile = UploadFileUtil.uploadFile(file, request);
            isFlag = feedbacksMapper.insertFeedbacks(new Feedbacks().setName(filename).setPath(uploadFile).setEnable(enable)) > 0;
        }
        if (!isFlag) {
            return AjaxResult.error("操作失败!");
        }
        return AjaxResult.success();
    }

    /**
     * 删除
     *
     * @param id      id
     * @param request 请求
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult del(Integer id, HttpServletRequest request) {
        if (getResult(id, request)) return AjaxResult.error("获取数据失败,不能进行删除!");
        int feedbacks1 = feedbacksMapper.deleteFeedbacksById(Convert.toLong(id));
        if (feedbacks1 > 0) {
            return AjaxResult.error("删除失败!");
        }
        return AjaxResult.success();
    }

    /**
     * 索引的查询列表
     *
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult indexQueryList() {
        List<Feedbacks> feedbacks = feedbacksMapper.selectFeedbacksList(new Feedbacks());
        List<String> collect = feedbacks.stream().sorted(Comparator.comparing(Feedbacks::getId).reversed()).map(Feedbacks::getPath).limit(5).collect(Collectors.toList());
        return AjaxResult.success(collect);
    }

    /**
     * 获取结果
     *
     * @param id      id
     * @param request 请求
     * @return boolean
     */
    private boolean getResult(Integer id, HttpServletRequest request) {
        Feedbacks feedbacks = feedbacksMapper.selectFeedbacksById(Convert.toLong(id));
        if (BeanUtil.isEmpty(feedbacks)) {
            return true;
        }
        //删除文件
        String path = feedbacks.getPath();
        File file1 = new File(request.getServletContext().getRealPath("\\"), path);
        if (file1.exists()) {
            file1.delete();
        }
        return false;
    }
}