package greedy;

/*
 * ���� ������ ���۽�Ÿ K
 * �� �����ڴ� �ᱹ �ϳ��� �帣�� ������ �����ؼ� �뷡�� �ҷ����Ѵ�.
 * �켱���� ť�� �̿��ؼ� ������ �ذ��Ѵ�.
 */
import java.util.*;
import java.io.*;

public class problem_2865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<Student> pq = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				pq.add(new Student(st.nextToken(), st.nextToken()));
			}
		}

		double[] cache = new double[N];

		while (!pq.isEmpty() && K > 0) {
			Student cur = pq.poll();

			if(cache[cur.num-1] == 0) {
				cache[cur.num-1] = cur.ability;
				K--;
			}else {
				if(cache[cur.num -1] < cur.ability)
					cache[cur.num-1] = cur.ability;
			}
			
		}

		double ans = 0;
		for (double d : cache)
			ans += d;

		System.out.println(String.format("%.1f", ans));
	}

	private static class Student implements Comparable<Student> {
		int num;
		double ability;

		public Student(String n, String a) {
			this.num = Integer.parseInt(n);
			this.ability = Double.parseDouble(a);
		}

		@Override
		public int compareTo(Student arg0) {
			// TODO Auto-generated method stub
			return Double.compare(arg0.ability, this.ability);
		}

	}
}
