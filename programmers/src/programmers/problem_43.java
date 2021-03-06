package programmers;
// [1차] 프렌즈 4블록
//자리수 처리
import java.util.*;

public class problem_43 {
	public static void main(String[] args) {
		String[] board = {"AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"
				};
		int result = solution(5,6,board);
		System.out.println(result);
	}

	public static int solution(int m, int n, String[] board) {
		Set<String> doubleCheck = new HashSet<>(); // 중복을 체크하기위한 집합
		char[][] map = new char[m][n];

		for (int i = 0; i < board.length; i++) {
			String tmp = board[i];
			for (int j = 0; j < tmp.length(); j++) {
				map[i][j] = tmp.charAt(j); // 문자로 다시 넣기
			}
		}

		int answer = 0;
		while (true) {
			// 2x2를 찾는 연산
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != '0' && isBlock(map, i, j)) {
						makeBlock(doubleCheck, i, j); // 나중에 지울 좌표
					}
				}
			}

			if(doubleCheck.size() == 0)
				break; 
			// 찾은 후 삭제 연산
			answer += doubleCheck.size();
			delete(doubleCheck, map);
			doubleCheck.clear(); // 좌표 삭제

			// 블록을 내리는 연산
			for (int i = map.length-1; i >=0; i--) {
				for (int j = map[i].length-1; j >=0; j--) {
					if (map[i][j] != '0') {
						// 해당 위치가 빈칸이 아닐 경우
						downBlock(map, i, j);
					}
				}
			}
			
		}
		
		return answer;
	}

	public static void downBlock(char[][] map, int x, int y) {
		int nx = x;
		while (true) {
			nx = nx + 1;
			
			if(nx >= map.length)
				break;
			
			if (map[nx][y] != '0')
				break;
		}
		if((nx-1) != x) {
			map[nx-1][y] = map[x][y]; // 내려온 블록의 위치
			map[x][y] = '0'; // 기존 위치는 없어짐
		}
	}

	public static void delete(Set<String> set, char[][] map) {
		// 넣어 놓은 좌표를 대상으로 삭제
		Iterator it = set.iterator();
		while (it.hasNext()) {
			String[] tmp = ((String)it.next()).split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			
			map[x][y] = '0'; // 빈칸으로
		}

	}

	public static void makeBlock(Set<String> set, int x, int y) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(x + i).append(' ').append(y + j);
				set.add(sb.toString()); // x,y 좌표를 집합에 넣는다.
			}
		}
	}

	public static boolean isBlock(char[][] map, int x, int y) {
		char target = map[x][y];
		
		boolean check = false;
		
		if(y + 1 >= map[x].length || x + 1 >= map.length)
			return check;
		
		if (target == map[x + 1][y] && target == map[x][y + 1] && target == map[x + 1][y + 1])
			return !check; // 2x2가 될 경우
		return check;
	}
}
