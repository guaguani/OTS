package com.filter;

import com.model.Venue_plan;
import com.service.VenueService;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

/**
 * Created by guagua on 18/3/20.
 */
@WebFilter(filterName = "GetPlanFilter")
public class GetPlanFilter implements Filter {
    private VenueService venueService;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        List<Venue_plan> plans = venueService.getAllPlans();
        System.out.println("getplanfilter");
        for (int i=0;i<plans.size();i++){
            System.out.println(plans.get(i).getTheme());
        }
        req.setAttribute("number",1);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(servletContext);
        if(cxt!=null && cxt.getBean("venueService")!=null && venueService == null){
            venueService = (VenueService) cxt.getBean("venueService");
        }
    }
}
