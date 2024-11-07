package com.in28Minutes.RestWebservices.RestWebservices.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	public static List<UserBean> users=new ArrayList<>(); 
	
	public static int usersCount=0;
	static
	{
		users.add(new UserBean(++usersCount,"Sakshi",LocalDate.now().minusYears(23)));
		users.add(new UserBean(++usersCount,"Bhagyashri",LocalDate.now().minusYears(25)));
		users.add(new UserBean(++usersCount,"Sagar",LocalDate.now().minusYears(20)));
	}
	
	public List<UserBean> findAll()
	{
		return users;
	}
	
	public UserBean findById(int id)
	{
		for(UserBean user:users)
		{
			int userId=user.getId();
			if(userId==id)
			{
				return user;
			}
				
		}
		return null;
	}

	public void saveUser(UserBean user)
	{
		user.setId(++usersCount);
		users.add(user);
	}
	
	public void deleteById(int id) 
	{
		for(UserBean user:users)
		{
			if(user.getId()==id)
			{
				System.out.print("Index is: "+ (id-1));
				users.remove(id-1);
			}
		}			
	}

	public void updateById(int id, UserBean updateUser)
	{
		for(UserBean user:users)
		{
			if(user.getId()==  id)
			{
				user.setName(updateUser.getName());
				user.setBirthDate(updateUser.getBirthDate());
			}
		}		
	}
	
}
