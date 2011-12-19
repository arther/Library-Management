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
	
	public static List findByCreator(String creator){
		return ItemRegistry.find("item.creator",creator).fetch();
	}
	
	public static List findByTitle(String creator){
		return ItemRegistry.find("item.title",creator).fetch();
	}
}
