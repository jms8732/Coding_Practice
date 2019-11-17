package programmers;
//종이 접기
import java.util.*;

public class problem_41 {
	public static void main(String[] args) {
		int n = 1;
		int[] result = solution(n);
		for(int i : result)
			System.out.print(i + " ");
	}

	public static int[] solution(int n) {
		int[] result =  new int[(int)(Math.pow(2, n)-1)]; 
		
		Vector<Integer> v = new Vector<>();
		dfs(v, 1, n,0);
		
		for(int i =0 ; i< v.size() ; i++) {
			result[i] = v.get(i);
		}
		
		return result;
	}
	
	public static void dfs(Vector<Integer> v, int idx , int n, int value) {
		if(idx == n ) {
			//종이 접은 횟수에 도달 했을 경우
			v.add(value);
			return;
		}
		
		dfs(v,idx+1,n,0); //좌측
		v.add(value); ///가운데
		dfs(v, idx+1, n, 1); //우측
	}
}
