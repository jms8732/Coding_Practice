package greedy;

/*
 * �� ì��� ��
 * �⺻���� �׸���
 * ��, �������� å�� žó�� �������� �׿��ִٰ� ��õ� �ֱ⿡ �켱���� ť�� �̿��ϸ� �ȵȴ�.
 */
import java.util.*;
import java.io.*;

public class problem_1817 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if (N == 0)
			System.out.println(0);
		else {
			Queue<Integer> q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				q.add(Integer.parseInt(st.nextToken()));

			int tmp = M;
			int ans = 0;
			while (true) {
				if (!q.isEmpty() && tmp - q.peek() >= 0)
					tmp -= q.poll();
				else {
					ans++;
					tmp = M;

					if (q.isEmpty())
						break;
				}
			}

			System.out.println(ans);
		}
	}
}
