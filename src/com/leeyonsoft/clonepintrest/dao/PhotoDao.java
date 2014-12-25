package com.leeyonsoft.clonepintrest.dao;

import org.apache.log4j.*;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.*;

import org.hibernate.HibernateException;

import com.leeyonsoft.clonepintrest.models.*;

public class PhotoDao {

	private static Logger logger = Logger.getLogger(PhotoDao.class);
	
	// ±£´æÍ¼Æ¬
	public static boolean SavePhoto(String largePhotoPath,String thumbnailPath,int userId)
			throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		boolean isSuccessful = false;
		try {

			// Begin unit of work
			session.beginTransaction();

			PhotoEntity photo=new PhotoEntity();
			photo.setBigPhotoPath(largePhotoPath);
			photo.setSmallPhotoPath(thumbnailPath);
			
			session.save(photo);

			// End unit of work
			session.getTransaction().commit();
			
			int photoId=photo.getId();
			
			session.beginTransaction();
			
			UserPhotoEntity userPhotoEnitity=new UserPhotoEntity();
			userPhotoEnitity.setIsOwner(true);
			userPhotoEnitity.setIsPublic(true);
			userPhotoEnitity.setPhotoId(photoId);
			userPhotoEnitity.setUserId(userId);
			
			session.save(userPhotoEnitity);
			
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
