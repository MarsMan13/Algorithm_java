import java.util.*;
import java.io.*;

class Main{

	static int N = 0;
	static int M = 0;
	static LinkedList<Integer>[] pointer = null;
	static int[] degree = null;
	static int[] visited = null;
	static LinkedList<Integer> result = null;

	public static void main(String[] args) throws IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pointer = new LinkedList[N+1];
		result = new LinkedList<>();
		degree = new int[N+1];
		visited = new int[N+1];

		int from = 0;
		int to = 0;
		for(int i = 0; i<M; i++){

			st = new StringTokenizer(bf.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			if(pointer[from] == null)
				pointer[from] = new LinkedList<>();

			pointer[from].add(to);
			degree[from] += 1;
		}

		for(int i = 1; i<=N; i++){
			if(visited[i] == 0){
				dfs(i);
			}
		}

		for(int i = result.size()-1; 0<=i; i--){	
			System.out.print(result.get(i)+" ");
		}
		System.out.println();

	}

	static void dfs(int root){
		visited[root] = 1;

		Deque<Integer> stack = new ArrayDeque<>();
		stack.offerFirst(root);
		while(!(stack.isEmpty())){
			int temp = stack.pollFirst();

			if(temp > 0){
				stack.offerFirst(temp * -1);
				if(pointer[temp] == null){
					continue;
				}
				for(int j : pointer[temp]){
					if(visited[j] == 0){
						visited[j] = 1;
						stack.offerFirst(j);
					}
				}
			}
			else{
				result.add(temp * -1);
			}
		}
		return;
	}
}
