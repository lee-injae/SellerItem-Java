package com.blit.repositories;

import org.springframework.data.repository.CrudRepository;

import com.blit.entities.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
	

}
