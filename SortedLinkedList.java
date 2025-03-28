
package listClasses;

import java.util.*;

/**
 * Implements a generic sorted list using a provided Comparator. It extends
 * BasicLinkedList class.
 * 
 * @author Dept of Computer Science, UMCP
 * 
 */

public class SortedLinkedList<T> extends BasicLinkedList<T> {
	private Comparator<T> comparator;

	// SortedLinkedList Constructor
	public SortedLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	// adds an element T to a sorted linked list using the comparator initial
	// variable
	public SortedLinkedList<T> add(T element) {
		return sortedAddHelper(element, head, null);
	}
	
	private SortedLinkedList<T> sortedAddHelper(T element, Node h, Node p) {
		if (h==null) { // reached end
			Node newT = new Node(element);
			if (p==null) { // empty list
				head = newT;
				newT.next = null;
				head.next = tail;
				tail = newT;
			}
			else { // adds element to end;
				p.next = newT;
				newT.next = null;
				tail = newT;
			}
			System.out.println("\nEnd Reached");
			return this;
		}
		else if (comparator.compare(element, h.data)<=0) { // adds the element before the current node h if h is greater than or equal to the element's value.
			Node newT = new Node(element);
			if (p==null) { // if matched at first value
				newT.next = head;
				head = newT;
			}
			else { // add element before the element that is greater than or equal to this element
				p.next = newT;
				newT.next = h;
			}
			return this;
		}
		
		
		return sortedAddHelper(element, h.next, h);
	}

	// removes element T from a SortedLinkedList using the super remove
	public SortedLinkedList<T> remove(T element) {
		super.remove(element, comparator);
		return this;
	}

	@Override
	// Overrides the addToFront method of BasicLinkedList since this list is sorted
	public BasicLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operatoin for sorted list.");
	}

	@Override
	// overrides the addToEnd method of BasicLinkedList since this list is sorted
	public BasicLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operatoin for sorted list.");
	}

}
