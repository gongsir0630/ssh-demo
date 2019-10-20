<%--
Created by IntelliJ IDEA.
User: gongsir
Date: 2019-10-14
Time: 13:51
To change this template use File | Settings | File Templates.
--%>
<%--让jsp解析EL表达式--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	pageContext.setAttribute("path",request.getContextPath());
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>ssh - 后台管理</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${path}/static/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${path}/static/css/admin.css" media="all">
		<script type="text/javascript" src="${path}/static/layui/layui.js"></script>
	</head>
	<body class="layui-layout-body">

		<div id="LAY_app">
			<div class="layui-layout layui-layout-admin">
				<!-- 头部区域 -->
				<div class="layui-header">
					<ul class="layui-nav layui-layout-left">
						<li class="layui-nav-item layadmin-flexible" lay-unselect>
							<a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
								<i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
							</a>
						</li>
						<li class="layui-nav-item layui-hide-xs" lay-unselect>
							<a href="http://gongsir.club:8080/views" target="_blank" title="前台">
								<i class="layui-icon layui-icon-website"></i>
							</a>
						</li>
						<li class="layui-nav-item" lay-unselect>
							<a href="javascript:;" layadmin-event="refresh" title="刷新">
								<i class="layui-icon layui-icon-refresh-3"></i>
							</a>
						</li>
					</ul>
					<ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

						<li class="layui-nav-item" lay-unselect>
							<!-- 修改消息通知显示 -->
							<a lay-href="" layadmin-event="message" lay-text="消息中心">
								<i class="layui-icon layui-icon-notice"></i>

								<!-- 需要后端数据进行判断，如果有新消息，则显示小圆点 -->
								<span class="layui-badge-dot"></span>
							</a>
						</li>
						<!-- 主题设置 -->
						<li class="layui-nav-item layui-hide-xs" lay-unselect>
							<a href="javascript:;" layadmin-event="theme">
								<i class="layui-icon layui-icon-theme"></i>
							</a>
						</li>
						<li class="layui-nav-item layui-hide-xs" lay-unselect>
							<a href="javascript:;" layadmin-event="note">
								<i class="layui-icon layui-icon-note"></i>
							</a>
						</li>
						<!-- 切换全屏 -->
						<li class="layui-nav-item layui-hide-xs" lay-unselect>
							<a href="javascript:;" layadmin-event="fullscreen">
								<i class="layui-icon layui-icon-screen-full"></i>
							</a>
						</li>
						<!-- 用户信息展示 -->
						<li class="layui-nav-item" lay-unselect>
							<a href="javascript:;">
								<!-- 用户名 -->
								<cite>龚涛</cite>
							</a>
							<dl class="layui-nav-child">
								<dd><a lay-href="">基本资料</a></dd>
								<dd><a lay-href="">修改密码</a></dd>
								<hr>
								<!-- 退出登陆 -->
								<dd style="text-align: center;"><a href="">退出</a></dd>
							</dl>
						</li>

						<!-- 关于 -->
						<li class="layui-nav-item layui-hide-xs" lay-unselect>
							<a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>
						</li>
						<!-- 更多 -->
						<li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
							<a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
						</li>
					</ul>
				</div>

				<!-- 侧边菜单 -->
				<div class="layui-side layui-side-menu">
					<div class="layui-side-scroll">
						<!-- logo显示 -->
						<div class="layui-logo">
							<span>
								<img src="${path}/static/img/header.JPG" width="30" height="30" class="layui-circle" alt="龚涛">
								后台管理系统
							</span>
						</div>
						<!-- 菜单列表 -->
						<ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
							<!-- 客户管理 -->
							<li data-name="home" class="layui-nav-item">
								<a href="javascript:;" lay-tips="客户管理" lay-direction="2">
									<i class="layui-icon layui-icon-home"></i>
									<cite>客户管理</cite>
								</a>
								<dl class="layui-nav-child">
									<!-- 设置layui-this,表示默认的选中项 -->
									<dd class="layui-this">
										<a lay-href="${path}/user/user_list">客户列表</a>
									</dd>
<%--									<dd>--%>
<%--										<a lay-href="${path}/user/user_query?customer.userId=201731061426">客户查询</a>--%>
<%--									</dd>--%>
								</dl>
							</li>
							<!-- 订单管理 -->
							<li data-name="book" class="layui-nav-item">
								<a href="javascript:;" lay-tips="订单管理" lay-direction="2">
									<i class="layui-icon layui-icon-layim-theme"></i>
									<cite>订单管理</cite>
								</a>
								<dl class="layui-nav-child">
									<dd>
										<a lay-href="${path}/order/order_list">订单信息</a>
									</dd>
<%--									<dd>--%>
<%--										<a lay-href="">订单查询</a>--%>
<%--									</dd>--%>
								</dl>
							</li>
						</ul>
					</div>
				</div>

				<!-- 页面标签 -->
				<div class="layadmin-pagetabs" id="LAY_app_tabs">
					<!-- 标签往左翻页 -->
					<div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
					<!-- 标签往右翻页 -->
					<div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
					<!-- 标签关闭 -->
					<div class="layui-icon layadmin-tabs-control layui-icon-down">
						<ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
							<li class="layui-nav-item" lay-unselect>
								<a href="javascript:;"></a>
								<dl class="layui-nav-child layui-anim-fadein">
									<dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
									<dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
									<dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
								</dl>
							</li>
						</ul>
					</div>
					<!-- 默认展示主页标签 -->
					<div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
						<ul class="layui-tab-title" id="LAY_app_tabsheader">
							<li lay-id="user/user_list" lay-attr="" class="layui-this" title="主页"><i class="layui-icon layui-icon-home"></i></li>
						</ul>
					</div>
				</div>


				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body">
					<div class="layadmin-tabsbody-item layui-show">
						<iframe src="${path}/user/user_list" frameborder="0" class="layadmin-iframe"></iframe>
					</div>
				</div>

				<!-- 辅助元素，一般用于移动设备下遮罩 -->
				<div class="layadmin-body-shade" layadmin-event="shade"></div>
			</div>
		</div>
		<script>
			layui.config({
				base: '${path}/static/' //静态资源所在路径
			}).extend({
				index: 'lib/index' //主入口模块
			}).use('index');
		</script>

	</body>
</html>
