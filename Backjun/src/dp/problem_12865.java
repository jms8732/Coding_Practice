package dp;

//평범한 배낭
import java.util.*;
import java.io.*;

public class problem_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new TreeSet<>(); // 중복 제거
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 물건의 개수
		int K = Integer.parseInt(st.nextToken()); // 버틸수 있는 무게

		List<Node> list[] = new ArrayList[100001];
		for (int i = 1; i < list.length; i++)
			list[i] = new ArrayList<>();

		// 값 할당
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			List<Integer> tmp = null;

			if (!map.containsKey(w)) {
				tmp = new ArrayList<>();
				tmp.add(v);
				map.put(w, tmp);
			} else {
				tmp = map.get(w);
				tmp.add(v);
				tmp.sort(Collections.reverseOrder()); // 내림차순으로 정렬
				map.put(w, tmp);
			}
			set.add(w);
		}

		Iterator<Integer> it = map.keySet().iterator();

		while (it.hasNext()) {
			int w = it.next();
			int sum = 0;
			int step = 1;
			List<Integer> tmp = map.get(w);
			for (int i = 0; i < tmp.size(); i++) {
				sum += tmp.get(i);
				if (w * step <= K)
					list[w].add(new Node(sum, w * step));
				step++;
			}

		}

		List<Integer> value = new ArrayList<>(set);
		int IMPOSSIBLE = -10000000;
		int[][] dp = new int[value.size()][K + 1];
		for (int[] tmp : dp) {
			Arrays.fill(tmp, IMPOSSIBLE);
		}

		// 첫번쨰 행 추가
		for (int i = 0; i < list[value.get(0)].size(); i++) {
			int idx = list[value.get(0)].get(i).idx;
			int v = list[value.get(0)].get(i).value;
			dp[0][idx] = v;
		}

		// 나머지 행
		for (int i = 1; i < dp.length; i++) {
			System.arraycopy(dp[i - 1], 0, dp[i], 0, value.get(i)); // 현재 위치 이전까지 값 복사
			int listIdx = value.get(i);
			for (int j = 0; j < list[listIdx].size(); j++) {
				int currentIdx = list[listIdx].get(j).idx;
				int currentValue = list[listIdx].get(j).value;
				dp[i][currentIdx] = Math.max(dp[i - 1][currentIdx], currentValue);
				for (int k = currentIdx + 1; k <= K; k++) {
					dp[i][k] = Math.max(dp[i][k], Math.max(dp[i - 1][k], currentValue + dp[i - 1][k - currentIdx]));
				}
			}
		}
		int big = 0;
		for (int i = 0; i < dp[value.size() - 1].length; i++) {
			big = Math.max(big, dp[value.size() - 1][i]);
		}
		System.out.println(big);

	}

	private static class Node {
		int value, idx;

		public Node(int v, int i) {
			this.value = v;
			this.idx = i;
		}
	}
}
