package com.example.demo.service;

import java.util.List;

import com.example.demo.docs.Item;

public interface ItemService {
	public List<Item> getAllItems();
	public List<Item> getItemByCategory(String category);
	public Item getItemByItemId(String id);
	public Item addItem(long id, String serialNumber, String name, String category);
	public int deleteItem(String id);

}
