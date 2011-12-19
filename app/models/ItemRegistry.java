package models;

import play.*;
import play.db.jpa.*;
import javax.persistence.*;
import java.util.*;

@Entity
public class ItemRegistry extends Model {

	private boolean isIssued;
	private boolean isReserved;

	public ItemRegistry() {
		isIssued = false;
		isReserved = false;
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
	
	public static ItemRegistry getItemRegistryById(long id){
		return ItemRegistry.findById(id);
	}
}
