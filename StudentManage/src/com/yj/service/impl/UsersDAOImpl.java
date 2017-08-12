package com.yj.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yj.db.HibernateSessionFactory;
import com.yj.entity.Users;
import com.yj.service.UsersDAO;

public class UsersDAOImpl implements UsersDAO {

	@Override
	public boolean usersLogin(Users user) {

		Transaction tx = null;
		String hql = "";
		try {
			// 获取会话对象
			Session session = HibernateSessionFactory.getSessionFactory().openSession();
			//开启事务
			tx = session.beginTransaction();
			// 查询语句
			hql = "from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			// 查询结果集
			List list = query.list();
			//提交事务
			tx.commit();
			if (list != null && list.size() > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}

	}

}
