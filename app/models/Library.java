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

	public List findItemByCreator(String creator) {
		Query query = JPA
				.em()
				.createNativeQuery(
						"select i.id, i.title, i.creator, ir.isavailable, ir.isreserved"
								+ " from item i, itemregistry ir where i.id=ir.id and i.creator like '%"
								+ creator + "%'");
		return query.getResultList();
	}
}
