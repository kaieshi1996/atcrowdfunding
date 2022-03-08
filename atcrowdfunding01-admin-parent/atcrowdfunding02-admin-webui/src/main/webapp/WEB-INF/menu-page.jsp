<%--
  Created by IntelliJ IDEA.
  User: 陈佳益
  Date: 2022/3/8
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="include-head.jsp" %>
<link rel="stylesheet" href="ztree/zTreeStyle.css"/>
<script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
    $(function (){
        // 1.准备生成树形结构的JSON数据，数据来源是发送Ajax请求得到
        $.ajax({
            url: "menu/get/whole/tree.do",
            type: "post",
            dataType: "json",
            success: function (resp) {
                var result = resp.result;
                if (result === "SUCCESS") {

                    // 2.创建json对象用于存储对zTree所做的设置
                    var setting = {
                        view:{
                            addDiyDom: myAddDiyDom
                        },
                        data: {
                            key:{
                                url: "nothing", // url值改为不存在的属性名，则点击页面响应菜单时不会跳转
                            }
                        }
                    };

                    // 3.从响应体中获取用来生成树形结构的JSON数据
                    var zNodes = resp.data;

                    // 4.初始化树形结构
                    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
                }
                if (result === "FAILED") {
                    layer.msg(resp.message);
                }
            },
        });

    })
</script>

<body>
<%@include file="include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="include-sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="panel panel-default">
                <div class="panel-heading"><i class="glyphicon glyphicon-th-list"></i> 权限菜单列表 <div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
                <div class="panel-body">
                    <!-- zTree动态生成的标签所依附的静态节点 -->
                    <ul id="treeDemo" class="ztree"></ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>