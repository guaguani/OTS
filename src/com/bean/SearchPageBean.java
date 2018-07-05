package com.bean;

import java.io.Serializable;
import java.util.ArrayList;


public class SearchPageBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<ActivityBean> beans;
	private String cur_type;
	private String cur_city;
	private String cur_input;
	private int cur_offset;
	private ArrayList<String> style;

	public void SearchPageBean(){
		style=new ArrayList<String>();
		style.add("background-color: #ff7919;");
		for(int i=1;i<9;i++){
			style.add("");
		}
	}

	public ArrayList<String> getStyle() {
		return style;
	}

	public void setStyle(ArrayList<String> style) {
		this.style = style;
	}

	public ArrayList<ActivityBean> getBeans() {
		return beans;
	}

	public void setBeans(ArrayList<ActivityBean> beans) {
		this.beans = beans;
	}

	public String getCur_type() {
		return cur_type;
	}

	public void setCur_type(String cur_type) {
		this.cur_type = cur_type;
	}

	public String getCur_city() {
		return cur_city;
	}

	public void setCur_city(String cur_city) {
		this.cur_city = cur_city;
	}

	public String getCur_input() {
		return cur_input;
	}

	public void setCur_input(String cur_input) {
		this.cur_input = cur_input;
	}

	public int getCur_offset() {
		return cur_offset;
	}

	public void setCur_offset(int cur_offset) {
		this.cur_offset = cur_offset;
	}
}
