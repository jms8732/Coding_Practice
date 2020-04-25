package bruteforce;

//시계 맞추기
import java.util.*;
import java.io.*;

public class clocksync {
	static int ans = Integer.MAX_VALUE;
	static String[] bc = { "xxx.............", "...x...x.x.x....", "....x.....x...xx", "x...xxxx........",
			"......xxx.x.x...", "x.x...........xx", "...x..........xx", "....xx.x......xx", ".xxxxx..........",
			"...xxx...x...x.." };

	static List<Integer> button[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		button = new ArrayList[10];

		for (int i = 0; i < button.length; i++)
			button[i] = new ArrayList<>();

		init();

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] clock_status = new int[16];
			for (int j = 0; j < 16; j++) {
				clock_status[j] = Integer.parseInt(st.nextToken());
			}

			findMin(0, 0, clock_status);
			
			if(ans == Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(ans);
			
			ans = Integer.MAX_VALUE;
		}
	}

	private static void findMin(int cur, int count, int[] clock_status) {
		if (cur == 10) {
			if (isFinish(clock_status))
				ans = Math.min(count, ans);
			return;
		}

		int tmpCount = count;
		for (int i = 0; i < 4; i++) {
			findMin(cur + 1, tmpCount, clock_status);
			push_button(cur, clock_status);
			tmpCount++;
		}
	}

	private static void push_button(int cur, int[] clock_status) {
		for (int i = 0; i < button[cur].size(); i++) {
			int clock_num = button[cur].get(i);

			clock_status[clock_num] += 3;
			if (clock_status[clock_num] == 15)
				clock_status[clock_num] = 3;
		}

	}

	private static void init() {
		for (int i = 0; i < bc.length; i++) {
			String tmp = bc[i];
			for (int j = 0; j < tmp.length(); j++)
				if (tmp.charAt(j) == 'x')
					button[i].add(j);
		}
	}

	private static boolean isFinish(int[] clock_status) {
		for (int i = 0; i < clock_status.length; i++) {
			if (clock_status[i] != 12)
				return false;
		}

		return true;
	}
}