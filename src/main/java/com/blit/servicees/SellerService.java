package com.blit.servicees;

import java.util.List;

import com.blit.entities.Seller;

public interface SellerService {
	
	List<Seller> getAllSellers();
	
	Seller findSellerById(Long id);
	
	Seller saveSeller(Seller seller);
	
	Seller updateSeller(Long id, Seller seller);
	
	void deleteSellerById(Long id);
	
	Long countSellers();

}
