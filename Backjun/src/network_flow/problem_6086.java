package network_flow;

//�ִ� ����
import java.util.*;
import java.io.*;

public class problem_6086 {
	static int d[], f[][], c[][];
	static List<Integer> link[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// �ʱ�ȭ
		link = new ArrayList[52];
		d = new int[52];
		f = new int[52][52];
		c = new int[52][52];

		for (int i = 0; i < 52; i++)
			link[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = convert(st.nextToken().charAt(0));
			int e = convert(st.nextToken().charAt(0));

			int cc = Integer.parseInt(st.nextToken());
			link[s].add(e);
			link[e].add(s);

			c[s][e] += cc;
		}

		maxFlow(0, 25);
	}

	private static int convert(char a) {
		if (a >= 'A' && a <= 'Z')
			return a - 'A';
		else
			return 26 + a - 'a';
	}

	private static void maxFlow(int start, int end) {
		int result = 0;
		int INF = 100000000;
		while (true) {
			Arrays.fill(d, -1);
			Queue<Integer> q = new LinkedList<>();
			q.add(start);

			// BFS�� �����ϸ鼭 ����� �������� ã�´�.
			while (!q.isEmpty()) {
				int cur = q.poll();

				// ���� ����� ������ ã�´�.
				for (int next : link[cur]) {
					// �뷮 - ������ ����̸鼭 ���ÿ� ���� ������ �湮���� �ʾ��� ���
					if (c[cur][next] - f[cur][next] > 0 && d[next] == -1) {
						d[next] = cur; // ���� ��ǥ ����
						q.add(next);
						if (d[next] == end)
							break;
					}
				}
			}

			// ��� ������ �湮�� ���
			if (d[end] == -1)
				break;

			int flow = INF;
			for (int i = end; i != start; i = d[i]) {
				flow = Math.min(flow, c[d[i]][i] - f[d[i]][i]);
			}

			for (int i = end; i != start; i = d[i]) {
				f[d[i]][i] += flow;
				f[i][d[i]] -= flow;
			}

			result += flow;
		}

		System.out.println(result);
	}

}
