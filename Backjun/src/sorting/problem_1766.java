package sorting;

//문제집
import java.util.*;
import java.io.*;

public class problem_1766 {
	static int[] indegree;
	static List<Integer> list[];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		indegree = new int[N];

		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;

			list[start].add(end);
		}

		topology_sort();
	}

	private static void topology_sort() {
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				indegree[list[i].get(j)] += 1;
			}
		}

		int[] answer = new int[indegree.length];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		// 진입 차수가 0인 지점의 인덱스를 넣는다.
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		// 정점의 개수만큼 반복을 수행한다.
		for (int i = 0; i < indegree.length; i++) {
			if (queue.isEmpty())
				break;
			int current = queue.poll();
			answer[i] = current+1;

			//들어가는 간선을 삭제한 후, 진입차수가 0인 부분이 존재할 경우
			for (int j = 0; j < list[current].size(); j++) {
				int next = list[current].get(j);
				indegree[next] -= 1;
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		for(int i =0 ; i< answer.length ; i++)
			System.out.print(answer[i] + " ");
	}
}
