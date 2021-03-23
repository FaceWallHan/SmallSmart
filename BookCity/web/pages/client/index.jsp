<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/12
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>书城首页</title>

  <%-- 静态包含 base标签、css样式、jQuery文件 --%>
  <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("button.addToCart").click(function () {
                //在事件响应的function函数中，有一个this对象，这个this对象，是当前正在响应事件的dom对象
                var  bookId=$(this).attr("bookId");
                <%--location.href="${requestScope.basePath}"+"cartServlet?action=addItem&id="+bookId;--%>
<%--                发送ajax请求，添加商品到购物车--%>
                $.getJSON("${requestScope.basePath}cartServlet","action=addAjaxItem&id="+bookId,function (data) {
                    $("#cartTotalCount").text("您的购物车中有"+data.totalCount+"件商品")
                    $("#cartLastName").text(" 您刚刚将"+data.lastName+"加入到了购物车中")
                    console.log(data)
                })
            });
        });
  </script>

</head>
<body>

<div id="header">
  <img  style="height: 80px;width: 80px" class="logo_img" alt="" src="static/img/system.jpg" >
  <span class="wel_word">小小商城</span>
  <div>
      <c:if test="${empty sessionScope.user.username}">
<%--            //没有登录--%>
            <a href="pages/user/login.jsp">用户登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;

      </c:if>
      <c:if test="${ not empty sessionScope.user.username}">
<%--            //已经登录--%>
          <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
          <a href="orderServlet?action=showMyOrders">我的订单</a>
          <a href="userServlet?action=logOut">注销</a>&nbsp;&nbsp;
      </c:if>
      <a href="pages/cart/cart.jsp">购物车</a>
      <a href="pages/user/managerLogin.jsp">后台管理</a>
  </div>
</div>

<div id="main">
  <div id="book">
    <div class="book_cond">
      <form action="client/bookServlet" method="get">
          <input type="hidden" name="action" value="pageByPrice">
        价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
        <input id="max" type="text" name="max" value="${param.max}"> 元
        <input type="submit" value="查询" />
      </form>
    </div>
    <div style="text-align: center">
        <c:if test="${empty sessionScope.cart.itemMap}">
            <span id="cartTotalCount" ></span>
            <div><span style="color: red" id="cartLastName">当前购物车为空</span></div>
        </c:if>
        <c:if test="${ not empty sessionScope.cart.itemMap}">
            <span id="cartTotalCount">您的购物车中有${sessionScope.cart.totalCount}件商品</span>
            <div>
                <span style="color: red" id="cartLastName">${sessionScope.lastName}</span>
            </div>
        </c:if>
    </div>
      <c:forEach items="${requestScope.page.items}" var="book">
          <div class="b_list">
              <div class="img_div">
                  <img class="book_img" alt="${book.imgPath}" src="${book.imgPath}" />
              </div>
              <div class="book_info">
                  <div class="book_name">
                      <span class="sp1">书名:</span>
                      <span class="sp2">${book.name}</span>
                  </div>
                  <div class="book_author">
                      <span class="sp1">产地:</span>
                      <span class="sp2">${book.author}</span>
                  </div>
                  <div class="book_price">
                      <span class="sp1">价格:</span>
                      <span class="sp2">￥${book.price}</span>
                  </div>
                  <div class="book_sales">
                      <span class="sp1">销量:</span>
                      <span class="sp2">${book.sales}</span>
                  </div>
                  <div class="book_amount">
                      <span class="sp1">库存:</span>
                      <span class="sp2">${book.stock}</span>
                  </div>
                  <div class="book_add">
                      <button bookId="${book.id}" class="addToCart">加入购物车</button>
                  </div>
              </div>
          </div>
      </c:forEach>


  </div>

    <%@include file="/pages/common/page_nav.jsp"%>

</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>
