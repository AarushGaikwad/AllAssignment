package singleylinearlinkedlist;

public class SingleyLinkedList {
	// inner class having fields of nodes
	static class node {
		int data;
		node next;
		public node(int d) {
			this.data = d;
			next = null;
		}		
	}
	
	node head; //reference to first node
	public SingleyLinkedList() {
		this.head = null;
	}
	
	public void addFirst(int data) {
		node nn = new node(data);
		if(head == null) {
			// list is empty
			head = nn; // make new node as first node
		}
		else {
			// list is not empty
			nn.next = head; //add first node into next of new node
			head = nn; //make new node as the first node
		}
	}
	
	public void displayList() {
		if(head == null)
			System.out.println("List is empty...");
		else {
			// if list is not empty
			System.out.println("List : ");
			node trav = head;  //declare temp ref as trav and copy the address of first node in trav
			while (trav != null) {
				System.out.print("---" + trav.data);
				trav = trav.next;
			}
			System.out.println();
		}
	}
	
	public void addLast(int data) {
		node nn = new node(data);
		if(head == null) 
			head = nn;
		else {
			node trav = head;
			while(trav.next != null) {
				trav = trav.next;
			}
			trav.next = nn; //build link between last node and new node
		}
	}
	
	public void addAtPosition(int data, int pos) {
		node nn = new node(data);
		if(head == null)
			head = nn;
		else if(pos <= 1) {
			nn.next = head;
			head = nn;
		}
		else {
			node trav = head;
			for (int i = 1; i < pos-1 && trav.next != null; i++)
				trav = trav.next;
			nn.next = trav.next;
			trav.next = nn;
		}
	}
	
	public void deleteFirst() {
		if(head == null)
			System.out.println("List is empty");
		else {
			head = head.next;  //move head to the second node
		}
	}
	
	public void deleteLast() {
		if(head == null)
			System.out.println("List is empty");
		else if(head.next == null)  //if list contains only one node
			head = null;
		else {
			node trav = head;
			while(trav.next.next != null) { //traverse till 2nd last node
				trav = trav.next;
			}
			trav.next = null; //update the ref value of trav as null
		}
	}
	
	public void deleteAtPosition(int pos) {
		if(head == null)
			return;
		if(head.next == null)
			head = null;
		else if(pos <= 1)
			deleteFirst();
		else {
			node trav = head;
			for (int i = 1; i < pos-1 && trav.next.next != null; i++) {
				trav = trav.next;
			}
			trav.next = trav.next.next;
		}
	}
}
