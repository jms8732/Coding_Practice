package dijkstra;

//최단 경로
import java.util.*;
import java.io.*;

public class problem_1753 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[] dist = null; // 각 v마다 가지고 있는 최소 거리
		int INF = Integer.MAX_VALUE; // 최대 값
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if (arg0.weight < arg1.weight) // 가중치 오름차순
					return -1;
				else
					return 1;
			}

		});
		int v = 0, e = 0, start = 0;
		List<Node> list[] = null; // 인접행렬을 표현하기 위한 배열

		try {
			st = new StringTokenizer(br.readLine()); // 한줄을 읽는다.
			v = Integer.parseInt(st.nextToken()); // v
			e = Integer.parseInt(st.nextToken()); // e
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken()) - 1; // 시작 노드

			list = new ArrayList[v];
			for (int i = 0; i < v; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine()); // 한줄씩 읽어온다.
				int s = Integer.parseInt(st.nextToken()) - 1; // 시작점
				int f = Integer.parseInt(st.nextToken()) - 1;// 끝점
				int w = Integer.parseInt(st.nextToken()); // 가중치
				
				list[s].add(new Node(f,w));
			}
			br.close();

			queue.add(new Node(start, 0));
			dist = new int[v]; // v의 개수 만큼 배열 생성
			Arrays.fill(dist, INF); // INF 설정
			dist[start] = 0;
			
			while (!queue.isEmpty()) {
				Node current = queue.poll();
				for (Node n : list[current.cur]) {
					if(dist[n.cur] > (dist[current.cur] + n.weight)) {
						dist[n.cur] =  dist[current.cur] + n.weight;
						queue.add(new Node(n.cur, dist[n.cur]));
					}
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < dist.length; i++) {
			if (dist[i] == INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}

	private static class Node {
		int cur, weight;

		public Node(int cur, int weight) {
			this.cur = cur;
			this.weight = weight;
		}
	}
}
