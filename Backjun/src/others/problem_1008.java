package others;

import java.util.*;
import java.io.*;
import java.math.*;

public class problem_1008 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		double A = Integer.parseInt(st.nextToken());
		double B = Integer.parseInt(st.nextToken());
		
		System.out.println(A/B);
	}
}
