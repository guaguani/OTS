package com.service;

import com.model.Plan_seat;
import com.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guagua on 18/2/21.
 */
public interface UserService {
    /**
     * 判断用户是否存在
     */
    public String exists(String username);
    /**
     * 保存用户
     */
    public void save(User user);
    /**
     * 修改用户
     */
    public void modifyUser(User user);
    /**
     * 删除用户
     */
    public void deleteUser(String id);
    /**
     * 获取指定id用户
     */
    public User getUser(String id);
    /**
     * 获取用户列表
     */
    public List<User> queryUsers(String id);

    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    public String login(String email,String password);

    /**
     * 注册
     * @param email
     * @param password
     * @return
     */
    public boolean register(String email,String password);

    /**
     * 获得所有邮箱账号，用于判断是否邮箱是否注册过
     * @return 所有邮箱
     */
    public List getAllEmails();

    /**
     * 激活邮箱
     * @param email
     * @return
     */
    public void activate(String email);

    /**
     * 修改个人信息（修改密码）
     * @param pw
     */
    public void modifyPw(String pw,String email);

    /**
     * 取消会员资格
     * @param email
     */
    public void cancelMember(String email);
    /**
     * 预订票
     * @param list
     */
    public String reserveTickets(ArrayList<String> list, String userid, String planid, String venueid);

    /**
     * 获得用户所有的订单
     * @param userid
     * @return
     */
    public List<Plan_seat> getAllOrders(String userid);

    /*
    支付
     */
    public void payOrder(String orderid, String username);

    public String cancelOrder(String orderid, String username);

    public int getBackTimes(String userid);

    public int getOrderTimes(String userid);

    public void allocateSeat(String userid, String planid, String venueid);

}
