package samsung;

//퇴사
import java.io.*;
import java.util.*;

public class problem_14501_1 {
	static int days[] , money[];
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	
		days = new int[N];
		money = new int[N];
		
		for(int i =0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			days[i] = t;
			money[i] = m;
		}
		
		find_max(0,N,0);
		System.out.println(answer);
	}
	
	private static void find_max(int cur,int N, int total) {
		if(cur >= N) {
			answer = Math.max(total,answer);
			return ;
		}
		
		//현재 날짜를 선택한 경우
		if(cur + days[cur] < N+1) {
			find_max(cur +days[cur],N, total + money[cur]);
		}
		
		//선택하지 않은 경우
		find_max(cur+1,N,total);
	}
}
