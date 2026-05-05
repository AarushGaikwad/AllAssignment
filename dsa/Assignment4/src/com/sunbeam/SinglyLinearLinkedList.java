package com.sunbeam;


public class SinglyLinearLinkedList {
	
	static class node {
		int data;
		node next;
		public node(int d) {
			this.data = d;
			next = null;
		}		
	}
	
	node head;
	public SinglyLinearLinkedList() {
		this.head = null;
	}
	
	public void addFirst(int data) {
		node nn = new node(data);
		if(head == null) {
			head = nn;
		}
		else {
			nn.next = head; 
			head = nn; 
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
			trav.next = nn;
		}
	}
	
	public void displayList() {
		if(head == null)
			System.out.println("List is empty...");
		else {
			System.out.println("List : ");
			node trav = head;
			while (trav != null) {
				System.out.print("---" + trav.data);
				trav = trav.next;
			}
			System.out.println();
		}
	}
}
