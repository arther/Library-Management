package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class ItemRegistry extends Model {

	private boolean isIssued;
	private boolean isReserved;
	
	@OneToOne
	private Item item;

	public ItemRegistry(Item item) {
		isIssued = false;
		isReserved = false;
		this.item = item;
	}

	public void setIssuedStatus(boolean issuedStatus) {
		isIssued = issuedStatus;
	}

	public boolean getIssuedStatus() {
		return isIssued;
	}

	public void setReservedStatus(boolean reservedStatus) {
		isReserved = reservedStatus;
	}

	public boolean getReservedStatus() {
		return isReserved;
	}
<<<<<<< HEAD

	public static List findItemByCreator(String creator) {
		if (creator == null || creator.isEmpty())
			return null;
		Query query = JPA.em().createNativeQuery(
				"select id,isIssued,isReserved from itemregistry where creator like '%"
						+ creator + "%'");
		return query.getResultList();
=======
	
	public static List findByCreator(String creator){
		return ItemRegistry.find("item.creator",creator).fetch();
	}
	
	public static List findByTitle(String creator){
		return ItemRegistry.find("item.title",creator).fetch();
>>>>>>> c547fbe0cac5a34160c69a9515c784062b0a5ab9
	}
}
