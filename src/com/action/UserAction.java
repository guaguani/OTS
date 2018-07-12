package com.action;

import com.bean.*;
import com.model.Plan_seat;
import com.model.Venue;
import com.model.Venue_plan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.model.User;
import com.service.*;
import com.sun.deploy.net.HttpResponse;
import com.util.MD5Util;
import com.util.SendMailUtil;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private UserService_new nuserService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ActService actService;

    @Autowired
    private VenueService venueService;

    private User user;

    private UserBean userbean;

    private IndexBean indexBean;

    private OrderPageBean orderPageBean;

    private OrderBean orderBean;

    private SearchPageBean searchPageBean;

    private ActivityBean activityBean;

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

    private ArrayList<String> chi;
    private ArrayList<String> eng;



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
            return SUCCESS;
        }
    }



    /**
     * 从jsp页面获得参数值
     * @param key
     * @return
     */
    protected String getParam(String key){
        HttpServletRequest request=ServletActionContext.getRequest();
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return request.getParameter(key);
    }

    //---------------------------------------------------------------------------------------------
    private void check(){
        if(chi==null){
            chi=new ArrayList<String>();
            eng=new ArrayList<String>();
        }
        if(chi.size()<9){
            chi.add("全部演出");
            eng.add("all");
            chi.add("演唱会");
            eng.add("con");
            chi.add("话剧歌剧");
            eng.add("ope");
            chi.add("休闲展览");
            eng.add("ent");
            chi.add("体育赛事");
            eng.add("spo");
            chi.add("音乐会");
            eng.add("mus");
            chi.add("儿童亲子");
            eng.add("chi");
            chi.add("舞蹈芭蕾");
            eng.add("dan");
            chi.add("戏曲综艺");
            eng.add("bei");

            chi.add("全国");
            eng.add("country");
            chi.add("上海");
            eng.add("shanghai");
            chi.add("北京");
            eng.add("beijing");
            chi.add("广州");
            eng.add("guangzhou");
            chi.add("深圳");
            eng.add("shenzhen");
            chi.add("成都");
            eng.add("chengdu");
            chi.add("重庆");
            eng.add("chongqing");
            chi.add("天津");
            eng.add("tianjin");
            chi.add("杭州");
            eng.add("hangzhou");
            chi.add("南京");
            eng.add("nanjing");
            chi.add("武汉");
            eng.add("wuhan");
            chi.add("西安");
            eng.add("xian");
            chi.add("长沙");
            eng.add("changsha");
            chi.add("全部订单");
            eng.add("all-o");
            chi.add("未支付");
            eng.add("unp");
            chi.add("待使用");
            eng.add("unu");
            chi.add("已完成");
            eng.add("fin");
            chi.add("已取消");
            eng.add("can");

        }
    }

    private String trans(String input){
        if(input.equals("1")){
            return input;
        }
        for(int i=0;i<eng.size();i++){
            if(eng.get(i).equals(input)){
                return chi.get(i);
            }
        }
        return input;
    }

    private String transToE(String input){

        for(int i=0;i<chi.size();i++){
            if(chi.get(i).equals(input)){
                return eng.get(i);
            }
        }
        return input;
    }

    public String getActDetail(){
        System.out.println("IN ACT! GET DETAIL");
        HttpSession session=ServletActionContext.getRequest().getSession();
        String id = getParam("id");
        ActivityBean activityBean=actService.getByID(Integer.parseInt(id));
        activityBean.setEngc(transToE(activityBean.getCity()));
        activityBean.setEngt(transToE(activityBean.getType()));
        session.setAttribute("activitybean", activityBean);
        return SUCCESS;
    }
    public String SearchByCond(){
        System.out.println("IN ACT! SEARCH BY COND");
        check();
        HttpSession session=ServletActionContext.getRequest().getSession();

        SearchPageBean searchPageBean=(SearchPageBean)session.getAttribute("searchPagebean");
        if(searchPageBean==null){
            searchPageBean=new SearchPageBean();
        }
        UserBean userBean=(UserBean)session.getAttribute("userbean");

        String city=trans(getParam("city"));
        String type=trans(getParam("type"));
        System.out.println("GET PARA city:"+city+",type"+type);

        if(city.equals("1")){
            city=searchPageBean.getCur_city();
        }
        else{
            searchPageBean.setCur_city(city);
            userBean.setCurPos(city);
        }
        if(type.equals("1")){
            type=searchPageBean.getCur_type();
        }
        else{
            searchPageBean.setCur_type(type);
            userBean.setCurType(type);
        }
        searchPageBean.setCur_offset(8);
        searchPageBean.setCur_input("");
        searchPageBean.setBeans(actService.selectByCond(city,type,0));


        session.setAttribute("userbean", userBean);
        session.setAttribute("searchPagebean", searchPageBean);


        return SUCCESS;
    }

    public String SearchByInp(){
        System.out.println("IN ACT! SEARCH BY INP");
        check();
        HttpSession session=ServletActionContext.getRequest().getSession();

        SearchPageBean searchPageBean=(SearchPageBean)session.getAttribute("searchPagebean");
        if(searchPageBean==null){
            searchPageBean=new SearchPageBean();
        }
        UserBean userBean=(UserBean)session.getAttribute("userbean");
        String inp = getParam("keyword");

        System.out.println("INPUT IS:"+inp);
        searchPageBean.setCur_input(inp);
        userBean.setCurInput(inp);
        userBean.setCurPos("全国");
        userBean.setCurType("全部演出");
        searchPageBean.setCur_type("全部演出");
        searchPageBean.setCur_city("全国");

        searchPageBean.setCur_offset(8);
        searchPageBean.setBeans(actService.selectByNameOrVen(inp, 0));

        session.setAttribute("userbean", userBean);
        session.setAttribute("searchPagebean",searchPageBean);
        return SUCCESS;
    }

    public String ActPageChange(){
        System.out.println("IN ACT! PAGE CHANGE");
        HttpSession session=ServletActionContext.getRequest().getSession();

        SearchPageBean searchPageBean=(SearchPageBean)session.getAttribute("searchPagebean");

        String dir=getParam("dir");
        System.out.println("GET DIR:"+dir);
        String input=searchPageBean.getCur_input();
        String city=searchPageBean.getCur_city();
        String type=searchPageBean.getCur_type();

        int offset=searchPageBean.getCur_offset();
        if(dir.equals("up")){
            searchPageBean.setCur_offset(offset-8);
            offset=offset-16;
        }
        else{
            searchPageBean.setCur_offset(offset+8);
        }

        if(!input.equals("")){
            searchPageBean.setBeans(actService.selectByNameOrVen(input,offset));
        }
        else{
            searchPageBean.setBeans(actService.selectByCond(city,type,offset));
        }

        session.setAttribute("searchPagebean", searchPageBean);


        return SUCCESS;
    }

    public String CreateOrder(){
        //info://date a price a num l
        System.out.println("IN ACT! CREATE ORDER");
        HttpSession session=ServletActionContext.getRequest().getSession();

        ActivityBean activityBean=(ActivityBean)session.getAttribute("activitybean");
        UserBean userBean=(UserBean)session.getAttribute("userbean");

        String info = getParam("info");
        String types[][];
        if(info.indexOf("l")<0){
            types=new String[1][];
            types[0]=info.split("a");
        }
        else{
            String t[]=info.split("l");
            types=new String[t.length][];
            int i=0;
            for(String s:t){
                types[i]=t[i].split("a");
                i++;
            }
        }

        OrderPageBean OPB=new OrderPageBean();
        ArrayList<OrderBean> ob=new ArrayList<OrderBean>();
        for(int i=0;i<types.length;i++){
            int oid=actService.buyTicket(activityBean.getId(),types[i][0],Double.parseDouble(types[i][1]),Integer.parseInt(types[i][2]),userBean.getId());
            ob.add(orderService.getOrderByID(oid));
        }
        OPB.setBeans(ob);
        session.setAttribute("OPB", OPB);
        return SUCCESS;
    }

    public String Pay(){
        //info://date a price a num l
        System.out.println("IN ACT! PAY ORDER");
        HttpSession session=ServletActionContext.getRequest().getSession();

        OrderPageBean OPB=(OrderPageBean) session.getAttribute("OPB");
        UserBean userBean=(UserBean)session.getAttribute("userbean");

        String ac = getParam("ac");
        String pw = getParam("pw");
        for(OrderBean o:OPB.getBeans()){
            String res=orderService.userPay(ac,pw,o.getSum(),o.getId());
            if(res.equals("FAIL")){
                return ERROR;
            }
        }
        OrderPageBean orderPagebean=new OrderPageBean();
        orderPagebean.setOffset(8);
        orderPagebean.setType("待使用");
        orderPagebean.setBeans(orderService.getOrder(0,userBean.getId(),"待使用"));
        session.setAttribute("orderPagebean", orderPagebean);
        return SUCCESS;
    }

    public String login(){
        System.out.println("IN USER! LOG IN");
        HttpSession session=ServletActionContext.getRequest().getSession();
        String id=getParam("id");
        String pwd=getParam("pwd");
        String result=nuserService.logIn(id, pwd);
        if(!result.equals("SUCCESS")) {
            userbean.setWrong(true);
            return userbean.getPagePos();
        }
        userbean.setWrong(false);
        session.setAttribute("username", id);

        UserBean userbean=nuserService.getUserInfo(id);
        OrderPageBean orderPagebean=new OrderPageBean();
        orderPagebean.setOffset(8);
        orderPagebean.setType("全部订单");
        orderPagebean.setBeans(orderService.getOrder(0,id,"全部订单"));

        session.setAttribute("userbean", userbean);
        session.setAttribute("orderPagebean", orderPagebean);
        session.setAttribute("searchPagebean", new SearchPageBean());
        return userbean.getPagePos();
    }

    public String logout(){
        System.out.println("IN USER! LOG OUT");
        HttpSession session=ServletActionContext.getRequest().getSession();
        session.setAttribute("username", "");
        session.setAttribute("userbean", new UserBean());
        session.setAttribute("orderPagebean", new OrderPageBean());
        return SUCCESS;
    }


    public String cancelOrder(){
        HttpSession session=ServletActionContext.getRequest().getSession();
        OrderPageBean OPB=(OrderPageBean) session.getAttribute("OPB");
        UserBean userBean=(UserBean)session.getAttribute("userbean");
        for(OrderBean o:OPB.getBeans()){
            orderService.cancleOrder(o.getId());
        }
        OrderPageBean orderPagebean=new OrderPageBean();
        orderPagebean.setType("已取消");
        orderPagebean.setOffset(8);
        orderPagebean.setBeans(orderService.getOrder(0,userBean.getId(),"已取消"));
        session.setAttribute("orderPagebean",orderPagebean);
        return SUCCESS;
    }

    public String getOrder(){
        HttpSession session=ServletActionContext.getRequest().getSession();
        check();
        String type=trans(getParam("type"));

        UserBean userBean=(UserBean)session.getAttribute("userbean");

        OrderPageBean orderPagebean=(OrderPageBean)session.getAttribute("orderPagebean");
        orderPagebean.setType(type);
        orderPagebean.setOffset(8);
        orderPagebean.setBeans(orderService.getOrder(0,userBean.getId(),type));
        session.setAttribute("orderPagebean",orderPagebean);
        return SUCCESS;
    }

    public String OrderPageChange(){
        System.out.println("IN ORDER! PAGE CHANGE");
        HttpSession session=ServletActionContext.getRequest().getSession();

        OrderPageBean orderPageBean=(OrderPageBean) session.getAttribute("orderPagebean");
        UserBean userBean=(UserBean)session.getAttribute("userbean");

        String dir=getParam("dir");
        System.out.println("GET DIR:"+dir);

        int offset=orderPageBean.getOffset();
        if(dir.equals("up")){
            orderPageBean.setOffset(offset-8);
            offset=offset-16;
        }
        else{
            orderPageBean.setOffset(offset+8);
        }

        orderPageBean.setBeans(orderService.getOrder(offset,userBean.getId(),orderPageBean.getType()));

        session.setAttribute("orderPagebean", orderPageBean);


        return SUCCESS;
    }

    public String changeCurOrder(){
        String orderid = getParam("oid");

        HttpSession session=ServletActionContext.getRequest().getSession();
        OrderPageBean OPB=(OrderPageBean) session.getAttribute("OPB");
        ArrayList<OrderBean> beans=new ArrayList<OrderBean>();
        beans.add(orderService.getOrderByID(Integer.parseInt(orderid)));
        OPB.setBeans(beans);
        OPB.setSum(beans.get(0).getSum());
        session.setAttribute("OPB",OPB);
        return SUCCESS;

    }

}
