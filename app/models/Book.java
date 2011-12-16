package models;

import play.*;
import play.db.jpa.*;
import javax.persistence.*;
import java.util.*;

@Entity
public class Book extends Item {

	public Book(String title, String creator) {
		super(title,creator);
	}
}
