package dp;

//점프
import java.util.*;
import java.io.*;
import java.math.*;

public class problem_1890 {
	static int N, map[][]; 
	static BigInteger cache[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cache = new BigInteger[N][N];
		map = new int[N][N];
		
		for(int i =0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < N ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				cache[i][j] = new BigInteger("-1"); 
			}
		}
		
		System.out.println(path(0,0));
	}
	
	private static BigInteger path(int x, int y) {
		if(x >= N|| y >= N)
			return BigInteger.valueOf(0);
		
		//현재 지점이 점프가 0인 경우
		if(map[x][y] == 0) {
			return (x== N-1 && y == N-1 ? BigInteger.valueOf(1) : BigInteger.valueOf(0));
		}
		
		if(cache[x][y].compareTo(BigInteger.valueOf(-1)) != 0)
			return cache[x][y];
		
		BigInteger ret = new BigInteger("0");
		
		//오른쪽 혹은 아래로 이동하는 경로
		ret = ret.add((path(x+map[x][y],y)));
		ret = ret.add(path(x,y+map[x][y]));
		
		return cache[x][y] = ret;
	}
}
