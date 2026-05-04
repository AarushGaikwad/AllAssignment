package queue;

import java.util.*;

class Queue {

    int arr[] = new int[5];
    int front = 0, rear = -1;

    void insert(int data) {
        if (rear == arr.length - 1)
            System.out.println("Queue Full");
        else
            arr[++rear] = data;
    }

    void delete() {
        if (front > rear)
            System.out.println("Queue Empty");
        else
            System.out.println("Removed: " + arr[front++]);
    }

    void display() {
        if (front > rear) {
            System.out.println("Empty");
            return;
        }

        for (int i = front; i <= rear; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();

        while (true) {
            System.out.println("\n1.Insert 2.Delete 3.Display 4.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    q.insert(sc.nextInt());
                    break;

                case 2:
                    q.delete();
                    break;

                case 3:
                    q.display();
                    break;

                case 4:
                    return;
            }
        }
    }
}