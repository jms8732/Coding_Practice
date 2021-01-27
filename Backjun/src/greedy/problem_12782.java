package greedy;

/*
 * ��Ʈ ��������
 * 2. �ϳ��� ���������� ���� �ٸ� �ڸ��� �ִ� �� ������ ��ġ�� �ٲ۴�. <<�̰��� �ּҿ����� �ϱ� ���� ����̴�.>>
 * Stack�� �̿��Ͽ� Ʋ�� ���ڸ� �ִ´�.
 * stack�� ���� �ְ� ���� Ʋ�� ���ڿ� ������ ��� ���ڰ� ���� �ٸ� ��� 0�� 1�̱⿡ stack�� ���� ���� ���� Ƚ���� 1 ������Ų��.
 * �ݺ����� ��ȸ�Ͽ� stack�� ���� ���� ������ ������ ��õ� 1�� ����� �̿��Ͽ� �ٲٸ� �Ǳ⿡ stack�� ����� ���ϸ�ȴ�.
 * 
 */
import java.util.*;
import java.io.*;

public class problem_12782 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i =0 ; i  <tc ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String tar1 = st.nextToken();
			String tar2 = st.nextToken();
			
			Stack<Character> stack = new Stack();
			int bc =0 ;
			for(int j =0 ; j < tar1.length() ; j++) {
				if(tar1.charAt(j) != tar2.charAt(j)) {
					if(stack.isEmpty())
						stack.push(tar1.charAt(j));
					else {
						if(stack.peek() != tar1.charAt(j)) {
							stack.pop();
							bc++;
						}else
							stack.push(tar1.charAt(j));
					}
				}
			}
			System.out.println(bc + stack.size());
		}
	}

}
