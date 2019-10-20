<%--
  Created by IntelliJ IDEA.
  User: gongsir
  Date: 2019/8/21
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path",request.getContextPath());
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
		<div class="layui-fluid">
			<div class="layui-card">
				<div class="layui-form layui-card-header layuiadmin-card-header-auto">
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">客户信息</label>
							<div class="layui-input-block">
								<input type="text" name="keyword" id="keyword" placeholder="用户名或姓名关键字" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<button class="layui-btn layuiadmin-btn-useradmin" id="user_search">
								<i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
							</button>
						</div>
					</div>
				</div>

				<div class="layui-card-body">
					<%--头部工具条--%>
					<div id="toolbarDemo">
<%--						<button class="layui-btn layuiadmin-btn-useradmin" lay-event="batchdel">删除</button>--%>
						<button class="layui-btn layuiadmin-btn-useradmin" lay-event="add" id="user_add">添加</button>
						<button class="layui-btn layuiadmin-btn-useradmin" lay-event="flush" id="user_flush">刷新</button>
					</div>

					<table id="LAY-user-manage" lay-filter="LAY-user-manage" class="layui-table">
						<tr>
							<th>客户ID</th>
							<th>客户姓名</th>
							<th>客户电话</th>
							<th>客户地址</th>
							<th>操   作</th>
						</tr>
						<c:forEach items="${list}" var="cus">
							<tr>
								<td>${cus.userId}</>
								<td>${cus.realName}</td>
								<td>${cus.userPhone}</td>
								<td>${cus.userAddr}</td>
								<td>
									<button class="layui-btn layui-btn-sm" onclick="delUser('${cus.userId}')">
										删除
									</button>
									<button class="layui-btn layui-btn-sm" onclick="editUser('${cus.userId}')">
										修改
									</button>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		layui.use('layer',function(){
			var layer = layui.layer;
			var $ = layui.$;
			var form = layui.form;

			// 删除客户信息
			window.delUser = function(userId) {
				layer.confirm("确定删除客户ID为"+userId+"的客户吗？",{icon:2,title:"提示"},function(idx){
					layer.msg("数据删除成功",{icon:1,time:2000});
					window.location = '${path}/user/user_del?customer.userId='+userId;
					layer.close(idx);
				})
			};

			// 刷新数据
			$('#user_flush').click(function () {
				window.location = '${path}/user/user_list';
			});

			// 添加客户信息
			$('#user_add').click(function () {
				layer.open({
					type:2
					,title:'添加客户信息'
					,content:'${path}/user/user_addPage'
					,offset:'auto'
					,area: ['400px', '500px']
					,btn: ['提交','取消']
					,yes:function (index,layero) {
						var body = layer.getChildFrame('body', index);
						body.find('#btn_addAdmin').click();
						layer.close(index);
					}
					,btn2:function (index) {
						layer.close(index);
					}
					,end:function () {
						// 刷新数据
						$('#user_flush').click();
					}
				})
			});

			// 编辑客户信息
			window.editUser = function (userId) {
				var index = layer.open({
					title:'编辑客户信息',
					type:2,
					content:'${path}/user/user_editPage?customer.userId='+userId,
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

			$('#user_search').click(function () {
				var key = $('#keyword').val();
				window.location = '${path}/user/user_search?keyword='+key;
			})
		})
	</script>
</html>
