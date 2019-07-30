package com.example.demo.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.domain.Item;
import com.example.demo.dto.ItemDTO;
import com.example.demo.exceptions.CustomExceptions;

@Component
public class ItemAssembler {

	public ItemDTO convertItemtoItemDTO(Item item) {

		try {
			return ItemDTO.builder().id(item.getId()).itemId(item.getItemId()).serialNumber(item.getSerialNumber())
					.category(item.getCategory()).name(item.getName()).build();
		} catch (Exception ex) {
			throw new CustomExceptions("Build Failed: Couldn't Convert fom Item to ItemDTO");
		}

	}

	public Item convertItemDTOtoItem(ItemDTO itemDto) {
		try {
			return Item.builder().id(itemDto.getId()).itemId(itemDto.getItemId())
					.serialNumber(itemDto.getSerialNumber()).category(itemDto.getCategory()).name(itemDto.getName())
					.build();
		} catch (Exception ex) {
			throw new CustomExceptions("Build Failed: Couldn't Convert from ItemDto to Item");
		}
	}

	public List<ItemDTO> convertAllItemToDto(List<Item> items) {
		try {
			List<ItemDTO> itemDTOs = new ArrayList<>();
			for (Item item : items) {
				ItemDTO itemDto = this.convertItemtoItemDTO(item);
				itemDTOs.add(itemDto);
			}
			return itemDTOs;
		} catch (Exception e) {
			throw new CustomExceptions("Error while converting list of Items to Item Dto::");
		}

	}

}
