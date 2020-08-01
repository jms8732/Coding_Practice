package programmers2;

//알바생 강호
import java.util.*;
import java.io.*;

public class problem_34 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list, Collections.reverseOrder());

		List<Integer> choose = new ArrayList<>();
		long answer = 0;
		int rank = 1;
		for (int tip : list) {
			int temp = tip - (rank - 1);
			if (temp > 0) {
				answer += temp;
				choose.add(tip);
			} else {
				for (int i = 0; i < tip; i++) {
					long answer_temp = answer;

					int first = choose.get(i) - i;
					answer_temp -= first;

					first = tip - i;

					int second = choose.get(i) - (rank - 1);
					answer_temp += first + second;

					if (answer < answer_temp) {
						int tmp = choose.get(i);
						choose.remove(i);
						choose.add(i, tip);
						choose.add(tmp);
						break;
					}

				}
			}

			rank++;
		}

		System.out.println(answer);
	}
}
