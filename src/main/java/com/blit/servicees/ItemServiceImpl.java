package com.blit.servicees;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.blit.entities.Item;
import com.blit.repositories.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired 
	private ItemRepository itemRepository;
	
	@Override
	public List<Item> getAllItems(){
		return (List<Item>) itemRepository.findAll();
	}
	
	@Override
	public Item findItemById(Long id) {
		Optional<Item> item = itemRepository.findById(id);
		if(item.isPresent()) {
			return item.get();
		} else {
			throw new ResourceNotFoundException("Item with " + id + ""
					+ "is not found");
		}
	}
	
	@Override
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
	}

	@Override
	public Item updateItem(Long id, Item item) {
		Optional<Item> optionalItem = itemRepository.findById(id);
		if (optionalItem.isPresent()) {
			optionalItem.get().setItemName(item.getItemName());
			optionalItem.get().setDescription(item.getDescription());
			optionalItem.get().setYearUsed(item.getYearUsed());
			optionalItem.get().setYearProduced(item.getYearProduced());
			optionalItem.get().setLikeNew(item.isLikeNew());
		}
		return null;
	}
	
}
