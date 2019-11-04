package programmers;

//�� ����� �ڵ� 95.0�� 
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
				if (tmp[i + 1] == ')') { // () ������ ������ �� ���
					for(int j = top ; j >= 0 ; j--) {
						array[j] += 1; // top��ġ ��ŭ ����
					}
					i++;
				}
				else
					top++; //��ġ ����
			}
			else {
				totalCount += array[top] +1; //�ش� ��ġ �� �߰�
				array[top--] = 0; //�ش� ��ġ �ʱ�ȭ �ϸ鼭 ���� ����Ʈ ����
			}
		}
		return totalCount;
	}
}
