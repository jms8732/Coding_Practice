package greedy;

//°Å½º¸§µ·
import java.util.*;

public class problem_5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cash = sc.nextInt();
		
		int [] coin = {500,100,50,10,5,1};
		
		int charge = 1000 - cash;
		int answer =0 ;

		for(int i =0 ; i < coin.length ; i++) {
			answer += charge / coin[i];
			charge %= coin[i];			
		}
		
		System.out.println(answer);
	}
}
