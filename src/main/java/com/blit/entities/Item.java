package com.blit.entities;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "item_name", nullable = false, length = 100)
	private String itemName;
	private String description;
	private int yearUsed, yearProduced;
	private boolean isLikeNew;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller")
	private Seller seller;
	
		public Seller getSeller() {
			return seller;
		}
		
		public void setSeller(Seller seller) {
			this.seller = seller;
		}
	
	
	public Item() {}

	public Item(Long id, 
			String itemName, 
			String description, 
			int yearUsed, 
			int yearProduced, 
			boolean isLikeNew,
			Seller seller) {
		
		super();
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.yearUsed = yearUsed;
		this.yearProduced = yearProduced;
		this.isLikeNew = isLikeNew;
		this.seller = seller;
	}
	
	public Item(String itemName, 
			String description, 
			int yearUsed, 
			int yearProduced, 
			boolean isLikeNew,
			Seller seller) {
		
		super();
		this.itemName = itemName;
		this.description = description;
		this.yearUsed = yearUsed;
		this.yearProduced = yearProduced;
		this.isLikeNew = isLikeNew;
		this.seller = seller;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public boolean isLikeNew() {
		return isLikeNew;
	}

	public void setLikeNew(boolean isLikeNew) {
		this.isLikeNew = isLikeNew;
	}

	
	

	

	
	
}
