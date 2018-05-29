package com.model;

import java.io.Serializable;

/**
 * Created by guagua on 18/2/13.
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String userid;
    private int state;
    private int level;
    private double cost;
    private int integral;
    private String password;
    private String typeofemail;
    private int activate;
    private int backtimes;
    private int ordertimes;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeofemail() {
        return typeofemail;
    }

    public void setTypeofemail(String typeofemail) {
        this.typeofemail = typeofemail;
    }

    public int getActivate() {
        return activate;
    }

    public void setActivate(int activate) {
        this.activate = activate;
    }

    public int getBacktimes() {
        return backtimes;
    }

    public void setBacktimes(int backtimes) {
        this.backtimes = backtimes;
    }

    public int getOrdertimes() {
        return ordertimes;
    }

    public void setOrdertimes(int ordertimes) {
        this.ordertimes = ordertimes;
    }
}
