package com.model;

import java.io.Serializable;

/**
 * Created by guagua on 18/2/23.
 */
public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;
    private int userid;
    private String password;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
