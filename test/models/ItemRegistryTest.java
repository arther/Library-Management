package models;

import static org.junit.Assert.*;

import org.junit.Test;

import play.test.UnitTest;

public class ItemRegistryTest extends UnitTest{
	
	@Test 
	public void shouldCreateObject(){
		assertNotNull(new ItemRegistry(new Book("xyz","zyx")));
	}
	
	@Test
	public void shouldFindItemByCreator(){
		Book book = new Book("aaa","bbb");
		book.save();
		new ItemRegistry(book).save();
		book.save();
		new ItemRegistry(book).save();
		book.save();
		new ItemRegistry(book).save();
		book.save();
		new ItemRegistry(book).save();
		assertEquals(4,ItemRegistry.findByCreator("bbb").size());
	}
	
	public void shouldFindItemByTitle(){
		Book book = new Book("xxx","yyy");
		book.save();
		new ItemRegistry(book).save();
		book.save();
		new ItemRegistry(book).save();
		book.save();
		new ItemRegistry(book).save();
		book.save();
		new ItemRegistry(book).save();
		assertEquals(8,ItemRegistry.findByTitle("xxx").size());
	}
}
