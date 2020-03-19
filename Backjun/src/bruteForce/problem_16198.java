package bruteForce;

//에너지 모으기
import java.util.*;
import java.io.*;

public class problem_16198 {
	static int big = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i =0 ; i < N ; i++) list.add(Integer.parseInt(st.nextToken()));
		
		makeMaximumEnergy(list,0);
		System.out.println(big);
	}
	
	private static void makeMaximumEnergy(List<Integer> list,int value) {
		if(list.size() == 2) {
			//처음과 끝의 에너지만 남아 있는 경우
			big = Math.max(big, value);
			return;
		}
		
		//처음과 마지막 에너지는 사용이 불가능하므로 범위를 조정한다.
		for(int i = 1 ; i < list.size()-1;i++) {
			int v = list.get(i-1) * list.get(i+1);
			int tmp = list.get(i);
			
			list.remove(i);
			makeMaximumEnergy(list,value+v);
			list.add(i,tmp);
			
		}
		
	}
}
