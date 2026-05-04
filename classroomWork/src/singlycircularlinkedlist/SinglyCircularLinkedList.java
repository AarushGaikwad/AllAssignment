package singlycircularlinkedlist;

public class SinglyCircularLinkedList {
	
	static class node{
		int data;
		node next;
		public node(int d) {
			this.data = d;
			next = null;
		}
		
	}
	
	node head;
	node tail;
	int count;
	public SinglyCircularLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}
	
	public void deleteAllNodesFromList() {
		head = null;
		tail = null;
	}
	
	public int getCount() {
		return count;
	}
	
	public void displayList() {
		if(head == null)
			System.out.println("list is empty");
		else {
			System.out.print("List : ");
			node trav = head;
			do {
				System.out.print("---" + trav.data);
				trav = trav.next;
			} while(trav != head);
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
			tail.next = nn;
			head = nn;
		}
		count++;
	}

	public void addLast(int data) {
		node nn = new node(data);
		if(head == null) {
			head = tail = nn;
			nn.next = head;
		}
		else {
			nn.next = head;
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
		if(head == null) {
			addFirst(data);
			return;
		}
		if(pos == 1) {
			addFirst(data);
			return;
		}
		if(pos == count+1) {
			addLast(data);
			return;
		}
		else {
			node nn = new node(data);
			node trav = head;
			for(int i = 1; i < pos - 1; i++) {
				trav = trav.next;
			}
			nn.next = trav.next;
			trav.next = nn;
			count++;
		}
	}
	
	public void deleteFirst() {
		if(head == null)
			return;
		else if(head.next == head)  { //single node in the list
			head = tail = null;
		}
		else {
			tail.next = head.next;
			head = head.next;
		}
		count--;
	}
	
	public void deleteLast() {
		if(head == null)
			return;
		if(head.next == head)
			head = tail = null;
		else {
			node trav = head;
			while(trav.next.next != head) { //traverse till second last node
				trav = trav.next;
			}
			trav.next = head;
			tail = trav;
		}
	}
	
	public void deleteAtPosition(int pos) {
	    if (pos < 1 || pos > count) {
	        System.out.println("Invalid position");
	        return;
	    }
	    if (head == null)
	        return;
	    // Only one node
	    if (head.next == head) {
	        head = tail = null;
	        count--;
	        return;
	    }
	    // Delete first node
	    if (pos == 1) {
	        deleteFirst();
	        return;
	    }
	    // Delete last node
	    if (pos == count) {
	        deleteLast();
	        return;
	    }
	    // Delete middle node
	    node trav = head;
	    for (int i = 1; i < pos - 1; i++) {
	        trav = trav.next;
	    }
	    trav.next = trav.next.next;
	    count--;
	}
	
}
