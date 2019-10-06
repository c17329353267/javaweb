//当输入框得到焦点时检测取消
function clearInfo(currentInfo){
	//根据传入的参数可以知道需要清除指定的样式
	document.getElementById(currentInfo).innerHTML = "";
}
//检查名字
function checkFname(){
	var fname = document.getElementById("fname");
	var reg = /^\w+$/;
	if(!reg.test(fname.value)){
		document.getElementById("usernameMsg").innerHTML = "用户名不合法";
		return false;
	}else{
		document.getElementById("usernameMsg").innerHTML = "";
		return true;
	}
	
}
//检查姓氏
function checkLname(){
	var lname = document.getElementById("lname");
	var reg = /^\w+$/;
	if(!reg.test(lname.value)){
		document.getElementById("lnameMsg").innerHTML = "姓氏不合法";
		return false;
	}else{
		document.getElementById("lnameMsg").innerHTML = "";
		return true;
	}
	
}
//检查登陆名
function checkLoginName(){
	var loginName = document.getElementById("sname");
	var reg = /^[A-Za-z0-9]{4,}/;
	if(!reg.test(loginName.value)){
		document.getElementById("loginNameMsg").innerHTML = "登陆名不合法";
		return false;
	}else{
		document.getElementById("loginNameMsg").innerHTML = "";
		return true;
	}
}
//检查输入密码
function checkPass(){
	var pwd = document.getElementById("pass");
	var reg = /^[a-zA-Z]\w{6,17}$/;
	if(!reg.test(pwd.value)){
		document.getElementById("passMsg").innerHTML = "密码不合法";
		return false;
	}else{
		document.getElementById("passMsg").innerHTML = "";
		return true;
	}
}
//在此确认密码
function checkRpass(){
	var rePwd = document.getElementById("rpass");
	var pwd = pwd = document.getElementById("pass");
	if(rePwd.value != pwd.value){
		document.getElementById("rePassMsg").innerHTML = "两次输入密码不一致";
		return false;
	}else{
		document.getElementById("rePassMsg").innerHTML = "";
		return true;
	}
}
//验证电子邮箱
function checkEmail(){
	var email = document.getElementById("email");
	var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(!reg.test(email.value)){
		document.getElementById("emailMsg").innerHTML = "邮箱不合法";
		return false;
	}else{
		document.getElementById("emailMsg").innerHTML = "";
		return true;
	}
}
//获取年
function checkYear(){
	var nyear = document.getElementById("nYear");
	var reg = /^\d{4}/;
	if(!reg.test(nyear.value)){
		document.getElementById("dateMsg").innerHTML = "年份输入有误&nbsp;&nbsp;"
		return false;
	}else{
		document.getElementById("dateMsg").innerHTML = "";
		return true;
	}	
}
//检查年份
function checkMonth(){
	var nmonth = document.getElementById("nMonth");
	//alert(nmonth.value);
	if(nmonth.value == ""){
		document.getElementById("dateMsg").innerHTML = "请填写月份&nbsp;&nbsp;";
		return false;
	}else{
		document.getElementById("dateMsg").innerHTML = "";
		return true;
	}
}
//检查天数
function checkDay(){
	var nDay = document.getElementById("nDay");
	//var reg = /^[0,1,2][0-9]|[3][0,1]/;
	var reg = /^((0?[1-9])|((1|2)[0-9])|30|31)$/;
	if(!reg.test(nDay.value)){
		document.getElementById("dateMsg").innerHTML = "请正确填写日期&nbsp;&nbsp;";
		return false;
	}else{
		return true;
	}
}
//测试文件域
function checkFilePicture(){
	alert("进入测试文件域中");
}
//检查
function checkLogin(){
	if(checkFname()&&checkLname()&&checkLoginName()&&checkPass()&&checkRpass()&&
	checkEmail()&&checkYear()&&checkMonth()&&checkDay()){
		document.getElementById("form1").submit();
	}
}
