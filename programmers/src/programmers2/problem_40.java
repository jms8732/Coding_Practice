package programmers2;

/*
 * 단체사진 찍기
 * 24분 소요
 * 친구 조합을 만든 뒤, 조건에 부합되는지 판단
 */
public class problem_40 {
	public static void main(String[] args) {
		String [] data = {"N~F=0","R~T>2"};
		
		System.out.println(solution(2,data));
	}
	
	public static int solution(int n, String[] data) {
		char [] friends = {'A','C','F','J','M','N','R','T'};
		char [] arrange = new char[friends.length];
		boolean [] visited = new boolean[friends.length];
		return combination(0,friends,arrange,visited,data);
	}

	private static int combination(int depth, char[] friends, char[] arrange,boolean [] visited, String[] data) {
		if (depth == friends.length) {
			if (checkCase(arrange, data))
				return 1;
			return 0;
		}

		int ret = 0;
		for(int i =0 ; i < friends.length; i++) {
			if(!visited[i]) {
				arrange[depth] = friends[i];
				visited[i] = true;
				ret += combination(depth+1,friends,arrange,visited,data);
				visited[i] = false;
			}
		}
		return ret;

	}

	private static boolean checkCase(char[] friends, String[] data) {
		for (String d : data) {
			char f1 = d.charAt(0);
			char f2 = d.charAt(2);

			char f3 = d.charAt(3);
			char f4 = d.charAt(4);

			int f1_idx = findIdx(friends, f1);
			int f2_idx = findIdx(friends, f2);

			// 조건에 맞지 않는 경우들
			if (f3 == '=') {
				if (Math.abs(f2_idx - f1_idx) - 1 != (f4 - '0'))
					return false;
			} else if (f3 == '>') {
				if (Math.abs(f2_idx - f1_idx) - 1 <= (f4 - '0'))
					return false;
			} else {
				if (Math.abs(f2_idx - f1_idx) - 1 >= (f4 - '0'))
					return false;
			}
		}

		return true;
	}

	private static int findIdx(char[] array, char target) {
		for (int i = 0; i < array.length; i++) {
			if (target == array[i])
				return i;
		}

		return 0;
	}
}
