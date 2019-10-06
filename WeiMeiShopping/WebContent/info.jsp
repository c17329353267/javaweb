<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贵美商城-商品分类页</title>
 <link rel="stylesheet"	type="text/css"	href="css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="css/layout.css"	/>
 <script type="text/JavaScript" defer="true">
	var oImg=document.getElementById("show").getElementsByTagName("img");
	for(var i=1;i<=(oImg.length-3);i++){
		oImg[i].onmouseover=function(){oImg[0].src=this.src.replace('.jpg','_big.jpg');
			this.style.border='2px #ff7300 solid';}
		oImg[i].onmouseout=function(){this.style.border='2px #ccc solid';}
 	}
 </script>
</head>
<body>
<div id="container">
	<iframe id="header" src="header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	<div class="good">
		<h1>${singlegoods.goodsName }</h1>
		<ul class="f_l" id="show">
			<!-- <li class="bigimg"><a href="buy.htm"><img src="images/show1_big.jpg" alt="笔记本大图" /></a></li> -->
			<li class="bigimg"><a href="buy.jsp"><img src="${goodimg.imgpath }" alt="购买大图" /></a></li>
			<c:forEach items="${allsmallimgs}" var="smallimg">
				<li class="smallimg"><img src="${smallimg.imgpath}" alt="购买小图1" /></li>
			</c:forEach>
			<!-- <li class="smallimg"><img src="images/show1.jpg" alt="购买小图1" /></li>
			<li class="smallimg"><img src="images/show2.jpg" alt="小图2" /></li>
			<li class="smallimg"><img src="images/show3.jpg" alt="小图3" /></li>
			<li class="smallimg"><img src="images/show4.jpg" alt="小图4" /></li>
			<li class="smallimg"><img src="images/show5.jpg" alt="小图5" /></li>		 -->	
			<li class="op clear f_l"><a href="#"><img src="images/share.gif" alt="分享" /></a></li>
			<li class="op f_l"><a href="#"><img src="images/favthis.gif" alt="藏" /></a></li>			
		</ul>
		<ul class="goodinfo f_l">
			<li>一 口 价：<span>${singlegoods.goodsCurprice } </span></li>
			<li>运　　费：<span>免运费</span></li>
			<!-- 将商品加入购物车 -->
			<!-- <li class="h74 buynow"><a href="buy.htm"><img src="images/buynow.gif" alt="alt" /></a></li> -->
			<li class="h74 buynow"><a href="GoodsCartServlet?goodsId=${singlegoods.goodsId }"><img src="images/buynow.gif" alt="alt" /></a></li>
			<li class="onlinepay">此商品支持<a href="#">网银支付</a>，网上汇款免手续费。<br />收货满意后出售者才能拿钱，货款都安全！</li>
			<li>剩余时间：<span>10天23小时</span></li>
			<li>本期售出：<span>2件</span></li>
			<li>累计售出：<span>8件</span></li>
			<li class="f_l w175">商品类型：<span>全新</span></li>
			<li>所 在 地：<span>山西太原</span></li>
			<!-- <li class="f_l w175">商品数量：<span>1件</span></li> -->
			<li class="f_l w175">商品数量：<span>${singlegoods.goodsRepertory}件</span></li>
			<li>浏 览 量：<span>17次</span></li>			
		</ul>
	</div>
	<iframe id="footer" src="footer.htm" width="980" height="136" frameborder="0" scrolling="no"></iframe>
</div> <!--container end-->
</body>
</html>