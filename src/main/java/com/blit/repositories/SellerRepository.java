package com.blit.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blit.entities.Seller;


public interface SellerRepository extends JpaRepository<Seller, Long> {
	Optional<Seller> findByUsername(String username);

}
