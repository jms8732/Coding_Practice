package greedy;

/*
 * APC�� �� ���� �׽�ũ ������ �Ǿ��� ��?
 * 1. ���� ���� ���̵� <= ����� ���� ���̵� �� ���� �̿��ؼ� �켱 ���� ť�� �̿��Ͽ� ����� ���� ���̵��� �������� ������ �����Ѵ�.
 * 2. ����� ���̵��� ������ ������ ������ ����� ������ Ǯ�� ���� ������ Ǯ �� �ֱ� ������ 140���� ���� �� �ֱ� �����̴�.
 * 3. ����, ����� ���̵��� ������ �� Ǯ�������� �ұ��ϰ� ���� Ǯ �� �ִ� �������� �����Ѵٸ� 100���� �߰��Ͽ� Ǯ �� �ִ� ������ Ǭ��.
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
