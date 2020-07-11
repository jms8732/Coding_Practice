package programmers2;

//∫∏ºÆ ºÓ«Œ
import java.util.*;

public class problem_33 {
	public static void main(String[] args) {
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };

		for (int i : solution(gems))
			System.out.print(i + " ");
	}

	public static int[] solution(String[] gems) {
		Set<String> set_g = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < gems.length; i++)
			set_g.add(gems[i]);

		int lo = -1;
		int hi = 0;
		int[] answer = new int[2];

		int len = Integer.MAX_VALUE;

		Set<String> set_t = new HashSet<>();
		while (lo < gems.length) {
			boolean check = true;
			lo++;
			if (lo - 1 >= 0) {
				int count = map.get(gems[lo - 1]);
				if (count == 1) {
					map.remove(gems[lo - 1]);
					set_t.remove(gems[lo - 1]);
				} else {
					map.replace(gems[lo - 1], map.get(gems[lo - 1]) - 1);
					check = false;
				}
			}

			if (check) {
				while(hi < gems.length){
					set_t.add(gems[hi]);

					if (map.containsKey(gems[hi])) {
						map.replace(gems[hi], map.get(gems[hi]) + 1);
					} else
						map.put(gems[hi], 1);

					hi++;
					if (set_t.size() == set_g.size()) {
						break;
					}
				}
			}

			if (set_t.size() == set_g.size() && len > hi - lo-1) {
				len = hi - lo-1;
				answer[0] = lo + 1;
				answer[1] = hi;
			}

		}

		return answer;
	}
}
