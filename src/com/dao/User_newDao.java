package com.dao;

import com.bean.UserBean;

public interface User_newDao {
    /*
     * 获取用户个人信息
     */
    public UserBean getUserInfo(String userid);

    /*
     * 修改用户个人信息
     */
    public void modUser(UserBean user);

    /*
     *存在则返回TRUE,不存在则返回FALSE
     */
    public String isUserExist(String userid);

    public void addUser(String id,String name,String ps);
}
