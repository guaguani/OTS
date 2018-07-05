package com.action;

import com.bean.*;
import com.service.OrderService;
import com.service.OrderServiceImpl;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Servlet implementation class StockListServlet
 */
@WebServlet("/Order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Order() {
		super();
	}
	
	public void init() {
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
		HttpSession session = request.getSession(false);

		String result="SUCCESS";
		OrderPageBean orderPageBean=(OrderPageBean)session.getAttribute("orderPagebean");
		UserBean userBean=(UserBean)session.getAttribute("userbean");

		if(func.equals("can")) {
			String oid=request.getParameter("id");
			result=orderService.cancleOrder(Integer.parseInt(oid));
			orderPageBean.setType("已取消");
			orderPageBean.setOffset(8);
			ArrayList<String> style=orderPageBean.getStyle();
			for(int i=0;i<orderPageBean.getTypes().size();i++){
				if(orderPageBean.getTypes().get(i).equals("已取消")){
					style.set(i,"color:#ff7919;");
				}
				else{
					style.set(i,"");
				}
			}
			orderPageBean.setStyle(style);
			orderPageBean.setBeans(orderService.getOrder(0,userBean.getId(),"已取消"));

			session.setAttribute("orderPagebean", orderPageBean);
		}
		else if(func.equals("pay")) {
			//oid:account:password:sum pay
			String id = request.getParameter("oid");
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			String sum = request.getParameter("sum");
			result=orderService.userPay(account,password,Double.parseDouble(sum),Integer.parseInt(id));
			orderPageBean.setType("未使用");
			orderPageBean.setOffset(8);
			ArrayList<String> style=orderPageBean.getStyle();
			for(int i=0;i<orderPageBean.getTypes().size();i++){
				if(orderPageBean.getTypes().get(i).equals("未使用")){
					style.set(i,"color:#ff7919;");
				}
				else{
					style.set(i,"");
				}
			}
			orderPageBean.setStyle(style);
			orderPageBean.setBeans(orderService.getOrder(0,userBean.getId(),"未使用"));

			session.setAttribute("orderPagebean", orderPageBean);

			String back = "[{'answer':'"+result+"'}]";
			System.out.println(back);
			JSONArray json = new JSONArray(back);
			PrintWriter writer = response.getWriter();
			writer.print(json);
			writer.flush();
			writer.close();
		}
		else if(func.equals("cond")) {
			String type=request.getParameter("type");
			orderPageBean.setType(type);
			orderPageBean.setOffset(8);
			ArrayList<String> style=orderPageBean.getStyle();
			for(int i=0;i<orderPageBean.getTypes().size();i++){
				if(orderPageBean.getTypes().get(i).equals(type)){
					style.set(i,"color:#ff7919;");
				}
				else{
					style.set(i,"");
				}
			}
			orderPageBean.setStyle(style);
			orderPageBean.setBeans(orderService.getOrder(0,userBean.getId(),type));

			session.setAttribute("orderPagebean", orderPageBean);
		}
		else if(func.equals("ord")) {
			String id = request.getParameter("oid");
			OrderBean orderBean=orderService.getOrderByID(Integer.parseInt(id));

			session.setAttribute("orderbean", orderBean);
		}
		else{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			int offset=orderPageBean.getOffset();
			orderPageBean.setOffset(offset+8);
			session.setAttribute("orderPagebean", orderPageBean);

			ArrayList<OrderBean> or=orderService.getOrder(offset,userBean.getId(),orderPageBean.getType());
			String back="[";
			for(int i=0;i<or.size();i++) {
				OrderBean ord=or.get(i);
				back=back+"{'id':'"+ord.getId()+"','state':'"+ord.getState()+"','c_time':'"+ord.getCreateDate()+"','aid':'"+ord.getActid()+
						"','path':'"+ord.getPath()+"','a_name':'"+ord.getActName()+"','a_time':'"+ord.getActTime()+
						"','v_name':'"+ord.getVenueName()+"','sum':'"+ord.getSum()+"'},";
			}
			if(back.length()>1) {
				back=back.substring(0, back.length()-1);
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(back);
				back = m.replaceAll("");
			}
			back=back+"]";
			System.out.println(back);
			JSONArray json = new JSONArray(back);
			PrintWriter writer = response.getWriter();
			writer.print(json);
			writer.flush();
			writer.close();

		}
	}
	
}
