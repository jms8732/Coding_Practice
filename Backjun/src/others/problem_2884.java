package others;

//알람 시계
import java.util.*;
import java.io.*;

public class problem_2884 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		m -= 45;
		
		if(m < 0) {
			h = Math.floorMod(h-1, 24);
		}
		
		m = Math.floorMod(m, 60);
		
		
		System.out.print(h + " " + m);
	}
}
