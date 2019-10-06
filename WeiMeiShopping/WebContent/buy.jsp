<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贵美商城-商品购买页</title>
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<script type="text/javascript" src="js/checkorderuser.js"></script>
<script type="text/JavaScript" defer="true">
		function openWindow(){
    var address=window.showModalDialog("address.htm","","dialogWidth=340px;dialogHeight=270px");
	  document.getElementById("address").value=address;	
		}
  function priceCalc(){
  	var oTr=document.getElementById("priceTable").getElementsByTagName("tr");
  	/**
  	* 因为priceTable从第三个tr开始出现价格列表，倒数第一行结束，所以i=2，i<trObject.length-1
  	* fSum为折扣后总价
  	* fTotal为原总价
  	*/
    var fSum=0;
    var fTotal=0;
		var j=1;
  	for (var i=2;i<oTr.length-1;i++){
  	  var oTd=oTr[i].getElementsByTagName("td");
  	  var fPrice=parseFloat(oTd[j].getElementsByTagName("span")[0].innerHTML.substring(1));
			var nCount=parseInt(oTd[j+3].getElementsByTagName("input")[0].value);
			var fRealPrice=fPrice*parseInt(oTd[j+2].getElementsByTagName("span")[0].innerHTML)/100;
  	  fSum  +=fRealPrice*nCount;
			fTotal+=fPrice*nCount;
      }  	 
  	}
  //三个参数分别是，购买填写数量，库存总数量，商品id
  function changeGoodsBuyNum(resporyTotalNum,goodsid){
	  var strbuynum = document.getElementById(goodsid).value;
	  var buynum = parseInt(strbuynum);
	  var totalNum = resporyTotalNum;
	 //alert("buynum="+buynum+",totalNum="+totalNum);
	// alert("totalNum类型："+typeof(totalNum)+",buynum类型："+typeof(buynum));
	//如果数量为0，判断是否要删除商品
		if (buynum == 0) {
			var flag = window.confirm("确认删除商品吗?");
			if (!flag) {
				buynum = 1;
			}
		}
		if (buynum > totalNum) {
			alert("已达到商品最大购买量");
			buynum = totalNum;
		}
	
		location.href = "${pageContext.request.contextPath}/GoodsChangCartServlet?goodsid="
				+goodsid+ "&buynum=" + buynum;
  }
  	/* function remove(oThis){
		oFather=oThis.parentNode;
		oFather.parentNode.parentNode.removeChild(oFather.parentNode);
		priceCalc();
	} */
	//删除某一项
	function removeGoods(goodsid){
		if(window.confirm("确认删除商品吗?")){
			location.href = "${pageContext.request.contextPath}/RemoveGoodsCartServlet?goodsid="+goodsid;
		}
	}
</script>
</head>
<body>
	<div id="container">
		<iframe id="header" src="header.jsp" width="980" height="136"
			frameborder="0" scrolling="no"></iframe>
		<div class="buy">
			<h4>
				<img src="images/mycart.gif" alt="alt" /> <a href="#">全场运费一律2元</a>
				<a href="#" class="b"
					onclick="JavaScript:window.open('calc.htm','计算器','width=200,height=200,toolbar=no,scrollbars=no,menubar=no,screenX=100,screenY=100')">简易计算器</a>
			</h4>
			<form id="buyForm" method="post" action="GoodsCreateOrderServlet">
			<table class="buy" cellpadding="0" cellspacing="0">
				<tbody id="priceTable">
					<tr class="buytitle">
						<td colspan="6" class="b">确认商品价格与交易条件</td>
					</tr>
					<tr>
						<td class="w364 b">&nbsp;&nbsp;&nbsp;&nbsp;商品名</td>
						<td class="w100 b">原价</td>
						<td class="w100 b">优惠价</td>
						<td class="w100 b">打折</td>
						<td class="w100 b">数量</td>
						<td class="w81 b">删除</td>
					</tr>
					<!-- 遍历加入购物车的商品 -->
					<c:set var="total" value="0" />
					<c:set var="totalyj" value="0" />
					<c:forEach items="${goodsCart }" var="entry">
						<tr class="h26 blue">
							<td><a
								href="SearchSingleElectricalInfoServlet?ElectricalId=${entry.key.goodsId}"
								title="攀高搓捶背靠垫按摩器（蓝色 ）（定制）">&nbsp;&nbsp;&nbsp;&nbsp;${entry.key.goodsName}</a></td>
							<td><span class="c9">${entry.key.goodsPrice}</span></td>
							<td><span class="red">${entry.key.goodsCurprice }</span></td>
							<td><span class="black">${entry.key.goodsCurprice/entry.key.goodsPrice*100}折</span></td>
							<!-- 折扣=现价/原价 -->
							<%--  <td><input onchange="priceCalc()" type="text" value="${entry.value }" maxlength="4" size="3"/></td> --%>
							<td><input id="${entry.key.goodsId }"
								onblur="changeGoodsBuyNum(${entry.key.goodsRepertory},${entry.key.goodsId });"
								type="text" value="${entry.value }" maxlength="4" size="3" /></td>
							<td><a href="#" onclick="removeGoods(${entry.key.goodsId})">删除</a></td>
						</tr>
						<c:set value="${total+entry.key.goodsCurprice*entry.value}"
							var="total" />
						<c:set value="${totalyj+entry.key.goodsPrice*entry.value}"
							var="totalyj" />
					</c:forEach>


					<tr class="h26">
						<td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="catlist.jsp">继续挑选商品</a></td>
						<td class="a_c" colspan="2" id="sum" class="pl58">商品共计：${total}元</td>
						<td colspan="3">你共节省：${totalyj-total}元</td>
					</tr>
				</tbody>
			</table>

			<!-- <form id="buyForm" method="post" action="consumerOrder.jsp"> -->
				<table class="buy">
					<tbody>
						<tr class="buytitle">
							<td colspan="2">补充您的邮件地址和联系人基本信息</td>
						</tr>
						<tr>
							<td class="a_r"><label for="username">收件人：</label></td>
							<td>
								<input type="text" name="username" id="username" onblur="checkUsername();" onfocus="clearInfo('usernameMsg')"/>
								<span id="usernameMsg" style="font-size: 14px; color:red"></span> 
							</td>
						</tr>
						<tr>
							<td class="a_r"><label for="address">地&nbsp;&nbsp;&nbsp;址：</label></td>
							<td id="selectPlace">
								<input type="text" name="address" id="address" onblur="checkAddress();" onfocus="clearInfo('addressMsg');"/> <!-- <a href="javascript:openWindow()" class="b">请点击填写地址</a> -->
								<span id="addressMsg" style="font-size: 14px; color:red"></span>
							</td>
						</tr>
						<tr>
							<!-- <td class="a_r"><label for="tel">电&nbsp;&nbsp;&nbsp;话：</label></td>
							<td><input class="w30" type="text" name="code" size="4" id="tel" />-<input class="w81" type="text" name="telnumber"
								size="8" />-<input class="w30" type="text" name="branchnumber"
								size="4" /><span class="red b"></span>（区号-电话号码-分机）</td> -->
							<td class="a_r"><label for="tel">电&nbsp;&nbsp;&nbsp;话：</label></td>
			 				<td>
			 					<input type="text" name="tel" id="tel"  onblur="checkPhone();" onfocus="clearInfo('phoneMsg');"/>
			 					<span id="phoneMsg" style="font-size: 14px; color:red"></span>
			 				</td>
			 				
						</tr>
						<tr>
							<td class="h65">&nbsp;</td>
							<td>
								<!-- <input class="imginput" onclick="checkAllOrderInfo();" type="image" src="images/submit.gif" /></td> -->
								<img src="images/submit.gif" class="imginput" style="border:0px;" onclick="checkAllOrderInfo();"/>
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