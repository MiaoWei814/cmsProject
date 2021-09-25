<%--
  Created by IntelliJ IDEA.
  User: MiaoDaWei
  Date: 2021/9/23
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/WEB-INF/views/common/includeHeadStatic.jsp" %>
    <title>CMS登陆</title>
</head>
<body>
<section class="material-half-bg">
    <div class="cover"></div>
</section>
<section class="login-content">
    <div class="logo">
        <h1>cms后台登陆</h1>
    </div>
    <div class="login-box">
        <form id="logForm" class="login-form" method="post" action="/system/startLogin">
            <h3 class="login-head">
                <i class="fa fa-lg fa-fw fa-user"></i>登陆<span id="loginMsg">
            </h3>
            <div class="form-group">
                <label class="control-label">用户名</label>
                <input id="username" class="form-control"
                       type="text" name="username" placeholder="用户名" autofocus>
            </div>
            <div class="form-group">
                <label class="control-label">密码</label>
                <input class="form-control" id="password"
                       type="password" name="password" placeholder="密码">
            </div>
            <div class="form-group">
                <div class="utility">
                    <div class="animated-checkbox">
                        <label> <input id="reme" type="checkbox" value="1" name="reme"><span
                                class="label-text">记住我</span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group btn-container">
                <button id="logBtn" type="button" class="btn btn-primary btn-block">
                    <i class="fa fa-sign-in fa-lg fa-fw"></i>登陆
                </button>
            </div>
        </form>
    </div>
</section>
<%@include file="/WEB-INF/views/common/includeBottomStatic.jsp" %>
<script type="text/javascript">
    $(function () {
        //点击登录
        $("#logBtn").on("click", function () {
            login()
        })
        //回车登录
        $(document).on("keydown",function (event){
            if (event.keyCode === 13) {
                login();
            }
        })

        function login() {
            $("#logForm").ajaxSubmit({
                success:function (data){
                    if (data.code === 200) {
                        location.href='http://localhost:8080/system/index'
                    }else{
                        alert(data.msg);
                    }
                }
            })
        }
        //获取cookie进行相关的回显
        var username = $.cookie("username")
        var password = $.cookie("password")
        if (username && password) {//都存在，填充用户和密码
            $("#username").val(username)
            $("#password").val(password)
            $("#reme").prop("checked", true) //勾选记住我
        }
    })
</script>
</body>
</html>
