package models;

import static org.junit.Assert.*;

import org.junit.Test;

import play.test.UnitTest;

public class ItemRegistryTest extends UnitTest{
	@Test 
	public void shouldCreateObject(){
		assertNotNull(new ItemRegistry());
	}
}
