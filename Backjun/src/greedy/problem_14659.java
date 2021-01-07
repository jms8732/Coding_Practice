package greedy;

/*
 * 한조서열정리하고옴ㅋ
 * 1. 용은 우측으로만 이동한다.
 * 2. 시작 높이보다 작은 궁수들만 죽일 수 있다. 시작 높이보다 높은 높이가 나올 경우, 용은 낮잠을 자기 때문에 바로 중단
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
