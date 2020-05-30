package greedy;

//대회 or 인턴
import java.util.*;
import java.io.*;

public class problem_2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int woman = N / 2, man = M;

		int team_count = 0;
		if (woman < man) {
			team_count = woman;
			int mod = N % 2;
			K -= mod;
			K -= man - team_count;
		} else {
			team_count = man;
			int remain = (woman - team_count) * 2;
			K -= remain;
		}

		if (K <= 0)
			System.out.println(team_count);
		else {
			while (team_count >= 0) {
				K -= 3;
				team_count--;
				if (K <= 0)
					break;
			}
			System.out.println(team_count);

		}

	}
}
