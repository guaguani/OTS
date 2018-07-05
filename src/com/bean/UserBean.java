package com.bean;

import java.io.Serializable;
import java.util.ArrayList;


public class UserBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String pwd;
	private String gender;
	private AddressBean address;
	private String payID;
	/*出生年月日*/
	private int b_year;
	private int b_month;
	private int b_day;
	/*个人兴趣*/
	private ArrayList<String> interest;
	private String curPos;
	private String curType;
	private String curInput;

	public void UserBean(){
		id="";
		payID="";
	}

	public String getCurPos() {
		return curPos;
	}

	public void setCurPos(String curPos) {
		this.curPos = curPos;
	}

	public String getCurType() {
		return curType;
	}

	public void setCurType(String curType) {
		this.curType = curType;
	}

	public String getCurInput() {
		return curInput;
	}

	public void setCurInput(String curInput) {
		this.curInput = curInput;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public AddressBean getAddress() {
		return address;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}

	public String getPayID() {
		return payID;
	}

	public void setPayID(String payID) {
		this.payID = payID;
	}

	

	

	public int getB_year() {
		return b_year;
	}

	public void setB_year(int b_year) {
		this.b_year = b_year;
	}

	public int getB_month() {
		return b_month;
	}

	public void setB_month(int b_month) {
		this.b_month = b_month;
	}

	public int getB_day() {
		return b_day;
	}

	public void setB_day(int b_day) {
		this.b_day = b_day;
	}

	public ArrayList<String> getInterest() {
		return interest;
	}

	public void setInterest(ArrayList<String> interest) {
		this.interest = interest;
	}

	
}
