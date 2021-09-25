<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- 导航条-->
<header class="app-header">
    <a class="app-header__logo" href="index.html">源码时代</a>
    <a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
    <!-- 导航条右边菜单 -->
    <ul class="app-nav">
        <!-- 用户菜单 -->
        <li class="dropdown">
            <a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu">
                <i class="fa fa-user fa-lg"></i></a>
            <ul class="dropdown-menu settings-menu dropdown-menu-right">
                <li>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/system/quit">
                        <i class="fa fa-sign-out fa-lg"></i> 退出 </a>
                </li>
            </ul>
        </li>
    </ul>
</header>