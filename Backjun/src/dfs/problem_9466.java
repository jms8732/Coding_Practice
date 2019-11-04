package dfs;
import java.util.*;

public class problem_9466 {
	static int[] student;
	static boolean[] visited;
	static boolean[] finished;
	static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalRound = scanner.nextInt();

		for (int i = 0; i < totalRound; i++) {
			int size = scanner.nextInt();
			student = new int[size + 1]; // 사이즈 설정
			visited = new boolean[size + 1];
			finished = new boolean[size + 1];
			Arrays.fill(visited, false);
			Arrays.fill(finished, false);
			for (int j = 1; j <= size; j++) {
				student[j] = scanner.nextInt(); // 번호 부여
			}
			for (int j = 1; j <= size; j++) {
				if (!visited[j])
					DFS(j);
			}
			System.out.println(student.length -1 - count);
			count = 0;
		}
	}

	static void DFS(int idx) {
		int tmp = student[idx];

		visited[idx] = true;
		if (visited[tmp] == true) {
			if (!finished[tmp]) {
				for(int temp = tmp ; temp != idx ; temp=student[temp])
					count++; //순환 하면서 카운트
				count++;
			}
		} else
			DFS(tmp);
		finished[idx] = true;

	}
}
