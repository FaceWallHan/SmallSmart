package com.atguigu.web;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {
    private BookService bookService=new BookServiceImpl();
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 1);
        //获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart!=null){
            cart.updateCount(id, count);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    protected void addAjaxItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookId(id);
        CartItem cartItem=new CartItem(book.getId(), 1, book.getName(), book.getPrice(), book.getPrice());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        //最后一个添加的商品名称
//        request.getSession().setAttribute("lastName", cartItem.getName());
        //重定向回原来商品的地址
//        response.sendRedirect(request.getHeader("Referer"));
        Map<String ,Object>result=new HashMap<>();
        result.put("totalCount", cart.getTotalCount());
        result.put("lastName",cartItem.getName());
        response.getWriter().write(new Gson().toJson(result));
    }
}
