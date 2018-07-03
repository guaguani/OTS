package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;



public class OrderBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String userid;
	/*对应演出的图片路径*/
	private String path;
	/*对应演出的ID*/
	private int actid;
	/*对应演出的场馆的ID*/
	private int venueid;
	/*订单状态*/
	private String state;
	/*订单总额*/
	private double sum;
	/*演出名称*/
	private String actName;
	/*演出时间*/
	private String actTime;
	/*场馆名称*/
	private String venueName;
	/*展厅名称*/
	private String room;
	/*订单包含的座位的排号*/
	private ArrayList<String> seatX;
	/*订单包含的座位的列号*/
	private ArrayList<String> seatY;
	/*订单支付时间*/
	private Date payDate;
	/*订单创建时间*/
	private Date createDate;
	/*付款账号*/
	private String pay_id;
	private long start;
	private int num;

	public OrderBean() {
		start=System.currentTimeMillis();
	}
	
	public void pay() {
		payDate = new Date();
	}

	public String getPay_id() {
		return pay_id;
	}

	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}

	public String getActTime() {
		return actTime;
	}

	public void setActTime(String actTime) {
		this.actTime = actTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getActid() {
		return actid;
	}

	public void setActid(int actid) {
		this.actid = actid;
	}

	public int getVenueid() {
		return venueid;
	}

	public void setVenueid(int venueid) {
		this.venueid = venueid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	
	public ArrayList<String> getSeatX() {
		return seatX;
	}

	public void setSeatX(ArrayList<String> seatX) {
		this.seatX = seatX;
	}

	public ArrayList<String> getSeatY() {
		return seatY;
	}

	public void setSeatY(ArrayList<String> seatY) {
		this.seatY = seatY;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ArrayList<Long> getTime(){
		ArrayList<Long> result=new ArrayList<Long>();
		long now=(System.currentTimeMillis()-this.start)/1000;
		result.add(now/60);
		result.add(now%60);
		return result;
	}
}
