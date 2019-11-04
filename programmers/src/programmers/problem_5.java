package programmers;

//쇠 막대기 코드 95.0점 
import java.util.*;

public class problem_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine();
		int result = solution(tmp);
		System.out.println(result);
	}

	public static int solution(String arrangement) {
		int[] array = new int[100000];
		char[] tmp = arrangement.toCharArray();
		int top = -1;
		int totalCount = 0;
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] == '(') {
				if (tmp[i + 1] == ')') { // () 레이저 포인터 일 경우
					for(int j = top ; j >= 0 ; j--) {
						array[j] += 1; // top위치 만큼 증가
					}
					i++;
				}
				else
					top++; //위치 증가
			}
			else {
				totalCount += array[top] +1; //해당 위치 값 추가
				array[top--] = 0; //해당 위치 초기화 하면서 스택 포인트 감소
			}
		}
		return totalCount;
	}
}
