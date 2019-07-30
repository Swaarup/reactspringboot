package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.domain.Item;

public interface ItemRepository extends MongoRepository <Item, Long>{
	
List<Item> findByCategory(String category);
Item findById(String id);
}
