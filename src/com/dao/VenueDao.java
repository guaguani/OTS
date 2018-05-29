package com.dao;

import com.model.Plan_seat;
import com.model.Venue_plan;
import com.model.Seat;
import com.model.Venue;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guagua on 18/2/21.
 */
@Component
public class VenueDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate(){
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate = hibernateTemplate;
    }

    public Venue getVenue(int id){
        List<Venue> venues = hibernateTemplate.find("from Venue where id="+id+" and state=1");
        Venue venue = venues.get(0);
        return venue;
    }

    public List<Venue> findAllVenues(){
        System.out.println("venueDao.getAllVenues");
        return hibernateTemplate.find("from Venue order by id");
    }

    public void save(String username, String password){
        Venue venue = new Venue();
        venue.setId(Integer.parseInt(username));
        venue.setPassword(password);
        hibernateTemplate.save(venue);
    }

    public List<Venue> getVenueInfo(String venueid){
        return hibernateTemplate.find("from Venue where id="+venueid);
    }

    /**
     * 场馆注册提交申请时，申请提交到venueApproval表中
     * @param username
     * @param password
     * @param address
     * @param totalseats
     * @param rows
     * @param seatsEachRow
     */
    public void venueRegisterApproval(String username, String password, String address, String totalseats, String rows, String seatsEachRow){
        Venue venue = new Venue();
        venue.setId(Integer.parseInt(username));
        venue.setPassword(password);
        venue.setAddress(address);
        venue.setTotalseats(Integer.parseInt(totalseats));
        venue.setRows(Integer.parseInt(rows));
        venue.setSeatsEachRow(Integer.parseInt(seatsEachRow));
        //注册场馆申请，等待审批
        venue.setState(0);
        hibernateTemplate.save(venue);
    }

    /**
     * 场馆申请修改信息时，同样提交到venueApproval表中
     * @param venueid
     * @param address
     * @param totalseats
     * @param rows
     * @param seatsEachRow
     */
    public void modifyVenueSeatInfo(String venueid, String address, String totalseats, String rows, String seatsEachRow){
        List<Venue> venues = hibernateTemplate.find("from Venue where id="+venueid);
        if(venues.size()>0){
            //一般来说，是得到一个venue
            Venue venue = venues.get(0);
            String password = venue.getPassword();
            Venue modiVenue = new Venue();
            modiVenue.setId(Integer.parseInt(venueid));
            modiVenue.setPassword(password);
            modiVenue.setAddress(address);
            modiVenue.setTotalseats(Integer.parseInt(totalseats));
            modiVenue.setRows(Integer.parseInt(rows));
            modiVenue.setSeatsEachRow(Integer.parseInt(seatsEachRow));
            modiVenue.setState(0);
            hibernateTemplate.save(modiVenue);
        }
    }

    /**
     * 场馆发布计划时，将计划存储到表Plan和表seat中,并且创建表plan_seat
     * @param id
     * @param theme
     * @param type
     * @param time
     * @param description
     * @param from
     * @param to
     * @param price
     */
    public void savePlan(String id, String theme, String type, String time, String description, String[] from, String[] to, String[] price) {
        List<Venue_plan>plans = hibernateTemplate.find("from Venue_plan");
        ArrayList planids = new ArrayList();
        for(int i=0;i<plans.size();i++){
            planids.add(plans.get(i).getPlanid());
        }
        int planid = 1;
        if(planids.size()>0){
            planid=(Integer)planids.get(planids.size()-1)+1;
        }
        int length = from.length;
        List<Seat>seats = hibernateTemplate.find("from Seat ");
        int order = seats.size();
        order=order+1;
        for (int i=0;i<from.length;i++){
            Seat seat = new Seat();
            seat.setVenueid(Integer.parseInt(id));
            seat.setFrom(Integer.parseInt(from[i]));
            seat.setTo(Integer.parseInt(to[i]));
            seat.setPrice(Double.parseDouble(price[i]));
            seat.setPlanid(planid);
            seat.setId(order+i);
            hibernateTemplate.save(seat);
        }

        Venue_plan plan = new Venue_plan();
        plan.setId(Integer.parseInt(id));
        plan.setTheme(theme);
        plan.setTime(time);
        plan.setType(type);
        plan.setPlanid(planid);
        plan.setDescription(description);
        plan.setBacknum(0);
        plan.setOrdernum(0);
        hibernateTemplate.save(plan);
    }

    /**
     * 获得所有已经发布的计划
     * @return
     */
    public List<Venue_plan>getAllPlans(){
        List<Venue_plan>plans = hibernateTemplate.find("from Venue_plan");
        return plans;
    }

    public List<Venue_plan> getOwnPlans(String username){
        return hibernateTemplate.find("from Venue_plan where id="+username);
    }
    /*
    获得某一个具体的计划
     */
    public List<Venue_plan> getOnePlan(String planid){
        List<Venue_plan>plans = hibernateTemplate.find("from Venue_plan where planid="+planid);
        return plans;
    }

    /**
     * 获得一个计划的座位情况
     * @param planid
     * @return
     */
    public List<Plan_seat> getAllSeats(String planid){
        List<Plan_seat> seats = hibernateTemplate.find("from Plan_seat where planid="+planid+" and state=1 and notexist=0");
        return seats;
    }
    public void update(Venue venue){hibernateTemplate.update(venue);}

    public void delete(Venue venue){hibernateTemplate.delete(venue);}
}
