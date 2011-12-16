package controllers;

import java.util.List;

import models.Item;


public class Library {
	public Library(){
		
	}

	public void addItem(Item item) {
		item.save();
	}

	public List getItemList() {		
		return Item.findAll();
	}
}
