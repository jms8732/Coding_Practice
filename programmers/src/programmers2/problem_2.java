package programmers2;

//���� ������������ ��ġ�ϱ�
import java.util.*;
public class problem_2 {
	public long solution(long n) {
		String tmp = Long.toString(n);
		List<Character> list = new ArrayList<>();
		
		for(int i =0 ; i< tmp.length() ; i++) {
			list.add(tmp.charAt(i));
		}
		
		//������������ ����
		list.sort(new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				if(o1 < o2)
					return 1;
				else
					return -1;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< list.size() ;i++)
			sb.append(list.get(i));
		
		return Long.parseLong(sb.toString());
	}
}
