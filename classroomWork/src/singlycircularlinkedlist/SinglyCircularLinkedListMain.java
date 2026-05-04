package singlycircularlinkedlist;

public class SinglyCircularLinkedListMain {
	public static void main(String[] args) {
		
		SinglyCircularLinkedList list = new SinglyCircularLinkedList();
		
		list.addFirst(11);
		list.addFirst(22);
		list.displayList();
		System.out.println("Count : "+list.getCount());
	}
}
