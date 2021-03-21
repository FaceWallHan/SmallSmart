<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>


	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
		<%--静态包含，登录 成功之后的菜单 --%>
		<%@ include file="/pages/common/login_success_menu.jsp"%>

	</div>
	<div id="main">
		<table>
			<tr>
				<td style="width: 200px">日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr><%--我的订单不为空场合--%>
			<c:if test="${not empty requestScope.orderList}">
				<c:forEach items="${requestScope.orderList}" var="order">
					<tr>
						<td>${order.createTime}</td>
						<td>${order.price}</td>
<%--						<td>${order.status}</td>--%>
						<td>
						<c:choose>
							<c:when test="${order.status == 'SHIP'}">待发货</c:when>
							<c:when test="${order.status == 'PAYMENT'}">
								<a class="payClass" href="orderServlet?action=payOrder&orderId=${order.orderId}">待支付</a>
							</c:when>
							<c:when test="${order.status == 'ARRIVE'}">
								<a class="signClass" href="orderServlet?action=signOrder&orderId=${order.orderId}">待收货</a>
							</c:when>
							<c:when test="${order.status == 'SIGNED'}">已签收</c:when>
<%--							<c:otherwise></c:otherwise>--%>
						</c:choose>
						</td>
						<td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty requestScope.orderList}">
				<tr>
					<td colspan="4"><a href="index.jsp">当前没有订单信息，过去首页进行下单吧！</a></td>
				</tr>
			</c:if>

		</table>
	</div>
	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>