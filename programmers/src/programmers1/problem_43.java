package programmers1;

//���ڿ� �ٷ�� �⺻

public class problem_43 {
	public static boolean solution(String s) {
		for(int i =0 ; i< s.length() ; i++) {
			
			//���ڿ� ���ο� �����ڰ� ������ ���
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				return false;
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
				return false;
		}
		
		if(s.length() == 4 || s.length() == 6)
			return true;
		
		return false;
	}
}
