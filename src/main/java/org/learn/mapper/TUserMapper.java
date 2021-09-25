package org.learn.mapper;

import org.apache.ibatis.annotations.Param;
import org.learn.domain.TUser;
import org.learn.domain.vo.QueryUserDto;
import org.learn.domain.vo.QueryUserVo;

import java.util.List;

public interface TUserMapper
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TUser selectTUserById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tUser 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TUser> selectTUserList(TUser tUser);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tUser 【请填写功能名称】
     * @return 结果
     */
    public int insertTUser(TUser tUser);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tUser 【请填写功能名称】
     * @return 结果
     */
    public int updateTUser(TUser tUser);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTUserById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTUserByIds(Long[] ids);

    /**
     * 选择用户所有
     *
     * @param dto dto
     * @return {@link List}<{@link QueryUserVo}>
     */
    List<QueryUserVo> selectUserAll(QueryUserDto dto);

    /**
     * 选择export
     *
     * @param username 用户名
     * @return {@link List}<{@link TUser}>
     */
    List<TUser> selectExport(@Param("name") String username);
}