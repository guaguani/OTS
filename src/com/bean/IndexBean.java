package com.bean;

import com.service.ActService;
import com.service.ActServiceImpl;

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
	private String curCity;

	public IndexBean(){
		curCity="全国";
		ActService service=new ActServiceImpl();
		adBeans=service.advertiseAct();
		System.out.println("ad:"+adBeans.size());
		hot=service.hotAct();
		System.out.println("hot:"+hot.size());
		con=service.selectByCond("全国","演唱会",0);
		System.out.println("con:"+con.size());
		ope=service.selectByCond("全国","话剧歌剧",0);
		System.out.println("ope:"+ope.size());
		ent=service.selectByCond("全国","休闲展览",0);
		System.out.println("ent:"+ent.size());
		spo=service.selectByCond("全国","体育赛事",0);
		System.out.println("spo:"+spo.size());
		mus=service.selectByCond("全国","音乐会",0);
		System.out.println("mus:"+mus.size());
		chi=service.selectByCond("全国","儿童亲子",0);
		System.out.println("chi:"+chi.size());
		dan=service.selectByCond("全国","舞蹈芭蕾",0);
		System.out.println("dan:"+dan.size());
		bei=service.selectByCond("全国","戏曲综艺",0);
		System.out.println("bei:"+bei.size());
	}

	public String getCurCity() {
		return curCity;
	}

	public void setCurCity(String curCity) {
		this.curCity = curCity;
	}

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
