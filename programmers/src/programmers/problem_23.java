package programmers;

import java.util.*;;

public class problem_23 {
	static Queue<Status> queue;

	public static void main(String[] args) {
		int result = solution("JEROEN");
		System.out.println(result);
	}

	public static int solution(String name) {
		queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < name.length(); i++) {
			sb.append("A");
		}
		boolean visited[] = new boolean[name.length()];
		int count = 0;
		int currentIdx = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == sb.charAt(i))
				visited[i] = true;
		}
		if (sb.charAt(0) != name.charAt(0)) {
			// 첫부분
			int tmp = 0;
			for (int j = 'B'; j <= 'Z'; j++) {
				tmp++;
				if (j == name.charAt(0)) {
					sb.replace(currentIdx, currentIdx + 1, Character.toString((char) j));
					break;
				}
			}
			count = Integer.MAX_VALUE;
			count = Math.min(tmp, count);

			tmp = 0;
			for (int j = 'Z'; j >= 'A'; j--) {
				tmp++;
				if (j == name.charAt(0))
					break;
			}
			count = Math.min(count, tmp);
		}
		visited[currentIdx] = true; // 현재 위치 탐색 완료
		int nextIdx = currentIdx + 1;
		Status L = new Status(sb.toString(), visited, nextIdx, count + 1);
		nextIdx = (name.length() + (currentIdx - 1)) % name.length();
		Status R = new Status(sb.toString(), visited, nextIdx, count + 1);
		queue.add(L);
		queue.add(R);

		int totalCount = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Status tmp = queue.poll();
			boolean check = false;
			count = 0;

			// 다 방문하지 않은 경우
			if (tmp.value.charAt(tmp.currentIdx) != name.charAt(tmp.currentIdx)) {
				// 첫부분
				int tmpC = 0;
				for (int j = 'B'; j <= 'Z'; j++) {
					tmpC++;
					if (j == name.charAt(tmp.currentIdx)) {
						sb.replace(tmp.currentIdx, tmp.currentIdx + 1, Character.toString((char) j));
						break;
					}
				}
				count = Integer.MAX_VALUE;
				count = Math.min(tmpC, count);

				tmpC = 0;
				for (int j = 'Z'; j >= 'B'; j--) {
					tmpC++;
					if (j == name.charAt(tmp.currentIdx))
						break;
				}
				count = Math.min(count, tmpC);
			}

			count += tmp.count; // 누적
			boolean tmpVisited[] = tmp.visited;
			tmpVisited[tmp.currentIdx] = true; //현재 위치
			for (int i = 0; i < tmpVisited.length; i++) {
				if (!tmpVisited[i]) {
					check = true;
					break;
				}
			}
			if (!check) {
				totalCount = Math.min(totalCount,count);
				break;
			}
			else {
				nextIdx = (tmp.currentIdx + 1) % name.length();
				L = new Status(tmp.value, tmpVisited, nextIdx, count + 1);
				nextIdx = (name.length() + (tmp.currentIdx - 1)) % name.length();
				R = new Status(tmp.value, tmpVisited, nextIdx, count + 1);
				queue.add(L);
				queue.add(R);
			}

		}
		return totalCount;
	}

}

class Status {
	boolean[] visited;
	int currentIdx;
	String value;
	int count = 0;

	public Status(String value, boolean[] visited, int currentIdx, int count) {
		this.value = value;
		this.visited = new boolean[visited.length];
		System.arraycopy(visited, 0, this.visited, 0, visited.length);
		this.currentIdx = currentIdx;
		this.count = count;
	}
}