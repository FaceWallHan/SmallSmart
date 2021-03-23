<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>我的订单</title>
<%@ include file="/pages/common/head.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
<%--	<div id="header">--%>
<%--			<img class="logo_img" alt="" src="static/img/logo.gif" >--%>
<%--			<span class="wel_word">订单详情</span>--%>
<%--			<%@ include file="/pages/common/login_success_menu.jsp" %>--%>
<%--	</div>--%>

	<div id="main">

		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
			</tr>
            <c:forEach items="${requestScope.orderItemList}" var="orderItem">
                <tr>
                    <td>${orderItem.name}</td>
                    <td>${orderItem.count}</td>
                    <td>${orderItem.price}</td>
                    <td>${orderItem.totalPrice}</td>
                </tr>
            </c:forEach>

		</table>


	</div>

<%--	<%@ include file="/pages/common/footer.jsp" %>--%>
</body>
</html>