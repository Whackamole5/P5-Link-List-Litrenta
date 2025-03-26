package listClasses;

import java.util.*;


public class BasicLinkedList<T> implements Iterable<T> {
	
	/* Node definition */
	protected class Node {
		protected T data;
		protected Node next;

		protected Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/* We have both head and tail */
	protected Node head, tail;
	
	/* size */
	protected int listSize;
	
	// BasicLinkdList Constructor creating an empty linked list
	public BasicLinkedList() {
		head = null;
		tail = null;
		listSize=0;
	}
	
	// returns the size instance variable
	public int getSize() {
		return listSize;
	}
	
	// add Node to the Front of the list
	// ask TAs about null additions to the list
	public BasicLinkedList<T> addToFront(T data) {
		Node newT = new Node(data);
		newT.next = head;
		head = newT;
		listSize++;
		if (listSize==1) {
			tail = head;
		}
		if (listSize==2) {
			tail = head.next;
			tail.next = null;
		}
		return this;
	}
	
	// add Node to the End of the List
	public BasicLinkedList<T> addToEnd(T data) {
		if (tail==null || tail==head) {
			return addToFront(data);
		}
		Node newT = new Node(data);
		tail.next = newT;
		tail = newT;
		tail.next = null;
		listSize++;	
		return this;
	}
	
	// get the First Node of the List
	public T getFirst() {
		return head.data;
	}
	
	// get the Last Node of the List
	public T getLast() {
		return tail.data;
	}
	
	// returns the first element of a linked list while also removing it
	public T retrieveFirstElement() {
		head = head.next;
		
		return head.data;
	}
	
	// returns the last element of a linked list while also removing it
	public T retrieveLastElement() {
		return this.retLastEleHelper(head, null);
	}
	
	private T retLastEleHelper(Node curr, Node prev) {
		if (curr==null) {
			if (prev!=null) {
				tail = prev;
				tail.next = null;
				return tail.data;
			}
			else {
				return null;
			}
		}
		return retLastEleHelper(curr.next, curr);
	}
	
	// removes entries with a single traversal of the list
	public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		return removeHelper(targetData, comparator, null, this.head);
		
	}
	
	// remove method helper that uses recursion
	private BasicLinkedList<T> removeHelper(T targetData, Comparator<T> comparator, BasicLinkedList<T>.Node p, BasicLinkedList<T>.Node h) {
		if (h==null) {
			return this;
		}
		if (comparator.compare(h.data, targetData)==0) {//it is the same so remove the node from linked list
			if (p==null) { // if same is the first node/first Node
				h = h.next;
			}
			else { // if same is found and h is not the first entry;
				p.next = h.next;
			}
		}
		return removeHelper(targetData, comparator, h, h.next);
	}

	// returns a reverse ArrayList of the Linked List
	public ArrayList<T> getReverseArrayList() {
		ArrayList<T> reverseArr = new ArrayList<T>();
		
		this.reverseArrHelper(this.head, reverseArr);
		
		return reverseArr;
	}
	
	// helper method to getReverseArrayList. Uses recursion
	private void reverseArrHelper(Node header, ArrayList<T> revArr) {
		if (header!=null) {
			revArr.add(header.data);
			reverseArrHelper(header.next, revArr);
		}
	}
	
	// returns a reversed Linked List
	public BasicLinkedList<T> getReverseList() {
		BasicLinkedList<T> reverseList = this;
		
		this.reverseListHelper(this.head, reverseList);
		
		return reverseList;
	}
	
	// helper method to getReverseList. Uses recursion 
	private void reverseListHelper(Node header, BasicLinkedList<T> revList) {
		if (header!=null) {
			revList.addToFront(header.data);
			reverseListHelper(header.next, revList);
		}
	}
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node index = head;

			@Override
			public boolean hasNext() {
				return (index !=null);
			}
			
			@Override
			public T next() {
				index = index.next;
				return index.data;
			}
			
		};
	}
	
	/**
	private class TIterator implements Iterator<T> {
		private int intIndex = 0;
		Node index = head;

		@Override
		public boolean hasNext() {
			intIndex++;
			index = index.next;
			return (intIndex < getSize()) && (index !=null);
		}

		@Override
		public T next() {
			
		}
	}
	**/
}
