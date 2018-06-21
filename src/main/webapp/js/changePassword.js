/**
 * Created by gem-kerion on 2018/5/27.
 */
function changePassword(){
	layer.confirm("确定修改密码吗？", {
		title:'修改密码',
		content:'<div>'+
		'<div><span>用户原密码：</span><input type="password"  id="userOldPassword" placeholder="请输入用户原密码"></div>'+
		'<div style="margin:20px 0"><span>用户新密码：</span><input type="password"  id="userNewPassword" placeholder="请输入用户新密码"></div>'+
		'<div><span>重复新密码：</span><input type="password"  id="repeatUserNewPassword" placeholder="请再次输入用户新密码"></div>'+
		'</div>',
		btn: ['确定', '取消'] //可以无限个按钮
	}, function (index) {
		//按钮【按钮一】的回调
			var userOldPassword = $('#userOldPassword').val();
			var userNewPassword = $('#userNewPassword').val();
			var repeatUserNewPassword = $('#repeatUserNewPassword').val();

			if (userNewPassword !== repeatUserNewPassword) {
				layer.msg("新密码与重复新密码不一致！");
			} else if(userOldPassword==''){
				layer.msg("用户原密码不能为空！");
			}else if(userNewPassword==''){
				layer.msg("用户新密码不能为空！");
			}else if (userNewPassword == repeatUserNewPassword) {
				$.ajax({
					url: '/User/changeUserPass',
					data: {'oldPass': userOldPassword, 'newPass': userNewPassword},
					dataType: 'json',
					type: 'POST',
					success: function (res) {
						if (res.state == 0) {
							layer.msg("修改密码成功！");
						} else if (res.state == 1) {
							layer.msg("修改密码失败！");
						}
					},
					error: function () {
						layer.msg("网络连接失败！");
					}
				})
			}

	});
}