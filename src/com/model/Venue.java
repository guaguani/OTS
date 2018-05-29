package com.model;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by guagua on 18/2/21.
 */
public class Venue implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String password;
    private String address;
    private int totalseats;
    private int rows;
    private int seatsEachRow;
    private int state;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(int totalseats) {
        this.totalseats = totalseats;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeatsEachRow() {
        return seatsEachRow;
    }

    public void setSeatsEachRow(int seatsEachRow) {
        this.seatsEachRow = seatsEachRow;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

