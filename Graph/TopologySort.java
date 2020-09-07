import java.util.*;
import java.io.*;



class Main{

	static int inputSize = 0;
	static int[] degree = null;
	static LinkedList<Integer>[] point = null;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		inputSize = sc.nextInt();
		
		degree = new int[inputSize+1];
		point = new LinkedList[inputSize+1];

		for(int i = 0; i<inputSize; i++){
			int from = sc.nextInt();
			int to = sc.nextInt();

			if(point[from] == null)
				point[from] = new LinkedList<Integer>();
			point[from].add(to);
			degree[to] += 1;
		}

		//END OF INIT

		Queue<Integer> queue = new LinkedList<>();

		for(int i = 1; i<=inputSize; i++){
			if(degree[i] == 0){
				queue.offer(i);
			}
		}

		List<Integer> result = new LinkedList<>();
		for(int i = 1; i<=inputSize; i++){
			int from = queue.poll();
			result.add(from);
			if(point[from] == null)
				continue;
			for(int j : point[from]){
				degree[j]-=1;
				if(degree[j] == 0){
					queue.offer(j);
				}
			}
		}


		// END OF PROCESS
		// PRINT RESULT
		for(int i : result){
			System.out.println(i + " ");
		}
		System.out.println();

	}
}
