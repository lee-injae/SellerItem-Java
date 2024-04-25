package com.blit.servicees;

import java.util.List;

import com.blit.entities.Item;
import com.blit.entities.Seller;

public interface ItemService {
	
	Item findItemById(Long id);
	
	List<Item> getAllItems();
	
	void deleteItem(Long id);
	
	Item saveItem(Item item);
	
	Item updateItem(Long id, Item item);

}
