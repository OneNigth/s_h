package com.yj.entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yj.db.HibernateSessionFactory;


public class TestStudent {
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
//		// 创建配置对象
//		Configuration config = new Configuration().configure();
//		// 创建服务器注册对象
//		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
//				.buildServiceRegistry();
//		// 创建会话工厂对象
//		sessionFactory = config.buildSessionFactory(registry);
		// 获取会话对象
		session = HibernateSessionFactory.getSessionFactory().openSession();
		// 开启事务
		transaction = session.beginTransaction();
	}

	@After
	public void destory() {
		if(transaction!=null)
		transaction.commit();
		if(session!=null)
		session.close();
	}


	@Test
	public void TestSaveStudents() {
		 Student s = new Student("s01234567891", "廉颇", "男", new Date(), "王者峡谷");
		 session.save(s);
	}
	
}
