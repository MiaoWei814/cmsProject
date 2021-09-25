package org.learn.service.impl;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.text.CharSequenceUtil;
import org.learn.domain.TUser;
import org.learn.domain.dto.LoginUserDto;
import org.learn.domain.vo.QueryUserDto;
import org.learn.domain.vo.QueryUserVo;
import org.learn.exception.CMSRuntimeException;
import org.learn.mapper.TUserMapper;
import org.learn.service.ITUserService;
import org.learn.util.AjaxResult;
import org.learn.util.Constant;
import org.learn.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.learn.util.Constant.MIN_PASSWORD_LENGTH;
import static org.learn.util.Constant.MIN_USERNAME_LENGTH;

@Service
public class TUserServiceImpl implements ITUserService {
    @Autowired
    private TUserMapper tUserMapper;

    /**
     * 开始登录
     *
     * @param login    登录
     * @param session
     * @param response
     * @param request
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult startLogin(LoginUserDto login, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        List<TUser> users;
        try {
            //数据校验
            userParameterVerification(login.getUsername(), login.getPassword());
            //查询数据库
            users = tUserMapper.selectTUserList(new TUser().setUsername(login.getUsername()));
            if (CollUtil.isEmpty(users)) {
                throw new CMSRuntimeException("用户名出错了哦,宝贝!");
            }

            if (!login.getPassword().equals(users.get(0).getPassword())) {
                throw new CMSRuntimeException("密码错了哦!");
            }
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }

        //勾选了记住我
        if (login.getReme() != null && login.getReme().compareTo(1) == 0) {
            //设置cookie
            Cookie cookieUserName = new Cookie("username", encryptUserName(login.getUsername(), true));
            Cookie cookiePassword = new Cookie("password", login.getPassword());
            //设置cookie的有效期-  五分钟
            cookieUserName.setMaxAge(300);
            cookiePassword.setMaxAge(300);
            //设置作用域,让当前所有站点都能享有cookie
            cookieUserName.setPath("/");
            cookiePassword.setPath("/");
            //响应
            response.addCookie(cookieUserName);
            response.addCookie(cookiePassword);
        }else{
            //清除cookie
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("username".equals(name) || "password".equals(name)) {
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        //登录成功就把信息放在session里面
        session.setAttribute(Constant.USER_SESSION_KEY, users.get(0));

        return AjaxResult.success();
    }

    /**
     * 用户参数验证
     *
     * @param username 登录
     * @param password
     */
    private void userParameterVerification(String username, String password) {
        if (CharSequenceUtil.isEmpty(username) || CharSequenceUtil.isEmpty(password)) {
            throw new CMSRuntimeException("账户或密码不能为空,请重新填写!");
        }
        //校验
        if (username.length() < MIN_USERNAME_LENGTH) {
            throw new CMSRuntimeException("用户名最小长度为:" + MIN_USERNAME_LENGTH);
        }
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new CMSRuntimeException("密码最小长度为:" + MIN_PASSWORD_LENGTH);
        }
        if (!Validator.isNumber(password)) {
            throw new CMSRuntimeException("密码只能输入数字相关!");
        }
    }


    /**
     * 用户名转换
     *
     * @param username  用户名
     * @param isEncrypt 是否加密
     */
    private String encryptUserName(String username, boolean isEncrypt) throws Exception {
        String newUserName;
        //true,代表是中文转格式utf-8
        if (isEncrypt) {
            newUserName = URLEncoder.encode(username, "UTF-8");
        } else {
            newUserName = URLDecoder.decode(username, "UTF-8");
        }
        return newUserName;
    }

    /**
     * 查询所有
     *
     * @param dto dto
     * @return {@link PageBean}<{@link QueryUserVo}>
     */
    @Override
    public PageBean<QueryUserVo> queryAll(QueryUserDto dto) {
        List<QueryUserVo> all = tUserMapper.selectUserAll(dto);
        all=all.stream().sorted(Comparator.comparing(QueryUserVo::getId).reversed()).collect(Collectors.toList());
        dto.setCurrentPage(null).setPageSize(null);
        int sizeCount = tUserMapper.selectUserAll(dto).size();
        return new PageBean<>(sizeCount, all);
    }

    /**
     * 删除
     *
     * @param id id
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult remove(Long id) {
        if (id == null) {
            return AjaxResult.error("请求参数不能为空");
        }
        TUser user = tUserMapper.selectTUserById(id);
        if (BeanUtil.isEmpty(user)) {
            return AjaxResult.error("该操作数据不存在,无法继续往下执行相关操作");
        }
        int byId = tUserMapper.deleteTUserById(user.getId());
        if (byId > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.error("删除失败");
    }

    /**
     * 保存
     *
     * @param user 用户
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult save(TUser user) {
        boolean isFlag;
        try {
            //参数校验
            userParameterVerification(user.getUsername(), user.getPassword());
            //添加
            if (user.getId() == null) {
                List<TUser> userList = tUserMapper.selectTUserList(new TUser().setUsername(user.getUsername()));
                if (CollUtil.isNotEmpty(userList)) {
                    throw new CMSRuntimeException("该用户名不能重复,请重新认真填写");
                }
                TUser tUser = new TUser().setUsername(user.getUsername()).setPassword(user.getPassword()).setNickName(user.getNickName());
                isFlag = tUserMapper.insertTUser(tUser) > 0;
            } else {
                List<TUser> userList = tUserMapper.selectTUserList(new TUser().setUsername(user.getUsername()));
                if (userList.size() > 1) {
                    throw new CMSRuntimeException("该用户名不能重复,请重新认真填写");
                }
                isFlag = tUserMapper.updateTUser(user) > 0;
            }

            if (!isFlag) {
                throw new CMSRuntimeException("操作失败!");
            }
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success();
    }

    /**
     * 导出
     *  @param username 用户名
     * @param map
     * @return*/
    @Override
    public String export(String username, ModelMap map) throws Exception{
        List<TUser> queryList=tUserMapper.selectExport(username);
//        //设置导出参数
        ExportParams params = new ExportParams("用户账号手册","详情", ExcelType.XSSF);

        //设置映射关系
        //集合
        map.put(NormalExcelConstants.DATA_LIST, queryList);
        //导出实体
        map.put(NormalExcelConstants.CLASS, TUser.class);
        //参数
        map.put(NormalExcelConstants.PARAMS, params);
        //文件名称
        map.put(NormalExcelConstants.FILE_NAME, "userLists");

        //View视图 走视图,视图解析器.
        return NormalExcelConstants.EASYPOI_EXCEL_VIEW;
    }

    /**
     * 导入excel
     *
     * @param file 文件
     * @return {@link AjaxResult}
     */
    @Override
    public AjaxResult importExcel(MultipartFile file) throws Exception {
        try{
            if (file == null) {
                throw new CMSRuntimeException("上传文件不能为空!");
            }
            String filename = file.getOriginalFilename();
            String suffix = FileNameUtil.getSuffix(filename);
            if (!"xlsx".equals(suffix)) {
                throw new CMSRuntimeException("请上传指定格式xlsx");
            }
        }catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }

        //参数1:文件的IO
        //参数2:导入实体类
        //参数3:导入参数设置
        ImportParams params = new ImportParams();
        //设置标题行, 行以下的就是数据可以导入
        params.setTitleRows(1);
        List<Object> objects = ExcelImportUtil.importExcel(file.getInputStream(), TUser.class, params);
        //循环添加到对象里去
        boolean isFlag = false;
        for (Object item : objects) {
            isFlag=tUserMapper.insertTUser((TUser) item)>0;
        }
        if (!isFlag) {
            return AjaxResult.error("添加数据库失败!");
        }
        return AjaxResult.success();
    }
}