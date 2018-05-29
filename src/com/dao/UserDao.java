package com.dao;

import com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by guagua on 18/2/21.
 */
@Component
public class UserDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate(){
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate = hibernateTemplate;
    }

    public void save(User user){
        this.getHibernateTemplate().save(user);
    }

    public void update(User user){
        this.getHibernateTemplate().update(user);
    }

    public void delete(String email){
        List<User> userList = getUser(email);
        User user = userList.get(0);
        hibernateTemplate.delete(user);
    }

    /**
     * 查询用户
     * @param email
     * @return
     */
    public List<User> getUser(String email){
        int symbol = email.indexOf("@");
        int length = email.length();
        String mail1 = email.substring(0,symbol);
        String mail2 = email.substring(symbol+1,length);
        return hibernateTemplate.find("from User where userid='"+mail1+"' and typeofemail='"+mail2+"'");
    }

    public void activate(String email){
        int symbol = email.indexOf("@");
        int length = email.length();
        String mail1 = email.substring(0,symbol);
        List<User>users = hibernateTemplate.find("from User where userid="+mail1);
        User user = users.get(0);
        user.setActivate(1);
        hibernateTemplate.update(user);
    }
    /**
     * 获得所有用户列表
     * @return
     */
    public List<User> findAllUsers(){
        return hibernateTemplate.find("from User order by userid");
    }

    /**
     * 修改用户信息（修改密码）
     * @param pw
     * @param email
     */
    public void modifyPw(String pw,String email){
        int symbol = email.indexOf("@");
        int length = email.length();
        String mail1 = email.substring(0,symbol);
        String mail2 = email.substring(symbol+1,length);
        List<User> users = hibernateTemplate.find("from User where userid='"+mail1+"' and typeofemail='"+mail2+"' and activate=1");
        //原则上这个查询是有唯一结果的
        User user = users.get(0);
        user.setPassword(pw);
        hibernateTemplate.update(user);
    }

    /**
     * 取消会员资格
     * @param email
     */
    public void cancelMember(String email){
        int symbol = email.indexOf("@");
        int length = email.length();
        String mail1 = email.substring(0,symbol);
        String mail2 = email.substring(symbol+1,length);
        List<User> users = hibernateTemplate.find("from User where userid='"+mail1+"' and typeofemail='"+mail2+"' and activate=1");
        User user = users.get(0);
        user.setState(0);
        //原则上有且仅有一个
        hibernateTemplate.update(user);
    }

    /**
     * 预订票
     * @param list
     */
    public String reserveTickets(ArrayList<String> list, String userid, String planid, String venueid){
        Plan_seat plan_seat = new Plan_seat();
        int symbol = userid.indexOf("@");
        int length = userid.length();
        String mail1 = userid.substring(0,symbol);
        String mail2 = userid.substring(symbol+1,length);
        plan_seat.setUserid(mail1);
        plan_seat.setTypeofemail(mail2);
        plan_seat.setVenueid(Integer.parseInt(venueid));
        plan_seat.setPlanid(Integer.parseInt(planid));
        String seatstring = list.get(0);
        String [] seats = seatstring.split(",");
        int p=0;
        List<Plan_seat>plan_seats = hibernateTemplate.find("from Plan_seat");
        p = plan_seats.size();
        System.out.println("p:"+p);
        System.out.println(seats.length);
        List<Venue> venues = hibernateTemplate.find("from Venue where id="+venueid);
        Venue venue = venues.get(0);
        String answer = "ERROR";
        //plan_seats1获得已经预订的票
        System.out.println(planid);
        System.out.println(venueid);
        List<Plan_seat> plan_seats1 = hibernateTemplate.find("from Plan_seat where planid="+planid+" and venueid="+venueid+" and notexist=0");
        System.out.println("已经预订了"+plan_seats1.size()+"张票");
        List<Integer> seatids = new ArrayList<>();
        for(int i=0;i<plan_seats1.size();i++){
            seatids.add(plan_seats1.get(i).getSeatid());
            //seatids中是已经预订掉的票
        }
        for(int i=0;i<seats.length;i++) {
            String ss = seats[i];
            String seatid = ss.substring(4, ss.length());
            for(int j=0;j<seatids.size();j++){
                if(seatid.equals(String.valueOf(seatids.get(j)))){
                    System.out.println(seatid);
                    answer = "ERROR";
                    //如果票已经被预订，return error
                    return answer;
                }
            }
            plan_seat.setSeatid(Integer.parseInt(seatid));
            //设置price
            List<Seat> seatList = hibernateTemplate.find("from Seat where venueid=" + venueid + " and planid=" + planid+" order by id");
            System.out.println("获得价格的记录为："+seatList.size()+"条");
            for (int j = 0; j < seatList.size(); j++) {
                System.out.println(j);
                Seat seat = seatList.get(j);
                double price = seat.getPrice();
                System.out.println(price);
                int to_row = seat.getTo();
                int seatEachRow = venue.getSeatsEachRow();
                int seatnum = Integer.parseInt(seatid);
                System.out.println(seatnum);
                System.out.println(to_row*seatEachRow);
                if(seatnum<((to_row+1)*seatEachRow)-1){
                    System.out.println("价格："+price);
                    plan_seat.setPrice(price);
                    //判断对应的价格
                    long nowtime = System.currentTimeMillis();
                    plan_seat.setMaketime(String.valueOf(nowtime));
                    plan_seat.setOrderid(p+i);
                    plan_seat.setNotexist(0);
                    hibernateTemplate.save(plan_seat);
                    System.out.println("保存票");
                    answer="SUCCESS";
                    break;
                }
            }
        }
        return answer;
    }

    /**
     * 获得所有的订单
     * @param userid
     * @return
     */
    public List<Plan_seat> getAllOrders(String userid){
        int symbol = userid.indexOf("@");
        int length = userid.length();
        String mail1 = userid.substring(0,symbol);
        List<Plan_seat> orders = hibernateTemplate.find("from Plan_seat where userid="+mail1+" and notexist=0");
        System.out.println("orders.size:"+orders.size());
        if(orders.size()>0) {
            for (int i = 0; i < orders.size(); i++) {
                Plan_seat plan_seat = orders.get(i);
                System.out.println("id:"+plan_seat.getOrderid());
                String starttime = plan_seat.getMaketime();
                Timestamp timestamp = new Timestamp(Long.parseLong(starttime));
                Timestamp ts = new Timestamp(System.currentTimeMillis());
                long timecha = ts.getTime() - timestamp.getTime();
                System.out.println(timecha);
                if ((timecha / 1000 > 120)&&(plan_seat.getState()==0)) {//超过两分钟未付款
                    plan_seat.setNotexist(1);
                    System.out.println("delete this order");
                    hibernateTemplate.update(plan_seat);
                }
            }
            List<Plan_seat> leftorder = hibernateTemplate.find("from Plan_seat where userid="+mail1+" and notexist=0");
            System.out.println("剩下的:"+leftorder.size());
            return leftorder;
        }
        else{
            return orders;
        }
    }

    /**
     * 付款
     * @param orderid
     * @param username
     */
    public void payOrder(String orderid, String username){
        int symbol = username.indexOf("@");
        String mail1 = username.substring(0,symbol);
        List<Plan_seat>orders =hibernateTemplate.find("from Plan_seat where userid="+mail1+" and orderid="+orderid);
        Plan_seat order = orders.get(0);
        int venueid = order.getVenueid();
        int planid = order.getPlanid();
        double price = order.getPrice();
        //完成支付
        order.setState(1);
        order.setNotexist(0);
        long ts = System.currentTimeMillis();
        //maketime时间变为付款时间
        order.setMaketime(String.valueOf(ts));
        hibernateTemplate.update(order);
        System.out.println("支付成功");
        //扣除余额
        List<User> users = hibernateTemplate.find("from User where userid="+mail1);
        User user = users.get(0);
        double cost = user.getCost();
        int integral = user.getIntegral();
        double leftcost = cost-price;
        user.setCost(leftcost);
        user.setIntegral(integral+10);
        System.out.println("扣钱");
        int ordertimes = user.getOrdertimes();
        user.setOrdertimes(ordertimes+1);
        hibernateTemplate.update(user);
        List<Venue_plan> plans = hibernateTemplate.find("from Venue_plan where id="+venueid+" and planid="+planid);
        Venue_plan plan = plans.get(0);
        int ordernum = plan.getOrdernum();
        plan.setOrdernum(ordernum+1);
        hibernateTemplate.update(plan);
    }

    public String cancelOrder(String orderid,String username){
        int symbol = username.indexOf("@");
        String mail1 = username.substring(0,symbol);
        List<Plan_seat>orders =hibernateTemplate.find("from Plan_seat where userid="+mail1+" and orderid="+orderid+" and notexist=0");
        Plan_seat order = orders.get(0);
        double price = order.getPrice();
        int planid = order.getPlanid();
        int venueid = order.getVenueid();
        List<Venue_plan> plans = hibernateTemplate.find("from Venue_plan where id="+venueid+" and planid="+planid);
        //获得计划开始时间
        Venue_plan venue_plan = plans.get(0);
        String starttime = venue_plan.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String nowtime = df.format(new Date());
        System.out.println(String.valueOf(nowtime));
        System.out.println(starttime);
        int result=999;
        try {
            Date date1 = df.parse(nowtime);
            Date date2 = df.parse(starttime);
            result = date1.compareTo(date2);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(result);
        if (result==-1) {//未到时间
            System.out.println("delete this order");
            order.setNotexist(1);
            hibernateTemplate.update(order);
            //退还现金
            List<User> users = hibernateTemplate.find("from User where userid="+mail1);
            User user = users.get(0);
            int backtimes = user.getBacktimes();
            user.setBacktimes(backtimes+1);
            double nowprice = user.getCost();
            user.setCost(nowprice+price);
            int integral = user.getIntegral();
            user.setIntegral(integral-1);
            hibernateTemplate.update(user);
            int backnum = venue_plan.getBacknum();
            venue_plan.setOrdernum(backnum+1);
            hibernateTemplate.update(venue_plan);
            return "SUCCESS";
        }
        else{
            System.out.println("已经不能退票了");
            return "ERROR";
        }
    }
    public int getBackTimes(String userid) {
        int symbol = userid.indexOf("@");
        String mail1 = userid.substring(0,symbol);
        List<Plan_seat> plan_seats = hibernateTemplate.find("from Plan_seat where userid="+mail1+" and state=1 and notexist=1");
        System.out.println("size2:"+plan_seats.size());
        return plan_seats.size();
    }

    public int getOrderTimes(String userid){
        int symbol = userid.indexOf("@");
        String mail1 = userid.substring(0,symbol);
        System.out.println("mail1"+mail1);
        List<Plan_seat> plan_seats = hibernateTemplate.find("from Plan_seat where userid="+mail1+" and state=1 and notexist=0");
        System.out.println("size1:"+plan_seats.size());
        return plan_seats.size();
    }

    public void allocateSeat(String userid,String planid,String venueid){
        //获得已经被预订的票seatlist
        System.out.println(planid);
        System.out.println(venueid);
        List<Plan_seat>plan_seats = hibernateTemplate.find("from Plan_seat where planid="+planid+" and venueid="+venueid+" and notexist=0");
        List<Integer> seatlist = new ArrayList<>();
        for(int i=0;i<plan_seats.size();i++){
            seatlist.add(plan_seats.get(i).getSeatid());
        }
        System.out.println("seatlist大小："+seatlist.size());
        //获得行，列数
        List<Venue> venues = hibernateTemplate.find("from Venue where id="+venueid);
        Venue venue = venues.get(0);
        int rows = venue.getRows();
        int seatEachRow = venue.getSeatsEachRow();
        boolean getTicket = false;
        for(int i=0;i<rows*seatEachRow;i++){
            if(getTicket==true){
                break;
            }
            int p=0;
            for(int j=0;j<seatlist.size();j++){
                if(i==seatlist.get(j)){
                    break;
                }
                else{
                    p++;
                }
            }
            if(p==seatlist.size()){
                //i可为座位
                List<Plan_seat>plan_seats1 = hibernateTemplate.find("from Plan_seat");
                Plan_seat plan_seat = new Plan_seat();
                plan_seat.setOrderid(plan_seats1.size());
                plan_seat.setNotexist(0);
                plan_seat.setMaketime(String.valueOf(System.currentTimeMillis()));
                plan_seat.setState(0);
                plan_seat.setTypeofemail("qq.com");
                plan_seat.setPlanid(Integer.parseInt(planid));
                plan_seat.setVenueid(Integer.parseInt(venueid));
                int symbol = userid.indexOf("@");
                String mail1 = userid.substring(0,symbol);
                plan_seat.setUserid(mail1);
                plan_seat.setSeatid(i);
                //设置price
                List<Seat> seatList = hibernateTemplate.find("from Seat where venueid=" + venueid + " and planid=" + planid+" order by id");
                System.out.println("获得价格的记录为："+seatList.size()+"条");
                for (int j = 0; j < seatList.size(); j++) {
                    Seat seat = seatList.get(j);
                    double price = seat.getPrice();
                    System.out.println(price);
                    int to_row = seat.getTo();
                    int seatnum = i;
                    System.out.println(seatnum);
                    System.out.println(to_row*seatEachRow);
                    if(seatnum<((to_row+1)*seatEachRow)-1){
                        System.out.println("价格："+price);
                        plan_seat.setPrice(price);
                        hibernateTemplate.save(plan_seat);
                        System.out.println("保存票");
                        getTicket = true;
                        break;
                    }
                }
            }
        }
    }
}
