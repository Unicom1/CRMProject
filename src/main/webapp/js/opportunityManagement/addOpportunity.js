/**
 * Created by gem-kerion on 2018/5/28.
 */
/*新建用户*/
function addOppo(){
	var bussessId = $('#bussessId').val();
	var bussessName = $('#bussessName').val();
	var bussessCustomerName = $('#bussessCustomerName').val();
	var bussessContactName = $('#bussessContactName').val();
	var bussessProgress = $('#bussessProgress option:selected') .val();
	var bussessState = $('#bussessState option:selected') .val();
	var bussessMoney = $('#bussessMoney').val();
	var bussessRate = $('#bussessRate option:selected') .val();
	var bussessRemark = $('#bussessRemark').val();
	var bussessNextContact = $('#bussessNextContact').val();

	// console.log(userName+","+userPassword+","+userSex+","+userAuthor+","+userDepartment+","+userEmail+","+userPhone+","+userAddress+","+userHead);

	$.ajax({
		url: '',
		data: {},
		dataType: 'json',
		type: 'POST',
		success: function (res) {
			if (res.state == 0) {
				layer.msg("新建商机成功！");
			} else if (res.state == 1){
				layer.msg("新建商机失败！");
			}else if (res.state == 2){
				layer.msg(res.errMsg);

			}
		},
		error: function () {
			layer.msg("网络连接失败！");
		}
	})

}