package com.action;

import com.bean.ActivityBean;
import com.bean.SearchPageBean;
import com.bean.UserBean;
import com.service.*;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Servlet implementation class StockListServlet
 */
@WebServlet("/Act")
public class Act extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActService actService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Act() {
		super();
	}
	
	public void init() {
		actService=new ActServiceImpl();
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
		HttpSession session = request.getSession(true);

		String result="SUCCESS";
		SearchPageBean searchPageBean=(SearchPageBean)session.getAttribute("searchPagebean");
		UserBean userBean=(UserBean)session.getAttribute("userbean");

		if(func.equals("cond")) {
			String city=request.getParameter("city");
			String type=request.getParameter("type");

			if(city.equals("")){
				city=searchPageBean.getCur_city();
			}
			else{
				searchPageBean.setCur_city(city);
				userBean.setCurPos(city);
			}
			if(type.equals("")){
				type=searchPageBean.getCur_type();
			}
			else{
				searchPageBean.setCur_type(type);
				userBean.setCurType(type);
				ArrayList<String> style=searchPageBean.getStyle();
				for(int i=0;i<searchPageBean.getType().size();i++){
					if(searchPageBean.getType().get(i).equals(type)){
						style.set(i,"background-color: #ff7919;");
					}
					else{
						style.set(i,"");
					}
				}
				searchPageBean.setStyle(style);
			}
			searchPageBean.setCur_offset(8);
			searchPageBean.setCur_input("");
			searchPageBean.setBeans(actService.selectByCond(city,type,0));

			session.setAttribute("userbean", userBean);
			session.setAttribute("searchPagebean", new SearchPageBean());
		}
		else if(func.equals("inp")) {
			String inp = request.getParameter("inp");
			searchPageBean.setCur_input(inp);
			userBean.setCurInput(inp);

			searchPageBean.setCur_offset(8);
			searchPageBean.setBeans(actService.selectByNameOrVen(inp, 0));

			session.setAttribute("userbean", userBean);
			session.setAttribute("searchPagebean", new SearchPageBean());
		}
		else if(func.equals("act")) {
			String id = request.getParameter("id");
			ActivityBean activityBean=actService.getByID(Integer.parseInt(id));

			session.setAttribute("activityBean", activityBean);
		}
		else{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			int offset=searchPageBean.getCur_offset();
			searchPageBean.setCur_offset(offset+8);
			session.setAttribute("searchPagebean",searchPageBean);
			ArrayList<ActivityBean> list;
			if(searchPageBean.getCur_input().equals("")){
				list=actService.selectByCond(searchPageBean.getCur_city(),searchPageBean.getCur_type(),offset);
			}
			else{
				list=actService.selectByNameOrVen(searchPageBean.getCur_input(),offset);
			}
			String back="[";
			for(int i=0;i<list.size();i++) {
				ActivityBean a=list.get(i);
				back=back+"{'id':"+a.getId()+",'name':\""+a.getName()+"\",'s_time':\""+a.getFirst()+"\",'e_time':\""+a.getLast()+
						"\",'vname':\""+a.getVname()+"\",'city':\""+a.getCity()+"\",'price':"+a.getPrice()+
						",'path':\""+a.getPath()+"\"},";
			}
			if(back.length()>1) {
				back=back.substring(0, back.length()-1);
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(back);
				back = m.replaceAll("");
			}

			back=back+"]";
			back = "[{'answer':'"+result+"'}]";
			System.out.println(back);
			JSONArray json = new JSONArray(back);
			PrintWriter writer = response.getWriter();
			writer.print(json);
			writer.flush();
			writer.close();
		}
	}
	
}
