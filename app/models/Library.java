package models;

import java.util.List;

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
		new ItemRegistry().save();
		return true;
	}

	public List getItemList() {
		Query query = JPA.em().createNativeQuery(
				"select * from item i, itemregistry ir where i.id = ir.id");
		return query.getResultList();
	}

	public List findItemByCreator(String creator) {
		if (creator == null || creator.isEmpty())
			return null;
		Query query = JPA
				.em()
				.createNativeQuery(
						"select i.id, i.title, i.creator, ir.isavailable, ir.isreserved"
								+ " from item i, itemregistry ir where i.id=ir.id and i.creator like '%"
								+ creator + "%'");
		return query.getResultList();
	}

	public List getItemsByTitle(String title) {
		Query query = null;
		if (((title == null) || (title.isEmpty())))
			return null;
		query = JPA.em().createNativeQuery(
				"select i.id, i.title, i.creator, ir.isavailable, ir.isreserved from item i, itemregistry ir where i.id = ir.id and i.title LIKE '%"
						+ title + "%'");
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
	
	public Item getItemById(String itemId){
		if (((itemId == null) || (itemId.isEmpty())))
			return null;
		return(Item.findById(Long.parseLong(itemId)));
		
	}

}
