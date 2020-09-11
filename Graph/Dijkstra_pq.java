import java.util.*;



class Main{

	final static int INF = 1000000000;

	static int start = 0;
	static int size = 6;
	static int[][] edges = {	// 6 X 6
		{0, 2, 5, 1, INF, INF},
		{2, 0, 3, 2, INF, INF},
		{5, 3, 0, 3, 1, 5},
		{1, 2, 3, 0, 1, INF},
		{INF, INF, 1, 1, 0, 2},
		{INF, INF, 5, INF, 2, 0},
	};
	static int[] d = new int[size];
	static boolean[] visited = new boolean[size];
	static int visitCount = 0;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args){

		for(int i = 0; i<size; i++){
			d[i] = edges[start][i];
			pq.add(new Edge(i, d[i]));
		}
		visited[start] = true;
		visitCount++;
		// END OF INIT
		//

		while(visitCount < size){
			Edge tempEdge = pq.poll();

			int tempFrom = tempEdge.target;
			if(visited[tempFrom] == true)
				continue;
			visited[tempFrom] = true;
			visitCount++;
			for(int i = 0; i<size; i++){
				if(d[tempFrom] + edges[tempFrom][i] < d[i]){
					d[i] = d[tempFrom] + edges[tempFrom][i];
					pq.add(new Edge(i, d[i]));
				}
			}
		}
		
		for(int i = 0; i<size; i++){
			System.out.println(d[i] + " ");
		}
		
	}
}


class Edge implements Comparable<Edge>{

	int target;
	int cost;

	Edge(int target, int cost){
		this.target = target;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o){
		return this.cost - o.cost;
	}
}
