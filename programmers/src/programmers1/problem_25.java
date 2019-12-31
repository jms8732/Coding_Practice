package programmers1;
//소수 만들기

import java.util.*;

public class problem_25 {
	static int count =0;
	public static void main(String[] args) {
		int [] nums = {1,2,3,4};
		int result = solution(nums);
		System.out.println(result);
	}
	public static int solution(int[] nums) {
		int depth = 0;
		int n = 3;
		int [] value = new int[3];
		combination(0,0,value,nums);
		return count;
	}
	
	public static void combination(int depth,int next, int [] value, int [] nums) {
		if(depth == value.length) {
			if(isPrime(value)) 
				count++;
			return;
		}
		
		for(int i = next ; i < nums.length;  i++) {
			value[depth] = nums[i];
			combination(depth+1,i+1,value,nums);
		}
	}
	
	private static boolean isPrime(int[] value) {
		int sum =0;
		for(int i =0 ; i< value.length ; i++) {
			sum += value[i];
		}
		
		//소수 판단
		for(int i = sum-1; i >=2 ; i--) {
			if(sum % i == 0)
				return false;
		}
		return true;
	}
}
