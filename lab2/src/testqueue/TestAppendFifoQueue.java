/**
 * 
 */
package testqueue;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue_singlelinkedlist.FifoQueue;

/**
 * @author ioannis
 *
 */
public class TestAppendFifoQueue {
	private  FifoQueue<Integer> in;
	private  FifoQueue<Integer> in2;
	private  FifoQueue<String> st;
	private  FifoQueue<String> st2;


	
	@Before
	public void setUp() throws Exception {
		in = new FifoQueue<Integer>();
		in2 = new FifoQueue<Integer>();
		st = new FifoQueue<String>();
		st2 = new FifoQueue<String>();
	}

	
	@After
	public void tearDown() throws Exception {
		in = null;
		in2= null;
		st= null;
		st2 = null;

	}
	
	/*
	 * två tomma köer
	 */
	@Test
	public final void Test1 () {
	
		try {	
			in.append(in2);
			fail("Should raise IllegalArgumentException");
		} catch (IllegalArgumentException e) {
//			 successful test
		}
		try {	
			st.append(st2);
			fail("Should raise IllegalArgumentException");
		} catch (IllegalArgumentException e) {
//			 successful test
		}
		
	}
	
	/*
	 * tom kö som konkateneras till icke-tom kö
	 */
	@Test
	public final void Test2 () {
		in.offer(1);
		in.offer(2);
		in.offer(3);
		st.offer("first");
		st.offer("second");
		st.offer("third");
		try {	
			in.append(in2);
			fail("Should raise IllegalArgumentException");
		} catch (IllegalArgumentException e) {
//			 successful test
		}
		try {	
			st.append(st2);
			fail("Should raise IllegalArgumentException");
		} catch (IllegalArgumentException e) {
//			 successful test
		}
	}
	
		/*
		 * icke-tom kö som konkateneras till tom kö
		 */
		@Test
		public final void Test3 () {
		in.offer(1);
		in.offer(2);
		in.offer(3);
		st.offer("first");
		st.offer("second");
		st.offer("third");
		try {	
			in2.append(in);
			fail("Should raise IllegalArgumentException");
		} catch (IllegalArgumentException e) {
//			 successful test
		}
		try {	
			st2.append(st);
			fail("Should raise IllegalArgumentException");
		} catch (IllegalArgumentException e) {
//			 successful test
		}
		
	}	
			
		/*
		 * Test if someone try to add a q to itself
		 */
		@Test
		public final void Test4 () {
		in.offer(1);
		in.offer(2);
		in.offer(3);
		st.offer("first");
		st.offer("second");
		st.offer("third");
		try {
			in.append(in);
			fail("Should raise IllegalArgumentException");
		} catch (IllegalArgumentException e) {
//			 successful test
		}
		try {	
			st.append(st);
			fail("Should raise IllegalArgumentException");
		} catch (IllegalArgumentException e) {
//			 successful test
		}
	}
		/*
		 * två icke-tomma köer
		 */
		@Test
		public final void Test5 () {
		in.offer(1);
		in.offer(2);
		in.offer(3);
		in2.offer(4);
		in2.offer(5);
		in2.offer(6);
		st.offer("first");
		st2.offer("second");
		in.append(in2);
		st.append(st2);
		int i=1;
		while(i<7) {
			assertEquals("Expected", Integer.valueOf(i),in.poll());
			i++;
		}
		
			assertEquals("Expected", "first",st.poll());
			assertEquals("Expected", "second",st.poll());
		
		
	}
	
	
}
