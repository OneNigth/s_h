package com.yj.service;

import com.yj.entity.Users;

//用户业务逻辑接口
public interface UsersDAO {
	
	/**
	 * 用户登录方法
	 * @param user 登陆用户
	 * @return boolean
	 */
	public boolean usersLogin(Users user);
}
