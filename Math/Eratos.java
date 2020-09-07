import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Eratos{

	static boolean[] primes;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();

		primes  = new boolean[limit+1];

		for(int i = 2; i<= limit; i++){
			if(primes[i]) continue;
			for(int j = i+i; j <= limit; j += i){
				primes[j] = true;
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 2; i<= limit; i++){
			if(!primes[i])	sb.append(i + " ");
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();

	}
}
