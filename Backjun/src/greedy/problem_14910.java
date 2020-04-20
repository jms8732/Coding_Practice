package greedy;

// ¿À¸£¸·
import java.util.*;
import java.io.*;

public class problem_14910 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String [] split = br.readLine().split(" ");
		
		int first = Integer.parseInt(split[0]);
		for(int i =1 ; i <split.length ; i++) {
			int next = Integer.parseInt(split[i]);
			
			if(first > next) {
				System.out.println("Bad");
				System.exit(0);
			}
			
			first = next;
		}
		
		System.out.println("Good");
	}
}
