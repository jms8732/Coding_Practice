package samsung;

//시험 감독
import java.util.*;
import java.io.*;

public class problem_13458_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] rooms = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			rooms[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int main = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());

		long answer = 0;
		for (int i = 0; i < rooms.length; i++) {
			int student = rooms[i];

			student -= main;
			answer += 1;

			if (student > 0) {
				int div = student / sub;
				int mod = student % sub;

				answer += div;

				if (mod != 0)
					answer += 1;
			}
		}

		System.out.println(answer);
	}
}
