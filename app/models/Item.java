package models;

import play.*;
import play.db.jpa.*;
import javax.persistence.*;
import java.util.*;

@Entity
public class Item extends Model{

	private final String title;
	private final String creator;

	public Item(String title,String creator){
		this.title = title;
		this.creator = creator;
	}
	public boolean getIssuedStatus() {
		ItemRegistry itemRegistry =ItemRegistry.findById(this.getId());
		return itemRegistry.getIssuedStatus();
	}
	
	public boolean getReservedStatus() {
		ItemRegistry itemRegistry =ItemRegistry.findById(this.getId());
		return itemRegistry.getReservedStatus();
	}
}
