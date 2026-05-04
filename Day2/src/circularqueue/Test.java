package circularqueue;

import java.util.*;

class CircularQueue {

    int arr[] = new int[5];
    int front = -1, rear = -1;

    void insert(int data) {
        if ((rear + 1) % arr.length == front) {
            System.out.println("Full");
            return;
        }

        if (front == -1)
            front = 0;

        rear = (rear + 1) % arr.length;
        arr[rear] = data;
    }

    void delete() {
        if (front == -1) {
            System.out.println("Empty");
            return;
        }

        System.out.println("Removed: " + arr[front]);

        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % arr.length;
    }

    void display() {
        if (front == -1) {
            System.out.println("Empty");
            return;
        }

        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % arr.length;
        }
        System.out.println();
    }
}

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularQueue cq = new CircularQueue();

        while (true) {
            System.out.println("\n1.Insert 2.Delete 3.Display 4.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    cq.insert(sc.nextInt());
                    break;

                case 2:
                    cq.delete();
                    break;

                case 3:
                    cq.display();
                    break;

                case 4:
                    return;
            }
        }
    }
}