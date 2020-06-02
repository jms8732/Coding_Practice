package others;

//¹æÇÐ ¼÷Á¦
import java.util.*;
import java.io.*;

public class problem_5532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());

		int lan_days = A / C;
		if (A % C != 0)
			lan_days += 1;

		int math_days = B / D;
		
		if (B % D != 0)
			math_days += 1;

		int total = Math.max(lan_days, math_days);
		
		System.out.println(L-total);
	}
}
