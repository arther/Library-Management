package models;

import java.util.*;

import javax.persistence.Query;

import play.db.jpa.JPA;
import play.db.jpa.Model;

public class Library extends Model {
	public Library() {

	}

	public boolean addItem(Item item) {
		if (item == null)
			return false;
		item.save();
		new ItemRegistry(item).save();
		return true;
	}

	public List findItemByCreator(String creator) {
		if (creator == null || creator.isEmpty())
			return null;
		return ItemRegistry.findByCreator(creator);
	}

	public List getItemsByTitle(String title) {
		if (((title == null) || (title.isEmpty())))
			return null;
		return ItemRegistry.findByTitle(title);
	}

	public void issueItem(Item item) {
		ItemRegistry itemRegistry = ItemRegistry.findById(item.getId());
		if (!item.getIssuedStatus())
			itemRegistry.setIssuedStatus(true);
		itemRegistry.save();
	}

	public void returnItem(Item item) {
		ItemRegistry itemRegistry = ItemRegistry.findById(item.getId());
		itemRegistry.setIssuedStatus(false);
		itemRegistry.save();
	}

	public void deleteItem(Item item) {
		ItemRegistry itemRegistry = ItemRegistry.findById(item.getId());
		itemRegistry.delete();
		item.delete();
	}

	public void reserveItem(Item item) {
		ItemRegistry itemRegistry = ItemRegistry.findById(item.getId());
		if (!item.getReservedStatus())
			itemRegistry.setReservedStatus(true);
		itemRegistry.save();
	}

}
