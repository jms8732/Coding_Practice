package others;

//µÚÁýÈù µ¡¼À
import java.util.*;
import java.io.*;

public class problem_1357 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder x = new StringBuilder(st.nextToken());
		StringBuilder y = new StringBuilder(st.nextToken());
		
		x = x.reverse();
		y = y.reverse();
		
		int result = Integer.parseInt(x.toString()) + Integer.parseInt(y.toString());
		
		x = new StringBuilder(String.valueOf(result));
		x = x.reverse();
		
		System.out.println(Integer.parseInt(x.toString()));
	}
}
