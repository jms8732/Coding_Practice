package greedy;

/*
 * APC는 왜 서브 테스크 문제가 되었을 까?
 * 1. 쉬운 문제 난이도 <= 어려운 문제 난이도 이 점을 이용해서 우선 순위 큐를 이용하여 어려운 문제 난이도를 기준으로 정렬을 수행한다.
 * 2. 어려운 난이도로 정렬을 진행한 이유는 어려운 문제를 풀면 쉬운 문제를 풀 수 있기 때문에 140점을 얻을 수 있기 떄문이다.
 * 3. 이후, 어려운 난이도의 문제를 다 풀었음에도 불구하고 아직 풀 수 있는 문제들이 존재한다면 100점을 추가하여 풀 수 있는 문제를 푼다.
 */
import java.util.*;
import java.io.*;

public class problem_17224 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<subTask> pq = new PriorityQueue<>(new Comparator<subTask>() {

			@Override
			public int compare(subTask arg0, subTask arg1) {
				// TODO Auto-generated method stub
				return Integer.compare(arg0.sub2, arg1.sub2);
			}

		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			pq.add(new subTask(st.nextToken(), st.nextToken()));
		}
		int score = 0;

		while (!pq.isEmpty() && K > 0) {
			subTask cur = pq.poll();

			if (cur.sub2 <= L) {
				score += 140;
				K--;
			} else if (cur.sub1 <= L) {
				score += 100;
				K--;
			}
		}

		System.out.println(score);
	}

	private static class subTask {
		int sub1, sub2;

		public subTask(String s1, String s2) {
			this.sub1 = Integer.parseInt(s1);
			this.sub2 = Integer.parseInt(s2);
		}
	}
}
