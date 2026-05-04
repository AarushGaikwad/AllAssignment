package stack;

import java.util.*;

class StackProgram {

    int arr[] = new int[5];
    int top = -1;

    void push(int data) {
        if (top == arr.length - 1)
            System.out.println("Stack Full");
        else
            arr[++top] = data;
    }

    void pop() {
        if (top == -1)
            System.out.println("Stack Empty");
        else
            System.out.println("Deleted: " + arr[top--]);
    }

    void display() {
        if (top == -1) {
            System.out.println("Empty");
            return;
        }

        for (int i = top; i >= 0; i--)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
    public class Test {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        StackProgram s = new StackProgram();
	
	        while (true) {
	            System.out.println("\n1.Push 2.Pop 3.Display 4.Exit");
	            int ch = sc.nextInt();
	
	            switch (ch) {
	                case 1:
	                    System.out.print("Enter value: ");
	                    s.push(sc.nextInt());
	                    break;
	
	                case 2:
	                    s.pop();
	                    break;
	
	                case 3:
	                    s.display();
	                    break;
	
	                case 4:
	                    return;
	            }
	        }
	    }
	}