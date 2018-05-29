package com.service;

import com.dao.ManagerDao;
import com.model.Manager;
import com.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guagua on 18/2/23.
 */

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public String login(String managerid, String password) {
        return managerDao.login(managerid,password);
    }

    @Override
    public List<Venue> getVenueRegister() {
        return managerDao.getVenueRegister();
    }

    @Override
    public void approve(String userid) {
        managerDao.approve(userid);
    }
}
