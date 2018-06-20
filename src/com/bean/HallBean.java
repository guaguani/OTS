package com.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class HallBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	/*隶属场馆ID*/
	private int vid;
	/*展厅名称*/
	private String name;
	/*演出时间*/
	private String showTime;
	/*位置信息*/
	private SeatBean[][] seats;
	/*价位*/
	private ArrayList<Double> prices;
	/*价位描述*/
	private ArrayList<String> tip;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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

	public String getShowTime() {
		return showTime;
	}


	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}


	public SeatBean[][] getSeats() {
		return seats;
	}


	public void setSeats(SeatBean[][] seats) {
		this.seats = seats;
	}


	public ArrayList<Double> getPrices() {
		return prices;
	}
	public void setPrices(ArrayList<Double> price) {
		this.prices = price;
	}
	public ArrayList<String> getTip() {
		return tip;
	}


	public void setTip(ArrayList<String> tip) {
		this.tip = tip;
	}
	
}
