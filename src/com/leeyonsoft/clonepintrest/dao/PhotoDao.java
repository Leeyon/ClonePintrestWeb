package com.leeyonsoft.clonepintrest.dao;

import org.apache.log4j.*;
import org.hibernate.Session;
import org.hibernate.Query;

import java.util.*;

import com.leeyonsoft.clonepintrest.models.*;

import org.hibernate.HibernateException;

public class PhotoDao {

	private static Logger logger = Logger.getLogger(PhotoDao.class);

	// 获取所有用户上传的图片
	public static List<PhotoViewModel> GetPhotos() throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<PhotoViewModel> photoList = null;
		try {

			// Begin unit of work
			session.beginTransaction();

			String hql = "select new com.leeyonsoft.clonepintrest.models.PhotoViewModel(u.id,u.displayName,p.bigPhotoPath,p.smallPhotoPath) "
					+ "from PhotoEntity as p, UserEntity as u,UserPhotoEntity as up where p.id=up.photoId "
					+ "and u.id=up.userId " + "and up.isPublic=true";

			Query query = session.createQuery(hql);

			@SuppressWarnings({ "unchecked" })
			List<PhotoViewModel> list = query.list();

			if (list.size() > 0) {
				photoList = list;
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
		return photoList;
	}

	// 获取用户所有上传的图片
	public static List<PhotoViewModel> GetPhotos(int userId)
			throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<PhotoViewModel> photoList = null;
		try {

			// Begin unit of work
			session.beginTransaction();

			String hql = "select new com.leeyonsoft.clonepintrest.models.PhotoViewModel(u.displayName,p.bigPhotoPath,p.smallPhotoPath) "
					+ "from PhotoEntity as p, UserEntity as u,UserPhotoEntity as up where p.id=up.photoId "
					+ "and u.id=up.userId "
					+ "and up.isPublic=true "
					+ "and u.id=" + userId;

			Query query = session.createQuery(hql);

			@SuppressWarnings({ "unchecked" })
			List<PhotoViewModel> list = query.list();

			if (list.size() > 0) {
				photoList = list;
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
		return photoList;
	}

	// 删除图片
	public static boolean DeletePhoto(int photoId) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		boolean isSuccessful = false;
		try {

			UserPhotoEntity upEntity = null;

			// Begin unit of work
			session.beginTransaction();

			String hql = "from UserPhotoEntity as up where up.photoId="
					+ photoId;

			Query query = session.createQuery(hql);

			@SuppressWarnings({ "unchecked" })
			List<UserPhotoEntity> queryResultList = query.list();

			if (queryResultList.size() > 0) {
				upEntity = queryResultList.get(0);
			}

			upEntity.setIsPublic(false);

			session.saveOrUpdate(upEntity);

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

	// 保存图片
	public static boolean SavePhoto(String largePhotoPath,
			String thumbnailPath, int userId) throws HibernateException {
		Session session1 = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		boolean isSuccessful = false;
		try {

			// Begin unit of work
			session1.beginTransaction();

			PhotoEntity photo = new PhotoEntity();
			photo.setBigPhotoPath(largePhotoPath);
			photo.setSmallPhotoPath(thumbnailPath);

			session1.save(photo);

			// End unit of work
			session1.getTransaction().commit();

			int photoId = photo.getId();

			Session session2 = HibernateUtil.getSessionFactory()
					.getCurrentSession();

			session2.beginTransaction();

			UserPhotoEntity userPhotoEnitity = new UserPhotoEntity();
			userPhotoEnitity.setIsOwner(true);
			userPhotoEnitity.setIsPublic(true);
			userPhotoEnitity.setPhotoId(photoId);
			userPhotoEnitity.setUserId(userId);

			session2.save(userPhotoEnitity);

			session2.getTransaction().commit();

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
