<%--
  Created by IntelliJ IDEA.
  User: 陈佳益
  Date: 2022/1/3
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试页面</title>
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
<%--    <script type="text/javascript">--%>
<%--        $(function (){--%>
<%--            $("#btn01").click(function (){--%>
<%--                $.ajax({--%>
<%--                    "url": "send/array1.do",--%>
<%--                    "type": "post",--%>
<%--                    "data": {--%>
<%--                        "array":[5,8,12]--%>
<%--                    },--%>
<%--                    "dataType": "text",--%>
<%--                    "success": function (response){--%>
<%--                        alert(response);--%>
<%--                    },--%>
<%--                    "error": function (response){--%>
<%--                        alert(response);--%>
<%--                    }--%>
<%--                });--%>
<%--            });--%>
<%--        })--%>
<%--    </script>--%>
    <script type="text/javascript">
        $(function (){
            $("#btn01").click(function (){
                // 准备好要发送到服务端的数组
                var array = [5,8,12];

                // 将JSON数组转换为JSON字符串
                var requestBody = JSON.stringify(array);
                $.ajax({
                    "url": "send/array2.do",
                    "type": "post",
                    "data": requestBody,
                    contentType: "application/json;character=UTF-8",
                    "dataType": "text",
                    "success": function (response){
                        alert(response);
                    },
                    "error": function (response){
                        alert(response);
                    }
                });
            });

            $("#btn03").click(function (){
                // 准备要发送的数据
                var student = {
                    stuId: 5,
                    stuNmae: "tom",
                    address: {
                        province: "江苏",
                        city: "南京",
                        street: "秣陵街道"
                    },
                    subjectList: [
                        {
                            subName: "java",
                            subScore: 100
                        },
                        {
                            subName: "c++",
                            subScore: 98
                        }
                    ],
                    map:{
                        key1: "value1",
                        key2: "value2"
                    }
                };
                // 将JSON对象转换为JSON字符串
                var requestBody = JSON.stringify(student);

                // 发送Ajax请求
                $.ajax({
                    url: "send/compose/object.do",
                    type: "post",
                    data: requestBody,
                    contentType: "application/json;character=UTF-8",
                    dataType: "text",
                    success: function (resp){
                        alert(resp);
                    },
                    error: function (resp) {
                        alert(resp)
                    }
                })
            })

        })

    </script>
</head>

<body>
<a href="test/ssm.html">测试</a>
<button id="btn01">Send text</button>
<button id="btn03">Send Object</button>
</body>
</html>
