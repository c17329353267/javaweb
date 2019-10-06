<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贵美商城</title>
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<!-- <script type="text/JavaScript" src="js/func.js"></script> -->
<script type="text/javascript" src="js/registercheck.js"></script>
</head>
<body>
	<div id="container">
		<iframe id="header" src="header.jsp" width="980" height="136"
			frameborder="0" scrolling="no"></iframe>
		<!-- <form id="form1" method="post" action="register_success.htm"> -->
		<form id="form1" method="post" action="${pageContext.request.contextPath }/UserRegisterServlet" enctype="multipart/form-data">
			<!-- <input type="hidden" name="flag" value="1"> -->
			<table class="reg" cellspacing="0px" cellpadding="0px">
				<tbody>
					<tr>
						<td class="a_r w15p"><label for="fname">名字：</label></td>
						<td class="w500">
						<input name="fname" id="fname" type="text" onblur="checkFname();" onfocus="clearInfo('usernameMsg');"/>
						<span id="usernameMsg" style="font-size: 14px; color:red"></span>
						</td>
						
						<td class="protocol" rowspan="11">
							<h4>
								<img src="images/read.gif" alt="alt" />阅读贵美网服务协议
							</h4> <textarea cols="35" rows="15">欢迎阅读服务条款协议，本协议阐述之条款和条件适用于您使用Gmgw.com网站的各种工具和服务。

  本服务协议双方为贵美与贵美网用户，本服务协议具有合同效力。 
  贵美的权利和义务
    1.贵美有义务在现有技术上维护整个网上交易平台的正常运行，并努力提升和改进技术，使用户网上交易活动的顺利。 
    2.对用户在注册使用贵美网上交易平台中所遇到的与交易或注册有关的问题及反映的情况，贵美应及时作出回复。 
    3.对于在贵美网网上交易平台上的不当行为或其它任何贵美认为应当终止服务的情况，贵美有权随时作出删除相关信息、终止服务提供等处理，而无须征得用户的同意。 
    4.因网上交易平台的特殊性，贵美没有义务对所有用户的注册资料、所有的交易行为以及与交易有关的其他事项进行事先审查。 	
				  </textarea>
						</td>
					</tr>
					<tr>
						<td class="a_r"><label for="sname">姓氏：</label></td>
						<td>
						<input name="sname" id="lname" type="text"  onblur="checkLname();" onfocus="clearInfo('lnameMsg');"/>
						<span id="lnameMsg" style="font-size: 14px; color:red"></span>
						</td>
						
					</tr>
					<tr>
						<td class="a_r"><label for="lname">登录名：</label></td>
						<td>
						<input name="lname" id="sname" type="text" placeholder="可包含a-z、0-9 和下划线"  onblur="checkLoginName();" onfocus="clearInfo('loginNameMsg');"/>
						<span id="loginNameMsg" style="font-size: 14px; color:red"></span>
						</td>
						
					</tr>
					<tr>
						<td class="a_r"><label for="pass">密码：</label></td>
						<td>
						<input name="pass" id="pass" type="password" placeholder="至少包含 6个字符" onblur="checkPass();" onfocus="clearInfo('passMsg');"/>
						<span id="passMsg" style="font-size: 14px; color:red"></span>
						</td>
					</tr>
					<tr>
						<td class="a_r"><label for="rpass">再次输入密码：</label></td>
						<td>
						<input name="rpass" id="rpass" type="password" onblur="checkRpass();" onfocus="clearInfo('rePassMsg');"/>	
						<span id="rePassMsg" style="font-size: 14px; color:red"></span></td>
					</tr>
					<tr>
						<td class="a_r"><label for="email">电子邮箱：</label></td>
						<td>
						<input name="email" id="email" type="text" placeholder="必须包含 @ 字符" onblur="checkEmail();" onfocus="clearInfo('emailMsg');"/>
						<span id="emailMsg" style="font-size: 14px; color:red"></span>
						</td>
					</tr>
					<tr>
						<td class="a_r"><label for="gender">性别：</label></td>
						<td>
							<input name="gender" id="gender" class="b0" type="radio"
							value="男" checked="checked" /> <img src="images/Male.gif"
							alt="alt" />男&nbsp; <input name="gender" class="b0" type="radio"
							value="女" /> <img src="images/Female.gif" alt="alt" />女
							</td>
					</tr>
					<tr>
						<td class="a_r">头像：</td>
						<td>
						<input type="file" name="filepicture" id="filepicture"/>
						<span id="emailMsg" style="font-size: 14px; color:red"></span>
						</td>
					</tr>
					<tr>
						<!-- <td class="a_r"><label for="hobby">爱好：</label></td>
						<td><input class="b0" type="checkbox" name="hobby1" id="hobby"
							value="运动" />&nbsp;运动&nbsp;&nbsp; <input class="b0"
							type="checkbox" name="hobby2" value="聊天" />&nbsp;聊天&nbsp;&nbsp;
							<input class="b0" type="checkbox" name="hobby3" value="玩游戏" />&nbsp;玩游戏 -->

						</td>
					</tr>
					<tr>
						<td class="a_r"><label for="nYear">出生日期：</label></td>
						<td><input name="nYear" id="nYear" class="w40" value="2019"
							maxlength="4" onblur="checkYear()" onfocus="clearInfo('dateMsg');" />年
							<select name="nMonth" id="nMonth" onblur="checkMonth()" onfocus="clearInfo('dateMsg');">
								<option value="" selected="selected">[选择月份]</option>
								<option value="1">一月</option>
								<option value="2">二月</option>
								<option value="3">三月</option>
								<option value="4">四月</option>
								<option value="5">五月</option>
								<option value="6">六月</option>
								<option value="7">七月</option>
								<option value="8">八月</option>
								<option value="9">九月</option>
								<option value="10">十月</option>
								<option value="11">十一月</option>
								<option value="12">十二月</option>
						</select> <input id="nDay" name="nDay" value="16" class="w20" maxlength="2" onblur="checkDay();" onfocus="clearInfo('dateMsg');"/>日
						
						<span id="dateMsg" style="font-size: 14px; color:red"></span>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="pl150">
						<!-- <input type="image" name="submit" class="b0" src="images/submit.gif" /> -->
						<img src="images/submit.gif" id="Button" style="border:0px;" onclick="checkLogin();"/>
						<img src="images/reset.gif" class="hand" alt="重置" /></td>
					</tr>
				</tbody>
			</table>
		</form>
		<iframe id="footer" src="footer.htm" width="980" height="150"
			frameborder="0" scrolling="no"></iframe>
	</div>
	<!--container	end-->
</body>
</html>