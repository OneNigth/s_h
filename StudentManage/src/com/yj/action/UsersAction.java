package com.yj.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

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
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		} else {
			return "login_failure";
		}
	}

	@SkipValidation
	// 用户注销
	public String logout() {
		session.removeAttribute("loginUserName");
		return "login_out";
	}
	
	//表单验证
	@Override
	public void validate() {
		if ("".equals(user.getUsername().trim())) {
			this.addFieldError("usernameError", "用户名不能为空");
		}
		if (user.getPassword().length() < 6) {
			this.addFieldError("passwordError", "密码长度不能小于6位");
		}
	}

	@Override
	public Users getModel() {
		return this.user;
	}

}
