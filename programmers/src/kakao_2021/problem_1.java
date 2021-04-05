package kakao_2021;

/*
 * �ű� ���̵� ��õ
 * Ǯ�� �ð�: 26��
 * 1~7�ܰ� ���� ������ �����ϸ� �ȴ�.
 */
public class problem_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String new_id = "=.=";
		
		System.out.print(solution(new_id));
	}

	public static String solution(String new_id) {
		new_id = new_id.toLowerCase(); //��� �빮�ڸ� �ҹ��ڷ�
		new_id = replaceAll(new_id); //������ ���� ����
		new_id = removeDoubleDot(new_id);
		
		new_id = deleteFirstLastDot(new_id);
		
		if(new_id.isEmpty())
			new_id = "a";
		
		if(new_id.length() >= 16) {
			new_id = makeNewString(new_id);
		}
		
		if(new_id.length() <= 3) {
			StringBuilder sb = new StringBuilder(new_id);
			
			while(sb.length() < 3) {
				sb.append(sb.charAt(sb.length()-1));
			}
			
			new_id = sb.toString();
		}
		
		return new_id;
	}
	
	private static String removeDoubleDot(String new_id) {
		StringBuilder sb = new StringBuilder();
		
		for(int i =0 ; i < new_id.length() ; i++) {
			char cur = new_id.charAt(i);
			
			if(cur != '.')
				sb.append(cur);
			else {
				while(++i < new_id.length()) {
					if(new_id.charAt(i) != '.')
						break;
				}
				sb.append(new_id.charAt(--i));
			}
		}
		
		return sb.toString();
	}
	
	private static String makeNewString(String new_id) {
		StringBuilder sb = new StringBuilder(new_id.substring(0, 15));
		
		if(sb.charAt(sb.length()-1) == '.')
			sb.deleteCharAt(sb.length()-1);
		
		return sb.toString();
	}
	
	private static String deleteFirstLastDot(String new_id) {
		StringBuilder sb = new StringBuilder(new_id);
		
		if(sb.charAt(0) == '.')
			sb.deleteCharAt(0);
		
		if(sb.length() != 0 && sb.charAt(sb.length()-1) == '.')
			sb.deleteCharAt(sb.length()-1);
		
		return sb.toString();
	}
	
	private static String replaceAll(String new_id) {
		StringBuilder sb = new StringBuilder();
		for(int i =0 ; i < new_id.length() ; i++) {
			char cur = new_id.charAt(i);
			
			if(cur >= 'a' && cur <= 'z')
				sb.append(cur);
			else if(cur >= '0' && cur <= '9')
				sb.append(cur);
			else if(cur == '-' || cur == '_' || cur == '.')
				sb.append(cur);
		}
		
		return sb.toString();
	}
}
