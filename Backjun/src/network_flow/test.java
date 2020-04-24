package network_flow;

//에드몬드 카프 알고리즘 연습
import java.util.*;

public class test {
	static List<Integer> link [] ;
	static int f[][] ,c[][] , d[];
	static int INF = 1000000;
	
	public static void main(String[] args) {
		link = new ArrayList[6];
		for(int i =0 ; i < link.length ; i++) link[i] = new ArrayList<>();
		
		link[0].add(1);
		link[1].add(0);
		
		c = new int[6][6];
		d = new int[6];
		f = new int[6][6];
		
		c[0][1]= 12;
		
		link[0].add(3);
		link[3].add(0);
		c[0][3] = 11;
		
		link[1].add(2);
		link[2].add(1);
		c[1][2]= 6;
		
		link[1].add(3);
		link[3].add(1);
		c[1][3] =3;
		
		link[1].add(5);
		link[5].add(1);
		c[1][5]=9;
		
		link[2].add(5);
		link[5].add(2);
		c[2][5]= 8;
		
		link[3].add(4);
		link[4].add(3);
		c[3][4] =9;
		
		link[4].add(2);
		link[2].add(4);
		c[4][2]=3;
		
		link[4].add(5);
		link[5].add(4);
		c[4][5] = 4;
		
		maxFlow(0,5);
		
	}
	
	private static void maxFlow(int start ,int end) {
		int result = 0;
		while(true) {
			Arrays.fill(d, -1);
			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			
			while(!q.isEmpty()){
				int cur = q.poll();
				
				for(int next : link[cur]) {
			
					//아직 방문하지 않은 곳과 용량이 유량보다 큰 곳
					if(c[cur][next] - f[cur][next] > 0 && d[next] == -1) {
						q.add(next);
						d[next] = cur;
						
						//마지막 지점인 경우 반복문을 중지한다.
						if(next == end)
							break;
					}
				}
			}
			
			//모든 경로를 방문한 경우 종료한다.
			if(d[end] == -1)
				break;
			
			int flow = INF;
			for(int i = end ; i != start ; i = d[i]) {
				flow = Math.min(flow, c[d[i]][i] - f[d[i]][i]);
			}
			
			//최소 유량만큼 추가
			for(int i = end ; i  != start ; i = d[i]) {
				f[d[i]][i] += flow;
				f[i][d[i]] -= flow;
			}
			
			result += flow;
		}
		
		System.out.println(result);
	}
}
