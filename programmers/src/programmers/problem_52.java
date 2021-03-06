package programmers;

//정수삼각형
import java.util.*;

public class problem_52 {
	public static void main(String[] args) {
		int[][] tmp = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		int result = solution(tmp);
		System.out.println(result);
	}

	public static int solution(int[][] triangle) {
		int answer = 0;
		for (int i = 0; i < triangle.length; i++) {
			int nextIdx = i + 1;
			if (nextIdx >= triangle.length)
				break;
			int nextTmp[] = new int[triangle[nextIdx].length]; // 임시로 저장할 배열 선언
			for (int j = 0; j < triangle[i].length; j++) {
				int current = triangle[i][j]; // 현재 값
				int left = j;
				int right = j + 1;
				nextTmp[left] = Math.max(nextTmp[left], current + triangle[nextIdx][left]);
				answer = Math.max(answer, nextTmp[left]);
				nextTmp[right] = Math.max(nextTmp[right], current + triangle[nextIdx][right]);
				answer = Math.max(answer, nextTmp[right]);

			}
			System.arraycopy(nextTmp, 0, triangle[nextIdx], 0, nextTmp.length);
		}

		return answer;
	}
}
