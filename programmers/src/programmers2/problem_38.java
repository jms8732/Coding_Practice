package programmers2;

import java.util.*;

/*
 * �ﰢ ������
 * ����(�ùķ��̼�) ���� ����
 * 2���� �迭�� ������ ��, ���� �������� �ʴ´�. => �迭�� �ﰢ�� ���·� ǥ���ϱ� ���ؼ�
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
		int zero = 0; //���� �迭�� ä������ ���� ������ ����.

		// �ﰢ�� ���·� �迭�� �����Ѵ�.
		int size = 1;
		for (int i = 0; i < slug.length; i++) {
			zero += size;
			slug[i] = new int[size++];
		}

		int number = 0;
		while (true) {
			// ������ �Ʒ� ����
			while (startX < n) {
				slug[startX++][startY] = ++number;
				zero--;
			}
			n--;
			startX--;

			if (zero == 0)
				break;

			// �ٴڸ� ä���
			startY++;
			rightbound++;
			while (startY < slug[startX].length - rightbound) {
				slug[startX][startY++] = ++number;
				zero--;
			}

			if (zero == 0)
				break;

			//�Ʒ����� �� ����
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
