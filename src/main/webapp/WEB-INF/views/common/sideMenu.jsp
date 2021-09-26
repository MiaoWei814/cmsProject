<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!--侧边菜单-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user">
        <img class="app-sidebar__user-avatar" width="48px" height="48px"
             src="${pageContext.request.contextPath}/static/system/images/m1.jpg" alt="User Image">
        <div>
            <p class="app-sidebar__user-name" id="username">${user_session_key.username}</p>
        </div>
    </div>
    <ul class="app-menu">
        <li>
            <a class="app-menu__item " href="${pageContext.request.contextPath}/system/article/index">
                <i class="app-menu__icon fa fa-dashboard"></i>
                <span class="app-menu__label">文章管理</span>
            </a>
        </li>
        <li>
            <a class="app-menu__item" href="${pageContext.request.contextPath}/system/slide/index">
                <i class="app-menu__icon fa fa-dashboard"></i>
                <span class="app-menu__label">轮播图管理</span>
            </a>
        </li>
        <li>
            <a class="app-menu__item" href="${pageContext.request.contextPath}/system/user/index">
                <i class="app-menu__icon fa fa-dashboard"></i>
                <span class="app-menu__label">用户管理</span>
            </a>
        </li>
        <li>
            <a class="app-menu__item" href="${pageContext.request.contextPath}/system/navigation/index">
                <i class="app-menu__icon fa fa-dashboard"></i>
                <span class="app-menu__label">导航栏管理</span>
            </a>
        </li>
    </ul>
</aside>