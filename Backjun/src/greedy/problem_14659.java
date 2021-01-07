package greedy;

/*
 * �������������ϰ�Ȥ�
 * 1. ���� �������θ� �̵��Ѵ�.
 * 2. ���� ���̺��� ���� �ü��鸸 ���� �� �ִ�. ���� ���̺��� ���� ���̰� ���� ���, ���� ������ �ڱ� ������ �ٷ� �ߴ�
 */
import java.util.*;
import java.io.*;
public class problem_14659 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] mountain = new int[N];
		
		for(int i =0 ; i < mountain.length ; i++) {
			mountain[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bruteforce(mountain));
	}
	
	private static int bruteforce(int [] mountain) {
		int max = 0;
		for(int i =0 ; i < mountain.length ; i++) {
			int cur = mountain[i];
			
			int count = 0;
			for(int j = i+1; j < mountain.length ; j++) {
				if(cur > mountain[j])
					count++;
				else
					break;
			}
			
			max = Math.max(max, count);
		}
		
		return max;
	}
}
