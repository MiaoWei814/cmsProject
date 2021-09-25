<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>CMS系统欢迎您</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--引入公共头部css资源-->
    <%@include file="/WEB-INF/views/common/includeHeadStatic.jsp" %>
</head>
<body class="app sidebar-mini">

<!-- 导航条-->
<%@include file="/WEB-INF/views/common/navigationBar.jsp" %>


<!-- 侧边栏 -->
<%@include file="/WEB-INF/views/common/sideMenu.jsp" %>

<!-- 中间显示内容的 -->
<main class="app-content">
    <!--高级查询-->
    <div class="row app-title">
        <div class="col-md-12">
            <!-- 表单 -->
            <form id="queryForm" class="form-inline" action="/system/user/exportExcel" method="post">
                <div class="form-group">
                    <label for="title">用户名：</label>
                    <input type="text" class="form-control" name="username" id="title">
                </div>
                <button type="button" id="queryButton" class="btn btn-success" style="margin-left: 20px">查询</button>
                <button  type="submit" id="downloadButton" class="btn btn-info" style="margin-left: 20px">导出</button>
                <button  type="button" id="importButton" class="btn btn-danger" style="margin-left: 20px">导入</button>
            </form>
        </div>
    </div>

    <!-- 列表展示 -->
    <div class="row app-title">
        <div class="col-md-12">
            <!-- 利用GridManager存放table列表 -->
            <table id='table-demo-ajaxPageCode'></table>
        </div>
    </div>

    <%--删除模态框--%>
    <div class="modal fade" id="delModel">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <h5 style="color: red">您确认要删除吗？</h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <a href="javascript:void(0);" id="delModelButton" class="btn btn-success">确定</a>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>

    <%--添加模态框--%>
    <div class="modal fade" id="saveModel">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="saveForm">
                        <%--这里id进行隐藏表示如果有则是修改--%>
                        <input type="hidden" name="id" id="id">

                        <div class="form-group row">
                            <label for="title" class="control-label col-md-3">用户名</label>
                            <div class="col-md-9">
                                <input class="form-control" type="text" name="username">
                            </div>

                        </div>

                        <div class="form-group row">
                            <label for="nickName" class="control-label col-md-3">昵称:</label>
                            <div class="col-md-9">
                                <input type="text" id="nickName" name="nickName">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="content" class="control-label col-md-3">密码:</label>
                            <div class="col-md-10">
								<input type="text" class="form-control" style="resize: none" rows="4"
                                    name="password" id="content">
                                </input>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <a href='javascript:void(0);' id="saveButton" class="btn btn-success">确定</a>
                </div>
            </div>
        </div>
    </div>
</main>
<%--引入公共JS--%>
<%@include file="/WEB-INF/views/common/includeBottomStatic.jsp" %>

<%--自定义JS--%>
<script type="text/javascript">
    //利用gridManager来针对表格进行处理
    $(function () {
        document.querySelector('#table-demo-ajaxPageCode').GM({
            gridManagerName: 'demo-ajaxPageCode',
            ajaxData: '${pageContext.request.contextPath}/system/user/list',
            ajaxType: 'POST',
            supportAjaxPage: true, //支持分页
            supportAdjust: false,
            supportDrag: false,
            currentPageKey: "currentPage",     //当前页
            pageSizeKey: "pageSize",			//每页显示的条数
            sizeData: [5, 10, 15, 20],			//分页的选项
            pageSize: 5,						//默认每页显示多少条
            columnData: [
                {
                    key: 'username',
                    text: '用户名',
                    align: 'center'
                }, {
                    key: 'password',
                    text: '密码',
                    align: 'center'
                }, {
                    key: 'nickName',
                    align: 'center',
                    text: '昵称'
                }, {
                    key: 'id',
                    align: 'center',
                    text: '操作&emsp;<a id="addBtn" style="color:blue" href="javascript:void(0)">添加</a>',
                    template: function (cell, row, index, key) {
                        let text = "<a id='editBtn' data-obj='" + JSON.stringify(row) + "' style='color:blue' href='javascript:void(0)'>修改</a>&emsp;<a id='delBtn' data-id=" + cell + " style='color:red' href='javascript:void(0)'>删除</a>"
                        return text;
                    }
                }
            ]
        });

        //高级查询
        $("#queryButton").on("click", function () {
            //获取到查询字段
            var serializeObject = $("#queryForm").serializeObject();
            //跟gridManager一起发送到后端数据库,
            GridManager.setQuery("demo-ajaxPageCode", serializeObject);
        })

        //删除
        const $table = $("#table-demo-ajaxPageCode");
        const $delModelButton = $("#delModelButton");

        $table.on("click", "#delBtn", function () {

            let delId = $("#delBtn").data("id");
            //展示
            $("#delModel").modal("show");
            //取消每次点击取消获得重复绑定

            $delModelButton.off();
            //开始点击
            $delModelButton.on("click", function () {
                //发送
                $.ajax({
                    data: {"id": delId},
                    url: "${pageContext.request.contextPath}/system/user/del",
                    success: function (result) {
                        //隐藏模态框
                        $("#delModel").modal("hide");
                        if (result.code === 200) {
                            //删除后重新加载表格
                            GridManager.refreshGrid("demo-ajaxPageCode");//刷新数据
                        } else {
                            alert(result.msg);
                        }
                    }
                })
            })
        });

        //添加
        $table.on("click", "#addBtn", function () {
            //显示模态框
            $("#saveModel").modal("show");
            //重置表单,以防后面取消添加然后浏览器进行缓存
            $("#saveForm").get(0).reset();
            //手动清除id(因为回显导致id可能存在缓存问题)
            $("#id").val("");
        })

        //编辑
        $table.on("click", "#editBtn", function () {
            $("#saveModel").modal("show");
            //获取数据
            let getData = $(this).data("obj");
            //回显
            $("#saveForm").setForm(getData);
        })
        //添加或编辑发送给后端
        $("#saveButton").on("click", function () {
            $("#saveForm").ajaxSubmit({
                url: "/system/user/save",
                method: "post",
                success: function (data) {
                    $("#saveModel").modal("hide");
                    if (data.code === 200) {
                        // 重新加载表格
                        GridManager.refreshGrid("demo-ajaxPageCode");//刷新数据
                    } else {
                        alert(data.msg);
                    }
                }
            })
        })

        // //导出
        // $("#downloadButton").on("click",function (){
        //     let val = $("#title").val();
        //     $.ajax({
        //         type:"post",
        //         data: {username:val},
        //         url:"/system/user/exportExcel"
        //     })
        //
        // })
    })

</script>
</body>
</html>
