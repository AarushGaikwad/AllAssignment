package binarysearchtree;

import java.util.Scanner;

import binarysearchtree.BinarySearchTree.Node;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BinarySearchTree bst = new BinarySearchTree();
		/*
		bst.addNode(50);
		bst.addNode(30);
		bst.addNode(90);
		bst.addNode(10);
		bst.addNode(40);
		bst.addNode(20);
		bst.addNode(70);
		bst.addNode(100);
		bst.addNode(60);
		bst.addNode(80);
		*/
		
		bst.addNodeRecursive(50);
		bst.addNodeRecursive(30);
		bst.addNodeRecursive(90);
		bst.addNodeRecursive(10);
		bst.addNodeRecursive(40);
		bst.addNodeRecursive(20);
		bst.addNodeRecursive(70);
		bst.addNodeRecursive(100);
		bst.addNodeRecursive(60);
		bst.addNodeRecursive(80);
		
		System.out.println("tree created!");
		
		bst.preorder();
		bst.inorder();
		bst.postorder();
		
		
		System.out.print("Enter key: ");
		int key = sc.nextInt();
		
		//Node temp = bst.search(key);
		Node temp = bst.searchWithRecursive(key);
		if(temp == null)
			System.out.println("Node not found : " + key);
		else
			System.out.println("Node found : " + temp.getData());
		
		/*
		System.out.print("Enter key to be find with parent : ");
		int parKey = sc.nextInt();
		Node[] find = bst.searchWithParent(parKey);
		Node parTemp = find[0], parent = find[1];
		
		if(parTemp == null)
		    System.out.println("Node not found : " + parKey);
		else {
		    System.out.println("Node found : " + parTemp.getData()); 
		    if(parent != null)
		        System.out.println("Parent found : " + parent.getData());
		}
		*/
		
		System.out.print("enter node to be deleted : ");
		int delKey = sc.nextInt();
		//bst.delete(delKey);
		bst.deleteNodeWithRecursive(delKey);
		bst.inorder();
		
		sc.close();
		
	}

}
