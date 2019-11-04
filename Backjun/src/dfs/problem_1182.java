package dfs;
import java.util.*;

public class problem_1182 {
	static Scanner scanner = new Scanner(System.in);
	static int arrayCount = scanner.nextInt();
	static int findSum = scanner.nextInt();
	static int count = 0 ; // findSum과 일치하는 값을 찾는다.
	public static void main(String[] args) {
		int [] tmpArray= new int[arrayCount];
		for(int i= 0 ; i< arrayCount ; i++) {
			int idx = scanner.nextInt();
			tmpArray[i] = idx;
		}
		DFS(0,tmpArray,0);
		System.out.println(count);
		
	}
	
	static void DFS(int idx, int[] array, int lenCount) {
		lenCount++;
		if(idx == findSum)
			count++;
		if(lenCount == array.length)
			return;
		DFS(idx,array,lenCount);
		
		DFS((idx += array[lenCount]),array,lenCount);
		
	}
	
	
}
