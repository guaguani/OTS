package com.service;

import com.bean.OrderBean;
import java.util.ArrayList;

public interface OrderService {
	/*
	 * 获取用户订单 type表示订单类型
	 */
	public ArrayList<OrderBean> getOrder(int offset, String userid, String type);
	/*
	 * 取消订单
	 */
	public String cancleOrder(int id);
	/*
	 * 支付订单
	 */
	public String userPay(String user_pay_id,String user_pwd,double sum,int oid,int min,int sec);
}
