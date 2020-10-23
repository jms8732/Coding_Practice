package programmers2;

/*
 * 쿼드압축 후 개수 세기
 * 4등분이 되므로 재귀 함수를 이용하여 배열의 길이를 2등분씩 나눠서 진행하면 된다.
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
			// 압축이 안된 경우, 4사분면으로 나눠서 진행한다.

			// 1사분면
			dfs(arr, startX, startY + (len / 2), len / 2);

			// 2사분면
			dfs(arr, startX, startY, len / 2);

			// 3사분면
			dfs(arr, startX + (len / 2), startY, len / 2);

			// 4사분면
			dfs(arr, startX + (len / 2), startY + (len / 2), len / 2);
		} else {
			// 압축이 된 경우
			if (arr[startX][startY] == 1)
				one++;
			else
				zero++;
		}
		return;
	}

	// 범위 내 배열의 숫자가 모두 같은 지, 다른 지를 판별해주는 메소드
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
