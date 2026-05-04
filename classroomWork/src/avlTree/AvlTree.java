package avlTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class AvlTree {
	static class Node {
		private int data;
		private Node left;
		private Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node root;
	public AvlTree() {
		root = null;
	}
	
	public void addNode(Node trav, int val) {
		if(val < trav.data) {
			if(trav.left == null)
				trav.left = new Node(val);
			else
				addNode(trav.left, val);
		}
		else { // val >= trav.data
			if(trav.right == null)
				trav.right = new Node(val);
			else
				addNode(trav.right, val);
		}		
	}
	public void addNode(int data) {
		if(root == null) {
			root = new Node(data);
		}
		else {
			addNode(root, data);
		}
	}
	
	private void preorder(Node trav) {
		if(trav == null)
			return;
		System.out.print(trav.data + ", ");
		preorder(trav.left);
		preorder(trav.right);
	}
	public void preorder() {
		System.out.print(" PRE: ");
		preorder(root);
		System.out.println();
	}
	
	private void inorder(Node trav) {
		if(trav == null)
			return;
		inorder(trav.left);
		System.out.print(trav.data + " ");
		inorder(trav.right);
	}
	public void inorder() {
		System.out.print("IN : ");
		inorder(root);
		System.out.println();
	}
	
	private void postorder(Node trav) {
		if(trav == null)
			return;
		postorder(trav.left);
		postorder(trav.right);
		System.out.print(trav.data + " ");
	}
	public void postorder() {
		System.out.print("POST : ");
		postorder(root);
		System.out.println();
	}
	
	private Node search(Node trav, int val) {
		if(trav == null)
			return null;
		if(val == trav.data)
			return trav;
		Node temp;
		if(val < trav.data)
			temp = search(trav.left, val);
		else
			temp = search(trav.right, val);
		return temp;
	}
	public Node search(int val) {
		return search(root, val);
	}
	
	public Node dfs(int data) {
		System.out.print("DFS : ");
		Stack<Node> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			Node trav = s.pop();
			if(data == trav.data)
				return trav;
			if(trav.right != null)
				s.push(trav.right);
			if(trav.left != null)
				s.push(trav.left);
		}
		return null;
	}
	
	public Node bfs(int data) {
		System.out.print("BFS : ");
		Queue<Node> q = new ArrayDeque<>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node trav = q.poll();
			if(data == trav.data)
				return trav;
			if(trav.left != null)
				q.offer(trav.left);
			if(trav.right != null)
				q.offer(trav.right);
		}
		return null;
	}
}
