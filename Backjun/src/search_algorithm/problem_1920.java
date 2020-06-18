package search_algorithm;

//¼ö Ã£±â
import java.util.*;
import java.io.*;

public class problem_1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> array = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			array.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());

		int[] find = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++)
			find[i] = Integer.parseInt(st.nextToken());

		Collections.sort(array);
		binarySearch(array, N,find);
	}

	private static void binarySearch(List<Integer> array, int N, int[] find) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < find.length; i++) {
			int left = 0;
			int right = N-1;
			int target = find[i];
			boolean check = false;
			while (left <= right) {
				int mid = (left + right) / 2;

				if (array.get(mid) == target) {
					check = true;
					break;
				}

				if (array.get(mid) < target)
					left = mid + 1;
				else
					right = mid - 1;
			}
			
			if(check)
				bw.write("1");
			else
				bw.write("0");
			bw.newLine();
		}
		
		bw.flush();
	}
	
}
