package doublycircularlinkedlist;

public class DoublyCircularLinkedList {

	static class node{
		int data;
		node next;
		node prev;
		public node(int d) {
			this.data = d;
			next = prev = null;
		}
	}
	
	node head;
	int count;
	public DoublyCircularLinkedList() {
		head = null;
		count = 0;
	}
	
	public int getCount() {
		return count;
	}
	
	public void deleteAllNodeFromList() {
		head = null;
	}
	
	public void forwardDisplay() {
		if(head == null) {
			System.out.println("list is empty");
		}
		else {
			System.out.print("Forward list : ");
			node trav = head;
			do {
				System.out.print("---" + trav.data);
				trav = trav.next;
			} while(trav != head);
			System.out.println();
			System.out.println("Count : " + count);
		}
	}
	
	public void reverseDisplay() {
		if(head == null) {
			System.out.println("list is empty");
		}
		else {
			System.out.print("reverse list : ");
			node trav = head.prev;
			do {
				System.out.print("---" + trav.data);
				trav = trav.next;
			} while(trav != head.prev);
			System.out.println();
			System.out.println("Count : " + count);
		}
	}
	
	public void addFirst(int data) {
		node nn = new node(data);
		if(head == null) { //if list is empty
			head = nn;
			nn.next = nn.prev = head;
		}
		else {
			nn.next = head;
			nn.prev = head.prev;
			head.prev.next = nn;
			head.prev = nn;
			head = nn;
		}
		count++;
	}
	
	public void addLast(int data) {
		node nn = new node(data);
		if(head == null) {
			head = nn;
			nn.next = nn.prev = head;
		}
		else {
			nn.next = head;
			nn.prev = head.prev;
			head.prev.next = nn;
			head.prev = nn;
		}
		count++;
	}
	
	public void deleteFirst() {
		if(head == null)
			return;
		else if(head.next == head) {
			head = null;
		}
		else {
			head.prev.next = head.next;
			head.next.prev = head.prev;
			head = head.next;
		}
		count--;
	}
	
	public void deleteLast() {
		if(head == null)
			return;
		else if(head.next == head) {
			head = null;
		}
		else {
			head.prev = head.prev.prev;
			head.prev.next = head;
		}
		count--;
	}
	
	public void addAtPosition(int data, int pos) {
		if(pos < 1 || pos > count+1) {
			System.out.println("invlaid position");
		}
		else if(head == null) {
			addFirst(data);
		}
		else if(pos == 1) {
			addFirst(data);
		}
		else if(pos == count+1) {
			addLast(data);
		}
		else {
			node nn = new node(data);
			node trav = head;
			for(int i=1; i < pos-1; i++) {
				trav = trav.next;
			}
			nn.next = trav.next;
			nn.prev = trav;
			trav.next.prev = nn;
			trav.next = nn;
		}
		count++;
	}
	
	public void deleteAtPosition(int pos) {
		if(pos < 1 || pos > count) {
			System.out.println("invalid position");
			return;
		}
		else if(head == null){
			return;
		}
		else if(pos == 1) {
			deleteFirst();
		}
		else if(pos == count) {
			deleteLast();
		}
		else {
			node trav = head;
			for (int i = 1; i < pos-1; i++) {
				trav = trav.next;
			}
			trav.next = trav.next.next;
			trav.next.prev = trav;
		}
		count--;
	}
	
}
