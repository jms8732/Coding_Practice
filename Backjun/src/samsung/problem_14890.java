package samsung;

//����
import java.util.*;
import java.io.*;

public class problem_14890 {
	static int N, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulation(map);
	}

	private static void simulation(int[][] map) {
		// ����
		int answer = 0;
		for (int[] m : map) {
			if(isRoad(m))
				answer++;
		}
		
		for(int i =0; i < N ; i++) {
			int [] m = new int[N];
			for(int j =0 ; j < N ; j++) {
				m[j] = map[j][i];
			}
			
			if(isRoad(m))
				answer++;
		}
		
		System.out.println(answer);
	}

	private static boolean isRoad(int[] road) {
		int cur_height = road[0];
		boolean [] check = new boolean[road.length];
		
		for (int i = 1; i < road.length; i++) {
			if(cur_height == road[i])
				continue;
			
			if (cur_height < road[i]) {
				// ���� ���̺��� ���� ���̰� ���� ���
				if (road[i] - cur_height == 1) {
					// ���� ���̰� 1�� ���
					int count = 0;
					for(int j = 1 ; j <= L ; j++) {
						if(i-j >= 0 && !check[i-j] && road[i-j] == cur_height) {
							check[i-j] = true;
							count++;
						}
					}
					// ���ӵ� ���̰� L�� �ƴ� ���
					if (count != L)
						return false;

					cur_height = road[i];
				} else
					return false;
			} else {
				// ���� ���̰� ���� ���̺��� ���� ���
				if (cur_height - road[i] == 1) {
					int count = 0;
					for(int j = 0; j < L ; j++) {
						if(i+j < road.length && !check[i+j] && road[i+j] == road[i]) {
							check[i+j] = true;
							count++;
						}
					}
					
					if(count != L)
						return false;
					
					cur_height = road[i];
					i += L-1;
				} else
					return false;
			}
		}

		return true;
	}
}
