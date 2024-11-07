package com.in28Minutes.RestWebservices.RestWebservices.User;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.hibernate.event.spi.PostCollectionUpdateEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJpaController {

private UserDao userDao;
private UserRepository repo;
private PostRepository postrepo;
	
	public UserJpaController(UserDao userDao,UserRepository repo, PostRepository postrepo)
	{
		this.userDao=userDao;
		this.repo=repo;
		this.postrepo=postrepo;
		
	}
	
	@GetMapping("/user/jpa/getAllUsers")
	public List<UserBean> getUsers()
	{
		return repo.findAll();
	}
	
	@GetMapping("/user/jpa/getUserById/{id}")
	public Optional<UserBean> getUserById(@PathVariable int id) throws Exception
	{
		Optional<UserBean> user=repo.findById(id);
		//UserBean user= userDao.findById(id);
		if(user==null)
		{
			throw new Exception("Generic Excpetion");
		}
		return user;
	}
	
	@PostMapping("/user/jpa/addUser")
	public ResponseEntity<UserBean> AddUser(@RequestBody UserBean user)
	{
		userDao.saveUser(user);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/user/jpa/deleteUser/{id}")
	public ResponseEntity<Object> DeleteUser(@PathVariable int id )
	{
		repo.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/user/jpa/createUser")
	public void CreateUser(@RequestBody UserBean user)
	{
		repo.save(user);
	}
	/*
	 * @PutMapping("/user/jpa/updateUser/{id}") public ResponseEntity<Object>
	 * updateUser( @RequestBody UserBean user,@PathVariable int id) {
	 * userDao.updateById(id,user); return ResponseEntity.ok(null); }
	 */
	
	//Post related API's
	@GetMapping("/user/jpa/{id}/post")
	public List<PostEntity> retriveUserPosts(@PathVariable int id ) throws Exception
	{
		Optional<UserBean> user=repo.findById(id);
		
		if(user==null)
		{
			throw new Exception("Generic Excpetion");
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/user/jpa/{id}/createpost")
	public void createPost(@PathVariable int id ,@RequestBody PostEntity post) throws Exception
	{
		Optional<UserBean> user=repo.findById(id);
		post.setUser(user.get());
		if(user==null)
		{
			throw new Exception("Generic Excpetion");
		}
		postrepo.save(post);
		
	}
}
