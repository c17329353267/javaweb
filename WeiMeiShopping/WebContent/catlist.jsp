<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贵美商城</title>
 <link rel="stylesheet"	type="text/css"	href="css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="css/layout.css"	/>
 <script type="text/JavaScript">
 	function multiCheck(oThis){
 		var oInput=document.getElementsByTagName("input");
 		for (var i=1;i<oInput.length;i++){ 	
 				oInput[i].checked=oThis.checked;}
 	}
	</script>
</head>
<body>
<div id="container">
	<iframe id="header" runat="server" src="header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	<div class="catlist a_c">
	<%-- <c:forEach items="${computerLists }" var="computers"></c:forEach> --%>
		 <ul class="w20p check">
			<h3><input type="checkbox" name="checkall" onclick="multiCheck(this)" />全选</h3>
			<li><input type="checkbox" /></li>
			<li><input type="checkbox" /></li>
			<!-- <li><input type="checkbox" /></li>
			<li><input type="checkbox" /></li>	 -->		
		</ul>
		<ul class="w20p">
			<h3>商品图片</h3>
			<!-- 此时点击应当跳回到servlet,根据当前的商品id进行再次查询后再次跳转到info.jsp -->
			<c:forEach items="${computerLists }" var="computers">
			<li><a href="SearchSingleElectricalInfoServlet?ElectricalId=${computers.goodsId }"><img src="${computers.imgpath}" alt="" /></a></li>
			</c:forEach>
		</ul>	
		
		<%-- <ul class="w20p">
			<h3>商品图片</h3>
			<li><a href="info.htm"><img src="images/list1.jpg" alt="" /></a></li>
			<li><a href="info.htm"><img src="images/list3.jpg" alt="" /></a></li>
			<li><a href="info.jsp"><img src="images/list2.jpg" alt="" /></a></li> 
			<li><a href="info.jsp"><img src="${computerLists[0].imgpath}" alt="" /></a></li>
		</ul>--%>
		
		<ul class="w50p info">
			<h3>商品名称/出售者/联系方式</h3>
			<c:forEach items="${computerLists }" var="computers">
				<li><a href="SearchSingleElectricalInfoServlet?ElectricalId=${computers.goodsId }">${computers.goodsIntroduce }</a><br />出售者：<a href="#">${computers.goodsLinkman }<br /></a><a href="#"><img src="images/contactme.gif" alt="alt" /> <img src="images/addfav.gif" alt="收藏" />收藏</a></li>		
			</c:forEach>
		</ul>
			
		<%-- <ul class="w50p info">
			<h3>商品名称/出售者/联系方式</h3>
			<li><a href="info.htm">杜比环绕，家庭影院必备，超真实享受</a><br />出售者：<a href="#">ling112233<br /><a href="#"><img src="images/contactme.gif" alt="alt" /> <img src="images/addfav.gif" alt="收藏" />收藏</a></li>
			<li><a href="info.htm">NVDIA 9999GT 512MB 256bit极品显卡，不容错过</a><br />出售者：<a href="#">aipiaopiao110<br /><a href="#"><img src="images/contactme.gif" alt="alt" /> <img src="images/addfav.gif" alt="收藏" />收藏</a></li>
			<li><a href="info.htm">精品热卖：高清晰，30寸等离子电视</a><br />出售者：<a href="#">阳光的挣扎<br /><a href="#"><img src="images/contactme.gif" alt="alt" /> <img src="images/addfav.gif" alt="收藏" />收藏</a></li>
			<li><a href="info.jsp">${computerLists[0].goodsIntroduce }</a><br />出售者：<a href="#">${computerLists[0].goodsLinkman }<br /><a href="#"><img src="images/contactme.gif" alt="alt" /> <img src="images/addfav.gif" alt="收藏" />收藏</a></li>																			
		</ul>--%>
		
		<ul class="w10p price">
			<h3>价格</h3>
			<c:forEach items="${computerLists }" var="computers">
			<li>一口价：<br />${computers.goodsCurprice }</li>
			</c:forEach>
		<%--<ul class="w10p price">
			<h3>价格</h3>
			<li>一口价：<br />2833.0</li>
			<li>一口价：<br />2460.0</li>
			<li>一口价：<br />18880</li>
			<li>一口价：<br />${computerLists[0].goodsCurprice }</li>
		</ul>  --%>
	</div>
	<iframe id="footer" runat="server" src="footer.htm" width="980" height="136" frameborder="0" scrolling="no"></iframe>
</div> <!--container end-->	
</body>
</html>