package dp;

/*
 * ����
 * ��Ʈ + ���̳��� ���α׷���
 */
import java.util.*;
import java.io.*;

public class problem_1014 {
	static int[][] cache;
	static char[][] class_room;
	static List<Node> bit; // ��Ʈ�� �� ������ �����ϴ� Node Ŭ������ ������ ����Ʈ

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		bit = new ArrayList<>();
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			cache = new int[N][1 << M];
			class_room = new char[N][M];

			init(M);

			// �� �ʱ�ȭ
			for (int j = 0; j < N; j++) {
				String temp = br.readLine();
				for (int k = 0; k < M; k++) {
					class_room[j][k] = temp.charAt(k);
				}
			}

			bw.write(dp(N, M) + "\n");
			bit.clear(); //M�� ũ���� 1�� �������� ���� ��Ʈ���� �����Ѵ�.
		}

		bw.flush();
	}

	//�������� ����� �����ϴ� �޼ҵ�
	private static int dp(int N, int M) {
		int ret = 0;

		// 1�� ���� �������� ���� ��Ʈ���� ������� ���� ��Ʈ�� �´� ���� ����
		for (Node node : bit) {
			if (!seat_possible(node.bit, 0, M))
				continue;
			
			cache[0][node.bit] = node.count;
			ret = Math.max(ret, cache[0][node.bit]); //N�� 1�� ��쵵 ������ �� �ֱ� ������ ��ȯ���� ū ���� �Ҵ��Ѵ�.
		}
		
		
		for (int i = 1; i < N; i++) {
			for (Node nex : bit) {
				if (!seat_possible(nex.bit, i, M))
					continue;

				for (Node pre : bit) {
					if (below_side(M, pre.bit, nex.bit)) {
						cache[i][nex.bit] = Math.max(cache[i][nex.bit], cache[i - 1][pre.bit] + nex.count);
						ret = Math.max(ret, cache[i][nex.bit]);
					}
				}
			}
		}

		return ret;
	}

	// �ڸ��� �������� �Ǵ��ϴ� �޼ҵ�
	private static boolean seat_possible(int bit, int idx, int M) {
		for (int i = 0; i < M; i++) {
			if (class_room[idx][i] == 'x' && (bit & 1 << i) == 1 << i) { // ���� �࿡ �����ϴ� ���� ���� x������ ��Ʈ�� 1�� ���
				return false;
			}
		}

		return true;
	}

	// �밢���� �Ǵ��ϴ� �޼ҵ�
	private static boolean below_side(int M, int pre_bit, int cur_bit) {
		for (int i = 0; i < M; i++) {
			if ((pre_bit & 1 << i) == 1 << i) { // ���� ��Ʈ�� 1��Ʈ�� �����ϴ� ��ġ
				int left = i - 1;
				int right = i + 1;

				if (left >= 0) { // ������ ������ �����ϸ鼭 ���� ��Ʈ�� ���� 1�� ���
					if ((cur_bit & 1 << left) == 1 << left)
						return false;
				}

				if (right < M) { // �������� ������ �����ϸ鼭 ���� ��Ʈ�� ���� 1�� ���
					if ((cur_bit & 1 << right) == 1 << right) {
						return false;
					}
				}
			}
		}

		return true;
	}

	// �������� �ʴ� ��Ʈ��� ������ ����Ʈ�� ����� ��ó�� �޼ҵ�
	private static void init(int M) {
		for (int i = 0; i < 1 << M; i++) {
			if (adj(M, i))
				bit.add(new Node(i, Integer.bitCount(i)));
		}
	}

	// 1��Ʈ�� ���� �������� �������� Ȯ���ϴ� �޼ҵ�
	private static boolean adj(int M, int bit) {
		for (int i = 0; i < M; i++) {
			if ((bit & 1 << i) == 1 << i) { // ���� ��ġ�� 1��Ʈ�� ���
				int left = i - 1;
				int right = i + 1;

				// ���� �������� �����ϰ�
				if (left >= 0) {
					if ((bit & 1 << left) == 1 << left) // ���ʿ� 1��Ʈ�� �����Ѵٸ�
						return false;
				}

				// ������ �������� �����ϰ�
				if (right < M) {
					if ((bit & 1 << right) == 1 << right) // �����ʿ� 1��Ʈ�� �����Ѵٸ�
						return false;
				}
			}
		}

		return true;
	}

	// ��Ʈ�� ������ �����ϴ� Node Ŭ����
	private static class Node {
		int bit;
		int count;

		public Node(int b, int c) {
			this.bit = b;
			this.count = c;
		}
	}
}
