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
	private ArrayList<String> typee;
	private boolean last;

	public SearchPageBean(){
		style=new ArrayList<String>();
		type=new ArrayList<String>();
		typee=new ArrayList<String>();
		style.add("search_type pick");
		type.add("全部演出");
		typee.add("all");
		type.add("演唱会");
		typee.add("con");
		type.add("话剧歌剧");
		typee.add("ope");
		type.add("休闲展览");
		typee.add("ent");
		type.add("体育赛事");
		typee.add("spo");
		type.add("音乐会");
		typee.add("mus");
		type.add("儿童亲子");
		typee.add("chi");
		type.add("舞蹈芭蕾");
		typee.add("dan");
		type.add("戏曲综艺");
		typee.add("bei");

		for(int i=1;i<9;i++){
			style.add("search_type");
		}
		cur_type="全部演出";
		cur_input="";
		cur_city="全国";
		cur_offset=8;
	}

	public ArrayList<String> getTypee() {
		return typee;
	}

	public boolean isLast() {
		return last;
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


	public ArrayList<ActivityBean> getBeans() {
		return beans;
	}

	public void setBeans(ArrayList<ActivityBean> beans) {
		this.beans = beans;
		if(beans.size()<8){
			last=true;
		}
	}

	public String getCur_type() {
		return cur_type;
	}

	public void setCur_type(String cur_type) {
		this.cur_type = cur_type;
		for(int i=0;i<type.size();i++){
			if(type.get(i).equals(cur_type)){
				style.set(i,"search_type pick");
			}
			else{
				style.set(i,"search_type");
			}
		}
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
