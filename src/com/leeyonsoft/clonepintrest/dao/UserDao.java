package com.leeyonsoft.clonepintrest.dao;

import org.apache.log4j.*;
import org.hibernate.Session;
import org.hibernate.Query;

import java.util.*;

import org.hibernate.HibernateException;

import com.leeyonsoft.clonepintrest.models.*;

public class UserDao {

	private static Logger logger = Logger.getLogger(UserDao.class);

	// 验证用户登录
	public static UserEntity auth(String name, String pass)
			throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		UserEntity authUser = null;
		try {

			// Begin unit of work
			session.beginTransaction();

			String hql = "from UserEntity as u where u.name='" + name
					+ "' and u.pass='" + pass + "'";

			Query query = session.createQuery(hql);

			@SuppressWarnings({ "unchecked" })
			List<UserEntity> queryResultList = query.list();

			if (queryResultList.size() > 0) {
				authUser = queryResultList.get(0);
			}

			// End unit of work
			session.getTransaction().commit();

		} catch (HibernateException hex) {
			logger.error(hex.toString());
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
		} catch (Exception ex) {
			logger.error(ex.toString());
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
		}
		return authUser;
	}

	// 用户注册
	public static boolean register(String name, String pass, String displayName)
			throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		boolean isSuccessful = false;
		try {

			// Begin unit of work
			session.beginTransaction();

			UserEntity user = new UserEntity();
			user.setName(name);
			user.setPass(pass);    
			user.setDisplayName(displayName);

			session.save(user);

			// End unit of work
			session.getTransaction().commit();

			isSuccessful = true;

		} catch (HibernateException hex) {
			logger.error(hex.toString());
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
		} catch (Exception ex) {
			logger.error(ex.toString());
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
		}
		return isSuccessful;
	}

}
