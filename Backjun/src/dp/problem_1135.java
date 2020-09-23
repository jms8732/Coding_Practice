package dp;

/*
 * 뉴스 전하기
 * 
 * DP + Tree 를 이용한 문제
 * 메모이제이션을 할 값은 현재 직원의 최소 시간을 저장한다.
 * list를 이용하여 반환된 값을 저장하는 이유는 내림차순으로 정렬하기 위함이다.
 *  => 내림차순으로 정렬하는 이유는 시간의 최솟값을 구하기 위해서이다.
 *  
 * 내림차순으로 정렬된 후, 반복문을 통해서 i+1를 진행하는 이유는 현재 상사와 부하간의 관계에서 시간을 더하기 위함이다.
 *
 */
import java.util.*;
import java.io.*;

public class problem_1135 {
	static List<Integer> adj[];
	static int[] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		cache = new int[N];
		Arrays.fill(cache, -1);

		adj = new ArrayList[N];
		for (int i = 0; i < N; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int supper = Integer.parseInt(st.nextToken());

			if (supper != -1) {
				adj[supper].add(i);
			}
		}

		System.out.println(dp(0));
	}

	private static int dp(int current) {
		if (adj[current].isEmpty()) //직속 부하가 없는 경우
			return cache[current] = 0;

		int ret = cache[current];

		List<Integer> temp = new ArrayList<>();
		for (int child : adj[current]) {
			temp.add(dp(child));
		}
		
		Collections.sort(temp,Collections.reverseOrder());
		
		for(int i =0 ; i < temp.size() ; i++) {
			ret = Math.max(ret, temp.get(i) + i + 1);
		}
		return cache[current] = ret;
	}
}
