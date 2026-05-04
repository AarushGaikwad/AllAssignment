package linearqueue;

public class Queue {
	int arr[];
	int rear;
	int front;
	int size;
	
	public Queue(int s) {
		size = s;
		arr = new int[size];
		rear = -1;
		front = -1;
	}
	
	public void push(int value) {
		rear++; //increment the rear by 1
		arr[rear] = value; //insert the element at the rear position
		if(front == -1)
			front = 0;
	}
	
	public int pop() {
		int t = arr[front];
		front++;
		return  t;
	}
	
	public int peek() {
		return arr[front];
	}
	
	public boolean isFull() {
		return rear == size - 1;
	}
	
	public boolean isEmpty() {
		return rear == -1 || front > rear;
	}
	
}
