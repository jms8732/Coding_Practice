package programmers2;

//[3차] 파일명 정렬
import java.util.*;

public class problem_21 {
	public static void main(String[] args0) {
		String[] files = {"F-17boo160","F17boo170"};
		
		for(String i : solution(files))
			System.out.print(i + " ");
	}

	public static String[] solution(String[] files) {
		Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				StringBuilder sb1 = new StringBuilder();
				for(int i =0 ; i <o1.length();  i++) {
					char tmp = o1.charAt(i);
					if((tmp >= '0' && tmp <= '9')) {
						break;
					}
					else
						sb1.append(tmp);

				}
				
				
				StringBuilder sb2 = new StringBuilder();
				for(int i =0 ; i <o2.length();  i++) {
					char tmp = o2.charAt(i);
					if((tmp >= '0' && tmp <= '9'))
						break;
					else
						sb2.append(tmp);
				}
				
				String t1 = sb1.toString();
				String t2 = sb2.toString();
				int t = t1.compareToIgnoreCase(t2);
				
				// 파일명의 문자로 정렬
				if (t < 0) {
					return -1;
				} else if (t == 0) {
					sb1 = new StringBuilder();
					for (int i = 0; i < o1.length(); i++) {
						if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
							int count =1;
							sb1.append(o1.charAt(i++) - '0');
							while (i < o1.length() && o1.charAt(i) >= '0' && o1.charAt(i) <= '9' && count < 5) {
								sb1.append(o1.charAt(i++) - '0');
								count++;
							}
							
							break;
						}

					}

					sb2 = new StringBuilder();
					for (int i = 0; i < o2.length(); i++) {
						if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
							int count =1;
							sb2.append(o2.charAt(i++) - '0');
							while (i < o2.length() && o2.charAt(i) >= '0' && o2.charAt(i) <= '9' && count < 5) {
								sb2.append(o2.charAt(i++) - '0');
								count++;
							}
							break;
						}
					}

					int v1 = Integer.parseInt(sb1.toString());
					int v2 = Integer.parseInt(sb2.toString());

					if (v1 < v2)
						return -1;
					else if(v1 == v2)
						return 0;
					else
						return 1;
				} else
					return 1;

			}

		});
		
		return files;
	}
}
