package programmers;

//k번째 수
import java.util.*;

public class problem_21 {
	public static void main(String[] args) {
		int [] array = {1, 5, 2, 6, 3, 7, 4};
		int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int [] result = solution(array,commands);
		for(int t : result) {
			System.out.print(t + " ");
		}
	}

	public static int[] solution(int[] array, int[][] commands) {
		List<Integer> queue=  new LinkedList<>(); //값을 넣으면서 자동으로 정렬하기 위해서 사용
		int [] result = new int[commands.length];
		int idx = 0;
		for(int [] tmp : commands) {
			int start = tmp[0];
			int end = tmp[1];
			for(int i = start-1 ; i < end ; i++) {
				queue.add(array[i]); //array에 값 추가 
			}
			Collections.sort(queue);
			int want = tmp[2]-1;
			Object[] arrayTmp = queue.toArray();
			result[idx] = (int)arrayTmp[want]; //원하는 값 대입
			idx++;
			queue.clear(); //계산이 완료된 큐 초기화
		}
		
		return result;
	}
}
