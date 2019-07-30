package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Item;

public interface ItemService {
	public List<Item> getAllItems();

	public List<Item> getItemByCategory(String category);

	public Item getItemByItemId(String id);

	public Item addItem(Item item);

	public String deleteItem(String id);

}
