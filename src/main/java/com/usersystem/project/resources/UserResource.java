package com.usersystem.project.resources;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usersystem.project.entities.User;
import com.usersystem.project.resources.exceptions.ResourceNotFoundException;
import com.usersystem.project.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List <User> list = userService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		try {
			User obj = userService.findbyId(id);
			return ResponseEntity.ok().body(obj);
		} catch(Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User userObject) {
        
        return ResponseEntity.ok().body(userService.insert(userObject));
    }

	@PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newDataUser) {
		try {
			User oldDataUser = userService.findbyId(id);
			return ResponseEntity.ok().body(userService.updateUser(oldDataUser, newDataUser));
		} catch(Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
    }

	@DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		try {
			User obj = userService.findbyId(id);
			return ResponseEntity.ok().body(userService.delete(obj));
		} catch(Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
    }

}
