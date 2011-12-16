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
		assertTrue(library.addItem(item));
		assertEquals(1,library.getItemList().size());
		assertFalse(library.addItem(null));
	}
	
	@Test
	public void shouldFindItemByCreator(){
		
		library.addItem(new Book("Head First Java","Kenth"));
		assertEquals(1,library.findItemByCreator("Kenth").size());
	}
	
	@Test
	public void shouldReturnNullForFindItemByCreatorWithEmptyOrNullParameter(){
		assertNull(library.findItemByCreator(""));
		assertNull(library.findItemByCreator(null));
	}
}
