package org.learn.service;

import org.learn.domain.TUser;
import org.learn.domain.dto.LoginUserDto;
import org.learn.domain.vo.QueryUserDto;
import org.learn.domain.vo.QueryUserVo;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
     * @param request
     * @return {@link AjaxResult}
     */
    AjaxResult startLogin(LoginUserDto login, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception;

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

    /**
     * 导出
     *  @param username 用户名
     * @param map
     * @return*/
    String export(String username, ModelMap map) throws Exception;

    /**
     * 导入excel
     *
     * @param file 文件
     * @return {@link AjaxResult}
     */
    AjaxResult importExcel(MultipartFile file) throws Exception;
}