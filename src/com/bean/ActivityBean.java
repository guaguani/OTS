package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Calendar;


public class ActivityBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/*描述*/
	private String des;
	/*类型*/
	private String type;
	/*演出场次*/
	private ArrayList<HallBean> halls;
	private int id;
	/*场馆ID*/
	private int vid;
	private String name;
	/*场馆名称*/
	private String vname;
	/*城市*/
	private String city;
	/*图片路径*/
	private String path;
	/*起价*/
	private double price;
	/*首演时间*/
	private String first;
	/*末场演出时间*/
	private String last;
	/*状态*/
	private String state;
	/*广告位图片路径*/
	private String apath;


	
	
	
	public String getApath() {
		return apath;
	}
	public void setApath(String apath) {
		this.apath = apath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<HallBean> getHalls() {
		return halls;
	}
	public void setHalls(ArrayList<HallBean> halls) {
		this.halls = halls;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
