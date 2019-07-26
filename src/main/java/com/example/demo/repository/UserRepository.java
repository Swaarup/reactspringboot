package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.docs.User;


public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

}