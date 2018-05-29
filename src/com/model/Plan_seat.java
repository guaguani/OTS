package com.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by guagua on 18/4/3.
 */
public class Plan_seat implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userid;
    private int seatid;
    private int planid;
    private int venueid;
    private double price;
    private int state;
    private int orderid;
    private String typeofemail;
    private String maketime;
    private int notexist;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getSeatid() {
        return seatid;
    }

    public void setSeatid(int seatid) {
        this.seatid = seatid;
    }

    public int getPlanid() {
        return planid;
    }

    public void setPlanid(int planid) {
        this.planid = planid;
    }

    public int getVenueid() {
        return venueid;
    }

    public void setVenueid(int venueid) {
        this.venueid = venueid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getTypeofemail() {
        return typeofemail;
    }

    public void setTypeofemail(String typeofemail) {
        this.typeofemail = typeofemail;
    }

    public String getMaketime() {
        return maketime;
    }

    public void setMaketime(String maketime) {
        this.maketime = maketime;
    }

    public int getNotexist() {
        return notexist;
    }

    public void setNotexist(int notexist) {
        this.notexist = notexist;
    }
}
