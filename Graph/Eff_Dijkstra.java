import java.util.*;
import java.io.*;

class Main{

	final static int INF = 987654321;

	static int N, M;
	static int start, end;

	static int[] dist;
	static int [][] adj;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		dist = new int[N+1];
		adj = new int[N+1][M+1];

		Arrays.fill(dist, INF);
		for(int i = 0; i<N+1; i++){
			for(int j = 0; j<N+1; j++){
				adj[i][j] = INF;
			}
		}

		for(int i = 1; i<=M; i++){
			token = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			int d = Integer.parseInt(token.nextToken());

			if(d < adj[s][e])	adj[s][e] = d;
		}
		token = new StringTokenizer(br.readLine());
		start = Integer.parseInt(token.nextToken());
		end = Integer.parseInt(token.nextToken());

		// END OF INIT

		PriorityQueue<Element> queue = new PriorityQueue<Element>();
		dist[start] = 0;
		queue.offer(new Element(start, dist[start]));

		while(!queue.isEmpty()){
			Element temp = queue.poll();
		
			if(dist[temp.index] < temp.distance)	continue;

			for(int i = 1; i<= N; i++){
				if(adj[temp.index][i] != INF){
					if(dist[i] > dist[temp.index] + adj[temp.index][i]){
						dist[i] = dist[temp.index] + adj[temp.index][i];
						queue.offer(new Element(i, dist[i]));
					}
				}	
			}
		}
		System.out.println(dist[end]);

	}
}

class Element implements Comparable<Element>{

	int index;
	int distance;

	Element(int index, int distance){
		this.index = index;
		this.distance = distance;
	}

	@Override
	public int compareTo(Element o){
		return this.distance - o.distance;
	}
}
