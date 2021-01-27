package greedy;

/*
 * 비트 우정지수
 * 2. 하나의 이진수에서 서로 다른 자리에 있는 두 숫자의 위치를 바꾼다. <<이것이 최소연산을 하기 위한 방법이다.>>
 * Stack을 이용하여 틀린 문자를 넣는다.
 * stack에 값이 있고 현재 틀린 문자와 스택의 상단 문자가 서로 다른 경우 0과 1이기에 stack에 값을 뺴고 연산 횟수를 1 증가시킨다.
 * 반복문을 순회하여 stack에 남은 값이 있으면 문제에 명시된 1번 방법을 이용하여 바꾸면 되기에 stack의 사이즈를 더하면된다.
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
