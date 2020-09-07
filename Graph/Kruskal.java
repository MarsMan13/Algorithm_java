import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;


public class Kruskal{

	LinkedList<Edge> edges = new LinkedList<>();
	LinkedList<Edge> selectedEdges = new LinkedList<>();
	int[] parents = new int[100];


	public static void main(String[] args){

		Kruskal obj = new Kruskal();
		for(int i = 0; i<100; i++)	obj.parents[i] = i;

		obj.edges.add(new Edge(12, 1, 7));
		obj.edges.add(new Edge(17, 1, 5));
		obj.edges.add(new Edge(24, 2, 4));
		obj.edges.add(new Edge(62, 2, 5));
		obj.edges.add(new Edge(20, 3, 5));
		obj.edges.add(new Edge(37, 3, 6));
		obj.edges.add(new Edge(45, 5, 6));
		obj.edges.add(new Edge(67, 1, 2));
		obj.edges.add(new Edge(73, 5, 7));
		obj.edges.add(new Edge(28, 1, 4));
		obj.edges.add(new Edge(13, 4, 7));

		// END OF INIT

		Collections.sort(obj.edges);

		
		int counter = obj.edges.size() - 1;
		int cost = 0;
		for(Iterator<Edge> itr = obj.edges.iterator(); counter != 0 && itr.hasNext(); ){
			Edge temp = itr.next();
			int left = temp.left;
			int right = temp.right;
			if(obj.sameParent(left, right)) continue;
			obj.unionParent(left, right);
			obj.selectedEdges.add(temp);
			cost += temp.weight;
			counter--;
		}

		for(Iterator<Edge> itr = obj.selectedEdges.iterator(); itr.hasNext(); ){
			System.out.println(itr.next());
		}

		System.out.println("Cost is "+cost);
	}


	// Find
	int getParent(int index){
		if(index == parents[index]) return index;
		return parents[index] = getParent(parents[index]);
	}

	// Union
	void unionParent(int index1, int index2){
		index1 = getParent(index1);
		index2 = getParent(index2);
		if(index1 < index2)	parents[index2] = index1;
		else parents[index1] = index2;
	}


	//
	boolean sameParent(int index1, int index2){
		return getParent(index1) == getParent(index2);
	}
}
	
class Edge implements Comparable<Edge>{
	int weight;
	int left;
	int right;

	Edge(int weight, int left, int right){
		this.weight = weight;
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(Edge e){
		return this.weight - e.weight;
	}

	@Override
	public String toString(){
		return this.left + "-(" +this.weight + ")-" + this.right;
	}

}

