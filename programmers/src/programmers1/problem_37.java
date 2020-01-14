package programmers1;

//문자열 내 마음대로 정렬하기
import java.util.*;

public class problem_37 {
	public static void main(String[] args) {
		String [] strings = {"sun","bed","car"};
		String [] result = solution(strings,1);
		
		for(String t : result)
			System.out.print(t + " ");
	}
	public static String[] solution(String[] strings, int n) {
		List<Node> list= new LinkedList<>();
		
		//값 할당
		for(int i =0 ; i < strings.length ; i++) {
			list.add(new Node(strings[i],strings[i].charAt(n)));
		}
		
		list.sort(new Comparator<Node>() {
			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if(arg0.alphabet < arg1.alphabet)
					return -1;
				else if(arg0.alphabet == arg1.alphabet) {
					if(arg0.content.compareTo(arg1.content)< 0) //사전순으로 정렬
						return -1;
					else
						return 1;
				}else
					return 1;
				
			}
			
		});
		
		String [] answer = new String[list.size()];
		
		for(int i = 0;  i< list.size() ; i++) answer[i] = list.get(i).content;
		
		return answer;
	}
	private static class Node{
		String content;
		char alphabet;
		public Node(String s , char a) {
			this.content =s;
			this.alphabet =a;
		}
	}
}
