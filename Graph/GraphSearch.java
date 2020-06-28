import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Queue;

public class GraphSearch{

	class Node{
		int data;
		List<Node> adjacent;
		boolean visited = false;
		
		Node(int data){
			this.data = data;
			adjacent = new LinkedList<>();
		}

		@Override
		public String toString(){
			return ""+data;
		}
	}

	Node[] nodes;

	GraphSearch(int size){
		nodes = new Node[size];
		for(int i = 0; i<size; i++){
			nodes[i] = new Node(i);
		}
	}

	void addEdge(int index1, int index2){
		Node n1 = nodes[index1];
		Node n2 = nodes[index2];
		if(!n1.adjacent.contains(n2)){
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)){
			n2.adjacent.add(n1);
		}
	}

	void dfs(int index){
		Node root = nodes[index];

		Deque<Node> stack = new ArrayDeque<>();
		stack.offerFirst(root);
		root.visited = true;
		while(!stack.isEmpty()){
			Node temp = stack.pollFirst();
			for(Node adj : temp.adjacent){
				if(adj.visited == false){
					adj.visited = true;
					stack.offerFirst(adj);
				}
			}
			visit(temp);
		}
	}

	void bfs(int index){
		Node root = nodes[index];

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!(queue.isEmpty())){
			Node temp = queue.poll();
			for(Node adj : temp.adjacent){
				if(adj.visited == false){
					adj.visited = true;
					queue.offer(adj);
				}
			}
			visit(temp);
		}
	}

	void dfsR(Node root){
	
		root.visited = true;
		visit(root);

		for(Node adj : root.adjacent){
			if(adj.visited == false){
				adj.visited = true;
				dfsR(adj);
			}
		}
	}


	void visit(Node n){
		System.out.println(n);
	}


	public static void main(String[] args){
		

	}
}
