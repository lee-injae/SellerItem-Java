package com.blit.repositories;

import org.springframework.data.repository.CrudRepository;

import com.blit.entities.Seller;


public interface SellerRepository extends CrudRepository<Seller, Long> {
	

}
