<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("a.deleteClass").click(function () {
				//在事件的function函数中..有一个this对象.。..这个this对象...是当前正在响应事件的dom对象...
				// confirm是确认提示框函数
				// 参数是它的提示内容
				// 它有两个按钮，一个确认，一个是取消。
				// 返回true表示点击了，确认，返回false表示点击取消。
				return confirm("你确定要删除["+$(this).parent().parent().find("td:first").text()+"]？");
			});
		});
	</script>

</head>
<body>
	<div id="main" class="manager">
		<table >
			<tr>
				<td>名称</td>	
				<td>图片</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td><img src="${book.imgPath}" style="width: 40px;height: 40px"></td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="8"><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>	
		</table>
		<%@include file="/pages/common/page_nav.jsp"%>
	</div>
</body>
</html>