<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>
</head>
<body>
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
			</tr>
			<%String name="待发货";%>
			<c:if test="${not empty requestScope.allOrder}">
				<c:forEach items="${requestScope.allOrder}" var="order">
					<tr>
						<td style="width: 200px">${order.createTime}</td>
						<td>${order.price}</td>
						<td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
						<td>
							<c:choose>
								<c:when test="${order.status == 'SHIP'}">
									<a href="orderServlet?action=sendOrder&orderId=${order.orderId}">点击发货</a>
								</c:when>
								<c:when test="${order.status == 'PAYMENT'}">待支付</c:when>
								<c:when test="${order.status == 'ARRIVE'}">待收货</c:when>
								<c:when test="${order.status == 'SIGNED'}">已签收</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>