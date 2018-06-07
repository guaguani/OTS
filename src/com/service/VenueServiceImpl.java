package com.service;

import com.dao.VenueDao;
import com.model.Plan_seat;
import com.model.Venue_plan;
import com.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guagua on 18/2/21.
 */
@Service("venueService")
public class VenueServiceImpl implements VenueService {
    @Autowired
    private VenueDao venueDao;

    @Override
    public Venue queryVenue(int id) {
        return venueDao.getVenue(id);
    }

    @Override
    public String venueLogin(String username, String password) {
        return null;
    }

    @Override
    public int getVenueSerialNumber() {
        List<Venue> venues = venueDao.findAllVenues();
        int length = venues.size();
        System.out.println(String.valueOf(length));
        int max = venues.get(length-1).getId();
        int newNumber = max+1;
        return newNumber;
    }

    @Override
    public void venueRegister(String username, String password, String address, String totalseats, String rows, String seatsEachRow) {
        venueDao.venueRegisterApproval(username, password, address, totalseats, rows, seatsEachRow);
    }

    @Override
    public List<Venue> getAllVenues() {
        return venueDao.findAllVenues();
    }

    @Override
    public List<Venue> getVenueInfo(String venueid) {
        return venueDao.getVenueInfo(venueid);
    }

    @Override
    public void modifyVenueSeatInfo(String venueid, String address, String totalseats, String rows, String seatsEachRow) {
        venueDao.modifyVenueSeatInfo(venueid,address,totalseats,rows,seatsEachRow);
    }

    @Override
    public void savePlan(String id, String theme, String type, String time, String description, String[] from, String[] to, String[] price) {
        venueDao.savePlan(id,theme,type,time,description,from,to,price);
    }

    @Override
    public List<Venue_plan> getAllPlans() {
        return venueDao.getAllPlans();
    }

    @Override
    public List<Venue_plan> getOwnPlans(String username) {
        return venueDao.getOwnPlans(username);
    }

    @Override
    public List<Venue_plan> getOnePlan(String planid) {
        return venueDao.getOnePlan(planid);
    }

    @Override
    public List<Plan_seat> getAllReservedSeats(String planid) {
        return venueDao.getAllSeats(planid);
    }

}
