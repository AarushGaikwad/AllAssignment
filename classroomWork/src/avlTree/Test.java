package avlTree;

import java.util.Scanner;

import avlTree.AvlTree.Node;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		AvlTree avl = new AvlTree();
		
		avl.addNode(50);
		avl.addNode(30);
		avl.addNode(90);
		avl.addNode(10);
		avl.addNode(40);
		avl.addNode(20);
		avl.addNode(70);
		avl.addNode(100);
		avl.addNode(60);
		avl.addNode(80);
		
		System.out.println("AVL tree created!!");
		
		avl.inorder();
		
		System.out.print("enter key for dfs search : ");
		int dfs = sc.nextInt();
		Node dfsTemp = avl.dfs(dfs);
		if(dfsTemp == null) 
			System.out.println("given key is not found");
		else
			System.out.println("key found : " + dfs);
		
		System.out.print("enter key for bfs search : ");
		int bfs = sc.nextInt();
		Node bfsTemp = avl.bfs(bfs);
		if(bfsTemp == null)
			System.out.println("given key is not found");
		else
			System.out.println("key found : " + bfs);
		
		sc.close();
	}

}
