package search_algorithm;

/*
 * 0과 1
 * BFS + mod 을 이용해서 문제를 해결한다.
 * 
 */
import java.util.*;
import java.io.*;

public class problem_8111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(br.readLine());
			bw.write(bfs(target) + "\n");
		}

		bw.flush();
	}

	private static String bfs(int mod) {
		Queue<Node> q = new LinkedList<>();
		boolean [] visited = new boolean[20001]; //중복된 연산을 방지하기 위해서 진행
		q.add(new Node("1",1));
		visited[1] = true;
		
		String ret = null;
		while (!q.isEmpty()) {
			Node cur  = q.poll();
			
			int z = (cur.mod*10) % mod;
			String zt = cur.target + "0"; //이전에 만들어진 몫에 10을 곱한 후, mod 연산 진행
			
			int o = (cur.mod*10 + 1) % mod;
			String ot = cur.target + "1";
			
			if(z == 0) {
				ret = zt;
				break;
			}
			
			if(o == 0) {
				ret = ot;
				break;
			}
			
			//길이가 100 초과인 경우
			if(cur.target.length() > 100) {
				ret= "BRAK";	
				break;
			}
			
			if(!visited[z]) {
				//아직 방문하지 않은 경우
				visited[z] = true;
				q.add(new Node(zt,z));
			}
			
			if(!visited[o]) {
				visited[o] = true;
				q.add(new Node(ot,o));
			}
			
		}

		return ret;
	}

	private static class Node {
		String target;
		int mod;

		public Node(String t, int m) {
			this.target = t;
			this.mod = m;
		}
	}
}
