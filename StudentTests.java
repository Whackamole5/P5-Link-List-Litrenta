package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;

/**
 * 
 * You need student tests if you are looking for help during office hours about
 * bugs in your code.
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {


	/**
	@Test
	public void addingTest() {
		BasicLinkedList<String> tester = new BasicLinkedList<String>();
		
		tester.addToEnd("one");
		System.out.println(tester.getFirst());
		System.out.println(tester.getLast());
		System.out.println(tester.getSize());
		tester.addToFront("two");
		System.out.println(tester.getFirst());
		System.out.println(tester.getLast());
		System.out.println(tester.getSize());
		tester.addToFront("three");
		System.out.println(tester.getFirst());
		System.out.println(tester.getLast());
		System.out.println(tester.getSize());
		tester.addToEnd("four");
		System.out.println(tester.getFirst());
		System.out.println(tester.getLast());
		System.out.println(tester.getSize());
	}
	**/
	
	/**
	@Test
	public void basicRemovalTest() {
		BasicLinkedList<String> tester = new BasicLinkedList<String>();
		
		tester.addToEnd("one");
		tester.addToFront("two");
		System.out.println(tester.getFirst());
		System.out.println(tester.getLast());
		System.out.println(tester.getSize());
		tester.addToFront("three");
		tester.addToFront("four");
		tester.addToFront("five");
		tester.remove("one", String.CASE_INSENSITIVE_ORDER);
	}
	**/
	
	
	@Test
	public void reverseListTest() {
		BasicLinkedList<String> tester = new BasicLinkedList<String>();
		
		tester.addToEnd("one");
		tester.addToFront("two");
		tester.addToFront("three");
		tester.addToFront("four");
		tester.addToFront("five");
		tester.addToEnd("six");
		
		BasicLinkedList<String> revTester = tester.getReverseList();
		
		System.out.println(revTester.getFirst());
		System.out.println(revTester.getLast());
		
	}
	
	/**
	@Test
	public void reverseArrayListTest() {
		BasicLinkedList<String> tester = new BasicLinkedList<String>();
		
		tester.addToEnd("one");
		tester.addToFront("two");
		tester.addToFront("three");
		tester.addToFront("four");
		tester.addToFront("five");
		tester.addToEnd("six");
		
		System.out.println(tester.getReverseArrayList());
	}
	**/
	
	public static void main(String[] args) {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue");
		System.out.println("First: " + basicList.getFirst());
		System.out.println("Last: " + basicList.getLast());
		System.out.println("Size: " + basicList.getSize());
		System.out.println("Retrieve First: " + basicList.retrieveFirstElement());
		System.out.println("Retrieve Last: " + basicList.retrieveLastElement());
		System.out.println("Removing Red");
		basicList.remove("Red", String.CASE_INSENSITIVE_ORDER);
		System.out.print("Iteration: ");
		for (String entry : basicList) {
			System.out.print(entry + " ");
		}

		System.out.println("Iteration Worked");
		
		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		System.out.print("\n\nIteration (for sorted list): ");
		for (String entry : sortedList) {
			System.out.print(entry + " ");
		}
		sortedList.remove("Red");
		System.out.print("\nAfter remove in sorted list first is: ");
		System.out.println(sortedList.getFirst());
	}
}
