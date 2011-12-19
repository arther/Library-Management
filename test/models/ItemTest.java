package models;

import static org.junit.Assert.*;

import org.junit.Test;

import play.test.UnitTest;

public class ItemTest extends UnitTest{

	@Test
	public void shouldCreateBookObject(){
		assertNotNull(new Book("Ansi C","Samy"));
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotCreateObjectWithNullOrEmptyValue(){
		new Book(null,null);
		new Book("","xxx");
		new Book("xxx","");
		new Book("xx",null);
		new Book(null,"xxx;");
	}
	
	@Test
	public void shouldGetItemsByTitle(){
		Library library = new Library();
		library.addItem(new Book("xxx","yyy"));
		library.addItem(new Book("xxx","yyy"));
		library.addItem(new Book("xxx","yyy"));
		library.addItem(new Book("xxx","yyy"));
		assertEquals(4,Item.getItemsByTitle("xxx").size());
	}
	
}
