package others;

/*
 * ZOAC
 * 문제에서 요구하는 대로 구현을 진행하면 된다. 자세한 건 아래 주석 참조
 */
import java.util.*;

public class problem_16719 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		simulation(line.toCharArray());

		sc.close();
	}

	private static void simulation(char[] array) {
		int len = 0;
		
		//사전순으로 먼저 오는 문자열을 저장하는 배열
		boolean finalCheck[] = new boolean[array.length];

		//1부터 시작하여 배열의 길이까지 루프를 돈다.
		while (++len <= array.length) {
			boolean[] temp = Arrays.copyOf(finalCheck, finalCheck.length); //이전에 만들었던 배열의 값 할당
			String first = null; //만들어 진 문자열 할당
			for(int i =0 ; i < array.length ; i++) {
				if(!temp[i]) {
					temp[i] = true;
					String t = makeString(array,temp);
					
					//현재 길이에 맞는 문자열을 만들면서 사전순 비교
					if(first == null) {
						first = t;
						System.arraycopy(temp, 0, finalCheck, 0, temp.length);
					}else {
						if(t.compareToIgnoreCase(first) < 0) {
							first = t;
							System.arraycopy(temp, 0, finalCheck, 0, temp.length);
						}
					}
					
					temp[i] = false;
				}
			}
			
			//현재 길이에 사전순으로 먼저 오는 문자열 출력
			print(array,finalCheck);
		}
	}

	
	private static void print(char[] array,  boolean [] check) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < check.length ; i++) {
			if(check[i])
				sb.append(array[i]);
		}
		System.out.println(sb.toString());
	}
	private static String makeString(char[] array, boolean[] check) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (check[i])
				sb.append(array[i]);
		}

		return sb.toString();
	}
}
