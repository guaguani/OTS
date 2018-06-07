package com.service;

import com.model.Manager;
import com.model.Venue;

import java.util.List;

/**
 * Created by guagua on 18/2/23.
 */


public interface ManagerService {
    public String login(String managerid,String password);
    public List<Venue> getVenueRegister();
    public void approve(String userid);
}
