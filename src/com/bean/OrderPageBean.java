package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class OrderPageBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int offset;
	private String type;
	private ArrayList<OrderBean> beans;

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
