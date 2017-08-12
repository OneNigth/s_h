package com.yj.service.impl;

import org.junit.Test;

import com.yj.entity.Users;
import com.yj.service.UsersDAO;

public class TestUsersDAOImpl {

	@Test
	public void testUserLogin() {
		Users u = new Users(1,"admin", "admin");
		UsersDAO usersDAO = new UsersDAOImpl();
		if (usersDAO.usersLogin(u)) {
			System.out.println("登陆成功");
		} else {
			System.out.println("登陆失败");
		}
	}
}
