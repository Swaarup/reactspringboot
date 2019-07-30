package com.example.demo.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Item;
import com.example.demo.dto.ItemDTO;
import com.example.demo.exceptions.CustomExceptions;
import com.example.demo.service.ItemService;

import com.example.demo.assembler.ItemAssembler;

@Service
public class ItemFacade {
	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemAssembler itemAssembler;

	public List<ItemDTO> getAllItems() {

		List<Item> items = itemService.getAllItems();
		return this.itemAssembler.convertAllItemToDto(items);

	}

	public List<ItemDTO> getItemByCategory(String category) {

		List<Item> items = itemService.getItemByCategory(category);
		return this.itemAssembler.convertAllItemToDto(items);
	}

	public ItemDTO getItemById(String id) {
		Item item = itemService.getItemByItemId(id);
		return this.itemAssembler.convertItemtoItemDTO(item);
	}

	public ItemDTO addItem(Item item) {
		Item added = this.itemService.addItem(item);
		return this.itemAssembler.convertItemtoItemDTO(added);
	}

	public String deleteItem(String id) {
		return itemService.deleteItem(id);
	}

	public ItemDTO updateItem(Item item) {
		if (null == item.getId()) {
			throw new CustomExceptions("Id of the project can not be null");
		}
		Item updateItem = this.itemService.getItemByItemId(item.getId());
		BeanUtils.copyProperties(item, updateItem);

		Item added = this.itemService.addItem(updateItem);
		return this.itemAssembler.convertItemtoItemDTO(added);
	}

}
