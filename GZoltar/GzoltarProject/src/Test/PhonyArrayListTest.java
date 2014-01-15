package Test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Main.PhonyArrayList;

/*
 * Group 3 - VVT 2013 / 2014
 * @author  Charles-Gael Djedai
 * @author  Quentin Hinsinger
 * @author  Brendan Masson
 * @author  Aurélien Sieurin   
 * @author  Florian Vrignaud
*/

/**
 * The class JUnit PhonyArrayListTest that test the class PhonyArrayList methods
 */
public class PhonyArrayListTest {
	PhonyArrayList<String> list1;
	Collection<String> coll;
	
	@Before
	public void setUp() {
		list1 = new PhonyArrayList<String>();
		coll = new ArrayList<String>();
	}
	
	@After
	public void tearDown() {
		list1 = null;
		coll = null;
	}

	@Test
	public void testIsEmpty() {
		assertTrue("An new list is empty", list1.isEmpty());
		
		list1.add("Hello");
		assertFalse("A list with added elements is not empty", list1.isEmpty());
	}
	
	@Test
	public void testSize() {
		assertEquals("A new list has a size of 0", 0, list1.size());
		
		list1.add("Hello");
		assertEquals("A list with 1 element has a size of 1", 1, list1.size());
	}
	
	@Test
	public void testIndexOf() {
		assertEquals(-1, list1.indexOf("Hello"));
		assertEquals(-1, list1.indexOf(null));
		
		list1.add("Hello");
		assertEquals(0, list1.indexOf("Hello"));
		
		list1.add(null);
		assertEquals(1, list1.indexOf(null));
		
		list1.add("World");
		assertEquals(2, list1.indexOf("World"));
	}
	
	@Test
	public void testContains() {
		assertFalse("A new list don't contains anything", list1.contains("Hello"));
		
		list1.add("Hello");
		assertTrue("A list contains what's added in it", list1.contains("Hello"));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetExcept() {
		list1.get(0);
	}
	
	@Test
	public void testGet() {
		list1.add("Hello");
		assertEquals("Hello", list1.get(0));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetExcept() {
		list1.set(0, "Hello");
	}
	
	@Test
	public void testSet() {
		list1.add("Hello");
		list1.set(0, "World");
		assertEquals("World", list1.get(0));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddAtExcept() {
		list1.add(10, "Hello");
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddAtExcept2() {
		list1.add(-1, "Hello");
	}
	
	@Test
	public void testAddAt() {
		list1.add("Hello");
		list1.add("World");
		
		list1.add(1, null);
		assertEquals("Hello", list1.get(0));
		assertNull(list1.get(1));
		assertEquals("World", list1.get(2));
	}
	
	@Test
	public void testRemove() {
		list1.add("Hello");
		list1.add(null);
		list1.add(null);
		list1.add("World");

		assertEquals("Hello", list1.get(0));
		assertNull(list1.get(1));
		assertNull(list1.get(2));
		assertEquals("World", list1.get(3));
		
		list1.remove(null);
		
		assertEquals("Hello", list1.get(0));
		assertNull(list1.get(1));
		assertEquals("World", list1.get(2));
		
		list1.remove("World");
		
		assertEquals("Hello", list1.get(0));
		assertNull(list1.get(1));
		
		list1.remove("Hello");
		
		assertNull(list1.get(0));
		
		list1.remove(null);
		
		assertTrue(list1.isEmpty());
		
		list1.add("Hello");
		assertFalse(list1.remove(null));
		
		list1.add(null);
		assertFalse(list1.remove("World"));
	}
	
	@Test
	public void testClear() {
		list1.add("Hello");
		list1.add(null);
		list1.add(null);
		list1.add("World");
		
		list1.clear();
		
		assertTrue(list1.isEmpty());
	}
	
	@Test
	public void testAddAll() {
		coll.add("Hello");
		coll.add("World");
		
		list1.addAll(0, coll);
		
		assertEquals(0, list1.indexOf("Hello"));
		assertEquals(1, list1.indexOf("World"));
		
		list1.addAll(1, coll);
		
		assertEquals("Hello", list1.get(0));
		assertEquals("Hello", list1.get(1));
		assertEquals("World", list1.get(2));
		assertEquals("World", list1.get(3));
		
		coll.clear();
		list1.addAll(0, coll);
		
		assertEquals("Hello", list1.get(0));
		assertEquals("Hello", list1.get(1));
		assertEquals("World", list1.get(2));
		assertEquals("World", list1.get(3));
	}
	
	@Test
	public void testConstructCollection() {
		coll.add("Hello");
		coll.add("World");
		
		list1 = new PhonyArrayList<String>(coll);
		assertEquals(2, list1.size());
		
		List<String> l = Arrays.asList(new String[]{"Hello", "World"});
		list1 = new PhonyArrayList<String>(l);
		assertTrue(list1.isEmpty());
	}
	
	@Test
	public void testCapacity() {
		list1.add("Hello");
		list1.add("World");
		list1.add(null);
		list1.add(null);
		
		assertEquals(4, list1.size());
		
		list1.add(3, "Test");
		
		assertEquals(5, list1.size());
		
		coll.clear();
		coll.add("t1");
		coll.add("t2");
		
		list1.addAll(0, coll);
		
		assertEquals(7, list1.size());
		
		coll.clear();
		coll.add("t3");
		coll.add("t4");
		coll.add("t5");
		coll.add("t6");
		coll.add("t7");
		coll.add("t8");
		
		list1.addAll(0, coll);
		
		assertEquals(13, list1.size());
		

		
		coll.clear();
		for (int i=0;i<20;i++) {
			coll.add("toto"+i);
		}
		
		list1.addAll(0, coll);
		assertEquals(33, list1.size());
	}
	
	@Test
	public void testRemoveAll() {
		for (int i = 0;i<10;i++) {
			list1.add("toto"+i);
			coll.add("toto"+i);
		}
		
		list1.removeAll(coll);
		
		assertTrue(list1.isEmpty());
		

		for (int i = 0;i<20;i++) {
			list1.add("toto"+i);
		}
		
		list1.removeAll(coll);
		
		assertEquals(10, list1.size());
	}
}
