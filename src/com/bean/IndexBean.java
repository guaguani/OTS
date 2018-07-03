package com.bean;

import java.io.Serializable;
import java.util.ArrayList;


public class IndexBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<ActivityBean> adBeans;
	private ArrayList<ActivityBean> hot;
	private ArrayList<ActivityBean> con;
	private ArrayList<ActivityBean> ope;
	private ArrayList<ActivityBean> ent;
	private ArrayList<ActivityBean> spo;
	private ArrayList<ActivityBean> mus;
	private ArrayList<ActivityBean> chi;
	private ArrayList<ActivityBean> dan;
	private ArrayList<ActivityBean> bei;

	public ArrayList<ActivityBean> getAdBeans() {
		return adBeans;
	}

	public void setAdBeans(ArrayList<ActivityBean> adBeans) {
		this.adBeans = adBeans;
	}

	public ArrayList<ActivityBean> getHot() {
		return hot;
	}

	public void setHot(ArrayList<ActivityBean> hot) {
		this.hot = hot;
	}

	public ArrayList<ActivityBean> getCon() {
		return con;
	}

	public void setCon(ArrayList<ActivityBean> con) {
		this.con = con;
	}

	public ArrayList<ActivityBean> getOpe() {
		return ope;
	}

	public void setOpe(ArrayList<ActivityBean> ope) {
		this.ope = ope;
	}

	public ArrayList<ActivityBean> getEnt() {
		return ent;
	}

	public void setEnt(ArrayList<ActivityBean> ent) {
		this.ent = ent;
	}

	public ArrayList<ActivityBean> getSpo() {
		return spo;
	}

	public void setSpo(ArrayList<ActivityBean> spo) {
		this.spo = spo;
	}

	public ArrayList<ActivityBean> getMus() {
		return mus;
	}

	public void setMus(ArrayList<ActivityBean> mus) {
		this.mus = mus;
	}

	public ArrayList<ActivityBean> getChi() {
		return chi;
	}

	public void setChi(ArrayList<ActivityBean> chi) {
		this.chi = chi;
	}

	public ArrayList<ActivityBean> getDan() {
		return dan;
	}

	public void setDan(ArrayList<ActivityBean> dan) {
		this.dan = dan;
	}

	public ArrayList<ActivityBean> getBei() {
		return bei;
	}

	public void setBei(ArrayList<ActivityBean> bei) {
		this.bei = bei;
	}
}
