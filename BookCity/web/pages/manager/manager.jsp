<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
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
			<img  style="height: 80px;width: 80px" class="logo_img" alt="" src="static/img/system.jpg" >
			<span class="wel_word">后台管理系统</span>
		<%-- 静态包含 manager管理模块的菜单  --%>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	<center>
		<table>
			<tr>
				<td>
					<iframe name="my_if" width="1200" height="500" frameborder="no" ></iframe>
				</td>
				<td>
					<ul>
						<li><a href="orderServlet?action=showAllOrders" target="my_if">订单管理</a></li>
						<li><a href="manager/bookServlet?action=page" target="my_if">商品管理</a></li>
					</ul>
				</td>
			</tr>
		</table>
	</center>
	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>