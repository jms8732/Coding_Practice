package samsung;

//이차원 배열과 연산
import java.util.*;
import java.io.*;

public class problem_17140 {
	static int r, c, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[][] array = new int[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		while (time <= 100) {
			print(array);

			if (is_val(array)) {
				System.out.print(time);
				System.exit(0);
			}

			array = simulation(array);
			time++;
		}

		System.out.println(-1);
	}

	private static boolean is_val(int[][] array) {
		int row = array.length;
		int col = array[0].length;

		if (r - 1 < 0 || r - 1 >= row || c - 1 < 0 || c - 1 >= col || array[r - 1][c - 1] != k)
			return false;

		return true;
	}

	private static int[][] simulation(int[][] array) {
		int row_len = array.length;
		int col_len = array[0].length;
		boolean op = false;
		List<List<Node>> total = new ArrayList<>();
		if (row_len >= col_len) {
			// R연산
			op = true;
			for (int[] tmp : array) {
				sort(total, tmp);
			}
			array = make_array(total, op);
		} else {
			// C연산
			op = false;
			for (int i = 0; i < array[0].length; i++) {
				int size = array.length;
				int tmp[] = new int[size];

				for (int j = 0; j < size; j++) {
					tmp[j] = array[j][i];
				}

				sort(total, tmp);
			}

			array = make_array(total, op);
		}

		total.clear();

		return array;
	}

	private static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int[][] make_array(List<List<Node>> total, boolean op) {
		int size = 0;
		for (List<Node> l : total)
			size = Math.max(size, l.size());

		int[][] array;
		if (op) {
			// R연산인 경우
			int row = total.size();
			int col = 100;

			if (size * 2 < 100)
				col = size * 2;

			array = new int[row][col];

			for (int i = 0; i < total.size(); i++) {
				int idx = 0;
				for (int j = 0; j < total.get(i).size(); j++) {
					array[i][idx++] = total.get(i).get(j).val;
					array[i][idx++] = total.get(i).get(j).count;
				}
			}
		} else {
			int row = 100;
			int col = total.size();

			if (size * 2 < 100)
				row = size * 2;

			array = new int[row][col];

			for (int i = 0; i < total.size(); i++) {
				int idx = 0;
				for (int j = 0; j < total.get(i).size(); j++) {
					array[idx++][i] = total.get(i).get(j).val;
					array[idx++][i] = total.get(i).get(j).count;
				}
			}
		}

		return array;
	}

	private static void sort(List<List<Node>> total, int[] tmp) {
		boolean[] visited = new boolean[tmp.length];

		List<Node> tmp_list = new ArrayList<>();
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i] && tmp[i] != 0) {
				visited[i] = true;
				int count = 1;
				for (int j = i + 1; j < visited.length; j++) {
					if (tmp[i] == tmp[j]) {
						visited[j] = true;
						count++;
					}
				}

				tmp_list.add(new Node(count, tmp[i]));
			}
		}

		Collections.sort(tmp_list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.count < o2.count)
					return -1;
				else if (o1.count == o2.count) {
					if (o1.val < o2.val)
						return -1;
					else
						return 1;
				} else
					return 1;
			}

		});

		total.add(tmp_list);
	}

	private static class Node {
		int count, val;

		public Node(int c, int v) {
			this.count = c;
			this.val = v;
		}
	}
}
