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
	private ArrayList<String> types;

	private double sum;


	public OrderPageBean(){
		style=new ArrayList<String>();
		style.add("color:#ff7919;");
		for(int i=1;i<5;i++){
			style.add("");
		}
		types.add("全部订单");
		types.add("未支付");
		types.add("待使用");
		types.add("已完成");
		types.add("已取消");

	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public ArrayList<String> getTypes() {
		return types;
	}


	public ArrayList<String> getStyle() {
		return style;
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
		for(int i=0;i<types.size();i++){
			if(types.get(i).equals(type)){
				style.set(i,"color:#ff7919;");
			}
			else{
				style.set(i,"");
			}
		}
	}

	public ArrayList<OrderBean> getBeans() {
		return beans;
	}

	public void setBeans(ArrayList<OrderBean> beans) {
		this.beans = beans;
		for(OrderBean b:beans){
			sum+=b.getSum();
		}
	}


}
