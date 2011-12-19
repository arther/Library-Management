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
		if (title == null || title.isEmpty() || creator == null || creator
				.isEmpty()) throw new RuntimeException();
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
	
	public static List getItemsByTitle(String title){
		return(Item.find("byTitle",title).fetch());
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getCreator(){
		return creator;
	}
}
