package models;

import static org.junit.Assert.*;

import org.junit.Test;

import play.test.UnitTest;

public class ItemRegistryTest extends UnitTest{
	@Test 
	public void shouldCreateObject(){
		assertNotNull(new ItemRegistry());
	}
	
	@Test
	public void shouldGetItemRegistryById(){
		Library library = new Library();
		library.addItem(new Book("xxx","yyy"));
		assertNotNull(ItemRegistry.getItemRegistryById((long)1));
		assertEquals(1,Long.parseLong(ItemRegistry.getItemRegistryById((long)1).getId().toString()));
	}
}
