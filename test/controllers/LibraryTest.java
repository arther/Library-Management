package controllers;

import static org.junit.Assert.*;

import models.Book;
import models.Item;

import org.junit.Test;

import play.test.UnitTest;

import controllers.Library;


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
		assertNotNull(item);
	}
//	@Test
//	public void shouldIssueItem(){
//		Library library = new Library();
//		Item item = new Book("Ansi c","Samy");
//		library.addItem(item);
//		library.
//	}
}
