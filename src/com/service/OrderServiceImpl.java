package com.service;

import com.bean.OrderBean;
import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{


    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public ArrayList<OrderBean> getOrder(int offset, String userid, String type) {
        return orderDao.getOrder(offset, userid, type);
    }

    @Override
    public OrderBean getOrderByID(int id) {
        return orderDao.getOrderByID(id);
    }

    @Override
    public String cancleOrder(int id) {
        OrderBean orderBean = orderDao.getOrderByID(id);
        orderBean.setState("已取消");
        orderDao.modOrder(orderBean);
        return "SUCESS";
    }

    @Override
    public String userPay(String user_pay_id, String user_pwd, double sum, int oid) {
        OrderBean orderBean = orderDao.getOrderByID(oid);
        orderBean.setState("待使用");
        orderBean.setPay_id(user_pay_id);
        orderBean.setPayDate(new Date());

        orderDao.modOrder(orderBean);
        return "SUCCESS";
    }
}
