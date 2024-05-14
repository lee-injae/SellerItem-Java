package com.blit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.blit.entities.Item;
import com.blit.entities.Seller;
import com.blit.servicees.ItemService;
import com.blit.servicees.SellerService;

@SpringBootApplication
public class SellerItemApplication implements CommandLineRunner {
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private static final Logger logger = LoggerFactory.getLogger(SellerItemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SellerItemApplication.class, args);
		logger.info("Application has started now!");
	}
	
	public void run(String... args) throws Exception {
		
		Seller seller1 = new Seller(
				"oshi", 
				"ADMIN",
				passwordEncoder.encode("leelee"), 
				"chevychase", 
				2000);
		
		sellerService.saveSeller(seller1);
		
		Seller seller2 = new Seller (
				"samiam",
				"USER",
				passwordEncoder.encode("greeneggs"),
				"sterling",
				1995
				);
		
		sellerService.saveSeller(seller2);
		
		sellerService.getAllSellers().forEach(s -> logger.info(s.getUsername()));
		
		
		Item item1 = new Item(
				"chair", 
				"sturdy and four-legged", 
				2, 
				2022, 
				false,
				seller1);
		
		Item item2 = new Item (
				"monitor",
				"HP 21inch flatscreen",
				0,
				2014,
				true,
				seller2
				);
		
		Item item3 = new Item (
				"book",
				"germs, guns, steel",
				5,
				2000,
				true,
				seller2
				);
		
		Item item4 = new Item (
				"water bottle",
				"steel strong",
				1,
				1940,
				false,
				seller1
				);
		
		itemService.saveItem(item1);
		itemService.saveItem(item2);
		itemService.saveItem(item3);
		itemService.saveItem(item4);
		itemService.getAllItems().forEach(i -> logger.info(i.getItemName()));

		
		
	}

}
