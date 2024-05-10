package com.blit.servicees;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blit.entities.Seller;
import com.blit.repositories.SellerRepository;

@Service
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
		throws UsernameNotFoundException {
		
			Optional<Seller> sellerOpt = sellerRepository.findByUsername(username);
		
			UserBuilder builder = null;
			if (sellerOpt.isPresent()) {
				Seller currentSeller = sellerOpt.get();
				builder = org.springframework.security.core
						.userdetails.User.withUsername(username);
				builder.password(currentSeller.getPassword());
				builder.roles(currentSeller.getRole());
				return builder.build();
			} else  {
				throw new UsernameNotFoundException("user not found");
			}
	}
	
}
