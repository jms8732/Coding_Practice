package others;

/*
 * 전기 요금
 * 금액을 대상으로 이분 탐색을 진행하여 알고리즘을 진행한다.
 */
import java.util.*;
import java.io.*;

public class problem_5710 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A == 0 && B == 0)
				break;

			System.out.println(findWatt(A,B));
		}
	}
	
	private static long findWatt(int A, int B) {
		int left = 0;
		int total = use(A);
		int right = total;
		
		while(left < right) {
			int mid = (left + right) /2;
			
			long c1 = cost(mid);
			long c2 = cost(total - mid);
			
			if(Math.abs(c2-c1) == B) {
				return Math.min(c1, c2);
			}
			
			if(Math.abs(c2-c1) > B)
				right = mid;
			else
				left = mid+1;
		}
		
		return 0;
	}



	private static int use(int cost) {
		if (cost > 4979900)
			return (cost + 2020100) / 7;
		else if (cost > 29900)
			return (cost + 20100) / 5;
		else if (cost > 200)
			return (cost + 100) / 3;
		else
			return cost / 2;
	}

	private static long cost(int use) {
		if (use > 1000000)
			return use * 7 - 2020100;
		else if (use > 10000)
			return use * 5 - 20100;
		else if (use > 100)
			return use * 3 - 100;
		else
			return use * 2;
	}
}
