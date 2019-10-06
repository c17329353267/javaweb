//当页面获得间焦点时清除提示信息
function clearInfo(infomsg){
	document.getElementById(infomsg).innerHTML = "";
}
//检查收件人姓名
function checkUsername(){
	var username = document.getElementById("username").value;
	var reg = /^[\u4E00-\u9FA5A-Za-z0-9]+$/;
	if(!reg.test(username)){
		document.getElementById("usernameMsg").innerHTML = "用户名不合法";
		return false;
	}else{
		document.getElementById("usernameMsg").innerHTML = "";
		return true;
	}
}
//检查收获地址
function checkAddress(){
	var receiveaddr = document.getElementById("username").value;
	var reg=/^[\u4E00-\u9FA5A-Za-z0-9]+$/;
	if(!reg.test(receiveaddr)){
		document.getElementById("addressMsg").innerHTML = "请填写正确收件地址";
		return false;
	}else{
		document.getElementById("addressMsg").innerHTML = "";
		return true;
	}
}
//检查电话是否正确
function checkPhone(){
	var telphoneNum = document.getElementById("tel").value;
	var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
	if(!reg.test(telphoneNum)){
		document.getElementById("phoneMsg").innerHTML = "请填写正确电话";
		return false;
	}else{
		document.getElementById("phoneMsg").innerHTML = "";
		return true;
	}
}
function checkAllOrderInfo(){
	if(checkUsername()&&checkAddress()&&checkPhone()){
		document.getElementById("buyForm").submit();
	}
}

