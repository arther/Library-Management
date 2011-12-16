package models;

import play.*;
import play.db.jpa.*;
import javax.persistence.*;
import java.util.*;

@Entity
public class ItemRegistry extends Model{
	
	private boolean isAvailable;
	private boolean isReserved;

	public ItemRegistry(){
		isAvailable = false;
		isReserved = false;
	}
}
