package com.action;

import com.model.Plan_seat;
import com.model.User;
import com.model.Venue_plan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.model.Venue;
import com.sun.deploy.net.HttpRequest;
import com.sun.scenario.effect.FilterContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.service.VenueService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guagua on 18/2/21.
 */
@Component("venueAction")
@Scope("prototype")
public class VenueAction extends ActionSupport {

    private static final long serialVersionUID =1L;

    @Autowired
    private VenueService venueService;

    private Venue venue;

    private List<Venue_plan> plans;


//    private String Username;
//
//    private String password;


    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public VenueService getVenueService() {
        return venueService;
    }

    @Resource
    public void setVenueService(VenueService venueService) {
        this.venueService = venueService;
    }

    public List<Venue_plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Venue_plan> plans) {
        this.plans = plans;
    }
//    public String getUsername(){return Username;}
//
//    public void setUsername(String username){
//        this.Username = username;
//    }


    /**
     * 场馆登录
     * @return
     */
    public String queryVenue(){
        String Username = getParam("Username");
        String password = getParam("Password");
        HttpSession session=ServletActionContext.getRequest().getSession();
        if(Username==null){
            Username = session.getAttribute("Username").toString();
            password = session.getAttribute("password").toString();
        }
        System.out.println(Username);
        System.out.println(password);
        Venue venue = venueService.queryVenue(Integer.parseInt(Username));
        String pw = venue.getPassword();
        if(pw.equals(password)) {
            ActionContext actionContext = ActionContext.getContext();
            //登录以后直接获得场馆地址和座位信息
            String address = venue.getAddress();
            int totalSeats = venue.getTotalseats();
            int rows = venue.getRows();
            System.out.println(rows);
            int seatsEachRow = venue.getSeatsEachRow();
            plans = venueService.getOwnPlans(Username);
            //这是为了让jsp中获得Username值
            actionContext.put("Username",Username);
            actionContext.put("venue_address",address);
            actionContext.put("totalSeats",totalSeats);
            actionContext.put("rows",rows);
            actionContext.put("seatsEachRow",seatsEachRow);
            session.setAttribute("Username",Username);
            session.setAttribute("password",password);
            session.setAttribute("rows",rows);
            session.setAttribute("venue_address",address);
            session.setAttribute("totalSeats",totalSeats);
            session.setAttribute("seatsEachRow",seatsEachRow);
            return SUCCESS;
        }
        else{
            return ERROR;
        }
    }

    /**
     * 注册场馆
     * @return
     */
    public String addVenue(){
        String Username = getParam("Username");
        List<Venue> venues = venueService.getAllVenues();
        boolean ifRegistered = false;
        String result = null;
        ActionContext actionContext = ActionContext.getContext();
        for(int i=0;i<venues.size();i++){
            if(Username.equals(venues.get(i).getId())){
                ifRegistered = true;
                actionContext.put("result","haveRegistered");
                System.out.println("the venue has registered");
            }
        }
        if(ifRegistered == true){
            //该场馆已被注册过，当然根据我的编码场馆是不存在被注册过的情况的
            result = ERROR;
        }
        else {
            String password = getParam("Password");
            String address = getParam("address");
            String totalseats = getParam("totalseats");
            String rows = getParam("rows");
            String seatsEachRow = getParam("seatsEachRow");
            venueService.venueRegister(Username, password, address, totalseats, rows, seatsEachRow);
            actionContext.put("Username",Username);
            result = SUCCESS;
        }
        return result;
    }

    /**
     * 修改场馆信息
     * @return
     */
    public String modifyVenueInfo(){
        HttpSession session=ServletActionContext.getRequest().getSession();
        String Username = session.getAttribute("Username").toString();
        List<Venue>venues = venueService.getVenueInfo(Username);
        ActionContext actionContext = ActionContext.getContext();
        if(venues.size()>0){
            if(venues.size()>1){
                actionContext.put("result","Wrong");
                return ERROR;
            }
            else{
                Venue venue = venues.get(0);
                String oldaddr = venue.getAddress();
                int oldtotal = venue.getTotalseats();
                int oldrow = venue.getRows();
                int oldseateach = venue.getSeatsEachRow();
                if(getParam("address")==null||getParam("totalseats")==null||
                        getParam("rows")==null||getParam("seatsEachRow")==null){
                    actionContext.put("result","Wrong");
                    return ERROR;
                }
                else{
                    String address = getParam("address");
                    int totalSeats = Integer.parseInt(getParam("totalseats"));
                    int rows = Integer.parseInt(getParam("rows"));
                    int seatsEachRow = Integer.parseInt(getParam("seatsEachRow"));
                    int multi = rows*seatsEachRow;
                    if((!oldaddr.equals(address))||(totalSeats!=oldtotal)||
                            (rows!=oldrow)||(seatsEachRow!=oldseateach)&&(totalSeats==multi)){
                        System.out.println("符合修改场馆信息的条件");
                        venueService.modifyVenueSeatInfo(Username,address,getParam("totalseats"),getParam("rows"),getParam("seatsEachRow"));
                        actionContext.put("Username",Username);
                        actionContext.put("venue_address",address);
                        actionContext.put("totalSeats",totalSeats);
                        actionContext.put("rows",rows);
                        actionContext.put("seatsEachRow",seatsEachRow);
                        return SUCCESS;
                    }
                    else{
                        actionContext.put("result","Wrong");
                        return ERROR;
                    }
                }
            }
        }
        else {
            actionContext.put("result","Wrong");
            return ERROR;
        }
    }

    /**
     * 发布计划
     */
    public String releasePlan(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String Username = session.getAttribute("Username").toString();
        String theme = getParam("plan_theme");
        String type = getParam("plan_type");
        String time = getParam("plan_time");
        String description = getParam("plan_des");
        String[] fromlist = ServletActionContext.getRequest().getParameterValues("from_td");
        String[] tolist = ServletActionContext.getRequest().getParameterValues("to_td");
        String[] pricelist = ServletActionContext.getRequest().getParameterValues("price_td");

        int len = 0;
        if(theme==null){
            return ERROR;
        }
        else if(type==null){
            return ERROR;
        }
        else if(time==null){
            return ERROR;
        }
        else if(description==null){
            return ERROR;
        }
        else if(fromlist.length==0||tolist.length==0||pricelist.length==0) {
            return ERROR;
        }
        else if(fromlist[0]==null||tolist[0]==null||pricelist[0]==null){
            return ERROR;
        }
        else if(!(fromlist[0].trim().equals("1"))){
            return ERROR;
        }
        else{
            for(int i=0;i<fromlist.length;i++){
                if((fromlist[i]==null)||tolist[i]==null||pricelist[i]==null){
                    len = i;
                    break;
                }
                else{
                    len++;
                }
            }
            len=len-1;
            for(int i=0;i<len;i++){
                int temp = Integer.parseInt(tolist[i])+1;
                if(temp!=Integer.parseInt(fromlist[i+1])){
                    return ERROR;
                }
            }

            String rows = session.getAttribute("rows").toString();

            if(Integer.parseInt(tolist[len])!=Integer.parseInt(rows)){
                return ERROR;
            }
            else{
                String[]from = new String[len+1];
                String[]to = new String[len+1];
                String[]price = new String[len+1];
                for(int i=0;i<=len;i++){
                    from[i] = fromlist[i];
                    to[i] = tolist[i];
                    price[i] = pricelist[i];
                }
                venueService.savePlan(Username,theme.trim(),type.trim(),time.trim(),description.trim(),from,to,price);
                queryVenue();
                return SUCCESS;
            }
        }
    }

    /**
     * 获得jsp页面的值
     * @param key
     * @return
     */
    protected String getParam(String key){
        return ServletActionContext.getRequest().getParameter(key);
    }
}
