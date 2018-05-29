package com.action;

import com.model.Plan_seat;
import com.model.Venue;
import com.model.Venue_plan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.model.User;
import com.service.VenueService;
import com.util.MD5Util;
import com.util.SendMailUtil;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.service.UserService;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guagua on 18/2/21.
 */
@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport{

    private static final long serialVersionUID =1L;

    @Autowired
    private UserService userService;

    @Autowired
    private VenueService venueService;

    private User user;

    private String email;

    private String password;

    private int state;

    private int level;

    private double cost;

    private int integral;

    private int backTimes;

    private int ordertimes;

    private List<Venue_plan> plans;

    private List<Plan_seat> orders;

    private List<Integer> seatRs;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }


    public List<Plan_seat> getOrders() {
        return orders;
    }

    public void setOrders(List<Plan_seat> orders) {
        this.orders = orders;
    }


    public List<Integer> getSeatRs() {
        return seatRs;
    }

    public void setSeatRs(List<Integer> seats) {
        this.seatRs = seats;
    }

    public int getBackTimes() {
        return backTimes;
    }

    public void setBackTimes(int backTimes) {
        this.backTimes = backTimes;
    }

    public int getOrdertimes() {
        return ordertimes;
    }

    public void setOrdertimes(int ordertimes) {
        this.ordertimes = ordertimes;
    }

    /**

     * 注册用户
     * @return
     */
    public String addUser(){
        email = getParam("Email");
        password = getParam("Password");
        String result = null;
        String judgeUser = userService.exists(email);
        ActionContext actionContext = ActionContext.getContext();
        if(judgeUser.equals("activated")){
            //用户存在，激活了
            actionContext.put("result","activated");
            result = ERROR;
        }
        else if(judgeUser.equals("notActivated")){
            //用户存在，没有激活
            actionContext.put("result","notActivated");
            result = ERROR;
        }
        else if(judgeUser.equals("UserNotExist")){
            //用户不存在，可以增加该用户
            ServletContext context = ServletActionContext.getServletContext();
            if(!email.matches("^\\w+@(\\w+\\.)+\\w+$")){
                //不是邮箱，提示错误。
                context.getRequestDispatcher("/jsp/Fail.jsp");
            }
            else{
                //注册邮箱
                //发送验证邮件
                System.out.println("succeed to create user:"+email);
                StringBuffer content = new StringBuffer("<h2>请点击下面的链接激活帐号，链接只能使用一次，请尽快激活！</h2>");
                String nameMd5 = MD5Util.encodeToHex(email+"审核通过");//创建加密字符串
                content.append("<a style='font-size:16px;' href='http://localhost:8080/activate?action=activate&")
                        .append("email=" + email + "&name=" + nameMd5 +"'>")
                        .append("http://localhost:8080/activate?action=activate&")
                        .append("email=" + email + "&name=" + nameMd5 + "</a><br/><br/>")
                        .append("<span style='color:blue;font-size:20px;font-weight:bold;'>———Welcome to Tickets！<span>");
                SendMailUtil.send(email, content.toString());//开始发送邮件
                }

            User user = new User();
            int symbol = email.indexOf("@");
            int length = email.length();
            String mail1 = null;
            String mail2 = null;
            mail1 = email.substring(0,symbol);
            mail2 = email.substring(symbol+1,length);
            user.setUserid(mail1);
            user.setTypeofemail(mail2);
            user.setPassword(password);
            user.setActivate(0);
            user.setCost(0);
            user.setIntegral(0);
            user.setLevel(0);
            user.setState(1);
            user.setBacktimes(0);
            user.setOrdertimes(0);
            userService.save(user);
            actionContext.put("result","AddUser");
            result = SUCCESS;
        }
        return result;
    }

    public String activate(){
        String email = getParam("email");
        userService.activate(email);
        return SUCCESS;
    }

    /**
     * 用户登录
     * @return
     */
    public String queryUser(){
        email = getParam("Email");
        password = getParam("Password");
        HttpSession session=ServletActionContext.getRequest().getSession();
        if(email==null){
            email = session.getAttribute("Username").toString();
            password = session.getAttribute("password").toString();
            System.out.println("Email:"+email);
        }
        user = userService.getUser(email);
        String pw = user.getPassword();
        int activate = user.getActivate();
        level = user.getLevel();
        cost = user.getCost();
        state = user.getState();
        integral = user.getIntegral();
        backTimes = user.getBacktimes();
        ordertimes = user.getOrdertimes();

        ActionContext actionContext = ActionContext.getContext();
        if(user!=null) {
            if (pw.equals(password)) {
                if (activate == 1) {
                    actionContext.put("Username", email);
                    actionContext.put("level",level);
                    actionContext.put("cost",cost);
                    actionContext.put("state",state);
                    actionContext.put("integral",integral);
                    actionContext.put("password",pw);
                    session.setAttribute("Username",email);
                    session.setAttribute("state",state);
                    session.setAttribute("password",pw);
                    session.setAttribute("level",level);
                    session.setAttribute("cost",cost);
                    session.setAttribute("integral",integral);
                    //用户登录的同时获得所有的计划和自己的账单
                    plans = venueService.getAllPlans();
                    orders = userService.getAllOrders(email);
                    System.out.println("获得自己的清单");
                    //获得退订次数
//                    System.out.println(email);
//                    backTimes = userService.getBackTimes(email);
//                    ordertimes = userService.getOrderTimes(email);
//                    System.out.println("预订次数："+ordertimes);
                    return SUCCESS;
                } else {
                    actionContext.put("result", "notActivated");
                    return ERROR;
                }
            } else {
                actionContext.put("result", "wrongPW");
                return ERROR;
            }
        }
        else{
            actionContext.put("result", "UserNotExist");
            return ERROR;
        }
    }

    /**
     * 修改用户信息，只能修改密码
     * @return
     */
    public String modifyUserInfo(){
        HttpSession session=ServletActionContext.getRequest().getSession();
        String password = getParam("password");
        String oldpw = session.getAttribute("password").toString();
        String email = session.getAttribute("Username").toString();
        if(oldpw.equals(password)){
            return ERROR;
        }
        else{
            userService.modifyPw(password,email);
            queryUser();
            return SUCCESS;
        }
    }

    /**
     * 取消会员资格
     * @return
     */
    public String cancelMember(){
        HttpSession session=ServletActionContext.getRequest().getSession();
        String email = session.getAttribute("Username").toString();
        userService.cancelMember(email);
        return SUCCESS;
    }

    //计划详情页面
    public String showOnePlan(){
        String planid = getParam("id");
        System.out.println(planid);
        //根绝planid获得订单的其他信息，并且传送到plan.jsp中
        List<Venue_plan> plans = venueService.getOnePlan(planid);
        Venue_plan plan = plans.get(0);
        int venueid = plans.get(0).getId();
        System.out.println(venueid);
        List<Venue> venues = venueService.getVenueInfo(String.valueOf(venueid));
        Venue venue = venues.get(0);
        HttpSession session=ServletActionContext.getRequest().getSession();
        //这里应该获得计划所有已经预订的座位号
        List<Plan_seat> plan_seats = venueService.getAllReservedSeats(planid);
        List<Integer> seatR = new ArrayList<>();
        for(int i=0;i<plan_seats.size();i++){
            seatR.add(plan_seats.get(i).getSeatid());
        }
        seatRs = seatR;
        System.out.println("seats:"+seatRs.size());

        session.setAttribute("venueid",venueid);
        session.setAttribute("userid",getParam("Username"));
        session.setAttribute("venueAdd",venue.getAddress());
        session.setAttribute("venueRows",venue.getRows());
        session.setAttribute("venueSeat",venue.getSeatsEachRow());
        session.setAttribute("theme",plan.getTheme());
        session.setAttribute("type",plan.getType());
        session.setAttribute("time",plan.getTime());
        session.setAttribute("description",plan.getDescription());
        session.setAttribute("planid",plan.getPlanid());

        return SUCCESS;
    }

    //预订票
    public String reserveTickets(){
        String [] seats = ServletActionContext.getRequest().getParameterValues("seats");
        System.out.println("reserveTickets");
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<seats.length;i++){
            list.add(seats[i]);
            System.out.println("action:"+seats[i]);
        }
        String userid = getParam("userid");
        String planid = getParam("planid");
        String venueid = getParam("venueid");
        String result = userService.reserveTickets(list,userid,planid,venueid);
        if(result.equals("SUCCESS")) {
            return SUCCESS;
        }
        else{
            ActionContext actionContext = ActionContext.getContext();
            actionContext.put("result","票已被预订");
            return ERROR;
        }
    }

    /**
     * 支付
     * @return
     */
    public String payOrder(){
        String orderid = getParam("id");
        String username = getParam("Username");
        userService.payOrder(orderid,username);
        queryUser();
        return SUCCESS;
    }

    /**
     * 退订
     * @return
     */
    public String cancelOrder(){
        String orderid = getParam("id");
        String username = getParam("Username");
        String result = userService.cancelOrder(orderid,username);
        if(result.equals("SUCCESS")){
            queryUser();
            return SUCCESS;
        }
        else{
            return ERROR;
        }
    }

    public String allocateSeat(){
        String userid = getParam("userid");
        String planid = getParam("planid");
        String venueid = getParam("venueid");
        userService.allocateSeat(userid,planid,venueid);
        return SUCCESS;
    }


    /**
     * 从jsp页面获得参数值
     * @param key
     * @return
     */
    protected String getParam(String key){
        return ServletActionContext.getRequest().getParameter(key);
    }

}
