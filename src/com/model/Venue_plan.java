package com.model;

import java.io.Serializable;

/**
 * Created by guagua on 18/3/6.
 */
public class Venue_plan implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String theme;
    private String type;
    private String time;
    private String description;
    private int planid;
    private int ordernum;
    private int backnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPlanid() {
        return planid;
    }

    public void setPlanid(int planid) {
        this.planid = planid;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public int getBacknum() {
        return backnum;
    }

    public void setBacknum(int backnum) {
        this.backnum = backnum;
    }
}
