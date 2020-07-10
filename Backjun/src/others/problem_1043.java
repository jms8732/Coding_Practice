package others;

//°ÅÁþ¸»
import java.util.*;
import java.io.*;

public class problem_1043 {
	static List<Integer> adj[];
	static List<Integer> party[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < T; i++) {
			set.add(Integer.parseInt(st.nextToken())-1);
		}

		adj = new ArrayList[N];
		for (int i = 0; i < N; i++)
			adj[i] = new ArrayList<>();

		party = new ArrayList[M];
		for (int i = 0; i < M; i++)
			party[i] = new ArrayList<>();

		int answer = M;
		for (int i = 0; i < M; i++) {
			String split[] = br.readLine().split(" ");

			for(int j = 1 ; j < split.length ; j++) {
				int s = Integer.parseInt(split[j])-1;
				
				for(int k = j +1 ; k< split.length ; k++) {
					int e = Integer.parseInt(split[k])-1;
					
					adj[s].add(e);
					adj[e].add(s);
				}
			}
			for (int j = 1; j < split.length; j++)
				party[i].add(Integer.parseInt(split[j]) - 1);
		}


		boolean[] true_people = new boolean[N];
		for(int i : set) {
			if (!true_people[i])
				find_total_true_people(i, true_people);
		}

		for (int i = 0; i < M; i++) {
			for (int j : party[i]) {
				if (true_people[j]) {
					answer--;
					break;
				}
			}
		}

		System.out.println(answer);
	}

	private static void find_total_true_people(int tar, boolean[] true_people) {
		true_people[tar] = true;
		for (int i : adj[tar]) {
			if (!true_people[i])
				find_total_true_people(i, true_people);
		}
	}

}
