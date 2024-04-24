package com.blit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blit.entities.Seller;
import com.blit.servicees.SellerService;

@SpringBootApplication
public class SellerItemApplication implements CommandLineRunner {
	
	@Autowired
	private SellerService sellerService;
	
	private static final Logger logger = LoggerFactory.getLogger(SellerItemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SellerItemApplication.class, args);
		logger.info("application started");
	}
	
	public void run(String... args) throws Exception {
		
		Seller seller = new Seller(
				"thing1", 
				"password", 
				"chevychase", 
				2000);
		
		sellerService.saveSeller(seller);
		
		sellerService.getAllSellers().forEach(s -> logger.info(s.getUsername()));
		
	}

}
