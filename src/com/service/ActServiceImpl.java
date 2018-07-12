package com.service;

import com.bean.ActivityBean;
import com.bean.OrderBean;
import com.bean.SeatBean;
import com.dao.ActDao;
import com.dao.ActDaoImpl;
import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;


@Service
public class ActServiceImpl implements ActService{


    private ActDao actDao = new ActDaoImpl();


    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public int buyTicket(int aid, String showtime, double ticket, int num, String username) {
        OrderBean orderBean = new OrderBean();

        int oid = (int)(1 + Math.random()*10000000);

        ActivityBean activityBean = getByID(aid);
        String path = activityBean.getPath();
        int venueid = activityBean.getVid();
        String state = "未支付";
        String actName = activityBean.getName();
        String venueName = activityBean.getVname();
        String room = activityBean.getHalls().get(0).getName();
        SeatBean seats[][]=activityBean.getHalls().get(0).getSeats();
        ArrayList<String> seatX = new ArrayList<String>();
        ArrayList<String> seatY = new ArrayList<String>();
        boolean out=false;
        int count=num;
        for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                if(seats[i][j].getState().equals("空")&&Math.abs(seats[i][j].getPrice()-ticket)<0.1){
                    seats[i][j].setOid(oid);
                    seats[i][j].setState("售");
                    seatX.add(seats[i][j].getPosRow());
                    seatY.add(seats[i][j].getPosColum());
                    count--;
                    if(count==0){
                        out=true;
                        break;
                    }
                }

            }
            if(out){
                break;
            }
        }


        Date createDate = new Date();


        orderBean.setId(oid);
        orderBean.setUserid(username);
        orderBean.setPath(path);
        orderBean.setActid(aid);
        orderBean.setVenueid(venueid);
        orderBean.setState(state);
        orderBean.setSum(ticket*num);
        orderBean.setActName(actName);
        orderBean.setActTime(showtime);
        orderBean.setVenueName(venueName);
        orderBean.setRoom(room);
        orderBean.setSeatX(seatX);
        orderBean.setSeatY(seatY);
        orderBean.setPayDate(null);
        orderBean.setCreateDate(createDate);
        orderBean.setPay_id("");
        orderBean.setStart(System.currentTimeMillis());
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
