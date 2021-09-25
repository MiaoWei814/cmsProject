package org.learn.service;

import org.learn.domain.TUser;
import org.learn.domain.dto.LoginUserDto;
import org.learn.domain.vo.QueryUserDto;
import org.learn.domain.vo.QueryUserVo;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ituser服务
 *
 * @author MiaoDaWei
 * @date 2021/09/24
 */
public interface ITUserService
{
    /**
     * 开始登录
     *
     * @param login 登录
     * @param session
     * @param response
     * @return {@link AjaxResult}
     */
    AjaxResult startLogin(LoginUserDto login, HttpSession session, HttpServletResponse response) throws Exception;

    /**
     * 查询所有
     *
     * @param dto dto
     * @return {@link PageBean}<{@link QueryUserVo}>
     */
    PageBean<QueryUserVo> queryAll(QueryUserDto dto);

    /**
     * 删除
     *
     * @param id id
     * @return {@link AjaxResult}
     */
    AjaxResult remove(Long id);

    /**
     * 保存
     *
     * @param user 用户
     * @return {@link AjaxResult}
     */
    AjaxResult save(TUser user);
}