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
	public void shouldDeleteAItem(){
		Library library = new Library();
		Item item = new Book("Ansi c","Samy");
		library.addItem(item);
		library.deleteItem(item);
		assertEquals(0, library.getItemList().size());
	}
	
	@Test
	public void shouldCreateLibraryObject() {
		assertNotNull(library);
	}
	
	@Test
	public void shouldAddItem(){
		Item item = new Book("Ansi c","Samy");
		library.addItem(item);
		assertEquals(1,library.getItemList().size());
		library.deleteItem(item);
	}
	@Test
	public void shouldIssueItem(){
		Library library = new Library();
		Item item = new Book("Ansi c","Samy");
		library.addItem(item);
		library.issueItem(item);
		assertTrue(item.getIssuedStatus());
		library.deleteItem(item);
			}
	@Test
	public void shouldReturnItem() {
		Library library = new Library();
		Item item = new Book("Ansi c","Samy");
		library.addItem(item);
		library.issueItem(item);
		library.returnItem(item);
		assertFalse(item.getIssuedStatus());
		library.deleteItem(item);
		}
	
	@Test
	public void shouldReserveABook(){
		Library library = new Library();
		Item item = new Book("Ansi c","Samy");
		library.addItem(item);
		library.reserveItem(item);
		assertTrue(item.getReservedStatus());	
		library.deleteItem(item);
	}
	
	public void shouldGetBooklistWhichContainsBookTitle() {
		Library library = new Library();
		Item item = new Book("c++","bala");
		library.addItem(item);
		assertEquals(2, library.getItemsByTitle("c").size());
		assertNull(library.getItemsByTitle(""));
		assertNull(library.getItemsByTitle(null));
	}	
	@Test
	public void shouldFindItemByCreator(){
		
		library.addItem(new Book("Head First Java","Kenth"));
		assertEquals(1,library.findItemByCreator("Kenth").size());
	}
}
