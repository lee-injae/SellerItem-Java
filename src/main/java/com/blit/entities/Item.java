package com.blit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String itemName, desc; 
	private int yearUsed, yearProduced;
	boolean isNew;
	
	public Item() {}

	public Item(Long id, String itemName, String desc, int yearUsed, int yearProduced, boolean isNew) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.desc = desc;
		this.yearUsed = yearUsed;
		this.yearProduced = yearProduced;
		this.isNew = isNew;
	}
	
	public Item(String itemName, String desc, int yearUsed, int yearProduced, boolean isNew) {
		super();
		this.itemName = itemName;
		this.desc = desc;
		this.yearUsed = yearUsed;
		this.yearProduced = yearProduced;
		this.isNew = isNew;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getYearUsed() {
		return yearUsed;
	}

	public void setYearUsed(int yearUsed) {
		this.yearUsed = yearUsed;
	}

	public int getYearProduced() {
		return yearProduced;
	}

	public void setYearProduced(int yearProduced) {
		this.yearProduced = yearProduced;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	
	
}
