package bruteforce;

//소풍
import java.util.*;
import java.io.*;

public class picnic {
	static List<Integer>[] link;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			link = new ArrayList[N];

			// 친구간의 연결된 것을 표시하기 위한 리스트 배열
			for (int j = 0; j < N; j++)
				link[j] = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				// 친구간의 방향성이 없으므로 양방향으로 연결한다.
				link[s].add(e);
				link[e].add(s);
			}

			int count = 0;
			int [] friend = new int[N];
			Arrays.fill(friend, -1);
			count = find(friend);
			System.out.println(count);
		}
	}
	
	
	private static int find(int[] friend) {
		
		int f = -1;
		//아직 매칭되지 않은 친구를 찾는다.
		for(int i =0 ; i < friend.length ; i++) {
			if(friend[i] == -1) {
				f = i ;
				break;
			}
		}
		
		//다 매칭이 되었으면 1을 반환한다.
		if(f == -1)
			return 1;
		
		int count = 0;
		
		//친구 매칭을 한다.
		for(int next : link[f]) {
			if(friend[next] == -1) {
				friend[f] = next;
				friend[next] = f;
				count += find(friend);
				
				friend[f] = -1;
				friend[next] = -1;
			}
		}
		
		return count;
	}

}
