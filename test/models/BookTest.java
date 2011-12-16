package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void shouldCreateBookObject(){
		assertNotNull(new Book("Ansi C","Samy"));
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotCreateObjectWithNullOrEmptyValue(){
		new Book(null,null);
	}
}
