package com.example.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Item;
import com.example.demo.exceptions.CustomExceptions;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	@Autowired
	ItemRepository itemRepo;

	public List<Item> getAllItems() throws CustomExceptions {
		try {
			return itemRepo.findAll(Sort.by(Sort.Direction.ASC, "itemId"));
		} catch (Exception Ex) {
			logger.info("Cannot find files");
			return null;
//			throw new CustomExceptions("Can not find all the Files." + Ex.getStackTrace());
		}

	}

	@Override
	public List<Item> getItemByCategory(String category) throws CustomExceptions {

		try {
			List<Item> item = itemRepo.findByCategory(category);
			return item;
		} catch (Exception e) {
			throw new CustomExceptions("The category can not be found." + e.getStackTrace());
		}
	}

	public Item getItemByItemId(String id) throws CustomExceptions {

		try {
			Item item = itemRepo.findById(id);
			return item;
		} catch (Exception e) {
			throw new CustomExceptions("The id does not exist. Error getting the item " + e.getStackTrace());
		}
	}

	public Item addItem(Item item) {
		try {
			return  itemRepo.save(item);
		} catch (Exception e) {
			logger.error("failed to add item::");
			return null;
//			throw new CustomExceptions("Failed trying to add the item " + e.getStackTrace());
		}
	}

	public String deleteItem(String id) throws CustomExceptions {

		try {

			Item item = itemRepo.findById(id);
			if (item != null) {
				itemRepo.delete(item);
			}
			return id;
		} catch (Exception e) {
			throw new CustomExceptions("Can not find the item id: " + id + " Stack Trace : " + e.getStackTrace());
		}

	}

}
