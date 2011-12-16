package models;

import static org.junit.Assert.*;

import models.Book;
import models.Item;
import models.Library;

import org.junit.Test;

import play.test.UnitTest;



public class LibraryTest extends UnitTest{
	@Test
	public void shouldCreateLibraryObject() {
		Library library = new Library();
		assertNotNull(library);
	}
	
	@Test
	public void shouldAddItem(){
		Library library = new Library();
		Item item = new Book("Ansi c","Samy");
		library.addItem(item);
		assertEquals(1,library.getItemList().size());
	}
}
