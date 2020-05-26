package bruteForce;

//합이 0인 네 정수
import java.util.*;
import java.io.*;

public class problem_7453 {
	static int[] A, B, C, D;
	static long [] AB, CD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			A[i] = a;
			int b = Integer.parseInt(st.nextToken());
			B[i] = b;
			int c = Integer.parseInt(st.nextToken());
			C[i] = c;
			int d = Integer.parseInt(st.nextToken());
			D[i] = d;
		}
		
		AB = new long[N*N];
		CD = new long[N*N];
		
		int idx =0 ;
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < N ; j++) {
				AB[idx] = A[i] + B[j];
				CD[idx] = C[i] + D[j];
				
				idx++;
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		long answer = 0;
		for(int i =0 ; i < AB.length ; i++) {
			int low = lower_bound(-AB[i]);
			int high = upper_bound(-AB[i]);
			
			answer += (high - low);
		}
		
		System.out.println(answer);
	}
	
	private static int lower_bound(long target) {
		int left =0 ;
		int right = AB.length;
		
		while(left < right) {
			int mid = (left+right) /2;
			if(CD[mid] < target) {
				left = mid+1;
			}else
				right = mid;
		}
		
		
		return left-1;
	}
	
	private static int upper_bound(long target) {
		int left =0 ;
		int right = AB.length;
		
		while(left < right) {
			int mid = (left+right)/2;
			if(CD[mid] <= target)
				left = mid+1;
			else
				right = mid;
		}
		
		return left-1;
	}
}
