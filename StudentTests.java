package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	// all work
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
	
	// tests the remove function. works in scenario
	@Test 
	public void removeTester() {
		BasicLinkedList<String> test = new BasicLinkedList<String>();
		
		test.addToFront("three");
		test.addToFront("one");
		test.addToEnd("two");
		test.addToEnd("three");
		test.addToFront("four");
		test.addToFront("three");
		
		test.remove("three", String.CASE_INSENSITIVE_ORDER);
		
		assertTrue(test.getSize()==3);
		assertTrue(test.getFirst().equals("four"));
		assertTrue(test.getLast().equals("two"));
		
	}
	
	// tests retrieveFirstElement and retrieveLastElement
	@Test
	public void retrieveTester() {
		BasicLinkedList<String> test = new BasicLinkedList<String>();
		test.addToFront("three");
		test.addToFront("one");
		test.addToEnd("two");
		
		assertTrue(test.retrieveFirstElement().equals("one"));
		assertTrue(test.getSize()==2);
		assertTrue(test.getFirst().equals("three"));
		assertTrue(test.getLast().equals("two"));
		
		assertTrue(test.retrieveLastElement().equals("two"));
		assertTrue(test.getSize()==1);
		assertTrue(test.getFirst().equals("three"));
		assertTrue(test.getLast().equals("three")); // error/fails
	}
	
	// tests the iterator
	@Test
	public void iteratorTester() {
		BasicLinkedList<String> test = new BasicLinkedList<String>();
		test.addToFront("three");
		test.addToFront("one");
		test.addToEnd("two");
		
		ArrayList<String> testArr = new ArrayList<String>();
		testArr.add("one");
		testArr.add("three");
		testArr.add("two");		
		
		int index = 0;
		for (String s : test) {
			assertTrue(s.equals(testArr.get(index)));
			index++;
		}
		
	}
	
	@Test // tests getReverseList and getReverseArrayList
	public void reverseTester() {
		BasicLinkedList<String> test = new BasicLinkedList<String>();
		test.addToFront("five");
		test.addToFront("one");
		test.addToEnd("two");
		test.addToEnd("three");
		test.addToFront("four");
		test.addToFront("six");
		
		ArrayList<String> wantedArr = new ArrayList<String>();
		wantedArr.add("three");
		wantedArr.add("two");
		wantedArr.add("five");
		wantedArr.add("one");
		wantedArr.add("four");
		wantedArr.add("six");
		
		ArrayList<String> revArr = test.getReverseArrayList();
		
		int index = 0;
		for (String s : revArr) {
			assertTrue(s.equals(wantedArr.get(index)));
			index++;
		}
		
		BasicLinkedList<String> revList = test.getReverseList();
		index = 0;
		for (String s : revList) {
			assertTrue(s.equals(wantedArr.get(index)));
			index++;
		}
		
	}
	
	// Tests for SortedLinkedList<T>
	
	@Test
	public void sortedAdd() {
		
	}
}
