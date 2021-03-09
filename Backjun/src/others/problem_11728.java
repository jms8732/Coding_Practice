package others;

/*
 * 배열 합치기
 * 합병정렬의 merge 부분을 이용한다.
 * System.out을 이용하면 시간초과 발생하므로 BufferedWriter를 이용한다.
 */
import java.util.*;
import java.io.*;

public class problem_11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] A = new int[n];
		int[] B = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			B[i] = Integer.parseInt(st.nextToken());

		merge(n,m,A, B);
		br.close();
	}

	private static void merge(int n, int m, int[] A, int[] B) throws IOException {
		BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));
		int left = 0;
		int right = 0;
		int idx = 0;
		int[] temp = new int[n + m];

		while (left < A.length && right < B.length) {
			if (A[left] <= B[right])
				temp[idx++] = A[left++];
			else
				temp[idx++] = B[right++];
		}

		if (left < A.length) {
			for (int i = left; i < A.length; i++)
				temp[idx++] = A[i];
		} else {
			for (int i = right; i < B.length; i++) {
				temp[idx++] = B[i];
			}
		}

		for (int i : temp)
			bw.write(i + " ");
		bw.flush();
		bw.close();
	}
}
