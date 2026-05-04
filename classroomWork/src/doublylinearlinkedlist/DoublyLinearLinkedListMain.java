package doublylinearlinkedlist;

public class DoublyLinearLinkedListMain {

	public static void main(String[] args) {
		
		DoublyLinearLinkedList list = new DoublyLinearLinkedList();
		//System.out.println("addFirst()");
		list.addFirst(11);
		list.forwardDisplay();
		list.addFirst(22);
		list.forwardDisplay();
		list.addFirst(33);
		list.forwardDisplay();
		list.addFirst(44);
		list.forwardDisplay();
		
		System.out.println("addLast()");
		list.addLast(55);
		list.forwardDisplay();
		list.addLast(66);
		list.forwardDisplay();
		System.out.println("List node count : "+list.getCount());
		
		list.addAtPosition(100, 3); //0 , 1, 3, 10
		list.forwardDisplay();
		System.out.println("List node count : "+list.getCount());
		
		list.deleteFirst();
		list.forwardDisplay();
		System.out.println("List node count : "+list.getCount());
		
		list.deleteLast();
		list.forwardDisplay();
		System.out.println("List node count : "+list.getCount());
		
		
		
		list.deleteAtPosition(3);
		list.forwardDisplay();
		System.out.println("List node count : "+list.getCount());
		
		
		list.forwardDisplay();
		list.reverseDisplay();
	}

}
