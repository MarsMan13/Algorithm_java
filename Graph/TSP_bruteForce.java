import java.util.*;

class Main{

	static int n;
	static int[][] weight;
	static boolean[] visited;
	static List<Integer> path = new LinkedList<Integer>();

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		visited = new boolean[n+1];
		weight = new int[n+1][n+1];
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=n; j++){
				weight[i][j] = sc.nextInt();
			}
		}

		// END OF INIT

		path.add(1);
		visited[1] = true;

		int ret  = TSP(0);

		System.out.println(ret);
	}

	static int TSP(int len){
	
		if(path.size() == n)
			return len + weight[path.get(path.size()-1)][1];
		int ret = 987654321;

		for(int next = 1; next<=n; next++){
			if(visited[next])	continue;

			int current = path.get(path.size() - 1);
			path.add(next);
			visited[next] = true;
			ret = Math.min(ret, TSP(len + weight[current][next]));
			visited[next] = false;
			path.remove(path.size() - 1);	
		}
		return ret;

	}
}
