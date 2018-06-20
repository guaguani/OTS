package com.bean;

import java.io.Serializable;


public class SeatBean implements Serializable{
	private static final long serialVersionUID = 1L;
	/*位置状态：空 已售 可选*/
	private String state;
	/*排、座信息*/
	private String posRow;
	private String posColum;
	/*价格*/
	private double price;
	/*购买此位置的订单号*/
	private int oid;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPosRow() {
		return posRow;
	}
	public void setPosRow(String posRow) {
		this.posRow = posRow;
	}
	public String getPosColum() {
		return posColum;
	}
	public void setPosColum(String posColum) {
		this.posColum = posColum;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	
}
