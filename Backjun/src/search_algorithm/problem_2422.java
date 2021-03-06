package search_algorithm;

//한윤정이 이탈리에 가서 아이스크림을 사먹는데
import java.util.*;
import java.io.*;

public class problem_2422 {
	static boolean [][] bad;
	static int answer, N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int [] selected = new int[3];
		bad =  new boolean[N][N];
		
		for(int i =0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			
			bad[s][e] = true;
			bad[e][s] = true;
		}
		
		for(int i =0 ; i< N ; i++) {
			selected[0] = i;
			iceCream(1,i,selected);
		}
		
		System.out.println(answer);
	}

	private static void iceCream(int depth, int cur, int[] selected) {
		if(depth == 3) {
			for(int i =0 ; i < 3;  i++) {
				for(int j =0 ; j < 3 ; j++) {
					if(i != j) {
						int a = selected[i];
						int b = selected[j];
						
						if(bad[a][b])
							return;
					}
				}
			}
			answer++;
			return;
		}
		
		for(int i = cur +1 ; i < N ; i++) {
			selected[depth] = i;
			iceCream(depth+1,i,selected);

		}
	}
}
