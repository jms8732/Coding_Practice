package sorting;

//ACM Craft
import java.util.*;
import java.io.*;

public class problem_1005 {
	static int[] indegree;
	static int[] time;
	static List<Integer> list[];
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			indegree = new int[N];
			time = new int[N];
			list = new ArrayList[N];

			st = new StringTokenizer(br.readLine());
			// 초기화
			for (int j = 0; j < N; j++) {
				time[j] = Integer.parseInt(st.nextToken());
				list[j] = new ArrayList<>();
			}

			// 건물들을 연결하는 과정
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;

				list[s].add(e);
			}

			// 승리를 위해서 지어야할 건물
			int want = Integer.parseInt(br.readLine())-1;

			topology_sort(want);
		}
	}

	private static void topology_sort(int want) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		//들어오는 간선의 개수를 증가시킨다.
		for(int i =0 ; i< N ; i++) {
			for(int j = 0 ; j< list[i].size() ; j++) {
				int target = list[i].get(j);
				indegree[target]++;
			}
		}
		
		//들어오는 간선이 0인 정점을 큐에 넣는다.
		for(int i =0 ; i < N ; i++) {
			if(indegree[i] == 0)
				pq.add(new Node(i,time[i]));
		}
		
		
		//정점의 개수만큼 반복문을 수행한다.
		for(int i =0 ; i< N ; i++) {
			if(pq.isEmpty()) {
				break;
			}
			
			Node cur = pq.poll();
			int curIdx = cur.number;
			int curTime = cur.time;
			//현재 정점에서 나가는 간선을 지운다.
			for(int j = 0 ; j< list[curIdx].size() ; j++) {
				int next = list[curIdx].get(j);
				
				indegree[next]--;
				if(indegree[next] == 0) {
					time[next] += curTime;
					pq.add(new Node(next,time[next]));
				}
			}
		}
		
		System.out.println(time[want]);
	}

	// 현재 건물의 번호와 완성되는 시간을 저장하는 클래스
	private static class Node implements Comparable<Node> {
		int number;
		int time;

		public Node(int n, int t) {
			this.number = n;
			this.time = t;
		}

		// 시간을 대상으로 오름차순을 정렬한다.
		@Override
		public int compareTo(Node arg0) {
			// TODO Auto-generated method stub
			if (this.time < arg0.time) {
				return -1;
			} else
				return 1;
		}

	}
}
