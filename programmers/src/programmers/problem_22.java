package programmers;

//2016��  =>64�� calendar���θ� ���� �ذ� -> �ڵ� ��ħ 85.7��
import java.util.*;

public class problem_22 {
	public static void main(String[] args) {
		String result = solution(12,31);
		System.out.println(result);
	}

	public static String solution(int a, int b) {
		int day = 0;
		for(int i = 1 ; i< a ; i++) {
			if(i == 1 || i == 3  || i == 5 || i== 7 || i == 8 || i== 10  ||i ==12)
				day += 31;
			else if(i == 2)
				day += 29; //�����̹Ƿ�
			else
				day += 30;
		}
		
		day += b;
		int dayOfWeek = day % 7; //�������� 7�� �̹Ƿ�
		String name = null;
		switch(dayOfWeek) {
		case 1:
			name = "FRI";
			break;
		case 2:
			name = "SAT";
			break;
		case 3:
			name = "SUN";
			break;
		case 4:
			name = "MON";
			break;
		case 5:
			name = "TUE";
			break;
		case 6:
			name = "WED";
			break;
		case 0:
			name = "THU";
			break;
		}
		return name;
	}

}
