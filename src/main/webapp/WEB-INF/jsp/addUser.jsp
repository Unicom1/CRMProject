	<%@ page language="java" contentType="text/html; charset=UTF-8"
			 pageEncoding="UTF-8"%>
	<!DOCTYPE html>
		<html lang="en">
		<head>
		<meta charset="UTF-8">
		<title>客户关系管理系统</title>
		<link rel="stylesheet" href="/css/bootstrap/css/bootstrap.min.css" >
		<!--<link href="../js/AdminLTE/css/AdminLTE.min.css" rel="stylesheet">-->
		<!--<link href="../js/AdminLTE/css/skins/_all-skins.min.css" rel="stylesheet">-->
		<link rel="stylesheet" href="/css/index.css">
		<link rel="stylesheet" href="/css/left_menu.css">
		<script src="/js/jquery-3.2.1.js"></script>
		<!--<script src="../js/AdminLTE/js/app.min.js"></script>-->
		<script src="/js/bootstrap.js"></script>
		<script src="/js/bootstrap.min.js"></script>
		<script src="/js/layer/layer.js"></script>
		<style>
		#userMenu li{
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
		</style>
		</head>
		<body >
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
		<div class="header" style="background-color:#ffffff;height:62px;width:100%;padding-top:15px;padding-left:50px;font-size:22px;">
		新建用户
		<span style="margin-left:50px;font-size:15px;"><a style="" href='/User/userManagementPage'>返回上一页面</a></span>
		</div>
		<div class="row" style="background-color:#f3f3f3;padding-top:20px;padding-left:75px;">
		<form class="form-horizontal col-sm-9" role="form" id="saveGoodsInfoForm">
		<div class="form-group col-md-offset-1">
		<label class="col-sm-2 control-label" for="userName">用户名</label>
		<div class="col-sm-8">
		<input type="text"  class="form-control" id="userName"
		placeholder="请输入用户名" value="" required>
		</div>
		</div>
		<div class="form-group col-md-offset-1">
		<label class="col-sm-2 control-label" for="userPassword">用户密码</label>
		<div class="col-sm-8">
		<input type="text"  class="form-control" id="userPassword"
		placeholder="请输入用户密码" value="" required>
		</div>
		</div>
		<div class="form-group col-md-offset-1">
		<label class="col-sm-2 control-label" >用户性别</label>
		<div class="col-sm-8" style="padding-top:5px;">
		<label><input type="radio" name="userSex"   value="0" checked="checked"/>男</label>
		<label><input type="radio" name="userSex"   style="margin-left:30px;" value="1"/>女</label>
		</div>
		</div>
		<div class="form-group col-md-offset-1">
		<label class="col-sm-2 control-label" >用户权限</label>
		<div class="col-sm-8" style="padding-top:5px;">
		<label><input type="radio" name="userAuthor"   value="0" checked="checked"/>管理员</label>
		<label><input type="radio" name="userAuthor"   style="margin-left:30px;" value="1"/>总经理</label>
		<label><input type="radio" name="userAuthor"   style="margin-left:30px;" value="2"/>部门经理</label>
		<label><input type="radio" name="userAuthor"   style="margin-left:30px;" value="3"/>部门工作人员</label>
		</div>
		</div>
		<div class="form-group col-md-offset-1">
		<label class="col-sm-2 control-label" >用户部门</label>
		<div class="col-sm-8" style="padding-top:5px;">
		<label><input type="radio" name="userDepartment"   value="0" checked="checked"/>销售部</label>
		<label><input type="radio" name="userDepartment"   style="margin-left:30px;" value="1"/>产品部</label>
		<label><input type="radio" name="userDepartment"   style="margin-left:30px;" value="2"/>财务部</label>
		</div>
		</div>
		<div class="form-group col-md-offset-1">
		<label class="col-sm-2 control-label" for="userEmail">用户邮箱</label>
		<div class="col-sm-8">
		<input type="text"  class="form-control" id="userEmail"
		placeholder="请输入用户邮箱" value="" required>
		</div>
		</div>
		<div class="form-group col-md-offset-1">
		<label class="col-sm-2 control-label" for="userPhone">用户手机号</label>
		<div class="col-sm-8">
		<input type="text"  class="form-control" id="userPhone"
		placeholder="请输入用户手机号" value="" required>
		</div>
		</div>
		<div class="form-group col-md-offset-1">
		<label class="col-sm-2 control-label" for="userAddress">用户地址</label>
		<div class="col-sm-8">
		<input type="text"  class="form-control" id="userAddress"
		placeholder="请输入用户地址" value="" required>
		</div>
		</div>
		<div class="form-group col-md-offset-1">
		<label class="col-sm-2 control-label" >用户头像</label>
		<div class="col-sm-8">
		<!--<input type="text"  class="form-control" id="userHead"-->
		<!--placeholder="请输入头像" value="" required>-->
		<input type="file" id="file" style="display:none;" onchange="filechange(event)">
		<!--//修改，这里如果不用onchange，会出现一个小bug,当你提交后，图片只能变一次-->
		<img src="" width="75px" height="75px" id="img-change" alt="点击选择图片">
		<!--<button id="btn">保存图片</button>-->
		</div>
		</div>
		<div class="text-center" style="margin-top:25px;">
		<button type="button" id="storeBtn" class="btn btn-primary" onclick="addUser()">保&nbsp;存</button>
		</div>
		</form>
		</div>
		</div>

		</div>
		<script type="text/javascript">
		/*新建用户*/
		function addUser(){
		var userName = $('#userName').val();
		var userPassword = $('#userPassword').val();
		var userSex = parseInt($("input[name='userSex']:checked").val());
		var userAuthor = parseInt($("input[name='userAuthor']:checked").val());
		var userDepartment = parseInt($("input[name='userDepartment']:checked").val());
	
		var userEmail = $('#userEmail').val();
		var userPhone = $('#userPhone').val();
		var userAddress = $('#userAddress').val();
		var userHead =  $("#img-change").attr("src");

		 console.log(userName+","+userPassword+","+userSex+","+userAuthor+","+userDepartment+","+userEmail+","+userPhone+","+userAddress+","+userHead);
		
		var jsonData = {
		'userName':userName,'userPassword':userPassword,'userSex':userSex,'userAuthor':userAuthor,'userDepartment':userDepartment,
		'userEmail':userEmail,'userPhone':userPhone,'userAddress':userAddress,'userHead':userHead
		}
		var json = 
{
  "userAddress": "string",
  "userAuthor": "0",
  "userDepartment": 0,
  "userEmail": "string",
  "userHead": "",
  "userName": "xxxx",
  "userPassword": "123456",
  "userPhone": "string",
  "userSex": 0
}
		
		$.ajax({
		url: '/User/addUser',
		data: JSON.stringify(jsonData),
		dataType: 'json',
		contentType: 'application/json',
		type: 'POST',
		success: function (res) {
		if (res.state == 0) {
		layer.msg("创建成功！");
		} else if (res.state == 1){
		layer.msg("用户已存在！");
		}else if (res.state == 2){
		layer.msg(res.errMsg);

		}
		},
		error: function () {
		layer.msg("网络连接失败！");
		}
		})

		}

		/*
		选择头像图片
		*/
		$("#img-change").click(function () {
		$("#file").click();
		});
		/*$("#file").change(function (event) {*/
		var filechange=function(event){
		var files = event.target.files, file;
		if (files && files.length > 0) {
		// 获取目前上传的文件
		file = files[0];// 文件大小校验的动作
		if(file.size > 1024 * 1024 * 2) {
		alert('图片大小不能超过 2MB!');
		return false;
		}
		// 获取 window 的 URL 工具
		var URL = window.URL || window.webkitURL;
		// 通过 file 生成目标 url
		var imgURL = URL.createObjectURL(file);
		//用attr将img的src属性改成获得的url
		$("#img-change").attr("src",imgURL);
		// 使用下面这句可以在内存中释放对此 url 的伺服，跑了之后那个 URL 就无效了
		// URL.revokeObjectURL(imgURL);
		}
		};
		</script>
		</body>
		</html>