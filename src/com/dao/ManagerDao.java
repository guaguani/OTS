package com.dao;

import com.model.Manager;
import com.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by guagua on 18/2/23.
 */

@Component
public class ManagerDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate(){
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate = hibernateTemplate;
    }
    public void save(Manager manager){
        this.getHibernateTemplate().save(manager);
    }

    public void update(Manager manager){
        this.getHibernateTemplate().update(manager);
    }

    public String login(String managerid, String password){
        System.out.println(managerid);
        List<Manager> managerList = hibernateTemplate.find("from Manager where userid="+managerid);
        Manager manager = managerList.get(0);
        if(password.equals(manager.getPassword())){
            return "SUCCESS";
        }
        else{
            return "ERROR";
        }
    }

    public List<Venue> getVenueRegister(){
        return hibernateTemplate.find("from Venue where state=0");
    }

    public void approve(String userid){
        List<Venue> venues = hibernateTemplate.find("from Venue where id="+userid);
        Venue venue = venues.get(0);
        venue.setState(1);
        hibernateTemplate.update(venue);
    }
}
