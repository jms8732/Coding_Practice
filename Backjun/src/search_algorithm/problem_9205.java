package search_algorithm;

//맥주 마시면서 걸어가기
import java.util.*;
import java.io.*;

public class problem_9205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int cc = Integer.parseInt(br.readLine());
			int[] cX = new int[cc + 1];
			int[] cY = new int[cc + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());

			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());

			for (int j = 0; j < cc; j++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				cX[j] = x;
				cY[j] = y;
			}

			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			cX[cc] = endX;
			cY[cc] = endY;

			System.out.println(simulation(startX, startY, cc, cX, cY, endX, endY));

		}
	}

	private static String simulation(int startX, int startY, int cc, int[] cX, int[] cY, int endX, int endY) {
		Queue<Status> q = new LinkedList<>();

		boolean[] visited = new boolean[cc+1];
		
		q.add(new Status(startX, startY, 20));

		while (!q.isEmpty()) {
			Status cur = q.poll();

			if (cur.x == endX && cur.y == endY) {
				return "happy";
			}

			for (int i = 0; i < cc+1; i++) {
				// 아직 방문하지 않은 편의점인 경우
				if (!visited[i]) {
					int diffX = Math.abs(cur.x - cX[i]);
					int diffY = Math.abs(cur.y - cY[i]);

					int total_diff = diffX + diffY;

					int need_beer = total_diff / 50;
					
					//나머지가 있는 경우, 맥주가 한병 더 필요
					if(total_diff % 50 != 0)
						need_beer +=1 ;

					// 현재 있는 맥주보다 필요한 맥주가 같거나 작은 경우
					if (need_beer <= cur.bottle) {
						visited[i] = true;
						q.add(new Status(cX[i], cY[i], 20)); // 편의점에서 맥주를 사든다.
					}
				}
			}
		}

		return "sad";
	}

	private static class Status {
		int x, y, bottle;

		public Status(int x, int y, int b) {
			this.x = x;
			this.y = y;
			this.bottle = b;
		}
	}
}
