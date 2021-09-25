package org.learn.Interceptor;

import cn.hutool.core.lang.Validator;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.learn.util.Constant.USER_SESSION_KEY;

/**
 * @program: frame
 * @description: 拦截器
 * @author: MiaoWei
 * @create: 2021-09-24 10:51
 **/
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 前处理
     *
     * @param httpServletRequest  http servlet请求
     * @param httpServletResponse http servlet响应
     * @param o                   o
     * @return boolean
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取session
        Object attribute = httpServletRequest.getSession().getAttribute(USER_SESSION_KEY);
        if (Validator.isEmpty(attribute)) {
            //拦截跳转到登录页面
            httpServletResponse.sendRedirect("/system/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
