package search_algorithm;

//상자 넣기

import java.util.*;
import java.io.*;

public class problem_1965 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(st.nextToken());
			if(ans.isEmpty())
				ans.add(target);
			else {
				int last = ans.get(ans.size()-1);
				if(last >= target) {
					lowerBound(ans,target);
				}else
					ans.add(target);
			}
		}

		System.out.println(ans.size());
	}



	private static void lowerBound(List<Integer> list, int target) {
		int left = 0;
		int right = list.size();

		while (left < right) {
			int mid = (left + right) / 2;

			if (list.get(mid) < target)
				left = mid + 1;
			else
				right = mid;
		}

		list.remove(left);
		list.add(left,target);
	}
}
