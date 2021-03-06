package programmers1;

//시저 암호
public class problem_46 {
	public static void main(String[] args) {
		String s = "a B z";
		String result = solution(s, 4);
		System.out.println(result);
	}

	public static String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		char[] array = new char[26];

		for (int i = 0; i < 26; i++) {
			int c = (int) 'a';
			c += i;
			array[i] = (char) c;
		}

		for (int i = 0; i < s.length(); i++) {
			int c = 0;
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') // 소문자 일 경우
			{
				int t = ((int) s.charAt(i) + n) % 'a';
				c = array[t % 26];
			} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') // 대문자 일 경우
			{
				int t = ((int) s.charAt(i) + n) % 'A';
				c = Character.toUpperCase(array[t % 26] );
			} else
				c = s.charAt(i);
			sb.append((char) c); // 형변환
		}

		return sb.toString();
	}
}
