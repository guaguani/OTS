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
	private ArrayList<String> type;

	public SearchPageBean(){
		style=new ArrayList<String>();
		style.add("background-color: #ff7919;");
		type.add("全部");
		type.add("演唱会");
		type.add("话剧歌剧");
		type.add("休闲展览");
		type.add("体育赛事");
		type.add("音乐会");
		type.add("儿童亲子");
		type.add("舞蹈芭蕾");
		type.add("戏曲综艺");

		for(int i=1;i<9;i++){
			style.add("");
		}
		cur_type="全部";
		cur_input="";
		cur_city="全国";
		cur_offset=8;
	}

	public ArrayList<String> getType() {
		return type;
	}

	public void setType(ArrayList<String> type) {
		this.type = type;
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
