package bruteForce;

//부분 수열의 합
import java.util.*;
import java.io.*;

public class problem_14225 {
	static int array[];
	static Set<Integer> set;
	
	public static void main(String[] args0) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		array  = new int[N];
		set = new HashSet<>();
		for(int i =0 ; i < N ; i++) array[i] = Integer.parseInt(st.nextToken());
		
		makePartial(N);
		
	}
	private static void makePartial(int N) {
		for(int i = 1 ; i < 1<<N; i++) {
			int tmp = 0;
			for(int j =0 ; j < N ; j++) {
				if((i & 1<< j) == (1<<j)) {
					tmp += array[j];
				}
			}
			
			set.add(tmp);
		}
		
		int answer =1;
		while(true) {
			if(!set.contains(answer)) {
				break;
			}
			answer++;
		}
		
		System.out.println(answer);
	}
}
