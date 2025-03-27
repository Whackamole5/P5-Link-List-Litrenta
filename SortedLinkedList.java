
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
		if (h == null) {
			Node nT = new Node(element);
			if (p == null) {
				head = nT;
				head.next = null;
			} 
			else {
				p.next = nT;
				tail = nT;
			}
			return this;
		}
		else if (comparator.compare(element, h.data)==-1 || comparator.compare(element, h.data)==0) {
			Node nT = new Node(element);
			p.next = nT;
			nT.next = h;
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
