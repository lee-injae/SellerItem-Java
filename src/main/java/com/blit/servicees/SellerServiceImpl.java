package com.blit.servicees;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.blit.entities.Seller;
import com.blit.repositories.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired 
	private SellerRepository sellerRepository;
	
	@Override
	public List<Seller> getAllSellers(){
		return (List<Seller>) sellerRepository.findAll();
	}
	
	@Override
	public Seller findSellerById(Long id) {
		Optional<Seller> seller = sellerRepository.findById(id);
		if(seller.isPresent()) {
			return seller.get();
		} else {
			throw new ResourceNotFoundException("Seller with " 
					+ id + " is not found");
		}
	}
	
	@Override
	public Seller saveSeller(Seller seller) {
		return sellerRepository.save(seller);
	}
	
	@Override
	public Seller updateSeller(Long id, Seller seller) {
		Optional<Seller> optionalSeller = sellerRepository.findById(id);
		if(optionalSeller.isPresent()) {
			optionalSeller.get().setUsername(seller.getUsername());
			optionalSeller.get().setPassword(seller.getPassword());
			optionalSeller.get().setBirthyear(seller.getBirthyear());
			
			sellerRepository.save(optionalSeller.get());
			
			return optionalSeller.get();
		} else {
			throw new ResourceNotFoundException("Seller with " + id + " does not exsit");
		}
	}
	
	@Override
	public void deleteSellerById(Long id) {
		sellerRepository.deleteById(id);
	}
	
	@Override
	public Long countSellers() {
		return sellerRepository.count();
	}

	
	
	
	
}
