package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Item extends Model {

	private String title;
	private String creator;

	public Item(String title, String creator) {
		if (title == null || title.isEmpty() || creator == null
				|| creator.isEmpty())
			throw new RuntimeException();
		this.title = title;
		this.creator = creator;

	}

	public boolean getIssuedStatus() {
		ItemRegistry itemRegistry = ItemRegistry.findById(this.getId());
		return itemRegistry.getIssuedStatus();
	}

	public boolean getReservedStatus() {
		ItemRegistry itemRegistry = ItemRegistry.findById(this.getId());
		return itemRegistry.getReservedStatus();
	}
<<<<<<< HEAD

	public static List getItemsByTitle(String title) {
		Query query = null;
		if (((title == null) || (title.isEmpty())))
			return null;
		query = JPA.em().createNativeQuery(
				"select id, title,creator from item i where i.title LIKE '%"
						+ title + "%'");
		return query.getResultList();
	}

	public static List findItemByCreator(String creator) {
		if (creator == null || creator.isEmpty())
			return null;
		Query query = JPA.em().createNativeQuery(
				"select id, title, creator from item  where i.creator like '%"
						+ creator + "%'");
		return query.getResultList();
=======
	
	public static List getItemsByTitle(String title){
		return(Item.find("byTitle",title).fetch());
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getCreator(){
		return creator;
>>>>>>> c547fbe0cac5a34160c69a9515c784062b0a5ab9
	}
}
