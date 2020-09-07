public class Dijkstra{

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
	static boolean[] v = new boolean[size]; 

	public static void main(String[] args){
		
		for(int i = 0; i<size; i++){
			d[i] = edges[start][i];
		}
		v[start] = true;

		// END OF INIT

		int visited = 1;
		while(visited < size){
			
			int min = getNext();

			v[min] = true;
			for(int i = 0; i<size; i++){
				if(!v[min] || d[min]+edges[min][i] < d[i])
					d[i] = d[min] + edges[min][i];
			}
			visited++;
		}

		// END OF PROCESSING
		for(int i = 0; i<size; i++){
			System.out.print(d[i] + " ");
		}

	}

	static int getNext(){

		int min = -1;
		for(int i = 0; i<size; i++){
			if(v[i] == false && (min == -1 || d[i] < d[min])){
				min = i;	
			}
		}
		return min;
	}
}
