package com.service;

import com.bean.UserBean;
import com.dao.User_newDao;
import com.dao.User_newDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class UserService_newImpl implements UserService_new {


    private User_newDao userNewDao = new User_newDaoImpl();

    @Override
    public String logIn(String userid, String password) {
        String exists = userNewDao.isUserExist(userid);
        if (exists.equals("FALSE")){
            return "NONEXIST";
        }else {
            UserBean userBean = userNewDao.getUserInfo(userid);
            if (userBean.getPwd().equals(password)){
                return "LOGINSUCESS";
            }else if (!userBean.getPwd().equals(password)){
                return "WRONGPASSWORD";
            }else {
                return "UNKNOWNERROR";
            }
        }
    }

    @Override
    public String mailCheck(String mail) {
        return null;
    }

    @Override
    public String checkVcode(String vcode) {
        long i=System.currentTimeMillis();
        String id=i+"";
        id=id.substring(id.length()-10);
        String s[]=vcode.split("=");
        userNewDao.addUser(id,s[0],s[1]);
        return id;
    }

    @Override
    public UserBean getUserInfo(String userid) {
        return userNewDao.getUserInfo(userid);
    }

    @Override
    public String modUser(UserBean user) {
        userNewDao.modUser(user);
        return "SUCCESS";
    }
}
