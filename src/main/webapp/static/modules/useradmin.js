layui.define(["table", "form"], function(e) {
	var t = layui.$,
		i = layui.table;
	layui.form;
	i.render({
		elem: "#LAY-user-manage",
		url: 'http://localhost/computerAssociation_war/admin/all',
		response: {
			statusName: 'code' //规定数据状态的字段名称，默认：code
				,
			statusCode: 200 //规定成功的状态码，默认：0
				,
			msgName: 'msg' //规定状态信息的字段名称，默认：msg
				,
			countName: 'count' //规定数据总数的字段名称，默认：count
				,
			dataName: 'data' //规定数据列表的字段名称，默认：data
		},
		parseData: function(res) { //res 即为原始返回的数据
			return {
				"code": res.code, //解析接口状态
				"msg": res.msg, //解析提示文本
				"count": res.count, //解析数据长度
				"data": res.data.data //解析数据列表
			};
		},
		cols: [
			[{
				type: "checkbox",
				fixed: "left"
			}, {
				field: "id",
				width: 100,
				title: "ID",
				sort: !0
			}, {
				field: "name",
				title: "姓名",
				minWidth: 100
			}, {
				field: "stunum",
				title: "学号",
				width: 100
			}, {
				field: "college",
				title: "学院"
			}, {
				field: "major",
				title: "专业"
			}, {
				field: "grade",
				width: 80,
				title: "年级"
			}, {
				field: "political",
				title: "政治面貌"
			}, {
				field: "qq",
				title: "QQ"
			}, {
				field: "dormitory",
				title: "宿舍"
			}, {
				field: "phone",
				title: "电话"
			}, {
				field: "memid",
				title: "会员证编号"
			}, {
				field: "post",
				title: "职务"
			}, {
				field: "activityLevel",
				title: "活动等级"
			}, {
				field: "assessmentGrade",
				title: "考核等级"
			}, {
				title: "操作",
				width: 150,
				align: "center",
				fixed: "right",
				toolbar: "#table-useradmin-webuser"
			}]
		],
		page: true,
		height: "full-220",
		text: "对不起，加载出现异常！"
	}), i.on("tool(LAY-user-manage)", function(e) {
		e.data;
		if ("del" === e.event) layer.prompt({
			formType: 1,
			title: "敏感操作，请验证口令"
		}, function(t, i) {
			layer.close(i), layer.confirm("真的删除行么", function(t) {
				e.del(), layer.close(t)
			})
		});
		else if ("edit" === e.event) {
			t(e.tr);
			layer.open({
				type: 2,
				title: "编辑用户",
				content: "../../../views/user/user/userform.html",
				maxmin: !0,
				area: ["500px", "450px"],
				btn: ["确定", "取消"],
				yes: function(e, t) {
					var l = window["layui-layer-iframe" + e],
						r = "LAY-user-front-submit",
						n = t.find("iframe").contents().find("#" + r);
					l.layui.form.on("submit(" + r + ")", function(t) {
						t.field;
						i.reload("LAY-user-front-submit"), layer.close(e)
					}), n.trigger("click")
				},
				success: function(e, t) {}
			})
		}
	}), i.render({
		elem: "#LAY-user-back-manage",
		url: layui.setter.base + "json/useradmin/mangadmin.js",
		cols: [
			[{
				type: "checkbox",
				fixed: "left"
			}, {
				field: "id",
				width: 80,
				title: "ID",
				sort: !0
			}, {
				field: "loginname",
				title: "登录名"
			}, {
				field: "telphone",
				title: "手机"
			}, {
				field: "email",
				title: "邮箱"
			}, {
				field: "role",
				title: "角色"
			}, {
				field: "jointime",
				title: "加入时间",
				sort: !0
			}, {
				field: "check",
				title: "审核状态",
				templet: "#buttonTpl",
				minWidth: 80,
				align: "center"
			}, {
				title: "操作",
				width: 150,
				align: "center",
				fixed: "right",
				toolbar: "#table-useradmin-admin"
			}]
		],
		text: "对不起，加载出现异常！"
	}), i.on("tool(LAY-user-back-manage)", function(e) {
		e.data;
		if ("del" === e.event) layer.prompt({
			formType: 1,
			title: "敏感操作，请验证口令"
		}, function(t, i) {
			layer.close(i), layer.confirm("确定删除此管理员？", function(t) {
				console.log(e), e.del(), layer.close(t)
			})
		});
		else if ("edit" === e.event) {
			t(e.tr);
			layer.open({
				type: 2,
				title: "编辑管理员",
				content: "../../../views/user/administrators/adminform.html",
				area: ["420px", "420px"],
				btn: ["确定", "取消"],
				yes: function(e, t) {
					var l = window["layui-layer-iframe" + e],
						r = "LAY-user-back-submit",
						n = t.find("iframe").contents().find("#" + r);
					l.layui.form.on("submit(" + r + ")", function(t) {
						t.field;
						i.reload("LAY-user-front-submit"), layer.close(e)
					}), n.trigger("click")
				},
				success: function(e, t) {}
			})
		}
	}), e("useradmin", {})
});