package programmers1;

//방문 길이
import java.util.*;

public class problem_20 {
	public static void main(String[] args) {
		String s = "LULLLLLLU";
		int result = solution(s);
		System.out.println(result);
	}

	public static int solution(String dirs) {
		int count = 0;
		Set<List<Integer>> set = new HashSet<>();
		int x = 0, y = 0, nx = 0, ny = 0;

		for (int i = 0; i < dirs.length(); i++) {
			nx = x;
			ny = y;
			switch (dirs.charAt(i)) {
			case 'U':
				ny = y + 1;
				break;
			case 'D':
				ny = y - 1;
				break;
			case 'L':
				nx = x - 1;
				break;
			case 'R':
				nx = x + 1;
				break;
			}

			if (nx < -5 || nx > 5 || ny < -5 || ny > 5)
				continue;

			if (isDouble(x, y, nx, ny, set)) {
				count++;
			}
			x = nx;
			y = ny;
		}

		return count;
	}

	private static boolean isDouble(int x, int y, int nx, int ny, Set<List<Integer>> set) {
		List<Integer> list = new ArrayList<>();
		list.add(x);
		list.add(y);
		list.add(nx);
		list.add(ny);

		if (set.contains(list))
			return false;

		set.add(list); // 현재 방향

		list.clear();
		list.add(nx);
		list.add(ny);
		list.add(x);
		list.add(y);

		if (set.contains(list))
			return false;

		set.add(list); // 역방향

		return true;
	}
}
