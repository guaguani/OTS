package com.action;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.OrderPageBean;
import com.bean.SearchPageBean;
import com.bean.UserBean;
import com.service.OrderService;
import com.service.OrderServiceImpl;
import com.service.UserService_new;
import com.service.UserService_newImpl;
import org.json.JSONArray;


/**
 * Servlet implementation class StockListServlet
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService_new userservice;
	private OrderService orderService;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User() {
		super();
	}
	
	public void init() {
		userservice=new UserService_newImpl();
		orderService=new OrderServiceImpl();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String func=request.getParameter("func");
		System.out.println("GET IN FOR TYPE "+func);
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
		HttpSession session = request.getSession(true);

		String result="SUCCESS";

		if(func.equals("in")) {
			String id=request.getParameter("id");
			String pwd=request.getParameter("pwd");
			result=userservice.logIn(id, pwd);
			if(!result.equals("SUCCESS")) {
				result="FAIL";
			}

			session.setAttribute("username", id);
			Cookie cookie = new Cookie("user", id);
			cookie.setPath("/");
			cookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(cookie);
			Cookie c2 = new Cookie("order_select_type", "all");
			c2.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(c2);
			Cookie c3 = new Cookie("order_select_offset", ""+8);
			c3.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(c3);

			UserBean userbean=userservice.getUserInfo(id);
			OrderPageBean orderPagebean=new OrderPageBean();
			orderPagebean.setOffset(8);
			orderPagebean.setType("全部订单");
			orderPagebean.setBeans(orderService.getOrder(0,id,"全部订单"));

			session.setAttribute("userbean", userbean);
			session.setAttribute("orderPagebean", orderPagebean);
			session.setAttribute("searchPagebean", new SearchPageBean());
		}
		else {
			Cookie cookie1 = new Cookie("user", null);
			cookie1.setMaxAge(0);
			cookie1.setPath("/");
			response.addCookie(cookie1);
			if (null != session) {
				session.setAttribute("username", "");
				session.setAttribute("userbean", new UserBean());
				session.setAttribute("orderPagebean", new OrderPageBean());
			}
		}
		String back = "[{'answer':'"+result+"'}]";
		System.out.println(back);
		JSONArray json = new JSONArray(back);
		PrintWriter writer = response.getWriter();
		writer.print(json);
		writer.flush();
		writer.close();
	}
	
}
