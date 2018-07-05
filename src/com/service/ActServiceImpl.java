package com.service;

import com.bean.ActivityBean;
import com.dao.ActDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActServiceImpl implements ActService{

    @Autowired
    private ActDao actDao;

    @Override
    public int buyTicket(int aid, String showtime, double ticket, int num, double sum, String username) {
        return 0;
    }

    @Override
    public ActivityBean getByID(int id) {
        return actDao.getByID(id);
    }

    @Override
    public ArrayList<ActivityBean> advertiseAct() {
        return actDao.advertiseAct();
    }

    @Override
    public ArrayList<ActivityBean> hotAct() {
        return actDao.hotAct();
    }

    @Override
    public ArrayList<ActivityBean> selectByCond(String city, String type, int offset) {
        return actDao.selectByCond(city, type);
    }

    @Override
    public ArrayList<ActivityBean> selectByNameOrVen(String input, int offset) {
        ArrayList<ActivityBean> allBeans = actDao.getAllActivity();
        String comp[] = input.split("");
        ArrayList<ActivityBean> result = new ArrayList<>();

        for (ActivityBean activityBean : allBeans){

            for (int i = 0; i < comp.length; i++){
                if (activityBean.getName().contains(comp[i]) ||
                        activityBean.getVname().contains(comp[i]) ||
                        activityBean.getDes().contains(comp[i])){
                    result.add(activityBean);
                }
            }

        }

        return result;
    }
}
