package others;

//최소공배수
import java.util.*;

public class problem_1934 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i =0 ; i < tc ; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int big = 0, small = 0;
			
			if(A > B)
			{
				big = A;
				small = B;
			}else {
				big = B;
				small = A;
			}
			int mod = 0;
			
			while(true) {
				mod = big % small;
				
				if(mod == 0)
					break;
				
				big = small;
				small = mod;
			}
			
			big = (A / small) * (B / small) * small;
			System.out.println(big);
		}
	}
}
