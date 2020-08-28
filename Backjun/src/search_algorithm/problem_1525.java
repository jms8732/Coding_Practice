package search_algorithm;

//∆€¡Ò
import java.util.*;
import java.io.*;

public class problem_1525 {
	static final String basic = "123456780";
	static Set<String> set;
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] array = new char[9];
		int startX = 0, startY = 0;
		StringTokenizer st = null;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				char temp = st.nextToken().charAt(0);

				if (temp == '0') {
					startX = i;
					startY = j;
				}

				array[i * 3 + j] = temp;
			}
		}

		set = new HashSet<>();

		bfs(startX, startY, String.valueOf(array));
	}

	private static void bfs(int startX, int startY, String initial) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(initial, startX, startY, 0));

		set.add(initial);

		int answer = -1;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.target.equals(basic)) {
				answer = cur.cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3)
					continue;

				int i1 = cur.x * 3 + cur.y;
				int i2 = nx * 3 + ny;

				String temp = swap(i1, i2, cur.target);

				if (!set.contains(temp)) {
					set.add(temp);
					q.add(new Node(temp, nx, ny, cur.cnt + 1));
				}
			}
		}

		System.out.println(answer);
	}

	private static String swap(int i1, int i2, String target) {
		char temp[] = target.toCharArray();
		char t = temp[i1];
		temp[i1] = temp[i2];
		temp[i2] = t;

		return String.valueOf(temp);
	}

	private static class Node {
		String target;
		int x, y, cnt;

		public Node(String t, int x, int y, int c) {
			this.target = t;
			this.x = x;
			this.y = y;
			this.cnt = c;
		}
	}
}
