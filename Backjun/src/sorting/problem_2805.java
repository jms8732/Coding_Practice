package sorting;

//수 이어쓰기2
import java.util.*;
import java.io.*;

public class problem_2805 {
	static List<Long> trees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\jms87\\Desktop\\contest5_testdata\\eko\\eko.in.7")));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		trees = new ArrayList<>();
		long K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			trees.add(Long.parseLong(st.nextToken()));

		Collections.sort(trees);

		simulation(K);
	}

	private static void simulation(long K) {
		long left = 0, mid =0 ;
		long right = trees.get(trees.size() - 1);

		Collections.sort(trees, Collections.reverseOrder());
		
		while (left <= right) {
			mid = (left + right) / 2;
			long tmp = cutTrees(mid);

			if(K == tmp) {
				System.out.println(mid);
				System.exit(0);
			}
			
			if (K < tmp) {
				left = mid+1;
			} else
				right =mid-1;
		}
		
		System.out.println(left-1);
	}

	private static long cutTrees(long height) {
		long totalHeight = 0;
		for (int i = 0; i < trees.size(); i++) {
			long tmp = trees.get(i) - height;
			if (tmp != 0 && tmp > 0)
				totalHeight += tmp;
			else
				break;
		}

		return totalHeight;
	}
}
