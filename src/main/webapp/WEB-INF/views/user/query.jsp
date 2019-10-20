<%--
  Created by IntelliJ IDEA.
  User: gongsir
  Date: 2019/10/14
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path",request.getContextPath());
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户信息查询</title>
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
        }
    </style>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-card-body">
    <h3 style="text-align: center; color: #0000FF">客户信息及全部订单</h3>
    <table class="layui-table">
        <tr>
            <td>客户ID</td>
            <td>${customer.userId}</td>
        </tr>
        <tr>
            <td>客户姓名</td>
            <td>${customer.realName}</td>
        </tr>
        <tr>
            <td>客户电话</td>
            <td>${customer.userPhone}</td>
        </tr>
        <tr>
            <td>客户地址</td>
            <td>${customer.userAddr}</td>
        </tr>
    </table>
    </div>
    <div class="layui-card-body">
        <%--头部工具条--%>
        <div id="toolbarDemo">
            <button class="layui-btn layuiadmin-btn-useradmin" lay-event="add" id="order_clear">清空全部订单</button>
            <button class="layui-btn layuiadmin-btn-useradmin" lay-event="flush" id="user_flush">刷新</button>
        </div>

        <table id="LAY-user-manage" lay-filter="LAY-user-manage" class="layui-table">
            <tr>
                <th>订单ID</th>
                <th>订单名称</th>
                <th>客户ID</th>
                <th>订单总价</th>
                <th>商品数量</th>
                <th>操   作</th>
            </tr>
            <c:forEach items="${orders}" var="d">
                <tr>
                    <td>${d.orderId}</>
                    <td>${d.orderName}</td>
                    <td>${d.userId}</td>
                    <td>${d.orderMoney}</td>
                    <td>${d.orderCount}</td>
                    <td>
                        <button class="layui-btn layui-btn-sm" onclick="delUser('${d.orderId}')">
                            删除
                        </button>
                        <button class="layui-btn layui-btn-sm" onclick="editUser('${d.orderId}')">
                            修改
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
<script type="text/javascript">
    layui.use('layer',function(){
        var layer = layui.layer;
        var $ = layui.$;
        var form = layui.form;

        // 删除订单信息
        window.delUser = function(orderId) {
            layer.confirm("确定删除订单ID为"+orderId+"的订单吗？",{icon:2,title:"提示"},function(idx){
                layer.msg("数据删除成功",{icon:1,time:2000});
                window.location = '${path}/order/order_del?order.orderId='+orderId;
                layer.close(idx);
            })
        };

        // 刷新数据
        $('#user_flush').click(function () {
            window.location = '${path}/user/user_query?customer.userId=${customer.userId}';
        });

        // 清空客户订单信息
        $('#order_clear').click(function () {
            layer.confirm("确定清空客户${customer.realName}的全部订单吗？",{icon:2,title:"提示"},function(idx){
                layer.msg("数据删除成功",{icon:1,time:2000});
                window.location = '${path}/order/order_clear?customer.userId=${customer.userId}';
                layer.close(idx);
            });
        });

        // 编辑订单信息
        window.editUser = function (orderId) {
            var index = layer.open({
                title:'编辑订单信息',
                type:2,
                content:'${path}/order/order_editPage?order.orderId='+orderId,
                offset:'auto',
                btn:['提交','取消'],
                area: ['400px', '500px'],

                yes:function (index,layero) {
                    var body = layer.getChildFrame('body', index);
                    body.find('#btn_addAdmin').click();
                    layer.close(index);
                },
                btn2:function (index) {
                    layer.close(index);
                },
                // layer关闭回调
                end:function () {
                    // 刷新数据
                    $('#user_flush').click();
                }
            });
        };
    })
</script>
</html>
