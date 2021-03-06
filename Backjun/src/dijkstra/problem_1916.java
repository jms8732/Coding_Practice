package dijkstra;
//최소 비용
import java.io.*;
import java.util.*;
public class problem_1916 {
	public static void main(String[] args0) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		PriorityQueue<Node> queue= new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.distance < o2.distance)
					return -1;
				else
					return 1;
			}
			
		});
		int dist[] = null;
		int INF = Integer.MAX_VALUE;
		List<Node>[] list = null; //인접 리스트
		int n =0 , m=0, start =0, end = 0; 
		try {
			st =new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); //도시의 개수
			dist = new int[n+1];
			Arrays.fill(dist, INF);
			
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); //버스의 개수
			
			list = new ArrayList[n+1]; 
			
			for(int i =1 ; i<= n ; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i =0 ; i <  m ;i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()); //시작점
				int e = Integer.parseInt(st.nextToken()); //끝점
				int w = Integer.parseInt(st.nextToken()); //가중치
				
				list[s].add(new Node(e,w));
			}
			
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			dist[start] = 0;
			
			end = Integer.parseInt(st.nextToken());
			br.close();
			queue.add(new Node(start,0)); //시작점을 우선순위 큐에 넣는다.
			
			while(!queue.isEmpty()) {
				Node tmp = queue.poll();
				int idx=  tmp.idx;
				int distance = tmp.distance;
				for(Node ne : list[idx]) {
					//해당 인덱스에 인접한 값들을 불러온다.
					int nextIdx = ne.idx;
					int nextDistance = dist[idx] + ne.distance; //거쳐 가는 경로의 비용 
					if(nextDistance < dist[nextIdx]) {
						//현재 비용보다 거쳐가는 비용이 최소 비용일 경우
						dist[nextIdx] = nextDistance;
						queue.add(new Node(nextIdx,dist[nextIdx]));
					}
					
				}
			}
			
			System.out.println(dist[end]);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	private static class Node{
		int idx =0, distance= 0;
		public Node(int i, int dist) {
			this.idx = i;
			this.distance = dist;
		}
	}
}
