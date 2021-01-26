package bruteForce;

import java.util.*;

public class problem_1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		if(number <= 9)
			System.out.println(number);
		else {
			long ans = 9;
			for(int i = 10 ; i<= number ; i++) {
				if(i < 100)
					ans += 2;
				else if(i < 1000)
					ans += 3;
				else if(i < 10000)
					ans += 4;
				else if(i < 100000)
					ans += 5;
				else if(i < 1000000)
					ans += 6;
				else if(i < 10000000)
					ans += 7;
				else if(i < 100000000)
					ans += 8;
				else
					ans += 9;
			}
			System.out.println(ans);
			
		}
	
	}
}
