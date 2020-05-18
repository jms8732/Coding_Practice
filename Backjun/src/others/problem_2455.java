package others;

//지능형 기차
import java.util.*;
import java.io.*;

public class problem_2455 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		int train_people = 0;
		int answer = 0;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			
			train_people -= out;
			train_people += in;
			
			answer = Math.max(answer, train_people);
			
			if(in == 0)
				break;
			
		}
		
		System.out.println(answer);
	}
}
