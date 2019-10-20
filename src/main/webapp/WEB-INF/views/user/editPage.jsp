<%--
  Created by IntelliJ IDEA.
  User: gongsir
  Date: 2019/10/15
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path",request.getContextPath());
%>
<html>
<head>
        <meta charset="utf-8">
        <title>客户信息管理</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <link rel="stylesheet" href="${path}/static/layui/css/layui.css" media="all">
        <link rel="stylesheet" href="${path}/static/css/admin.css" media="all">
        <script type="text/javascript" src="${path}/static/layui/layui.all.js"></script>
        <style type="text/css">
            .layui-table td {
                text-align: center;
            }
            .layui-table th {
                text-align: center;
                color: #0000FF;
            }
        </style>
</head>
<body>
<div class="layui-container layui-card" id="user_edit_page">
    <div class="layui-fluid">
        <form class="layui-form" action="${path}/user/user_edit" method="post">
            <input type="text" name="customer.userId" value="${customer.userId}" placeholder="请输入客户ID" required autocomplete="off" class="layui-input layui-hide">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户账号</label>
                    <div class="layui-input-block">
                        <input type="text" name="customer.userId" value="${customer.userId}" placeholder="请输入客户ID" required autocomplete="off" class="layui-input" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户密码</label>
                    <div class="layui-input-block">
                        <input type="text" name="customer.userPass" id="password" value="${customer.userPass}" placeholder="请输入密码" required autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="customer.realName" id="realName" value="${customer.realName}" placeholder="请输入真实姓名" required autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户电话</label>
                    <div class="layui-input-block">
                        <input type="text" name="customer.userPhone" id="userPhone" value="${customer.userPhone}" placeholder="请输入真实姓名" required autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户地址</label>
                    <div class="layui-input-block">
                        <input type="text" name="customer.userAddr" id="userAddr" value="${customer.userAddr}" placeholder="请输入详细地址" required autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item layui-col-md-offset1">
                <div class="layui-input-inline">
                    <input type="submit" id="btn_addAdmin" class="layui-btn layui-btn-fluid layui-hide" value="提交">
                </div>
            </div>
            <%--				<div class="layui-form-item layui-col-md-offset2 layui-hide">--%>
            <%--					<div class="layui-input-inline">--%>
            <%--						<button type="button" id="btn_goBack" class="layui-btn layui-btn-fluid" onclick="goBack()">返回</button>--%>
            <%--					</div>--%>
            <%--				</div>--%>
        </form>
    </div>
</div>
</body>
</html>
