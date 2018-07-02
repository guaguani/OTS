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
}
