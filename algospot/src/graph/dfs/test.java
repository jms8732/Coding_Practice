package graph.dfs;

//순방향, 역방향, 교차 간선 테스트

import java.util.*;

public class test {
	static List<Integer> adj [];
	static int count =0 ; //방문 순서를 표현하기 위한 변수
	static int [] discovered, finish;
	
	public static void main(String[] args) {
		adj = new ArrayList[4];
		
		for(int i = 0 ; i < 4 ; i++) adj[i] = new ArrayList<>();
		
		init();
		discovered = new int[4];
		Arrays.fill(discovered, -1);
		finish = new int[4];
		
		dfs(0);
	}
	
	private static void dfs(int cur) {
		discovered[cur] = count; //현재 방문 순서
		
		//현재 정점에 연결된 정점들 확인
		for(int next : adj[cur]) {
			//아직 방문하지 않은 정점이 발견된 경우
			if(discovered[next] == -1) {
				System.out.println("tree edge : " + cur + " --> " + next);
				count++; //순서를 늘린 뒤,
				dfs(next); //dfs 수행
			}else {
				/*
				 * 다음 정점이 방문했을 경우.
				 * 1. 현재 정점과 다음 정점의 방문 순서를 파악한다.
				 * 2. 현재 정점보다 다음 정점의 순서가 큰 경우, 순간선이다.
				 * 3. 다음 정점이 아직 종료되지 않은 상턔(dfs가 종료되지 않은 상태)이며 다음 정점의 순서가 현재 정점보다 빠른 경우, 역간선이다.
				 * 4. 2번, 3번 상황이 아닌 경우, 교차 간선이다. 
				 */
				if(discovered[cur] < discovered[next]) {
					System.out.println("forward edge : " + cur + " --> " + next);
				}else {
					if(finish[next] == 1)
						System.out.println("cross edge : " + cur + " --> " + next);
					else
						System.out.println("back edge : " + cur + " --> " + next);
						
				}
			}
		}
		
		finish[cur] = 1; //현재 정점 종료
	}
	
	private static void init() {
		adj[0].add(1);
		adj[0].add(3);
		adj[0].add(2);
		
		adj[1].add(2);
		
		adj[2].add(1);
		adj[3].add(1);
		adj[3].add(2);
		
	}
}
