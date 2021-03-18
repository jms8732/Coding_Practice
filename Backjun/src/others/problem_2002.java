package others;

/*
 * 추월
 * Map을 이용하여 차량의 인덱스를 지정한다.
 * 그 후, 나가는 차량을 대상으로 앞서는 차량이 존재하는 지 판단하여 출력
 */
import java.util.*;
import java.io.*;
public class problem_2002 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String [] input = new String[n];
		
		for(int i =0 ; i < n ; i++) {
			input [i] = br.readLine();
		}
		
		String [] output = new String[n];
	
		for(int i =0 ; i < n ; i++) {
			output[i] = br.readLine();
		}
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i =0 ; i < n ; i++) {
			map.put(input[i],i);
		}
		
		int ans =0 ;
		int [] output_idx = new int[n];
	
		for(int i =0 ; i  < output.length ; i++) {
			output_idx[i] = map.get(output[i]);
		}
		
		for(int i = output_idx.length-2 ; i >= 0 ; i--) {
			int previous = output_idx[i+1];
			int current = output_idx[i];
			
			if(previous < current)
				ans++;
			
			output_idx[i] = Math.min(previous, current);
		}
		
		System.out.println(ans);
	}

}
