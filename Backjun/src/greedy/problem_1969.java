package greedy;

//DNA
import java.util.*;
import java.io.*;

public class problem_1969 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}

		char[] dna = { 'A', 'C', 'G', 'T' };

		StringBuilder sb = new StringBuilder();
		int answer = 0;
		
		for (int i = 0; i < M; i++) {
			int len = Integer.MAX_VALUE;
			int idx = 0;
			for (int j = 0; j < 4; j++) {
				int dist = 0;
				for (String cur : list) {
					if(cur.charAt(i) != dna[j])
						dist++;
				}
				
				if(len > dist) {
					len = dist;
					idx = j;
				}
			}
			
			answer += len;
			sb.append(dna[idx]);
		}
		
		System.out.println(sb.toString());
		System.out.println(answer);
	}
}
