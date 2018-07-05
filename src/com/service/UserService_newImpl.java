package com.service;

import com.bean.UserBean;
import com.dao.User_newDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService_newImpl implements UserService_new {

    @Autowired
    private User_newDao userNewDao;

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
        return null;
    }

    @Override
    public UserBean getUserInfo(String userid) {
        return userNewDao.getUserInfo(userid);
    }

    @Override
    public String modUser(UserBean user) {
        UserBean userBean = getUserInfo(user.getId());
        if (userBean.getPwd().equals(user.getPwd())){
            return "NOCHANGE";
        }else {
            userNewDao.modUser(user);
        }
        return "SUCESS";
    }
}
