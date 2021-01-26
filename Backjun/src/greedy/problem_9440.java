package greedy;

/*
 * 숫자 더하기
 * 1. 우선순위 큐를 이용하여 입력되는 숫자를 내림차순으로 정렬
 * 2. 정렬된 값을 가지고 홀수인지 짝수인지 구분하여 알고리즘을 진행
 */
import java.util.*;
import java.io.*;

public class problem_9440 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;

			for (int i = 0; i < N; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}

			if (pq.size() % 2 == 0) {
				// 짝수인 경우
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();

				boolean sw = true;
				while (!pq.isEmpty()) {
					if (sw)
						sb1.insert(0, pq.poll());
					else
						sb2.insert(0, pq.poll());

					sw = !sw;
				}

				char[] temp1 = sb1.toString().toCharArray();
				char[] temp2 = sb2.toString().toCharArray();

				if (temp1[0] == '0')
					swap(temp1);

				if (temp2[0] == '0')
					swap(temp2);

				System.out.println(Integer.parseInt(String.valueOf(temp1)) + Integer.parseInt(String.valueOf(temp2)));
			} else {
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();

				boolean sw = true;
				while (pq.size() != 1) {
					if (sw)
						sb1.insert(0, pq.poll());
					else
						sb2.insert(0, pq.poll());

					sw = !sw;
				}

				char[] temp1 = sb1.toString().toCharArray();
				char[] temp2 = sb2.toString().toCharArray();

				if (temp1[0] == '0')
					swap(temp1);

				if (temp2[0] == '0')
					swap(temp2);

				int tar1 = Integer.parseInt(String.valueOf(temp1));
				int tar2 = Integer.parseInt(String.valueOf(temp2));

				if (tar1 > tar2) {
					if (pq.peek() == 0)
						sb2.insert(1, pq.poll());
					else
						sb2.insert(0, pq.poll());
				} else {
					if (pq.peek() == 0)
						sb1.insert(1, pq.poll());
					else
						sb1.insert(0, pq.poll());
				}

				temp1 = sb1.toString().toCharArray();
				temp2 = sb2.toString().toCharArray();

				if (temp1[0] == '0')
					swap(temp1);

				if (temp2[0] == '0')
					swap(temp2);

				System.out.println(Integer.parseInt(String.valueOf(temp1)) + Integer.parseInt(String.valueOf(temp2)));

			}
		}
	}

	private static void swap(char[] array) {
		char temp = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] != '0') {
				array[0] = array[i];
				array[i] = temp;
				break;
			}
		}
	}
}
