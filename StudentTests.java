package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import listClasses.BasicLinkedList;

/**
 * 
 * You need student tests if you are looking for help during office hours about
 * bugs in your code.
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {
	

	
	// Tests for BasicLinkedList<T>

	@Test // tests functions with a null list ensuring that they work in an empty list scenario.
	public void NullTester() {
		BasicLinkedList<String> test = new BasicLinkedList<String>();
		
	}
	
	// tests addToFront, addToEnd, getSize, getFirst, and getLast with a small linked list.
	// checks every time a node is added to the LinkedList.
	@Test 
	public void addingTester() {
		BasicLinkedList<String> test = new BasicLinkedList<String>();
		
		assertTrue(test.getSize()==0);
		assertTrue(test.getFirst()==null);
		assertTrue(test.getLast()==null);
		test.addToFront("one");
		assertTrue(test.getSize()==1);
		assertTrue(test.getFirst().equals("one"));
		assertTrue(test.getLast().equals("one"));
		test.addToEnd("two");
		assertTrue(test.getSize()==2);
		assertTrue(test.getFirst().equals("one"));
		assertTrue(test.getLast().equals("two"));
		test.addToFront("three");
		assertTrue(test.getSize()==3);
		assertTrue(test.getFirst().equals("three"));
		assertTrue(test.getLast().equals("two"));
		test.addToEnd("four");
		assertTrue(test.getSize()==4);
		assertTrue(test.getFirst().equals("three"));
		assertTrue(test.getLast().equals("four"));
		
	}
	
	@Test // tests the remove function
	public void removeTester() {
		BasicLinkedList<String> test = new BasicLinkedList<String>();
		BasicLinkedList<String> after = new BasicLinkedList<String>();
		
		test.addToFront("three");
		test.addToFront("one");
		test.addToEnd("two");
		test.addToEnd("three");
		test.addToFront("four");
		test.addToFront("three");
		
		test.remove("three", String.CASE_INSENSITIVE_ORDER);
		
		after.addToFront("two");
		after.addToFront("one");
		after.addToFront("four");
		
		System.out.println(test.getSize());
		assertTrue(test.getFirst().equals("four"));
		assertTrue(test.getLast().equals("two"));
		
	}
	
	@Test // tests retrieveFirstElement and retrieveLastElement
	public void retrieveTester() {
		BasicLinkedList<String> test = new BasicLinkedList<String>();
	}
	
	// Tests for SortedLinkedList<T>

}
