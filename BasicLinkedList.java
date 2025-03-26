
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
		listSize = 0;
	}

	// returns the size instance variable
	public int getSize() {
		return listSize;
	}

	// add Node to the Front of the list
	// ask TAs about null additions to the list
	public BasicLinkedList<T> addToFront(T data) {
		Node newT = new Node(data);
		if (listSize == 0) { // if list is empty add head and make tail and head the same since the only
								// entry is the first and last
			head = newT;
			head.next = null;
			tail = head;
		}

		// if list has one entry. add newT to be head and then make tail = head.next.
		// now tail and head point to two different Nodes
		else if (listSize == 1) {
			head = newT;
			head.next = tail;
			tail.next = null;
		} else {
			newT.next = head;
			head = newT;
		}
		listSize++;
		return this;
	}

	// add Node to the End of the List
	public BasicLinkedList<T> addToEnd(T data) {
		Node newT = new Node(data);
		if (tail == null) {
			return addToFront(data);
		}
		else if (head==tail) {
			newT.next = null;
			tail = newT;
			head.next = tail;
		}
		tail.next = newT;
		tail = newT;
		tail.next = null;
		listSize++;
		return this;
	}

	// get the First Node of the List
	public T getFirst() {
		if (head==null) {
			return null;
		}
		return head.data;
	}

	// get the Last Node of the List
	public T getLast() {
		if (tail==null) {
			return null;
		}
		return tail.data;
	}

	// returns the first element of a linked list while also removing it
	public T retrieveFirstElement() {
		if (head == null) {
			return null;
		}
		Node temp = head;
		head = head.next;

		return temp.data;
	}

	// returns the last element of a linked list while also removing it
	public T retrieveLastElement() {
		return this.retLastEleHelper(head, null);
	}

	// helper for retrieveLastElement
	private T retLastEleHelper(Node curr, Node prev) {
		if (curr == null) {
			if (prev != null) {
				prev.next = null;
				tail = prev;
				return tail.data;
			} else {
				return null;
			}
		}
		return retLastEleHelper(curr.next, curr);
	}

	// removes entries with a single traversal of the list using the helper/aux
	// method
	public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		return removeHelper(targetData, comparator, head, null);

	}

	// remove method helper that uses recursion
	private BasicLinkedList<T> removeHelper(T targetData, Comparator<T> comparator, Node h, Node p) {
		if (h == null) { // if the current node is null we have met
			return this;
		}
		if (comparator.compare(h.data, targetData) == 0) {// it is the same so remove the node from linked list
			if (p == null) { // if same is the first node/first Node
				h = h.next;
			} else { // if same is found and h is not the first entry;
				p.next = h.next;
			}
		}
		return removeHelper(targetData, comparator, h, h.next);
	}

	// returns a reverse ArrayList of the Linked List
	public ArrayList<T> getReverseArrayList() {
		ArrayList<T> reverseArr = new ArrayList<T>();

		this.reverseArrHelper(head, reverseArr);

		return reverseArr;
	}

	// helper method to getReverseArrayList. Uses recursion
	private void reverseArrHelper(Node header, ArrayList<T> revArr) {
		if (header != null) { // runs while header is not null. AKA ends when header is null
			revArr.add(header.data);
			reverseArrHelper(header.next, revArr);
		}
	}

	// returns a reversed Linked List
	public BasicLinkedList<T> getReverseList() {
		BasicLinkedList<T> reverseList = this;

		this.reverseListHelper(head, reverseList);

		return reverseList;
	}

	// helper method to getReverseList. Uses recursion
	private void reverseListHelper(Node header, BasicLinkedList<T> revList) {
		if (header != null) {
			Node replacement = header;
			replacement.next = revList.head;
			revList.head = replacement;
			// revList.addToFront(header.data);
			reverseListHelper(header.next, revList);
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
