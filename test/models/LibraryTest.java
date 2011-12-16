package models;

import static org.junit.Assert.*;

import models.Book;
import models.Item;
import models.Library;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;



public class LibraryTest extends UnitTest{
	
	Library library = new Library();
	
	@Test
	public void shouldCreateLibraryObject() {
		assertNotNull(library);
	}
	
	@Test
	public void shouldAddItem(){
		Item item = new Book("Ansi c","Samy");
		library.addItem(item);
		assertEquals(1,library.getItemList().size());
	}
	
	@Test
	public void shouldFindItemByCreator(){
		
		library.addItem(new Book("Head First Java","Kenth"));
		assertEquals(1,library.findItemByCreator("Kenth").size());
	}
}
