package greedy;

/*
 * UCPC�� ������ �����ϱ�
 * �Էµ� ���ڿ��� ������� ��ȯ�ϸ鼭 U, C, P, C äũ
 */
import java.util.*;

public class problem_15904 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Character> q = new LinkedList<>();
		
		String line = sc.nextLine();
		
		for(int i =0 ; i < line.length() ; i++) {
			q.add(line.charAt(i));
		}
		
		char [] target = {'U','C','P','C'};
		int idx = 0;
		
		while(!q.isEmpty() && idx < target.length) {
			char cur = q.poll();
			
			if(cur == target[idx])
				idx++;
		}
		
		if(idx == target.length)
			System.out.println("I love UCPC");
		else
			System.out.println("I hate UCPC");
	}
}