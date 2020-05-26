package others;

//X보다 작은 수
import java.util.*;
import java.io.*;

public class problem_10871 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i < N ; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			if(target < X)
				bw.write(target + " ");
		}
		bw.flush();
	}
}
