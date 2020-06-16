package search_algorithm;

//달팽이는 올라가고 싶다.
import java.util.*;
import java.io.*;
import java.math.*;

public class problem_2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		binarySearch(A, B, V);
	}

	private static void binarySearch(int A, int B, int V) {
		int left = 0, right = 1000000000;
		BigDecimal a = new BigDecimal(String.valueOf(A));
		BigDecimal b = new BigDecimal(String.valueOf(B));
		BigDecimal v = new BigDecimal(String.valueOf(V));

		while (left < right) {
			int mid = (left + right) / 2;

			BigDecimal height = a.subtract(b).multiply(new BigDecimal(String.valueOf(mid)));

			if (height.compareTo(v) < 0) {
				if(v.subtract(height).compareTo(a) <= 0) {
					right = mid;
					continue;
				}
				left = mid+1;
			}else
				right = mid;
		}
		
		System.out.println(left+1);
	}
}
