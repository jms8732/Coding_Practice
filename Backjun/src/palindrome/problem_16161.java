package palindrome;

//가장 긴 증가하는 팰린드롬 부분 수열
/*
 * 예시
 * 6
 * 32 59 75 75 59 32 result: 6
 * 
 * 5
 * 3 2 1 2 3 result: 1
 * 
 * 7
 * 32 57 57 80 57 57 32 result: 3
 * 
 * 5
 * 8 7 9 7 8 result:3 
 * 
 */
import java.io.*;
import java.util.*;

public class problem_16161 {
	static BufferedReader br;

	public static void main(String[] args) {
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int[] array = getModifiedArray(); // 수정된 문자열
			int r = 0, c = 0;
			int[] p = new int[array.length];
			int big = 0;
			// manacher's algorithm
			for (int i = 0; i < array.length; i++) {
				int mirror = 2 * c - i;

				// 우측 범위내에 존재할 경우
				if (i < r)
					p[i] = Math.min(r - i, p[mirror]);

				int left = i - (p[i] + 1);
				int right = i + (p[i] + 1);

				int tmp = array[i];
				if (tmp == -1 && right < array.length && left >= 0)
					tmp = Math.max(array[right], array[left]) +1 ; // 가장 큰 값에서 1증가
				// 확장
				while(right < array.length && left >= 0
						&& array[left] == array[right]
						&& array[left] < tmp 
						&& array[right] < tmp) {
					if(array[left] != -1)
						tmp = array[left];
					
					left--;
					right++;
					p[i]++;
						
				}

				if (i + p[i] > r) {
					// 경계를 벗어 난 경우
					c = i;
					r = i + p[i];
					big = Math.max(big, p[i]);
				}

			}
			System.out.println(big);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int[] getModifiedArray() throws IOException {
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> tmp = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			tmp.add(-1); // 구분하기 위한 변수
			tmp.add(Integer.parseInt(st.nextToken()));
		}

		tmp.add(-1); // 마지막에 삽입
		int[] array = new int[tmp.size()];
		for (int i = 0; i < array.length; i++)
			array[i] = tmp.get(i);

		return array;
	}
}
