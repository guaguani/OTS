package com.filter;

import com.service.VenueService;
import com.service.VenueServiceImpl;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by guagua on 18/2/21.
 */
@WebFilter(filterName = "GetVenueIdFilter")
public class GetVenueIdFilter implements Filter {
    private VenueService venueService;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        int serialNumber = venueService.getVenueSerialNumber();
        System.out.println("serialnumber is:"+String.valueOf(serialNumber));
        req.setAttribute("serialNumber",serialNumber);
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
