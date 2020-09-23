package dp;

/*
 * ���� ���ϱ�
 * 
 * DP + Tree �� �̿��� ����
 * �޸������̼��� �� ���� ���� ������ �ּ� �ð��� �����Ѵ�.
 * list�� �̿��Ͽ� ��ȯ�� ���� �����ϴ� ������ ������������ �����ϱ� �����̴�.
 *  => ������������ �����ϴ� ������ �ð��� �ּڰ��� ���ϱ� ���ؼ��̴�.
 *  
 * ������������ ���ĵ� ��, �ݺ����� ���ؼ� i+1�� �����ϴ� ������ ���� ���� ���ϰ��� ���迡�� �ð��� ���ϱ� �����̴�.
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
		if (adj[current].isEmpty()) //���� ���ϰ� ���� ���
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
