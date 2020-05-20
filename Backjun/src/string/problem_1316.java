package string;

//그룹 단어 채커
import java.util.*;
import java.io.*;

public class problem_1316 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		int answer =0 ;
		for(int i =0 ; i < tc ; i++) {
			if(isGroup(br.readLine())) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	private static boolean isGroup(String line) {
		Set<Character> alphabet = new HashSet<>();
		
		for(int i =0 ; i < line.length() ; i++)
			alphabet.add(line.charAt(i));
		
		Iterator<Character> it = alphabet.iterator();
		
		while(it.hasNext()) {
			char cur_char = it.next();
			Queue<Integer> idx = new LinkedList<>();
			
			for(int i =0 ; i< line.length() ; i++) {
				if(cur_char == line.charAt(i))
					idx.add(i);
			}
			
			int pre = idx.poll();
			while(!idx.isEmpty()) {
				int cur = idx.poll();
				
				if(Math.abs(pre-cur) != 1)
					return false;
				pre = cur;
			}
		}
		
		
		return true;
	}
}
