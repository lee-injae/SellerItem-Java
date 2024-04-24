package com.blit;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blit.entities.Seller;

@SpringBootApplication
public class SellerItemApplication implements CommandLineRunner {
	
	
	private static final Logger logger = LoggerFactory.getLogger(SellerItemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SellerItemApplication.class, args);
		logger.info("application started");
	}
	
	public void run(String... args) throws Exception {
		List<Seller> sellers = Arrays.asList(
				new Seller("thing1", "thing@a.com", "chevychase"),
				new Seller("grinch", "grinch@b.com", "bethesda"),
				new Seller("samiam", "sam@c.com", "rockville")
				);
		
				
	}

}
