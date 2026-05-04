package singleylinearlinkedlist;

public class SingleyLinkedListMain {
	public static void main(String[] args) {
		
		SingleyLinkedList  list = new SingleyLinkedList();
		System.out.println("\n addFirst() : ");
		list.addFirst(66);
		list.displayList();
		list.addFirst(50);
		list.displayList();
		list.addFirst(60);
		list.displayList();
		
		System.out.println("\n addLast() : ");
		list.addLast(90) ;
		list.displayList();
		list.addLast(88) ;
		list.displayList();
		
		System.out.println("\n addAtPosition() : ");
		list.addAtPosition(70, -2);
		list.displayList();
		list.addAtPosition(55, 3);
		list.displayList();
		list.addAtPosition(33, 12);
		list.displayList();
		
		System.out.println("\n delFirst() : ");
		list.deleteFirst();
		list.displayList();
		
		System.out.println("\n delLast() : ");
		list.deleteLast();
		list.displayList(); 
		
		//List :  --> 60 --> 55 --> 50 --> 66 --> 90 --> 88
		list.deleteAtPosition(1);
		list.displayList(); 
		
		list.deleteAtPosition(3);
		list.displayList(); 
	
		list.deleteAtPosition(13);
		list.displayList(); 
	}
}
