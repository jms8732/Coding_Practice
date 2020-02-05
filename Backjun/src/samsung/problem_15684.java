package samsung;

//��ٸ� ����
import java.util.*;
import java.io.*;

public class problem_15684 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		List<List<Integer>> map[][] = new ArrayList[H][N];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int row1 = Integer.parseInt(st.nextToken()) - 1;
			int col1 = Integer.parseInt(st.nextToken()) - 1;
			int col2 = col1 + 1;

			List<Integer> tmp = new ArrayList<>();
			tmp.add(col1);
			tmp.add(col2);

			map[row1][col1].add(tmp);

			List<Integer> tmp1 = new ArrayList<>();
			tmp1.add(col2);
			tmp1.add(col1);
			map[row1][col2].add(tmp1);
		}
		int depth = 0;
		for (int i = 0; i <= 3; i++) {
			dfs(depth,0, i, map);
		}
		System.out.println(-1);
	}

	private static void dfs(int depth, int next, int size, List<List<Integer>>[][] map) {
		if (depth == size) {
			if(go_down(map)) {
				//ã�� ���
				System.out.println(depth);
				System.exit(0);
			}
			return;
		}

		for (int i = next; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (j + 1 >= map[i].length)
					continue;

				if (map[i][j].isEmpty() && map[i][j + 1].isEmpty()) {
					// �Ѵ� ����� ���
					List<Integer> tmp = new ArrayList<>();
					tmp.add(j);
					tmp.add(j + 1);

					map[i][j].add(tmp);

					List<Integer> tmp1 = new ArrayList<>();
					tmp1.add(j + 1);
					tmp1.add(j);
					map[i][j + 1].add(tmp1);

					dfs(depth + 1,next, size, map);

					map[i][j].clear();
					map[i][j + 1].clear();

				}
			}
		}
	}

	private static boolean go_down(List<List<Integer>>[][] map) {
		boolean answer= true;
		for (int i = 0; i < map[0].length; i++) {
			int col = i;
			int row =0;
			while (row < map.length) {
				if(!map[row][col].isEmpty()){
					col = map[row][col].get(0).get(1);
				}
				row++;
			}
			
			if(col != i) //�����Դµ� i != i �ΰ��
				return !answer;
		}
		return answer;
	}
}
