package others;

/*
 * 킥다운
 * 슬라이딩 윈도우같은 형식으로 배열의 끝에서 끝으로 한칸씩 이동하면서 길이를 구한다.
 * 
 */
import java.util.*;

public class problem_1195 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String a1 = sc.nextLine();
		String a2 = sc.nextLine();

		System.out.println(simulation(a1, a2));
	}

	private static int simulation(String a1, String a2) {
		char[] a = a1.toCharArray();
		char[] b = a2.toCharArray();

		int a_idx = a.length;
		int len = a.length + b.length;

		while (a_idx >= 0) {
			int c = 0;
			int b_idx = 0;
			int start = a_idx;
			boolean check = true;
			while (start < a.length && b_idx < b.length) {
				if (a[start] == '2' && a[start] == b[b_idx]) {
					check = false;
					break;
				}

				c++;
				start++;
				b_idx++;
			}

			if (check)
				len = Math.min(len, a.length + b.length - c);
			a_idx--;
		}

		int b_idx = 1;

		while (b_idx < b.length) {
			int c = 0;
			a_idx = 0;
			int start = b_idx;
			boolean check = true;
			while (start < b.length && a_idx < a.length) {
				if (b[start] == '2' && b[start] == a[a_idx]) {
					check = false;
					break;
				}

				c++;
				start++;
				a_idx++;
			}

			if (check)
				len = Math.min(len, a.length + b.length - c);
			b_idx++;
		}
		return len;
	}

}
