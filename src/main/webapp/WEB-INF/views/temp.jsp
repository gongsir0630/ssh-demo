<%--
  Created by IntelliJ IDEA.
  User: gongsir
  Date: 2019/8/21
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path",request.getContextPath());
%>
<html>
<head>
    <title>Blank Page</title>
    <link rel="stylesheet" href="${path}/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${path}/static/css/admin.css" media="all">
    <script type="text/javascript" src="${path}/static/layui/layui.all.js"></script>
</head>
<body style="background-color: #3F3F3F">
    <script type="text/javascript">
        layui.use('layer',function () {
            var layer = layui.layer;
            var $ = layui.$;
            var msg = "${msg}";
            if (msg==="客户信息不存在，请先添加客户信息")
                layer.msg("${msg}",{icon:2,time:2000});
            else
                layer.msg("${msg}",{icon:1,time:2000});
        })
    </script>
</body>
</html>
