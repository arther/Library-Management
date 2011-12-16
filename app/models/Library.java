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
<<<<<<< HEAD
=======
		return query.getResultList();
	}

	public List findItemByCreator(String creator) {
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
		if(((title==null)||(title.isEmpty()))) return null;
		query = JPA.em().createNativeQuery("select * from item i, itemregistry ir where i.id = ir.id and i.title LIKE '%"+title+"%'");
>>>>>>> 7c4d6dba3a3482d36b0c62f69f8411b05d785835
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
