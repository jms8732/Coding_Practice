package programmers2;

/*
 * ������� �� ���� ����
 * 4����� �ǹǷ� ��� �Լ��� �̿��Ͽ� �迭�� ���̸� 2��о� ������ �����ϸ� �ȴ�.
 */

public class problem_36 {
	static int one = 0, zero = 0;

	public static void main(String[] args) {
		// int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1
		// } };

		int[][] arr = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 0, 1, 0, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 } };

		for (int i : solution(arr))
			System.out.print(i + " ");
	}

	public static int[] solution(int[][] arr) {

		int size = arr.length;
		dfs(arr, 0, 0, size);

		return new int[] { zero, one };
	}

	private static void dfs(int[][] arr, int startX, int startY, int len) {

		if (!checking(startX, startY, startX + len, startY + len, arr)) {
			// ������ �ȵ� ���, 4��и����� ������ �����Ѵ�.

			// 1��и�
			dfs(arr, startX, startY + (len / 2), len / 2);

			// 2��и�
			dfs(arr, startX, startY, len / 2);

			// 3��и�
			dfs(arr, startX + (len / 2), startY, len / 2);

			// 4��и�
			dfs(arr, startX + (len / 2), startY + (len / 2), len / 2);
		} else {
			// ������ �� ���
			if (arr[startX][startY] == 1)
				one++;
			else
				zero++;
		}
		return;
	}

	// ���� �� �迭�� ���ڰ� ��� ���� ��, �ٸ� ���� �Ǻ����ִ� �޼ҵ�
	private static boolean checking(int startX, int startY, int endX, int endY, int[][] arr) {
		boolean first = false;
		int temp = 0;
		for (int i = startX; i < endX; i++) {
			for (int j = startY; j < endY; j++) {
				if (!first) {
					first = true;
					temp = arr[i][j];
				} else {
					if (temp != arr[i][j])
						return false;
				}
			}
		}

		return true;
	}
}
