package com.sunbeam;

public class BinarySearchTree {
	static class Node{
		private int data;
		private Node left;
		private Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		public int getData() {
			return data;
		}
	}
	
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void addNode(int data) {
		//create node
		Node nn = new Node(data);
		//check if root is null
		if(root == null) {
			root = nn; //if root is null assign new node as root
		}
		else {
			//else create a trav
			Node trav = root; 
			while(true) { //while the condition is true
				if(data < trav.data) { //check if the data is less than trav's data
					if(trav.left == null) { //if it is less then check trav's left is null or not
						trav.left = nn; //if it is null then assign new node to trav's left
						break;
					}
					trav = trav.left; //else trav to the left side
				}
				else {
					//if given data is greater than trav's data
					if(trav.right == null) { //check if trav's right is null or not
						trav.right = nn; //if it is null then assign new node to trav's right
						break;
					}
					trav = trav.right; //else trav to the rigth side 
				}
			}
		}
	}
	
	private void addNodeRecursive(Node trav, int data) {
		if(data < trav.data) {
			if(trav.left == null) {
				trav.left = new Node(data);
				return;
			}
			else {
				addNodeRecursive(trav.left, data);
			}
		}
		else {
			if(trav.right == null) {
				trav.right = new Node(data);
				return;
			}
			else {
				addNodeRecursive(trav.right, data);
			}
		}
	}
	public void addNodeRecursive(int data) {
		if(root == null) {
			root = new Node(data);
		}
		else {
			addNodeRecursive(root, data);
		}
	}
	
	private void preorder(Node trav) {
		if(trav == null)
			return;
		System.out.print(trav.data + " ");
		preorder(trav.left);
		preorder(trav.right);
	}
	public void preorder() {
		System.out.print("PRE : ");
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
	
	public Node search(int data) {
		Node trav = root;
		while(trav != null) {
			if(data == trav.data)  //if root is given as a data to find
				return trav;
			if(data < trav.data)
				trav = trav.left;
			else
				trav = trav.right;
		}
		return null;
	}
	
	private Node searchWithRecursive(Node trav, int data) {
		if(trav == null) 
			return null;
		if(data == trav.data)
			return trav;
		Node temp;
		if(data < trav.data)
			temp = searchWithRecursive(trav.left, data);
		else
			temp = searchWithRecursive(trav.right, data);
		return temp;
	}
	public Node searchWithRecursive(int data) {
		return searchWithRecursive(root, data);
	}
	
	public Node[] searchWithParent(int data) {
		Node trav = root;
		Node parent = null;
		while(trav != null) {
			if(data == trav.data) //if root is given as a data to find
				return new Node[] {trav, parent};
			parent = trav;
			if(data < trav.data)
				trav = trav.left;
			else
				trav = trav.right;
		}
		return new Node[] {null,null};
	}
	
	public void delete(int data) {
		// find node to be deleted along with its parent
		Node[] find = searchWithParent(data);
		Node temp = find[0], parent = find[1];
		if(temp == null) {
			System.out.println("node not found");
			return;
		}
		
		//delete node who have both child
		if(temp.left != null && temp.right != null) {
			//find temp inorder successor along with its parent
			parent = temp;
			Node succ = temp.right;
			while(succ.left != null) {
				parent = succ;
				succ = succ.left;
			}
			//overwrite temp data with succ data
			temp.data = succ.data;
			//consider the succ node to be deleted
			temp = succ;
		}
		
		//delete node who don't have left child
		if(temp.left != null) {
			if(temp == root)
				root = temp.right;
			else if(temp == parent.left)
				parent.left = temp.right;
			else
				parent.right = temp.right;
		}
		
		//delete node who don't have right child
		else if(temp.right == null) {
			if(temp == root)
				root = temp.left;
			else if(temp == parent.left)
				parent.left = temp.left;
			else
				parent.right = temp.left;
		}
	}
	
	private Node deleteNodeWithRecursive(Node trav, int data) {
	    // If current node is null, value not found
	    if (trav == null)
	        return null;
	    // If target data is smaller than current node, go to left subtree
	    if (data < trav.data) {
	        trav.left = deleteNodeWithRecursive(trav.left, data);
	    }

	    // If target data is greater than current node, go to right subtree
	    else if (data > trav.data) {
	        trav.right = deleteNodeWithRecursive(trav.right, data);
	    }

	    // Node found
	    else {
	        // Node has no left child
	        // Return right child to parent
	        if (trav.left == null)
	            return trav.right;


	        // Node has no right child
	        // Return left child to parent
	        else if (trav.right == null)
	            return trav.left;

	        // Node has both children
	        else {

	            // Find inorder successor
	            Node temp = trav.right;

	            while (temp.left != null) {
	                temp = temp.left;
	            }

	            // Copy successor data into current node
	            trav.data = temp.data;

	            // Delete duplicate successor node from right subtree
	            trav.right = deleteNodeWithRecursive(trav.right, temp.data);
	        }
	    }

	    // Return updated subtree root
	    return trav;
	}
	public void deleteNodeWithRecursive(int data) {
	    // Update root because deleting root may change tree root
	    root = deleteNodeWithRecursive(root, data);
	}
	

}
