package bruteForce;

//Doubles
import java.util.*;
import java.io.*;

public class problem_4641 {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Set<Integer> set = new LinkedHashSet<>(); 
		while(true) {
			String[] split = br.readLine().split(" ");
			
			if(split[0].equals("-1"))
				break;
			
			for(int i = 0 ; i < split.length -1; i++) {
				set.add(Integer.parseInt(split[i]));
			}
			
			int count = 0;
			for(int tar : set) {
				tar *= 2;
				
				if(set.contains(tar)) {
					count++;
				}
			}
			
			bw.write(count + "\n");
			set.clear();
		}
		
		bw.flush();
	}
}
