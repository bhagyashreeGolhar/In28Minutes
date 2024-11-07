package com.in28Minutes.RestWebservices.RestWebservices.User;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private UserDao userDao;
	
	public UserController(UserDao userDao)
	{
		this.userDao=userDao;
	}
	
	@GetMapping("/user/getAllUsers")
	public List<UserBean> getUsers()
	{
		return userDao.findAll();
	}
	
	@GetMapping("/user/getUserById/{id}")
	public UserBean getUserById(@PathVariable int id) throws Exception
	{
		UserBean user= userDao.findById(id);
		if(user==null)
		{
			throw new Exception("Generic Excpetion");
		}
		return user;
	}
	
	@PostMapping("/user/addUser")
	public ResponseEntity<UserBean> AddUser(@RequestBody UserBean user)
	{
		userDao.saveUser(user);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/user/deleteUser/{id}")
	public ResponseEntity<Object> DeleteUser(@PathVariable int id )
	{
		userDao.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/user/updateUser/{id}")
	public ResponseEntity<Object> updateUser( @RequestBody UserBean user,@PathVariable int id)
	{
		userDao.updateById(id,user);
		return ResponseEntity.ok(null);
	}
	
}
