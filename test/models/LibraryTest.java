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
		assertEquals(1,Item.findAll().size());
		assertFalse(library.addItem(null));
	}
	
	@Test
	public void shouldIssueItem(){
		Item item = new Book("Ansi c","Samy");
		library.addItem(item);
		library.issueItem(item);
		assertTrue(item.getIssuedStatus());
		library.issueItem(item);
		library.deleteItem(item);
			}
	@Test
	public void shouldReturnItem() {
		Item item = new Book("Ansi c","Samy");
		library.addItem(item);
		library.issueItem(item);
		library.returnItem(item);
		assertFalse(item.getIssuedStatus());
		library.deleteItem(item);
		}
	
	@Test
	public void shouldReserveABook(){
		Item item = new Book("Ansi c","Samy");
		library.addItem(item);
		library.reserveItem(item);
		assertTrue(item.getReservedStatus());	
		library.deleteItem(item);
	}
	
	public void shouldFindItemByTitle() {
		Item item = new Book("c++","bala");
		library.addItem(item);
		assertEquals(2, library.getItemsByTitle("c").size());
		assertNull(library.getItemsByTitle(""));
		assertNull(library.getItemsByTitle(null));
	}	
	@Test
	public void shouldFindItemByCreator(){
		
		library.addItem(new Book("Head First Java","Kenth"));
		library.addItem(new Book("Head First Java","Kenth"));
		assertEquals(2,library.findItemByCreator("Kenth").size());
	}
	
	@Test
	public void shouldReturnNullForFindItemByCreatorWithEmptyOrNullParameter(){
		assertNull(library.findItemByCreator(""));
		assertNull(library.findItemByCreator(null));
	}

	@Test
	public void shouldDeleteAItem(){
		Item item = new Book("Ansi c","Samy");
		library.addItem(item);
		library.deleteItem(item);
		assertEquals(3, Item.findAll().size());
	}
}
