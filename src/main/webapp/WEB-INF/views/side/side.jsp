<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>CMS系统欢迎您</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">



    <%@ include file="/WEB-INF/views/common/includeHeadStatic.jsp" %>


</head>
<body class="app sidebar-mini">

<%@ include file="/WEB-INF/views/common/navigationBar.jsp" %>

<%@ include file="/WEB-INF/views/common/sideMenu.jsp" %>


<!-- 中间显示内容的 -->
<main class="app-content">
    <!-- 添加修改模态框 -->
    <div class="modal fade" id="saveModel">
        <div class="modal-dialog modal-lg">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/system/slide/save" method="post"  class="form-horizontal" id="saveForm">
                        <input type="hidden" name="id" id="id">
                        <span id="upavator" style="color: #a92222"></span>
                        <div class="form-group row">
                            <label for="photo" class="control-label col-md-2">技师头像</label>
                            <div class="col-md-10">
                                <input class="form-control" type="file" name="photo">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="enable" class="control-label col-md-2">是否启用</label>
                            <div class="col-md-10">
                                <div class="form-check">
                                    <label class="form-check-label"> <input
                                            class="form-check-input" type="radio" checked="checked"
                                            id="enable" name="enable" value="1">启用
                                    </label>
                                </div>
                                <div class="form-check">
                                    <label class="form-check-label"> <input
                                            class="form-check-input" type="radio" name="enable" value="0">禁用
                                    </label>
                                </div>
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

    <!-- 删除模态框 -->
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


    <!--2. 高级查询 -->
    <div class="row app-title">
        <div class="col-md-12">
            <!-- 表单 -->
            <form id="queryForm" class="form-inline">
                <div class="form-group">
                    <label for="name">技师花名：</label>
                    <input type="text" class="form-control" name="name" id="name">
                </div>
                <div class="form-group" style="margin-left: 20px">
                    <label>是否启用：</label>
                    <select name="enable" class="form-control" id="enable">
                        <option value="">请选择</option>
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                </div>
                <button  type="button" id="queryButton" class="btn btn-success" style="margin-left: 20px">查询</button>
            </form>
        </div>
    </div>


    <!--1.列表展示 -->
    <div class="row app-title">
        <div class="col-md-12">
            <!-- 存放table列表 -->
            <table id='table-demo-ajaxPageCode'></table>
        </div>
    </div>

</main>


<%@ include file="/WEB-INF/views/common/includeBottomStatic.jsp" %>

</body>
<script type="text/javascript">
    //利用gridManager来针对表格进行处理
    $(function () {
        document.querySelector('#table-demo-ajaxPageCode').GM({
            gridManagerName: 'demo-ajaxPageCode',
            ajaxData: '${pageContext.request.contextPath}/system/slide/list',
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
                    key: 'name',
                    text: '名称',
                    align: 'center'
                },{
                    key:"path",
                    text:"图片",
                    align: "center",
                    template:function (cell,row,index,key){
                        return "<img src=" + cell + " alt='地址不存在' width='50px'>";
                    }
                },  {
                    key: 'createDate',
                    align: 'center',
                    text: '创建时间'
                }, {
                    key: 'enable',
                    align: 'center',
                    text: '是否启用',
                    template: function (cell, row, index, key) {
                        return cell ? "<span style='color:green'>启用</span>" : "<span style='color:red'>禁用</span>";
                    }
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
        //查询
        $("#queryButton").on("click",function (){
            let object = $("#queryForm").serializeObject();
            GridManager.setQuery("demo-ajaxPageCode", object);
        })

        //添加
        $("#table-demo-ajaxPageCode").on("click", "#addBtn", function () {
            //显示模态框
            $("#saveModel").modal("show");
            //重置表单,以防后面取消添加然后浏览器进行缓存
            $("#saveForm").get(0).reset();
            //手动清除id(因为回显导致id可能存在缓存问题)
            $("#id").val("");
            $("#upavator").get(0).innerText='';
        })

        //编辑
        $("#table-demo-ajaxPageCode").on("click","#editBtn",function (){
            //展示模态框
            $("#saveModel").modal("show");
            //获取数据
            let obj = $(this).data("obj");
            $("#saveForm").setForm(obj);
            $("#upavator").get(0).innerText = "若更新操作当前您的轮播图会被覆盖!请注意!";
        })

        //添加或编辑发送给后端
        $("#saveButton").on("click", function () {
            $("#saveForm").ajaxSubmit({
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

        //删除
        $("#table-demo-ajaxPageCode").on("click", "#delBtn", function () {
            //显示模态框
            $("#delModel").modal("show");
            let delteById = $(this).data("id");
            //避免重复绑定
            $("#delModelButton").off();
            $("#delModelButton").on("click",function (){
                $.ajax({
                    type: "get",
                    data:{id:delteById},
                    url:"/system/slide/remove",
                    success:function (data){
                        //隐藏掉
                        $("#delModel").modal("hide");
                        if (data.code === 200) {
                            //重新加载表格
                            GridManager.refreshGrid("demo-ajaxPageCode");
                        }else{
                            alert(data.msg);
                        }
                    }
                })
            })
        })



    })
</script>

</html>