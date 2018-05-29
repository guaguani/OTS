package com.servlet;

import com.service.VenueService;
import com.service.VenueServiceImpl;
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

/**
 * Created by guagua on 18/2/28.
 */
@WebServlet(name = "ModifyVenueInfoServlet")
public class ModifyVenueInfoServlet extends HttpServlet {
    public void init(ServletConfig servletConfig) throws ServletException {
        ServletContext servletContext = servletConfig.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils
                .getWebApplicationContext(servletContext);
        AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
                .getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.configureBean(this, "venueService");
    }

    /**
     * 修改场馆信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ModifyVenueInfoServlet");
        String venueid = request.getParameter("Username");
        System.out.println(venueid);
        String address = request.getParameter("address");
        String totalSeats = request.getParameter("totalseats");
        String rows = request.getParameter("rows");
        String seatsEachRow = request.getParameter("seatsEachRow");
        VenueService venueService = new VenueServiceImpl();
        venueService.modifyVenueSeatInfo(venueid,address,totalSeats,rows,seatsEachRow);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
