package com.blit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blit.entities.Item;
import com.blit.servicees.ItemService;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Item>> getAllItems() {
		return new ResponseEntity<>(itemService.getAllItems(), 
				HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> getItem(
			@PathVariable Long id) {
		return new ResponseEntity<>(itemService.findItemById(id),
				HttpStatus.CREATED);
	}
	
	@PostMapping 
	public ResponseEntity<Item> saveItem(
			@RequestBody Item item) {
		return new ResponseEntity<>(itemService.saveItem(item), 
				HttpStatus.CREATED);
	}
	
	@DeleteMapping("{/id}")
	public void deleteItem(Long id) {
		itemService.deleteItem(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Item> updateItem(
			@RequestBody Long id, Item item) {
		return new ResponseEntity<>(itemService.updateItem(id, item), 
				HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	

}
