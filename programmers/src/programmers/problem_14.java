package programmers;


import java.util.*;
//소수 찾기 83.3점
public class problem_14 {
	public static void main(String[] args) {
		int result = solution("0113");
		System.out.println(result);
	}

	public static int solution(String numbers) {
		HashSet<Integer> set = new HashSet<>();
		int idx = 0;
		for(int i =0 ; i < numbers.length() ; i++) {
			String value = numbers.substring(i,i+1);
			StringBuilder sb = new StringBuilder(numbers);
			sb = sb.deleteCharAt(i);
			dfs(numbers.length(), sb.toString(),set,value,idx+1);
		}
		

		return set.size();
	}
	
	public static void dfs(int size, String remain, HashSet<Integer> set, String value, int idx) {
		if(value.length() == size)
		{
			int tmp = Integer.parseInt(value);
			if(isPrime(tmp)) {
				set.add(tmp);
			}
			return ;
		}
		if(isPrime(Integer.parseInt(value))) //소수인지 판단
			set.add(Integer.parseInt(value));
		
		for(int i = 0 ; i < remain.length()  ; i++) {
			char c= remain.charAt(i);
			StringBuilder sb = new StringBuilder(value);
			sb = sb.append(c);
			StringBuilder resb = new StringBuilder(remain);
			resb = resb.deleteCharAt(i);
			dfs(size,resb.toString(),set,sb.toString(),idx+1);
			sb = sb.deleteCharAt(idx);
		}
	}
	public static boolean isPrime(int c) {
		int tmp = c;
		if(c ==1 || c == 0)
			return false;
		
		for(int i = 2 ; i <= (int)Math.sqrt(c); i++)
		{
			if(c % i == 0)
				return false;
		}
		return true;
	}
}
