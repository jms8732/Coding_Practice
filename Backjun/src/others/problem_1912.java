package others;

//¿¬¼ÓÇÕ
import java.util.*;
import java.io.*;

public class problem_1912 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] array = new int[N];
		for(int i=0 ; i <N ; i++)
			array[i] = Integer.parseInt(st.nextToken());
		
		int big = array[0];
		for(int i =1 ; i < N ; i++) {
			array[i] = Math.max(array[i], array[i-1]+array[i]);
			big = Math.max(array[i], big);
		}
		
		System.out.println(big);
	}
}
