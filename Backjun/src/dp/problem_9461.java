package dp;

//파도반 수열
import java.io.*;

public class problem_9461 {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long [] dp = new long[101];
		long [] temp = new long[] {1,1,1,2,2};
		
		System.arraycopy(temp, 0, dp, 0, temp.length);
		
		for(int i =5 ; i < dp.length ; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		
		for(int i =0 ; i < N ; i++) {
			int l = Integer.parseInt(br.readLine());
			bw.write(dp[l-1]+"\n");
		}
		
		bw.flush();
	}
}
