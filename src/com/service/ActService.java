package com.service;

import com.bean.ActivityBean;
import java.util.ArrayList;

public interface ActService {
	/*
	 * 购票  返回订单号
	 */
	public int buyTicket(int aid,String showtime,double ticket,int num,String username);
	/*
	 * 得到活动详细信息
	 */
	public ActivityBean getByID(int id);
	/*
	 * 广告演出
	 */
	public ArrayList<ActivityBean> advertiseAct();
	/*
	 * 热门演出
	 */
	public ArrayList<ActivityBean> hotAct();
	/*
	 * 搜索演出 city 是城市名或全国，sort是演出类型或全部演出
	 */
	public ArrayList<ActivityBean> selectByCond(String city,String type,int offset);
	/*
	 * 根据用户输入的场馆名或者活动名搜索
	 */
	public ArrayList<ActivityBean> selectByNameOrVen(String input,int offset);
}
