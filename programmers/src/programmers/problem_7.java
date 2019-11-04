package programmers;
import java.util.*;
//��� ����
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
			//���� �����Ȳ�� ���� �ӵ�
			int currentProgress = progresses[i];
			int currentSpeed = speeds[i];
			
			//���� ���� ��Ȳ
			int remainProgress = 100 - currentProgress;
			//���� �� �ϼ�
			double tmp = Math.ceil(remainProgress/currentSpeed); //���� �ϼ�
			int remainDays = (int)tmp;
			
			//�� ��
			if(big >= remainDays) //���� �ϼ��� ���� �ϼ����� ���� ���
			{
				array[top] += 1; //����
			}
			else {
				//���� �ϼ��� ���� �ϼ����� Ŭ ���
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
