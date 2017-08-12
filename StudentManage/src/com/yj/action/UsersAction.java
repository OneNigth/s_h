package com.yj.action;

import com.opensymphony.xwork2.ModelDriven;
import com.yj.entity.Users;
import com.yj.service.UsersDAO;
import com.yj.service.impl.UsersDAOImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Users user = new Users();

	// 用户登陆
	public String login() {
		UsersDAO udao = new UsersDAOImpl();
		// 登陆成功
		if (udao.usersLogin(user)) {
			return "login_success";
		} else {
			return "login_failure";
		}
	}

	@Override
	public Users getModel() {
		return this.user;
	}

}
