package greedy;

//알바생 강호
import java.util.*;
import java.io.*;

public class problem_1758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list, Collections.reverseOrder());

		long answer =0 ;
		int rank  =1; 
		for(int tip : list) {
			int temp = tip - (rank-1);
			if(temp > 0)
				answer += temp;
			
			rank++;
		}
		

		System.out.println(answer);
	}
}
