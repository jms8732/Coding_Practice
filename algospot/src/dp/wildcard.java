package dp;

//와일드 카드
import java.util.*;
import java.io.*;

public class wildcard {
	static int cache[][];
	static String pattern, target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			pattern = br.readLine();
			int N = Integer.parseInt(br.readLine());
			cache = new int[101][101];
			
			List<String> val = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				for (int tmp[] : cache)
					Arrays.fill(tmp, -1);

				target = br.readLine(); 
				if (matchMemoized(0, 0) == 1)
					val.add(target);
			}
			
			Collections.sort(val);
			for(String t : val)
				System.out.println(t);
		}
	}

	private static int matchMemoized(int w, int s) {
		int ret = cache[w][s];

		if (ret != -1) {
			return ret;
		}

		while (w < pattern.length() && s < target.length()
				&& (pattern.charAt(w) == '?' || pattern.charAt(w) == target.charAt(s))) {
			++w;
			++s;
		}

		// 패턴의 시작 위치가 패턴의 길이과 동일할 경우
		if (w == pattern.length()) {
			return cache[w][s] = (s == target.length()? 1 : 0);
		}

		if (pattern.charAt(w) == '*') {
			for (int i = 0; i + s <= target.length(); i++) {
				if (matchMemoized(w + 1, s + i) == 1) {
					return cache[w][s]=1;
				}
			}
		}
		return cache[w][s]=0;
	}
}
