package dijkstra;
//알고스팟

import java.util.*;
import java.io.*;
public class problem_1261 {
	static int rl[] = {0,1,0,-1};
	static int ud[] = {-1,0,1,0};
	static int[][] dist; //벽의 개수를 담고 있는 이차원 배열
	static int INF = Integer.MAX_VALUE;
	static int N= 0 , M = 0;
	static BufferedReader br;
	public static void main(String[] args) {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		try {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //세로 크기
			N = Integer.parseInt(st.nextToken()); //가로 크기
			
			int small = dijkstra(0,0);
			br.close();
			System.out.println(small);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	private static int dijkstra(int x,int y) throws IOException {
		dist = new int[N][M]; //벽의 최소 갯수를 담는 이차원 배열
		int map [][] = new int[N][M];//탐색을 진행할 맵
		
		for(int i =0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			for(int j =0 ; j< tmp.length() ; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		for(int [] t : dist) {
			Arrays.fill(t, INF);
		}
		dist[x][y] = 0; //시작 지점
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) { //벽을 대상으로 오름차순 정렬
				// TODO Auto-generated method stub
				if(arg0.wall < arg1.wall)
					return -1;
				else
					return 1;
			}
			
		});
		
		pq.add(new Node(x,y,0));
		
		while(!pq.isEmpty()) {
			Node c = pq.poll();
			int cx = c.x;
			int cy = c.y;
			
			for(int i =0 ; i< 4;  i++) {
				int nx = cx + ud[i];
				int ny = cy + rl[i];
				
				if(nx < 0|| ny < 0 || nx >= N || ny >= M) //범위를 벗어나면
					continue;
				
				if(dist[nx][ny] > dist[cx][cy] + map[nx][ny]) {
					dist[nx][ny] = dist[cx][cy] + map[nx][ny];
					pq.add(new Node(nx,ny,dist[nx][ny]));
				}
			}
			
		}
		
		return dist[N-1][M-1];
		
	}
	private static class Node{
		int x,y, wall;
		public Node(int x,int y,int wall) {
			this.x =x;
			this.y =y;
			this.wall = wall;
		}
	}
}
