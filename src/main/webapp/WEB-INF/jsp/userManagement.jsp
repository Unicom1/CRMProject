	<%@ page language="java" contentType="text/html; charset=UTF-8"
			 pageEncoding="UTF-8"%>
	<!DOCTYPE html>
		<html lang="en">
		<head>
		<meta charset="UTF-8">
		<title>客户关系管理系统</title>
		<link rel="stylesheet" href="../../css/bootstrap/css/bootstrap.min.css" >
		<link href="../../css/bootstrap-table.min.css" rel="stylesheet">
		<!--<link href="../js/AdminLTE/css/AdminLTE.min.css" rel="stylesheet">-->
		<!--<link href="../js/AdminLTE/css/skins/_all-skins.min.css" rel="stylesheet">-->
		<link rel="stylesheet" href="../../css/index.css">
		<link rel="stylesheet" href="../../css/left_menu.css">
		<script src="../../js/jquery-3.2.1.js"></script>
		<!--<script src="../js/AdminLTE/js/app.min.js"></script>-->
		<script src="../../js/bootstrap.js"></script>
		<script src="../../js/bootstrap.min.js"></script>
		<!--<script src="../../js/bootstrap-table.min.js"></script>-->
		<!--<script src="../../js/bootstrap-table-zh-CN.min.js"></script>-->
		<script src="../../js/layer/layer.js"></script>
		<style>
		#userMenu{
		margin-left:10px;
		}
		#userMenu li{
		float:left;
		list-style:none;
		height:60px;
		width:150px;
		padding-top:10px;
		text-align:center;
		font-size:22px;
		border-bottom:2px solid #ffb173;
		}
		a:hover{
		text-decoration:none;
		}

		table thead tr th{
		text-align:center;
		}
		</style>
		</head>
		<body>
		<div class="wrapper">
		<div class="wmenu">
		<dl ><dt class="user"><a href="#" style="margin-left:15px;">首页</a></dt></dl>
		<dl style="background-color:#bdd7ee"><dt class="edit"><a href="#">用户管理</a></dt></dl>
		<dl><dt class="edit"><a href="#">商机管理</a></dt></dl>
		<dl><dt class="edit"><a href="#">产品管理</a></dt></dl>
		<dl><dt class="edit"><a href="#">产品管理</a></dt></dl>
		<dl><dt class="edit"><a href="#">编辑管理</a></dt></dl>
		<dl><dt class="edit"><a href="#">编辑管理</a></dt></dl>
		<dl><dt class="edit"><a href="#">编辑管理</a></dt></dl>
		</div>
		<div style="float:right;margin-right:50px;margin-top:20px;font-size:15px;"><a href="/index/logout">退出系统</a></div>
		<div class="content" style="margin-left:170px;">
		<div>
		<ul id="userMenu">
		<li><a href="javascript:void(0)" onclick="">用户列表</a></li>
		<!--<li style="border:none;"><a href="javascript:void(0)" onclick="" style="color:grey;">修改密码</a></li>-->
		</ul>
		</div>
		<div class="" style="position:relative;top:70px;right:120px;">
		<button type="button" id="" class="btn btn-primary" onclick="jumpAddUser()">新建用户</button>
		</div>
		<div style="width:95%;padding:60px 20px;">
		<table class="table table-bordered table-condensed list_table" id="userTable" style="text-align:center;background-color:#ffffff;width:90%;position:relative;top:20px;left:20px;">
		<thead >
		<tr>
		<th width="8%">ID</th>
		<th width="10%">用户名</th>
		<th width="8%">性别</th>
		<th width="8%">权限</th>
		<th width="8%">部门</th>
		<th width="15%">手机号</th>
		<th width="15%">邮箱</th>
		<!--<th width="15%">头像</th>-->
		<th>操作</th></tr>
		</thead>
		<tbody>
		<tr>
		<td></td>
		<td >123</td>
		<td ></td>
		<td></td>
		<td></td>
		<td ></td>
		<!--<td></td>-->
		<td></td>
		<td >
		<a style="margin-right: 15px;"  href="">修改密码</a>
		<a style="margin-right: 15px;"  href="">编辑</a>
		<a style="color: #FF0000;" href="javascript: void(0)" onclick="deleteAction(this)">删除</a>
		</td>
		</tr>
		</tbody>
		</table>
		<div id="navPage"></div>
		</div>
		</div>

		</div>
		<script type="text/javascript">

		$(document).ready(function(){
		renderPageNav('navPage',1,3);
		getUser('1');

		});

		$('.wmenu dl dt').click(function(){
		$(this).toggleClass('icotop');
		$(this).siblings('dd').toggleClass('hidden');
		});

		function deleteUser(self) {
		//var userName = $(self).parentNode.parentNode.firstChild.nextSibling.innerHTML;
		console.log($(self).previousSibling);
		layer.confirm("确定删除该用户？", {
		title:false,
		btn: ['确定', '取消'] //可以无限个按钮
		}, function (index) {
		//按钮【按钮一】的回调
		$.ajax({
		url: "/User/deleteUser" ,
		data: {'userName':self},
		dataType: "json",
		success: function (res) {
		if (res.state == 0) {
		layer.msg("删除成功！");
		setTimeout(
		"window.location.reload();",
		800
		)
		} else {
		layer.alert("删除失败!" );
		}
		},
		error: function () {
		layer.msg("网络出错！");
		}
		})
		});
		}

		function renderPageNav(eleId, pageIndex, totalResult) {
		var pageIndexInt = parseInt(pageIndex),
		totalResultInt = parseInt(totalResult),
		totalPage = parseInt(totalResultInt / 10),
		pageNavStr = '';

		if (totalResultInt % 10 > 0) {
		totalPage++;
		}

		pageNavStr += '<nav aria-label="Page navigation"><ul class="pagination">';

		if (pageIndexInt == 1) {
		pageNavStr = pageNavStr + "<li class=\"disabled\"><a aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>";
		}
		else {
		pageNavStr = pageNavStr + "<li><a aria-label=\"Previous\" onclick=\"getUser(" + (pageIndexInt - 1) + ");\"><span aria-hidden=\"true\">&laquo;</span></a></li>";
		}

		if (pageIndexInt < 6) {
		for (var i = 1; i < pageIndexInt; i++) {
		pageNavStr = pageNavStr + "<li><a onclick=\"getUser(" + i + ");\">" + i + "</a></li>";
		}
		}
		else if (pageIndexInt < totalPage - 3) {
		for (var i = pageIndexInt - 5; i < pageIndexInt; i++) {
		pageNavStr = pageNavStr + "<li><a onclick=\"getUser(" + i + ");\">" + i + "</a></li>";
		}
		}
		else {
		for (var i = totalPage - 9; i < pageIndexInt; i++) {
		pageNavStr = pageNavStr + "<li><a onclick=\"getUser(" + i + ");\">" + i + "</a></li>";
		}
		}

		pageNavStr = pageNavStr + "<li class=\"active\"><a>" + pageIndexInt + "</a></li>";

		if (pageIndexInt < 6) {
		for (var i = pageIndexInt + 1; i <= 10 && i <= totalPage; i++) {
		pageNavStr = pageNavStr + "<li><a onclick=\"getUser(" + i + ");\">" + i + "</a></li>";
		}
		}
		else if (pageIndexInt < totalPage - 3) {
		for (var i = pageIndexInt + 1; i <= pageIndexInt + 4; i++) {
		pageNavStr = pageNavStr + "<li><a onclick=\"getUser(" + i + ");\">" + i + "</a></li>";
		}
		} else {
		for (var i = pageIndexInt + 1; i <= totalPage; i++) {
		pageNavStr = pageNavStr + "<li><a onclick=\"getUser(" + i + ");\">" + i + "</a></li>";
		}
		}

		if (pageIndexInt == totalPage) {
		pageNavStr = pageNavStr + "<li class=\"disabled\"><a aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>";
		}
		else {
		pageNavStr = pageNavStr + "<li><a aria-label=\"Next\" onclick=\"getUser(" + (pageIndexInt + 1) + ");\"><span aria-hidden=\"true\">&raquo;</span></a></li>";
		}

		pageNavStr += '</ul></nav>';

		$('#' + eleId).get(0).innerHTML = pageNavStr;
		}

		function getUser(startPage){
		$.ajax({
		url: '/User/selectAllUserByPage',
		data: {'startPage':startPage,'pageSize':'10'},
		dataType: 'json',
		type: 'POST',
		success: function (res) {
		if(res.state == "ERROR") {
			layer.msg("获取数据出错，请联系管理员");
			return false;
		}
		else if(res.state==0){
		$('#userTable tbody').html("");
		$.each(res.aaData,function(index,item){

		$("#userTable").append(
		'<tr >' +
		//                                '<td ><input type="checkbox" name="select"></td >'+
		//                                '<td  align="center"  ><a  href="javascript:void(0)" style="text-decoration: none">'+result.data[i]+'</a></td>'+
		'<td>'+item.id+'</td>'+
		'<td>'+item.userName+'</td>'+
		'<td>'+item.userSex+'</td>'+
		'<td>'+item.userAuthor+'</td>'+
		'<td>'+item.userDepartment+'</td>'+
		'<td>'+item.userPhone+'</td>'+
		'<td>'+item.userEmail+'</td>'+
		'<td>'+
		'<ul  >' +
		'<li><a href="javascript:void(0)" onclick="">编辑</a></li>' +
		' <li><a href="javascript:void(0)" onclick="deleteUser('+item.userName+')">删除</a></li>' +
		' </ul>' +
		' </td>' +
		'</tr>'
		)
		});
		}
		},
		error: function () {
		layer.msg("网络连接失败！");
		}
		})
		}

		<%--function deleteUser(userName){--%>
			<%--layer.open({--%>
				<%--title:"删除框",--%>
				<%--content:'<span>是否要删除此条数据？</span>',--%>
				<%--btn:['确认','取消'],--%>
				<%--yes:function(index){--%>
					<%--$.ajax({--%>
					<%--url: '/User/deleteUser',--%>
					<%--data: {'userName':userName},--%>
					<%--dataType: 'json',--%>
					<%--type: 'POST',--%>
					<%--success: function (res) {--%>
						<%--if(res.state == 0){--%>
							<%--window.location.href= '/User/userManagementPage'--%>
						<%--} else if(res.state == "ERROR") {--%>
							<%--layer.msg("删除出错，请联系管理员");--%>
							<%--return false;--%>
						<%--}--%>
					<%--},--%>
					<%--error: function () {--%>
					<%--layer.msg("网络出错！");--%>
					<%--}--%>
			<%--})--%>
					<%--}--%>

			<%--})--%>
		<%--}--%>

		function jumpAddUser(){
		window.location.href='/User/addUserPage';
		}
		</script>
		</body>
		</html>