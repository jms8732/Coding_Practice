package others;

//토너 먼트
import java.util.*;
import java.io.*;

public class problem_1057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int im = Integer.parseInt(st.nextToken());

		int round = 0;
		// 짝수 인 경우

		while (true) {
			int kim_rival = 0, im_rival = 0;
			round++;
			// 홀 수 인 경우
			if (N % 2 != 0 && (kim == N || im == N)) {
				kim = kim / 2 + kim % 2;
				im = im / 2 + im % 2;
				N = N / 2 + N %2;
				continue;
			}
			
			if (kim % 2 == 0)
				kim_rival = kim - 1;
			else
				kim_rival = kim + 1;

			if (im % 2 == 0)
				im_rival = im - 1;
			else
				im_rival = im + 1;

			if (kim_rival == im && im_rival == kim) {
				break;
			}

			kim = kim / 2 + kim % 2;
			im = im / 2 + im % 2;
			N = N / 2 + N % 2;

		}

		if (round == 0)
			System.out.println(-1);
		else
			System.out.println(round);
	}
}
