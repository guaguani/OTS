package com.service;

import com.model.Plan_seat;
import com.model.Venue_plan;
import com.model.Venue;

import java.util.List;

/**
 * Created by guagua on 18/2/21.
 */
public interface VenueService {
    /**
     * 根据id查询场馆
     * @param id
     * @return
     */
    public Venue queryVenue(int id);
    /**
     * 场馆登录
     * @param username
     * @param password
     * @return
     */
    public String venueLogin(String username, String password);

    /**
     * 系统自动给场馆分配7位编码
     * @return
     */
    public int getVenueSerialNumber();

    /**
     * 场馆注册
     * @param username
     * @param password
     * @param address
     * @param totalseats
     * @param rows
     * @param seatsEachRow
     */
    public void venueRegister(String username, String password, String address, String totalseats, String rows, String seatsEachRow);

    /**
     * 获得所有场馆
     * @return
     */
    public List<Venue> getAllVenues();

    /**
     * 获得场馆地址和座位情况
     * @param venueid
     * @return
     */
    public List<Venue> getVenueInfo(String venueid);

    /**
     * 修改场馆信息，包括座位和地点
     * @param venueid
     * @param address
     * @param totalseats
     * @param rows
     * @param seatsEachRow
     */
    public void modifyVenueSeatInfo(String venueid, String address, String totalseats, String rows, String seatsEachRow);

    /**
     * 场馆发布计划时，存储计划
     * @param id
     * @param theme
     * @param type
     * @param time
     * @param description
     * @param from
     * @param to
     * @param price
     */
    public void savePlan(String id, String theme, String type, String time, String description, String[] from, String[] to, String[] price);

    /**
     * 获得所有计划
     * @return
     */
    public List<Venue_plan> getAllPlans();

    /**
     * 获得自己的计划
     * @param username
     * @return
     */
    public List<Venue_plan> getOwnPlans(String username);
    /*
    获得一个具体的计划
     */
    public List<Venue_plan> getOnePlan(String planid);

    /**
     * 获得一个计划里的所有已经预订的座位
     * @return
     */
    public List<Plan_seat> getAllReservedSeats(String planid);

}
