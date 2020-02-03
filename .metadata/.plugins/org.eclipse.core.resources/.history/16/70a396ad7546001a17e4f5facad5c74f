package programmers2;

//하노이의 탑
import java.util.*;

public class problem_12 {
	static List<List<Integer>> list;
	public static void main(String[] args) {
		int [][] result = solution(2);
		
		for(int i [] : result) {
			for(int j =0 ; j < i.length ; j++) {
				System.out.print(i[j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] solution(int n) {
		list = new ArrayList<>();
		hanoii(n,1,3,2);
		
		int [][] answer = new int[list.size()][2];
		
		for(int i =0 ; i < list.size() ; i++) {
			List<Integer> tmpList = list.get(i);
			for(int j = 0 ; j< 2 ; j++) {
				answer[i][j] = tmpList.get(j);
			}
		}
		
		return answer;
		
	}
	
	private static void hanoii(int n, int from ,int to, int others) {
		if(n == 0)
			return;
		hanoii(n-1,from,others,to);
		List<Integer> tmpList = new ArrayList<>();
		tmpList.add(from);
		tmpList.add(to);
		list.add(tmpList);
		hanoii(n-1,others,to,from);
		
	}
}
