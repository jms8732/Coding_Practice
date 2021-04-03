package dp;

//มกวม
import java.util.*;
import java.io.*;
import java.math.*;

public class problem_1890 {
	static int [][] array;
	static BigInteger [][] cache;
	public static void main(String []args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		array=  new int[n][n];
		cache = new BigInteger[n][n];
		
		
		for(int i = 0 ; i <n  ;i++) {
			for(int j =0 ; j < n ;j++)
				cache[i][j] = new BigInteger("-1");
		}
		
		StringTokenizer st = null;
		
		for(int i =0 ; i < n ;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j =0 ; j < n ; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dp(0,0));
	}
	
	private static BigInteger dp(int x, int y) {
		if(x >= array.length || y >= array.length)
			return new BigInteger("0");
		
		if(array[x][y] == 0) {
			if(x== array.length-1 && y == array.length-1)
			return new BigInteger("1");
			else
				return new BigInteger("0");
		}
		
		if(cache[x][y].compareTo(new BigInteger("-1")) != 0)
			return cache[x][y];
		
		
		BigInteger ret = dp(x+array[x][y],y).add(dp(x,array[x][y]+y));
		
		return cache[x][y] = ret;
	}
}
