package string;

//brainFuck
import java.util.*;
import java.io.*;

public class problem_2733 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringBuilder sb = new StringBuilder();

			int[] array = new int[32767];
			int pointer = 0;
			int [] partner = new int[32767];
			String tmp = null;
			
			
			while (!(tmp = br.readLine()).equals("end")) {
				tmp = tmp.replaceAll(" ", "");
				tmp = tmp.replaceAll("=","");
				if (tmp.contains("%")) {
					int idx = tmp.indexOf("%");
					if (idx != 0)
						sb.append(tmp.substring(0, idx).trim());
				} else
					sb.append(tmp);
			}
			int open = 0, close = 0;
			for (int j = 0; j < sb.length(); j++) {
				if (sb.charAt(j) == '[')
					open++;
				if (sb.charAt(j) == ']')
					close++;
			}

			System.out.println("PROGRAM #" + (i + 1) + ":");

			if (open == close) {
				// 공백 제거
				partnership(sb.toString(),partner);
				interprinter(sb.toString(),partner,pointer,array);
			} else
				System.out.println("COMPILE ERROR");

		}
	}
	
	private static void partnership(String line, int [] partner) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i =0 ; i < line.length() ; i++) {
			if(line.charAt(i) == '[')
				stack.add(i);
			else if(line.charAt(i) == ']') {
				int pair = stack.pop();
				partner[pair] = i;
				partner[i] = pair;
			}
		}
	}

	private static void interprinter(String line, int [] partner, int pointer , int [] array) {
		for (int i = 0; i < line.length(); i++) {
			char cur = line.charAt(i);
			
			if(cur == '<') {
				if(pointer == 0)
					pointer = array.length-1;
				else
					pointer -=1;
				continue;
			}
			
			if(cur == '>') {
				if(pointer == array.length)
					pointer = 0;
				else
					pointer += 1;
				continue;
			}
			
			if(cur == '[') {
				if(array[pointer] == 0)
					i = partner[i]-1;
				
				continue;
			}
			
			if(cur == ']') {
				if(array[pointer] != 0)
					i = partner[i]-1;
				
				continue;
			}
			
			if (cur == '+') {
				if (array[pointer] + 1 > 255)
					array[pointer] = 0;
				else
					array[pointer] += 1;

				continue;
			}

			if (cur == '-') {
				if (array[pointer] - 1 < 0)
					array[pointer] = 255;
				else
					array[pointer] -= 1;

				continue;
			}
		
			if(cur == '.')
				System.out.print((char)array[pointer]);
		}
		System.out.println();
	}
}
