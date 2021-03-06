package samsung_Atype;

//게리 맨더링
import java.util.*;
import java.io.*;

public class problem_17471 {
	static int value[]; // 값
	static List<Integer>[] list; // 연결된 요소
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N];
		value = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[N];

		// 연결된 요소 넣기
		for (int i = 0; i < list.length; i++)
			list[i] = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int l = 0; l < m; l++) {
				list[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}

		boolean[] count = new boolean[N];
		int c =0 ;
		for(int i =0 ; i< list.length ; i++) {
			if(!count[i]) {
				c++;
				connectCount(i,count);
			}
		}
		
		if(c <= 2) //연결된 요소가 2개 이하일 경우만 수행
			dfs(0, 0, visited);
		System.out.println(answer);
	}

	private static void connectCount(int idx, boolean[] visited) {
		visited[idx] = true;
		for(int i =0 ; i < list[idx].size() ; i++) {
			int iidx = list[idx].get(i);
			if(!visited[iidx]) {
				connectCount(iidx,visited);
			}
		}
	}

	private static int calculate(boolean[] visited) {
		int A = 0, B = 0;
		for (int i = 0; i < visited.length; i++)
			if (visited[i])
				A += value[i];
			else
				B += value[i];

		int result = Math.abs(A - B);
		return result;
	}

	
	private static void makeSet(int idx,boolean part, Set<Integer> set , boolean[] component, boolean[]visited) {
		for(int i =0 ; i< list[idx].size() ; i++) {
			int iidx = list[idx].get(i);
			if(!component[iidx] && visited[iidx] == part) {
				component[iidx] = true;
				set.add(iidx);
				makeSet(iidx,visited[iidx],set,component,visited);
			}
			
		}
	}
	
	
	private static void dfs(int depth, int next, boolean[] visited) {
		if (depth == visited.length) {
			Set<Set<Integer>> totalSet = new HashSet<>(); 
			
			boolean [] component = new boolean[visited.length];
			
			for(int i =0 ; i< component.length ; i++) {
				if(!component[i]) {
					component[i] = true;
					Set<Integer> set = new TreeSet<>();
					set.add(i);
					makeSet(i,visited[i],set,component,visited);
					totalSet.add(set);
				}
			}
			
			
			if(totalSet.size() == 2) {
				//연결과 당의 나눔이 제대로 됨
				if(answer == -1)
					answer = calculate(visited);
				else
					answer = Math.min(answer, calculate(visited));
			}
			return;
		}

		for (int i = next; i < visited.length; i++) {
			visited[i] = true;
			dfs(depth + 1, i + 1, visited);
			visited[i] = false;
			dfs(depth + 1, i + 1, visited);
		}
	}
}
