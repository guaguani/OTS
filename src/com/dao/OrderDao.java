package com.dao;

import com.bean.OrderBean;

import java.util.ArrayList;

public interface OrderDao {

    /*
     * 获取用户订单 type表示订单类型: 全部订单、已完成、未支付、已取消、待使用
     */
    public ArrayList<OrderBean> getOrder(String userid, String type);

    /*
     *添加订单
     */
    public void addOrder(OrderBean order);

    /*
     *修改订单
     */
    public void modOrder(OrderBean order);
}
