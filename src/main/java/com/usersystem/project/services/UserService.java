package com.usersystem.project.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.usersystem.project.entities.User;
import com.usersystem.project.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
		
	public List <User> findAll(){
		return userRepository.findAll();
	}
	
	public User findbyId(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}

	public User insert(User userObject) {
		return userRepository.save(userObject);
	}

	public User delete(User userObject)  {
		userRepository.delete(userObject);
		
		return userObject;
	}

	public User updateUser(User oldDataUser, User newDataUser)  {
		oldDataUser.setName(newDataUser.getName());
		oldDataUser.setEmail(newDataUser.getEmail());
		oldDataUser.setTelefone(newDataUser.getTelefone());
		oldDataUser.setPassword(newDataUser.getPassword());
		final User updatedUser = userRepository.save(oldDataUser);
        return updatedUser;
	}

} 
    

