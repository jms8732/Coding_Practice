package bitmask;

//링크와 스타트
import java.util.*;
import java.io.*;

public class problem_15661 {
	static int board[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		StringTokenizer st = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		makeTeam(N);
	}

	private static void makeTeam(int N) {
		int score = Integer.MAX_VALUE;

		// 두 팀의 인원수는 같지 않아도 된다.
		for (int i = 1; i < (1 << N) - 1; i++) {
			int tmp = getScore(i, N);

			score = Math.min(tmp, score);
		}

		System.out.println(score);
	}

	private static int getScore(int bit, int N) {
		boolean[] member = new boolean[N];

		int aTeam = 0, bTeam = 0;
		// 팀 만들기
		for (int i = 0; i < N; i++) {
			if ((bit & 1 << i) == 1 << i) {
				member[i] = true;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(member[i] == true && member[j] == true)
					aTeam += board[i][j];
				
				if(member[i] == false && member[j] == false)
					bTeam += board[i][j];
			}
		}

		return Math.abs(aTeam - bTeam);
	}
}
