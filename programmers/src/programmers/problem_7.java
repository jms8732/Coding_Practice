package programmers;
import java.util.*;
//기능 개발
public class problem_7 {
	public static void main(String[] args) {
		int [] p = {};
		int [] d = {1,1,5};
		int[] result= solution(p,d);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
	public static int[] solution(int[] progresses, int[] speeds) {
		
		int top = -1;
		int big = 0;
		int [] array = new int[100];
		for(int i =0 ; i < progresses.length ; i++) {
			//현재 진행상황과 현재 속도
			int currentProgress = progresses[i];
			int currentSpeed = speeds[i];
			
			//남은 진행 상황
			int remainProgress = 100 - currentProgress;
			//진행 될 일수
			double tmp = Math.ceil(remainProgress/currentSpeed); //남은 일수
			int remainDays = (int)tmp;
			
			//값 비교
			if(big >= remainDays) //남은 일수가 이전 일수보다 작을 경우
			{
				array[top] += 1; //증가
			}
			else {
				//남은 일수가 이전 일수보다 클 경우
				top++;
				big = remainDays;
				array[top] = 1;
			}
		}
		int [] answer = new int[top+1];
		for(int i =0 ; i <= top ; i++) {
			answer[i] = array[i];
		}
		return answer;
	}
}
