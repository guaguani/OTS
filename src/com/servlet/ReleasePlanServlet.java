package com.servlet;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by guagua on 18/3/2.
 */
@WebServlet(name = "ReleasePlanServlet")
public class ReleasePlanServlet extends HttpServlet {
//    public void init(ServletConfig servletConfig) throws ServletException {
////        ServletContext servletContext = servletConfig.getServletContext();
////        WebApplicationContext webApplicationContext = WebApplicationContextUtils
////                .getWebApplicationContext(servletContext);
////        AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
////                .getAutowireCapableBeanFactory();
////        autowireCapableBeanFactory.configureBean(this, "venueService");
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        System.out.println("releasePlanServlet");
//        String theme = request.getParameter("theme");
//        System.out.println(theme);
//        String type = request.getParameter("type");
//        String time = request.getParameter("time");
//        String des = request.getParameter("des");
        String list = request.getParameter("fromlist");
        System.out.println(list);
        String[] fromlist = request.getParameterValues("fromlist");
//        String[] tolist = request.getParameterValues("tolist");
//        String[] pricelist = request.getParameterValues("pricelist");
        for(int i=0;i<fromlist.length;i++){
            System.out.println(fromlist[i]);
        }
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("success");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
