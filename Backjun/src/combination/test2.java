package combination;

import java.util.*;

//중복 조합 만들기
public class test2 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		int [] data = {1,2,5};
		
		reCombination(list,data,0,0,5);
	}
	
	private static void reCombination(List<Integer> list ,int[] data, int depth, int value,int n ) {
		if(value >=  n) {
			if(value == n) {
				print(list);
			}
			return;
		}
		
		if(depth == data.length)
			return;
		
		list.add(data[depth]);
		reCombination(list,data,depth,value+data[depth],n);
		list.remove(list.size()-1);
		reCombination(list,data,depth+1,value,n);
	}
	
	private static void print(List<Integer> list) {
		for(int i : list)
			System.out.print(i +" " );
		System.out.println();
	}
}
