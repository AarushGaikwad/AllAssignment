package doublycircularlinkedlist;

public class DoubleCircularLinkedListMain {

	public static void main(String[] args) {
		
		DoublyCircularLinkedList list = new DoublyCircularLinkedList();
		
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addFirst(50);
		
		list.forwardDisplay();
		list.reverseDisplay();
		
		list.addLast(60);
		list.addLast(70);
		
		list.forwardDisplay();
		
		list.addAtPosition(80, 5);
		list.forwardDisplay();
		
		list.deleteFirst();
		list.forwardDisplay();
		
		list.deleteLast();
		list.forwardDisplay();
		
		list.deleteAtPosition(4);
		list.forwardDisplay();
	}

}
