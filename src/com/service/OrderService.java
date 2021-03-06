package com.service;

import com.bean.OrderBean;
import java.util.ArrayList;

public interface OrderService {
	/*
	 * 获取用户订单 type表示订单类型: 全部订单、已完成、未支付、已取消、待使用
	 */
	public ArrayList<OrderBean> getOrder(int offset, String userid, String type);
	/*
	 * 根据ID获取订单
	 */
	public OrderBean getOrderByID(int id);
	/*
	 * 取消订单
	 */
	public String cancleOrder(int id);
	/*
	 * 支付订单
	 */
	public String userPay(String user_pay_id,String user_pwd,double sum,int oid);
}
