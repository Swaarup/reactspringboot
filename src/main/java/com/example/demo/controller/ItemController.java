package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.domain.Item;
import com.example.demo.dto.ItemDTO;
import com.example.demo.facade.ItemFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemFacade itemFacade;

	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "This is a public Index Page. Everyone Can see this";
	}

	@RequestMapping("/getAllItems")
	@ResponseBody

	public ResponseEntity<List<ItemDTO>> getAllProjects() {

		return new ResponseEntity<>(this.itemFacade.getAllItems(), HttpStatus.OK);
	}

	@RequestMapping("/{category}")
	public ResponseEntity<List<ItemDTO>> getItem(@PathVariable("category") String category) {
		return new ResponseEntity<>(this.itemFacade.getItemByCategory(category), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemDTO> getItemById(@PathVariable("id") String id) {
		return new ResponseEntity<>(this.itemFacade.getItemById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ItemDTO> addItem(@RequestBody @Valid Item item) {
		return new ResponseEntity<>(itemFacade.addItem(item), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ItemDTO> updateItem(@RequestBody @Valid Item item) {
		return new ResponseEntity<>(itemFacade.updateItem(item), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deteteItem(@PathVariable("id") String id) {
		return new ResponseEntity<>(itemFacade.deleteItem(id), HttpStatus.OK);
	}
}