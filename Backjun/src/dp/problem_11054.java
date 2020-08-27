package dp;

//가장 긴 바이토닉 부분 수열
import java.util.*;
import java.io.*;

public class problem_11054 {
	static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		array = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int[] cache1 = new int[N];
		int[] cache2 = new int[N];

		Arrays.fill(cache1, -1);
		cache1[0] = 1;
		Arrays.fill(cache2, -1);
		cache2[N-1] = 1;

		for (int i = 1; i < N; i++) {
			cache1[i] = 1;
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j] && cache1[j] + 1 > cache1[i]) {
					cache1[i] = cache1[j] + 1;
				}
			}
		}
		
		for(int i = N -2 ; i >=0 ; i--) {
			cache2[i] = 1;
			
			for(int j = N-1 ; j > i ; j--) {
				if(array[i] > array[j] && cache2[j] + 1 > cache2[i])
					cache2[i] = cache2[j]+1;
			}
		}

		int[] answer = new int[N];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = cache1[i] + cache2[i];
		}

		int ans =0 ; 
		for(int i : answer)
			ans = Math.max(i, ans);
		
		System.out.println(ans-1);
	}
}
