package sorting;

//K¹ø¤Š ¼ö
import java.util.*;
import java.io.*;

public class problem_11004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		quick_sort(array,0,array.length-1);
		System.out.println(array[K-1]);
	}

	private static void quick_sort(int[] array, int left, int right) {
		if (left < right) {
			int l = left;
			int r = right;
			int pivot = array[(left + right) / 2];

			while (l <= r) {
				while (array[l] < pivot)
					l++;
				while (array[r] > pivot)
					r--;

				if (l <= r) {
					swap(array, l, r);
					l++;
					r--;
				}
			}
			
			quick_sort(array,left,r);
			quick_sort(array,l,right);
		}
	}

	private static void swap(int[] array, int l, int r) {
		int temp = array[l];
		array[l] = array[r];
		array[r] = temp;
	}
}
