package dp;

//������ ���ϱ�
import java.util.*;
import java.io.*;

public class pi {
	static String target;
	static int cache[], INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {

			target = br.readLine();
			cache = new int[target.length()];
			Arrays.fill(cache, -1);

			System.out.println(memorize(0));
		}
	}

	private static int memorize(int cur) {
		// 3~5 �ڸ��� ��ŭ ������ �񱳸� ������ ���ư���.
		if(cur == target.length())
			return 0;
		
		if (cache[cur] != -1)
			return cache[cur];

		int ret = (cache[cur] == -1 ? INF: cache[cur]);

		for (int size = 3; size <= 5; size++) {
			if (cur + size <= target.length())
				ret = cache[cur] = Math.min(ret, memorize(cur + size) + classify(cur, cur + size));
		}

		return ret;
	}

	private static int classify(int begin, int end) {
		String sub = target.substring(begin, end);

		int len = 0;
		// ù ��° case
		for (int i = 0; i < sub.length(); i++) {
			if (sub.charAt(0) == sub.charAt(i))
				len++;
		}

		if (len == sub.length())
			return 1;

		int first = sub.charAt(0) - '0';
		int second = sub.charAt(1) - '0';

		// �� ��° case, �ټ� ��° case
		boolean progressive = true;

		for (int i = 2; i < sub.length(); i++) {
			int pre = sub.charAt(i - 1) - '0';
			int cur = sub.charAt(i) - '0';

			if (cur - pre != second - first)
				progressive = false;
		}

		if (progressive && Math.abs(first - second) == 1)
			return 2;

		// �� ��° case
		boolean alternative = true;
		for (int i = 0; i < sub.length(); i++) {
			int cur = sub.charAt(i);
			int mod = sub.charAt(i % 2);

			if (cur != mod)
				alternative = false;
		}

		if (alternative)
			return 4;

		if (progressive)
			return 5;

		return 10;
	}
}
