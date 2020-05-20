package bruteForce;

//µ¢Ä¡
import java.util.*;
import java.io.*;

public class problem_7568 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Person p_array[] = new Person[N];
		
		for(int i =0 ; i < p_array.length ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			p_array[i] = new Person(w,h);
		}
		
		int rank [] = new int[N];
		Arrays.fill(rank, 1);
		
		for(int i =0 ; i < N ; i++) {
			Person cur = p_array[i];
			
			for(int j = 0 ; j < N ; j++) {
				if(i != j && (cur.weight > p_array[j].weight && cur.height > p_array[j].height)) {
					rank[j]++;
				}
			}
		}
		
		for(int a : rank)
			System.out.print(a + " ");
	}
	
	private static class Person{
		int weight, height;
		public Person(int w , int h) {
			this.weight = w;
			this.height = h;
		}
	}
}
