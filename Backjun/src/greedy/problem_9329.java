package greedy;

/*
 * 패스트 푸드 상금
 * 브루트 포스 + 그리디
 * 
 */
import java.util.*;
import java.io.*;

public class problem_9329 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			HashMap<Set<Integer>, Integer> book = new HashMap<>();

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());

				int k = Integer.parseInt(st.nextToken());
				Set<Integer> tmp = new HashSet<>();
				for (int l = 0; l < k; l++) {
					tmp.add(Integer.parseInt(st.nextToken()));
				}

				book.put(tmp, Integer.parseInt(st.nextToken()));
			}

			int[] sticker = new int[m];
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < sticker.length; j++) {
				sticker[j] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(max_score(book,sticker));

		}
	}

	private static int max_score(HashMap<Set<Integer>, Integer> book, int[] sticker) {
		int ret = 0;

		for (Map.Entry<Set<Integer>, Integer> m : book.entrySet()) {
			Set<Integer> tmp = m.getKey();
			int price = m.getValue();

			int min = Integer.MAX_VALUE;

			for (int i : tmp) {
				min = Math.min(sticker[i - 1], min);
			}

			ret += price * min;
		}

		return ret;
	}
}
