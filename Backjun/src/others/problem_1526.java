package others;

//가장 큰 금민수
import java.util.*;
public class problem_1526 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = n; i >= 0 ; i--) {
			String tmp = String.valueOf(i);
			
			boolean c = false;
			for(int j =0 ; j < tmp.length() ; j++) {
				if(tmp.charAt(j) != '4' && tmp.charAt(j) != '7') {
					c= true;
					break;
				}
			}
			
			if(!c) {
				System.out.println(i);
				System.exit(0);
			}
		}
	}
}
