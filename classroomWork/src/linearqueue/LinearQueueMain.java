package linearqueue;

import java.util.Scanner;

public class LinearQueueMain {

	public static void main(String[] args) {
		Queue q = new Queue(5);
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1: push\n2: pop\n3: peek\n0: exit");
			System.out.print("Enter your choice: ");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1: //push
				//always check if the queue is full before inserting the element
				if(q.isFull()) {
					System.out.println("Queue is full");
				}
				else {
					System.out.print("Enter value to push: ");
					int value = sc.nextInt();
					q.push(value);
				}
				break;
				
			case 2: //pop
				//always check if the queue is empty before deleting the element
				if(q.isEmpty()) {
					System.out.println("Queue is empty");
				}
				else {
					int val = q.pop();
					System.out.println("poped value: " + val);
				}
				break;
				
			case 3: //peek
				//always check if the queue is empty before peeking the element
				if(q.isEmpty()) {
					System.out.println("Queue is empty");
				}
				else {
					int val = q.peek();
					System.out.println("peeked value: " + val);
				}
			}
		} while(ch != 0);
		
		System.out.println("EXIT.......");
		sc.close();
	}

}
