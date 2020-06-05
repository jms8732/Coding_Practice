package others;

//직사각형에서 탈출
import java.util.*;
import java.io.*;

public class problem_1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int r_len = Math.min(x, Math.abs(x-w));
		int c_len = Math.min(y, Math.abs(y-h));
		
		int result = Math.min(r_len, c_len);
		System.out.println(result);
	}
}
