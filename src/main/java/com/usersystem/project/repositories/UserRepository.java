package com.usersystem.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usersystem.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}