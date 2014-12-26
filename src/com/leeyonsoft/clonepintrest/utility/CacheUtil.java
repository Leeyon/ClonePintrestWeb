package com.leeyonsoft.clonepintrest.utility;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.leeyonsoft.clonepintrest.models.UserEntity;

public class CacheUtil {

	private static Map<Integer,UserEntity> usersData = new ConcurrentHashMap<Integer, UserEntity>();  
	
	@Cacheable(value="userCache", key="#id")
	public static UserEntity GetUser(int userId)
	{
		UserEntity user=null;
		if(usersData.containsKey(userId));
		{
			user=usersData.get(userId);
		}
		return user;
	}
	
	@CacheEvict(value="userCache", key="#id")
	public static void SetUser(UserEntity user)
	{
		if(!usersData.containsKey(user.getId()))
		{
			usersData.put(user.getId(), user);
		}
	}
	
}
