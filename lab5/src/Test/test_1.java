package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bst.BinarySearchTree;

class test_1 {
	BinarySearchTree<String> s;
	BinarySearchTree<Integer> i;



	@BeforeEach
	void setUp() throws Exception {
		s = new BinarySearchTree<String>();
		i = new BinarySearchTree<Integer>();
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
		i = null;
	}

	@Test
	void testBinarySearchTreeSetUp() {
		assertTrue(i.height()==0);
		assertTrue(i.size()==0);
		assertTrue(s.height()==0);
		assertTrue(s.size()==0);
	}

	@Test
	void testAdd() {
		assertTrue(i.add(1));
		assertFalse(i.add(1));
		assertTrue(s.add("S"));
		assertFalse(s.add("S"));
		
		assertTrue(i.height() == 1);
		assertTrue(i.size()==1);
		assertTrue(s.height()==1);
		assertTrue(s.size()==1);
	}

	@Test
	void testHeight() {
		
		assertTrue(i.add(1));
		assertTrue(i.add(2));
		assertTrue(i.add(3));
		assertFalse(i.add(1));
		
		
		assertTrue(s.add("a"));
		assertFalse(s.add("a"));
		assertTrue(s.add("b"));
		assertTrue(s.add("c"));
		
		
		assertTrue(i.height() == 3);
		assertTrue(s.height()==3);
		
		
	}

	@Test
	void testSize() {
		assertTrue(i.add(1));
		assertTrue(i.add(2));
		assertTrue(i.add(3));
		assertFalse(i.add(1));
		assertTrue(i.add(4));
		
		
		assertTrue(s.add("a"));
		assertFalse(s.add("a"));
		assertTrue(s.add("b"));
		assertTrue(s.add("c"));
		
		
		assertTrue(i.size()==4);
		assertTrue(s.size()==3);
	}

}
