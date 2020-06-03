package greedy;

//한줄로 서기
import java.util.*;
import java.io.*;

public class problem_1138 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] left_count = new int[N];
		List<Integer> people = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			left_count[i] = Integer.parseInt(st.nextToken());
			people.add(i);
		}
		permutation(0, N, people, left_count);
	}

	private static void permutation(int depth, int N, List<Integer> people, int[] left_count) {
		if (depth == N) {
			if (check(people,left_count)) {
				for (int i : people) {
					System.out.print((i + 1) + " ");
				}
				System.exit(0);
			}

			return;
		}

		for (int i = depth; i < N; i++) {
			swap(depth, i, people);
			permutation(depth + 1, N, people, left_count);
			swap(i, depth, people);
		}
	}
	
	private static boolean check(List<Integer> people, int [] left_count) {
		
		for(int i =0 ; i < left_count.length ; i++) {
			int cur_people = people.get(i);
			int count =0;
			for(int j = i -1 ; j >= 0 ; j--) {
				if(cur_people < people.get(j))
					count++;
			}
			
			if(count != left_count[cur_people])
				return false;
		}
		
		return true;
	}

	private static void swap(int depth, int i, List<Integer> people) {
		int tmp = people.get(depth);
		people.set(depth, people.get(i));
		people.set(i, tmp);
	}
}
