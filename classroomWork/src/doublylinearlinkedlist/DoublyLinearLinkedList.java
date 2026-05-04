package doublylinearlinkedlist;

public class DoublyLinearLinkedList {
	static class node{
		int data;
		node next;
		node prev;
		public node(int d) {
			this.data = d;
			next = null;
			prev = null;
		}
	}
	
	node head;
	node tail;
	int count;
	int getCount() {
		return count;
	}
	public DoublyLinearLinkedList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	//forward display
	public void forwardDisplay() {
		System.out.print("forward direction display : ");
		node trav = head;
		while(trav != null) {
			System.out.print("---" + trav.data);
			trav = trav.next;
		}
		System.out.println();
	}
	
	//reverse display
	public void reverseDisplay() {
		System.out.print("reverse direction display : ");
		node trav = tail;
		while(trav != null) {
			System.out.print("---" + trav.data);
			trav = trav.prev;
		}
		System.out.println();
	}
	
	public void addFirst(int data) {
		node nn = new node(data);
		if(head == null) {
			head = tail = nn;
		}
		else {
			nn.next = head;
			head.prev = nn;
			head = nn;
		}
		count++;
	}
	
	public void addLast(int data) {
		//create node
		node nn = new node(data);
		//if list is empty
		if(head == null) {
			head = tail = nn;
		}
		else {
			nn.prev = tail;
			tail.next = nn;
			tail = nn;
		}
		count++;
	}
	
	public void addAtPosition(int data, int pos) {
		if(pos < 1 || pos > count + 1) {
			System.out.println("invalid position");
			return;
		}
		
		//if list is empty
		if(head == null) {
			addFirst(data);
			return;
		}
		else if (pos == count+1) {
			addLast(data);
			return;
		}
		else {
			node nn = new node(data);
			node trav = head;
			for(int i = 1; i < pos-1; i++) {
				trav = trav.next;
			}
			//1) update nn next value
			nn.next = trav.next;
			//2)update nn prev ref with trav
			nn.prev = trav;
			//3) update pos+1 node prev as nn
			trav.next.prev = nn;
			//4) update pos-1 node next as nn
			trav.next = nn;
			count++;
		}
	}
	
	public void deleteFirst() {
		if(head == null)
			return;
		if(head.next == null)
			head = tail = null;
		else {
			//move head to second node
			head = head.next;
			//make head's prev as null
			head.prev = null;
		}
		count--;
	}
	
	public void deleteLast() {
		if(head == null)
			return;
		if(head.next == null)
			head = tail = null;
		else {
			tail = tail.prev;
			tail.next = null;
		}
		count--;
		
	}
	
	public void deleteAtPosition(int pos) {
		if(pos < 1 || pos > count) {
			System.out.println("invalid position");
			return;
		}
		if(head == null) {
			deleteFirst();
			return;
		}
		else if(pos == 1) {
			deleteFirst();
			return;
		}
		else if(pos == count) {
			deleteLast();
			return;
		}
		else {
			node trav = head;
			for(int i = 1; i < pos; i++) {
				trav = trav.next;
			}
			trav.prev.next = trav.next;
			trav.next.prev = trav.prev;
		}
		count--;
	}
	
}
   	