package greedy;

//센서
import java.util.*;
import java.io.*;

public class problem_2212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] sensor = new int[N];

		for (int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		if (K < N) {
			// 오름차순으로 정렬
			Arrays.sort(sensor);

			int[] diff = new int[N - 1];

			// 구간 거리 계산
			for (int i = 1; i < N; i++) {
				diff[i - 1] = sensor[i] - sensor[i - 1];
			}

			Arrays.sort(diff);
			for (int i = 0; i < diff.length - (K - 1); i++) {
				answer += diff[i];
			}
			System.out.println(answer);
		} else
			System.out.println(answer);
	}
}
