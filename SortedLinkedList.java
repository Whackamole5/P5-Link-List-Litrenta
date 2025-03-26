package listClasses;

import java.util.*;


/**
 * Implements a generic sorted list using a provided Comparator. It extends
 * BasicLinkedList class.
 * 
 *  @author Dept of Computer Science, UMCP
 *  
 */

public class SortedLinkedList<T> extends BasicLinkedList<T> {
	private Comparator<T> comparator;
	
	// SortedLinkedList Constructor
	public SortedLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	
	// adds an element T to a sorted linked list using the comparator initial variable
	public SortedLinkedList<T> add(T element) {
		Node placement = this.head;
		Node input = new Node(element);
		if (head == null) {
			super.addToFront(element);
			return this;
		}
		if (comparator.compare(element, placement.data)==1) {
			placement = placement.next;
		}
		else {
			placement.next = input;
			return this;
		}
		
		return this;
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
