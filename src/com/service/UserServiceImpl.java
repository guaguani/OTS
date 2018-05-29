package com.service;

import com.dao.UserDao;
import com.model.Plan_seat;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guagua on 18/2/21.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String exists(String email){
        String result = null;
        List<User> userList = userDao.getUser(email);
        if(userList.size()>0) {
            //用户已存在
            User user = userList.get(0);
            int activate = user.getActivate();
            if(activate==1){
                //用户已激活
                result = "activated";
            }
            else if(activate == 0){
                //用户还未激活
                result = "notActivated";
            }
            return result;
        }
        else {
            result = "UserNotExist";
            return result;
        }
    }

    /**
     * 获得用户列表
     * @param email
     * @return
     */
    @Override
    public List<User> queryUsers(String email){
        return userDao.findAllUsers();
    }

    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public boolean register(String email, String password) {
        return false;
    }

    @Override
    public List getAllEmails() {
        return null;
    }

    @Override
    public void activate(String email) {
        userDao.activate(email);
    }

    @Override
    public void modifyPw(String pw, String email) {
        userDao.modifyPw(pw,email);
    }

    @Override
    public void cancelMember(String email) {
        userDao.cancelMember(email);
    }

    @Override
    public String reserveTickets(ArrayList<String> list, String userid, String planid, String venueid) {
        return userDao.reserveTickets(list,userid,planid,venueid);
    }

    @Override
    public List<Plan_seat> getAllOrders(String userid) {
        return userDao.getAllOrders(userid);
    }

    @Override
    public void payOrder(String orderid, String username) {
        userDao.payOrder(orderid,username);
    }

    @Override
    public String cancelOrder(String orderid, String username) {
        return userDao.cancelOrder(orderid,username);
    }

    @Override
    public int getBackTimes(String userid) {
        return userDao.getBackTimes(userid);
    }

    @Override
    public int getOrderTimes(String userid) {
        return userDao.getOrderTimes(userid);
    }

    @Override
    public void allocateSeat(String userid, String planid, String venueid) {
        userDao.allocateSeat(userid,planid,venueid);
    }

    @Override
    public User getUser(String email){
        return userDao.getUser(email).get(0);
    }

    @Override
    @Transactional
    public void save(User user){
        userDao.save(user);
    }

    @Override
    @Transactional
    public void modifyUser(User user){
        userDao.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(String userid){
        userDao.delete(userid);
    }

}
