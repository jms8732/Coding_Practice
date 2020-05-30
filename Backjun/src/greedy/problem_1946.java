package greedy;

//신입 사원
import java.util.*;
import java.io.*;

public class problem_1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<grade> pq = new PriorityQueue<>(new Comparator<grade>() {

				@Override
				public int compare(grade arg0, grade arg1) {
					// TODO Auto-generated method stub
					if (arg0.a < arg1.a)
						return -1;
					else
						return 1;
				}

			});
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pq.add(new grade(a,b));
			}

			grade first = pq.poll();
			int grade_a = first.a;
			int grade_b = first.b;
			
			int answer = 1;
			while(!pq.isEmpty()) {
				grade next = pq.poll();
				
				if(next.a > grade_a && next.b > grade_b) {
					continue;
				}
				answer++;
				grade_a = next.a;
				grade_b = next.b;
				
			}
			System.out.println(answer);
		}
	}

	private static class grade {
		int a, b;

		public grade(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
