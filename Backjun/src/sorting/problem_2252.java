package sorting;

//줄 세우기
import java.util.*;
import java.io.*;

public class problem_2252 {
	static List<Integer> list[];
	static int [] indegree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		indegree =new int[N];
		
		for(int i = 0 ; i < list.length ; i++) list[i] = new ArrayList<>();
		
		for(int i =0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			
			list[start].add(end);
		}
		
		topology_sort();
	}
	private static void topology_sort() {
		for(int i =0  ; i< list.length ; i++) {
			for(int j =0 ; j < list[i].size() ; j++) {
				indegree[list[i].get(j)] += 1;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i =0 ; i< indegree.length ; i++) {
			if(indegree[i] == 0)
				queue.add(i);
		}
		
		int [] answer = new int[list.length];
		
		for(int i =0 ; i< list.length ; i++) {
			if(queue.isEmpty())
				break;
			int current = queue.poll();
			answer[i] = current+1;
			
			for(int j = 0 ; j< list[current].size() ; j++) {
				int next = list[current].get(j);
				indegree[next] -=1;
				
				if(indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		for(int i : answer) {
			System.out.print(i + " ");
		}
	}
}
