package programmers2;

import java.util.*;

/*
 * 삼각 달팽이
 * 구현(시뮬레이션) 유형 문제
 * 2차원 배열을 선언할 떄, 열은 선언하지 않는다. => 배열을 삼각형 형태로 표현하기 위해서
 * 
 */
public class problem_38 {
	public static void main(String[] args) {
		for (int i : solution(4)) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int n) {
		int startX = 0, startY = 0, upbound = 0, rightbound = 0;

		int[][] slug = new int[n][];
		int zero = 0; //현재 배열에 채워지지 않은 공간을 센다.

		// 삼각형 형태로 배열을 생성한다.
		int size = 1;
		for (int i = 0; i < slug.length; i++) {
			zero += size;
			slug[i] = new int[size++];
		}

		int number = 0;
		while (true) {
			// 위에서 아래 방향
			while (startX < n) {
				slug[startX++][startY] = ++number;
				zero--;
			}
			n--;
			startX--;

			if (zero == 0)
				break;

			// 바닥면 채우기
			startY++;
			rightbound++;
			while (startY < slug[startX].length - rightbound) {
				slug[startX][startY++] = ++number;
				zero--;
			}

			if (zero == 0)
				break;

			//아래에서 위 방향
			while (startX > upbound) {
				slug[startX--][startY--] = ++number;
				zero--;
			}
			
			startY++;
			startX += 2;
			upbound = startX;

			if (zero == 0)
				break;
		}

		List<Integer> list = new ArrayList<>();
		for (int[] i : slug) {
			for (int k : i)
				list.add(k);
		}

		int[] ret = new int[list.size()];

		int idx = 0;
		for (int i : list)
			ret[idx++] = i;

		return ret;
	}
}
