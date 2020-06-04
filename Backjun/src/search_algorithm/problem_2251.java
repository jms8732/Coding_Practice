package search_algorithm;

//π∞≈Î
import java.util.*;
import java.io.*;

public class problem_2251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		pour_water(A,B,C);
	}

	private static void pour_water(int A, int B ,int C) {
		Queue<Node> q = new LinkedList<>();
		boolean [][][] visited =new boolean[201][201][201];
		
		int [] cup_capacity = {A,B,C};
		
		int [] cup = {0,0,C};
		q.add(new Node(cup));
		visited[0][0][C]= true;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.cup[0] == 0) {
				pq.add(cur.cup[2]);
			}
			
			int tmp []= new int[3];
			
			for(int i= 0 ; i < 3; i++) {
				for(int j =0 ; j< 3;  j++) {
					if(i!=j && cur.cup[i] != 0) {
						System.arraycopy(cur.cup, 0, tmp, 0, 3);
						tmp[j] += tmp[i];
						tmp[i] = 0;
						
						if(tmp[j] > cup_capacity[j]) {
							int overflow = tmp[j] - cup_capacity[j];
							tmp[i] += overflow;
							tmp[j] = cup_capacity[j];
						}
						
						if(!visited[tmp[0]][tmp[1]][tmp[2]]) {
							visited[tmp[0]][tmp[1]][tmp[2]] = true;
							q.add(new Node(tmp));
						}
					}
				}
			}
		}
		
		while(!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
		
	}

	private static class Node {
		int[] cup;

		public Node(int [] c) {
			this.cup = new int[3];
			System.arraycopy(c, 0, this.cup, 0, c.length);
		}
	}
}
