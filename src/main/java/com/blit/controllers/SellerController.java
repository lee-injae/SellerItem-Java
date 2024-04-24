package com.blit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blit.entities.Seller;
import com.blit.servicees.SellerService;

@RestController
@RequestMapping("/api/v1/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Seller>> getAllSellers() {
		return new ResponseEntity<>(sellerService.getAllSellers(), 
				HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Seller> getSeller(
			@PathVariable Long id) {
		return new ResponseEntity<>(sellerService.findSellerById(id), 
				HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Seller> saveCar(
			@RequestBody Seller seller) {
		return new ResponseEntity<>(sellerService.saveSeller(seller), 
				HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Seller> updateSeller(
			@PathVariable Long id, Seller seller) {
		return new ResponseEntity<>(sellerService.updateSeller(id, seller), 
				HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	

}
