package greedy;

//등수 매기기
import java.util.*;
import java.io.*;

public class problem_2012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int [] array = new int[N];
		
		for(int i =0 ; i < N ; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		
		int answer =0 ;
		int rank = 1;
		for(int i = 0 ; i < N ; i++) {
			answer += Math.abs(array[i] - rank++);
		}
		System.out.println(answer);
	}

	
}
