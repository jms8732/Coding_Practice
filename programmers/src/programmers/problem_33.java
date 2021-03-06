package programmers;

//카펫
public class problem_33 {
	public static void main(String[] args) {
		int[] result = solution(8,1);
		for (int tmp : result)
			System.out.print(tmp + " ");
	}

	public static int[] solution(int brown, int red) {
		int[] answer = new int[2];
		int result = 0;
		for (int i = 1; i <= red; i++) {
			if (red % i == 0) {
				// 나머지가 없을 경우
				int row = i;
				int col = red /i ;
				result = row * 2 + col * 2 + 4;
				if (result == brown && row <= col) {
					answer[0] = col + 2;
					answer[1] = row + 2;
					break;
				}
				result = 0;
			}
		}

		return answer;
	}
}
