package com.sunbeam;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {

    Node root;

    // Insert into BST
    Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    void add(int data) {
        root = insert(root, data);
    }

    // ---------------- RECURSIVE TRAVERSALS ----------------

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // ---------------- ITERATIVE TRAVERSALS ----------------

    void inorderIterative() {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    void preorderIterative() {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.data + " ");

            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
    }

    void postorderIterative() {
        if (root == null) return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            Node temp = s1.pop();
            s2.push(temp);

            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }

        while (!s2.isEmpty())
            System.out.print(s2.pop().data + " ");
    }
}

public class Test {
    public static void main(String[] args) {

        BST tree = new BST();

        // Given values
        int[] values = {5, 3, 1, 4, 7, 2, 6, 8, 9, 0};

        System.out.println("Constructing BST with values:");
        for (int v : values) {
            System.out.print(v + " ");
            tree.add(v);
        }

        System.out.println("\n\n===== RECURSIVE TRAVERSALS =====");

        System.out.print("Inorder   : ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder  : ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder : ");
        tree.postorder(tree.root);

        System.out.println("\n\n===== ITERATIVE TRAVERSALS =====");

        System.out.print("Inorder   : ");
        tree.inorderIterative();

        System.out.print("\nPreorder  : ");
        tree.preorderIterative();

        System.out.print("\nPostorder : ");
        tree.postorderIterative();

        System.out.println();
    }
}