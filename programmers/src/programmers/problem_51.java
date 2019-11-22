package programmers;

import java.util.*;

//가장 먼 노드, 다익스트라 알고리즘
public class problem_51 {

	public static void main(String[] args) {
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		int result = solution(6, edge);
		System.out.println(result);
	}

	public static int solution(int n, int[][] edge) {
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.cost < o2.cost) // 거리 비용을 대상으로 오름차순 정렬
					return -1;
				else
					return 1;
			}

		});

		List<Integer>[] list = new ArrayList[n]; //인접 노드를 list로 
		int answer =0 ;
		for(int i =0  ; i < n  ;i++) list[i] = new ArrayList<>();
		
		for(int i =0 ; i< edge.length ; i++) {
			int x = edge[i][0] -1;
			int y = edge[i][1] -1;
			list[x].add(y);
			list[y].add(x);
		}
		
		int [] dist = new int[n]; //해당 노드의 거리 비용을 가지고 있는 배열
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		queue.add(new Node(0,0));
		int big =0;
		while(!queue.isEmpty()) {
			//우선순위 큐가 빌 때까지 수행
			Node tmp = queue.poll();
			for(Integer i : list[tmp.idx]) {
				//현재 연결되어 있는 노드 가져옴
				if(dist[i] == Integer.MAX_VALUE && dist[i] >= tmp.cost) {
					dist[i] = Math.min(dist[i], tmp.cost+1);
					big = Math.max(tmp.cost+1,big);
					queue.add(new Node(i,tmp.cost+1));
				}
			}
		}
		
		for(int i =0 ; i< dist.length ; i++) {
			if(big == dist[i])
				answer++;
		}
		
		return answer;

	}

	public static class Node {
		int idx, cost;

		public Node(int i, int c) {
			this.idx = i;
			this.cost = c;
		}
	}
}
