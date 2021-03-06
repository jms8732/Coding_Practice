package sorting;

//음악 프로그램
import java.util.*;
import java.io.*;

public class problem_2623 {
	public static void main(String[] args) {
		List<Integer> list[] = null;
		int[] indegree = null;
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt() +1;
		int M = scanner.nextInt();

		list = new ArrayList[N];
		indegree = new int[N];

		for (int i = 1; i < N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int k = scanner.nextInt();

			int start = scanner.nextInt();

			for (int l = 0; l < k - 1; l++) {
				int end = scanner.nextInt();
				list[start].add(end);
				start = end;
			}
		}

		topology_sort(list, indegree);
	}

	private static void topology_sort(List<Integer>[] list, int[] indegree) {

		// 진입차수를 구하는 과정
		for (int i = 1; i < list.length; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				indegree[list[i].get(j)] += 1;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean check = false;
		int[] answer = new int[indegree.length];

		for (int i = 1; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.add(i);
		}

		// 위상 정렬
		if (!queue.isEmpty()) {
			for (int i = 1; i < indegree.length; i++) {
				if (queue.isEmpty()) {
					check = true;
					break;
				}

				
				int current = queue.poll();
				answer[i] = current;

				for (int j = 0; j < list[current].size(); j++) {
					int next = list[current].get(j);
					indegree[next] -= 1;

					if (indegree[next] == 0) {
						queue.add(next);
					}
				}
			}
		}else
			check = true;
		
		if (!check) {
			for(int i = 1 ; i < answer.length ; i++){
				System.out.println(answer[i]);
			}
		} else
			System.out.println(0);
	}
}
