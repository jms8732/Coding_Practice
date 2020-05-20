package bruteForce;

//¹®ÀÚ¿­
import java.util.*;
import java.io.*;

public class problem_1120 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken();
		String B = st.nextToken();

		find_min_gap(A, B);
	}

	private static void find_min_gap(String A, String B) {
		int gap = Integer.MAX_VALUE;
		for(int i = 0 ; i <= B.length() - A.length() ; i++) {
			int tmp = 0;
			for(int j =0 ; j < A.length() ; j++) {
				if(A.charAt(j) != B.charAt(i+j))
					tmp++;
			}
			
			gap = Math.min(gap,  tmp);
		}
		
		System.out.println(gap);
		
	}
}
