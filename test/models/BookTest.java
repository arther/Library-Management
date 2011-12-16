package models;

import static org.junit.Assert.*;

import org.junit.Test;

import play.test.UnitTest;

public class BookTest extends UnitTest{

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
}
