package com.service;

import com.bean.ActivityBean;
import com.bean.OrderBean;
import com.dao.ActDao;
import com.dao.ActDaoImpl;
import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;


@Service
public class ActServiceImpl implements ActService{


    private ActDao actDao = new ActDaoImpl();


    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public int buyTicket(int aid, String showtime, double ticket, int num, double sum, String username) {
        OrderBean orderBean = new OrderBean();

        int oid = (int)(1 + Math.random()*10000000);

        ActivityBean activityBean = getByID(aid);
        String path = activityBean.getPath();
        int venueid = activityBean.getVid();
        String state = "未支付";
        String actName = activityBean.getName();
        String venueName = activityBean.getVname();
        String room = activityBean.getHalls().get(0).getName();
        ArrayList<String> seatX = new ArrayList<>();
        ArrayList<String> seatY = new ArrayList<>();

        Date createDate = new Date();

        orderBean.setId(oid);
        orderBean.setUserid(username);
        orderBean.setPath(path);
        orderBean.setActid(aid);
        orderBean.setVenueid(venueid);
        orderBean.setState(state);
        orderBean.setSum(sum);
        orderBean.setActName(actName);
        orderBean.setActTime(showtime);
        orderBean.setVenueName(venueName);
        orderBean.setRoom(room);
        orderBean.setSeatX(seatX);
        orderBean.setSeatY(seatY);
        orderBean.setPayDate(null);
        orderBean.setCreateDate(createDate);
        orderBean.setPay_id("");
        orderBean.setStart(0);
        orderBean.setNum(num);

        orderDao.addOrder(orderBean);

        return oid;
    }

    @Override
    public ActivityBean getByID(int id) {
        return actDao.getByID(id);
    }

    @Override
    public ArrayList<ActivityBean> advertiseAct() {
        ArrayList<ActivityBean> result = actDao.advertiseAct();
        System.out.println("size : " + result.size());
        return actDao.advertiseAct();
    }

    @Override
    public ArrayList<ActivityBean> hotAct() {
        return actDao.hotAct();
    }

    @Override
    public ArrayList<ActivityBean> selectByCond(String city, String type, int offset) {
        return actDao.selectByCond(city, type, offset);
    }

    @Override
    public ArrayList<ActivityBean> selectByNameOrVen(String input, int offset) {
        return actDao.selectByNameOrVen(input, offset);
    }
}
