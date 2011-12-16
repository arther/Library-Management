package models;

import java.util.List;

import javax.persistence.Query;

import play.db.jpa.JPA;
import play.db.jpa.Model;

public class Library extends Model {
	public Library() {

	}

	public void addItem(Item item) {
		item.save();
		new ItemRegistry().save();
	}

	public List getItemList() {
		Query query = JPA.em().createNativeQuery(
				"select * from item i, itemregistry ir where i.id = ir.id");
		return query.getResultList();
	}

	public void issueItem(Item item) {
		ItemRegistry itemRegistry = ItemRegistry.findById(item.getId());
		if (!item.getIssuedStatus())
			itemRegistry.setIssuedStatus(false);
		itemRegistry.save();
	}

	public void returnItem(Item item) {
		ItemRegistry itemRegistry = ItemRegistry.findById(item.getId());
		if (item.getIssuedStatus())
			itemRegistry.setIssuedStatus(true);
		itemRegistry.save();
	}

	public void deleteItem(Item item) {
		ItemRegistry itemRegistry = ItemRegistry.findById(item.getId());
		item.delete();
		itemRegistry.delete();
	}

	public void reserveItem(Item item) {
		ItemRegistry itemRegistry = ItemRegistry.findById(item.getId());
		if (!item.getReservedStatus())
			itemRegistry.setReservedStatus(true);
		itemRegistry.save();
	}

}
