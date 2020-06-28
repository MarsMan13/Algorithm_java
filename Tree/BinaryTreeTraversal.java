import java.util.Scanner;

class Node{
	int data;
	Node left;
	Node right;

	public Node(Node left, int data, Node right){
		this.left = left;
		this.data = data;
		this.right = right;
	}
}

class Tree{

	public Node root;

	public void setRoot(Node node){
		this.root = node;
	}

	public Node getRoot(){
		return this.root;
	}

	public Node makeNode(Node left, int data, Node right){
		return new Node(left, data, right);
	}

	public void inorder(Node node){
		if(node != null){
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}

	public void preorder(Node node){
		if(node != null){
			System.out.println(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public void postorder(Node node){
		if(node != null){
			preorder(node.left);
			preorder(node.right);
			System.out.println(node.data);
		}
	}
	
}


public class BinaryTreeTraversal{


	public static void main(String[] args){

		Tree t = new Tree();
		Node n4 = t.makeNode(null, 4, null);
		Node n5 = new Node(null, 5, null);
		Node n2 = new Node(n4, 2, n5);
		Node n3 = new Node(null, 3, null);
		Node n1 = new Node(n2, 1, n3);
		t.setRoot(n1);

		System.out.println("==== inorder ====");
		t.inorder(t.getRoot());
		System.out.println("==== preorder ====");
		t.preorder(t.getRoot());
		System.out.println("==== postorder ====");
		t.postorder(t.getRoot());

	}
}
