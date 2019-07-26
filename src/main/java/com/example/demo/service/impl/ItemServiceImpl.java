package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.docs.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemRepository itemRepo;

	public List<Item> getAllItems() {
		return itemRepo.findAll(Sort.by(Sort.Direction.ASC, "itemId"));
		// return itemRepo.findAll(sort)();
	}

	public List<Item> getItemByCategory(String category) {
		List<Item> item = itemRepo.findByCategory(category);
		return item;
	}

	
	public Item getItemByItemId(String id) {
		Item item = itemRepo.findById(id);
		return item;
	}

	public Item addItem(long id, String serialNumber, String name, String category) {
		Item item = new Item();
		item.setCategory(category);
		item.setItemId(id);
		item.setName(name);
		item.setSerialNumber(serialNumber);
		return (Item) itemRepo.save(item);
	}

	public int deleteItem(String id) {
		Item item = itemRepo.findById(id);
		if (item != null) {
			itemRepo.delete(item);
			return 1;
		}
		return -1;
	}

	

}
