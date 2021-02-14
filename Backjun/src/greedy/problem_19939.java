package greedy;

//박 터트리기
import java.util.*;

public class problem_19939 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N <= K)
			System.out.println(-1);
		else {
			int c = 1;
			while (N > 0 && K > 0) {
				N -= c++;
				K--;
			}
		}
	}
}
