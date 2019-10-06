-<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贵美商城</title>
 <link rel="stylesheet"	type="text/css"	href="css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="css/layout.css"	/>
 	<script type="text/JavaScript">
	var strHome = 'http://www.gmgw.com';
	function addFav(){
		switch(getNav()){
			case 1:
			  window.external.addFavorite(strHome,'贵美商城');
			  break;
			case 2:
			  window.sidebar.addPanel('贵美商城',strHome,'');
			  break;
			case 0:
			  alert("加入收藏失败");
			  break;
		}		
		function getNav(){
			if(navigator.userAgent.indexOf("MSIE")!=-1)    return 1;
			if(navigator.userAgent.indexOf("Firefox")!=-1) return 2;
			return 0;
			}
	}
	function setHome(oThis){
		oThis.style.behavior='url(#default#homepage)';
		oThis.setHomePage(strHome);
		return false;
	} 	
	function showTime(){
		now=new Date;
		document.write(now.getYear()+"年"+(now.getMonth()+1)+"月"+now.getDate()+"日"+now.getHours()+"点"+now.getMinutes()+"分");	
	}
	</script>
</head>
<body>
<div id="header">
			<div id="logo"></div>
			<div class="menu">
				<ul>
					<li class="pic pic1"></li>
					<li class="txt"><a href="buy.jsp" target="_parent">购物车</a></li>
					<li class="pic pic2"></li>
					<li class="txt"><a href="help.htm" target="_parent">帮助中心</a></li>
					<li class="pic pic3"></li>
					<li class="txt"><a href="JavaScript:void(0);" onclick="addFav();">加入收藏</a></li>		
					<li class="pic pic4"></li>
					<li class="txt"><a href="JavaScript:void(0);" onclick="setHome(this);">设为首页</a></li>			
					<li class="pic btn txt"><a href="login.jsp" target="_parent">登录</a></li>
					<li class="pic btn txt"><a href="register.jsp" target="_parent">注册</a></li>
				</ul>
			</div> <!--menu	end-->
			<div class="f_r w62p">
				<ul>
					<li class="txt hello">你好，欢迎${register.loginName }访问贵美商城！<script type="text/JavaScript">showTime();</script></li>
				</ul>
			</div> 
  		<div class="nav f_l w100p">
  			<ul>
  				<!-- <li><a href="index.jsp" target="_parent">&nbsp;首&nbsp;&nbsp;&nbsp;页&nbsp;</a></li> -->
  				<li><a href="LoadingLunBoPictureServlet" target="_parent">&nbsp;首&nbsp;&nbsp;&nbsp;页&nbsp;</a></li>
  				<li><a href="#" target="_parent">家用电器</a></li>
  				<li><a href="#" target="_parent">手机数码</a></li>
  				<li><a href="#" target="_parent">日用百货</a></li>
  				<li><a href="#" target="_parent">&nbsp;书&nbsp;&nbsp;&nbsp;籍&nbsp;</a></li>
  				<li><a href="#" target="_parent">帮助中心</a></li>
  				<li><a href="#" target="_parent">免费开店</a></li>
  				<li><a href="#" target="_parent">全球咨询</a></li>  
  				<!-- <li><a href="catlist.htm" target="_parent">家用电器</a></li>
  				<li><a href="catlist.htm" target="_parent">手机数码</a></li>
  				<li><a href="catlist.htm" target="_parent">日用百货</a></li>
  				<li><a href="catlist.htm" target="_parent">&nbsp;书&nbsp;&nbsp;&nbsp;籍&nbsp;</a></li>
  				<li><a href="help.htm" target="_parent">帮助中心</a></li>
  				<li><a href="help.htm" target="_parent">免费开店</a></li>
  				<li><a href="help.htm" target="_parent">全球咨询</a></li>   -->				
  			</ul>
  		</div>	<!--nav	end-->		
		</div> <!--header	end-->	
</body>
</html>