package models;

import static org.junit.Assert.*;

import models.Book;
import models.Item;
import models.Library;

import org.junit.Test;

import play.test.UnitTest;



public class LibraryTest extends UnitTest{
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
		Library library = new Library();
		assertNotNull(library);
	}
	
	@Test
	public void shouldAddItem(){
		Library library = new Library();
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
	
}
