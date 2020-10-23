package graph;

/*
 * 공항
 * Disjoint 문제 (Union-find)

 */
import java.util.*;
import java.io.*;

public class problem_10775 {
	static int G, P, parent[] ;
	public static void main(String []args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine()) + 1;
		P = Integer.parseInt(br.readLine());
		
		parent=  new int[G];
		
		for(int i =1 ; i < G ; i++) parent[i] = i;
		
		Queue<Integer> q = new LinkedList<>();
		for(int i =0 ; i < P ; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		
		union_find(q);
	}
	
	private static void union_find(Queue<Integer> q) {
		int count = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			int p = find(cur); //현재 남은 공항의 게이트를 찾는다.
			
			if(union(p,p-1)) {
				count++;
			}else //게이트에 비행기를 둘 수 없으면 바로 종료시킨다.
				break;
		}
		
		System.out.println(count);
	}

	private static boolean union(int c1, int c2) {
		if(c2 < 0) //공항의 게이트의 넘버가 음수인 경우, 더 이상 남은 게이트가 존재하지 않는다는 의미이다.
			return false;
		
		int p1 = find(c1);
		int p2 = find(c2);
		
		
		if(p1 > p2)
			parent[p1] = p2;
		else
			parent[p2] = p1;
		
		
		return true;
	}
	
	private static int find(int c) {
		if(c == parent[c])
			return c;
		else
			return parent[c] = find(parent[c]);
	}
}
