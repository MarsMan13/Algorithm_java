import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

public class Test1{

	class Node{
		int data;
		List<Node> adjacent;
		boolean visited = false;

		Node(int data){
			this.data = data;
			this.adjacent = new LinkedList<>();
		}

		@Override
		public String toString(){
			return ""+this.data;
		}
	}

	Node[] nodes;

	Test1(int size){
		nodes = new Node[size];
		for(int i = 0; i<size; i++){
			nodes[i] = new Node(i);
		}
	}

	void addEdge(int index1, int index2){
		Node n1 = nodes[index1];
		Node n2 = nodes[index2];

		if(!(n1.adjacent.contains(n2))){
			n1.adjacent.add(n2);
		}
		if(!(n2.adjacent.contains(n1))){
			n2.adjacent.add(n1);
		}
	}

	void dfs(int index){

		Node root = nodes[index];
		Deque<Node> stack = new ArrayDeque();
	
		stack.offer(root);
		root.visited = true;
		while(!(stack.isEmpty())){
			Node tempNode = stack.poll();
			for(Node i : tempNode.adjacent){
				if(!(i.visited)){
					i.visited = true;
					stack.offer(i);
				}
			}
			visit(tempNode);
		}

	}

	void bfs(int index){

		Node root = nodes[index];
		Queue<Node> queue = new LinkedList<>();
	
		queue.offer(root);
		root.visited = true;
		while(!(queue.isEmpty())){
			Node tempNode = queue.poll();
			for(Node i : tempNode.adjacent){
				if(!(i.visited)){
					i.visited = true;
					queue.offer(i);
				}
			}
			visit(tempNode);
		}
	}

	void dfsR(Node root){

		root.visited = true;
		visit(root);

		for(Node i : root.adjacent){
			if(!(i.visited)){
				i.visited = true;
				dfsR(i);
			}
		}
	}


	void visit(Node node){
		System.out.println(node);
	}


	public static void main(String[] args){




	}
}
