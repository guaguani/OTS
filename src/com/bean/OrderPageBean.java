package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class OrderPageBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int offset;
	private String type;
	private ArrayList<OrderBean> beans;
	private ArrayList<String> style;

	public void OrderPageBean(){
		style=new ArrayList<String>();
		style.add("color:#ff7919;");
		for(int i=1;i<5;i++){
			style.add("");
		}
	}

	public ArrayList<String> getStyle() {
		return style;
	}

	public void setStyle(ArrayList<String> style) {
		this.style = style;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<OrderBean> getBeans() {
		return beans;
	}

	public void setBeans(ArrayList<OrderBean> beans) {
		this.beans = beans;
	}
}
