package com.service;

import com.bean.UserBean;

public interface UserService_new {
	/*
	 * 用户登录
	 */
	public String logIn(String userid,String password);
	/*
	 * 邮箱验证，发送验证码到邮箱
	 */
	public String mailCheck(String mail);
	/*
	 * 验证码激活邮箱。成功返回用户名，否则返回FAIL
	 */
	public String checkVcode(String vcode);
	/*
	 * 获取用户个人信息
	 */
	public UserBean getUserInfo(String userid);
	/*
	 * 修改用户个人信息
	 */
	public String modUser(UserBean user);
}
