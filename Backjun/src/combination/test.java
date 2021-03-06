package combination;


/*
 * 순열을 표현하는 방법중 swap과 visited 방법이 있다.
 * 이때 visited와 swap의 시간 비교
 * 배열의 길이가 10일 경우, visited = 0.291, swap= 0.053
 * swap이 visited보다 4배 빠른 것을 확인
 */
import java.util.*;

public class test {
	static boolean[] visited;
	static int count;
	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,6,7,8};
		visited = new boolean[array.length];
		int value[] = new int[array.length];
		int depth = 0;
		
		long start = System.currentTimeMillis();
		for(int i =0 ; i< array.length ; i++) {
			if(!visited[i])
			{
				visited[i] = true;
				value[depth]= array[i];
				visitedDfs(array,value,depth+1);
				visited[i] =false;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("visited time : " + (end-start)/1000.0);
		System.out.println("count : " + count);
		depth = 0 ;
		count = 0;
		start = System.currentTimeMillis();
		swapDfs(array,0,array.length,array.length);
		end = System.currentTimeMillis();
		System.out.println("swap time : " + (end-start)/1000.0);
		System.out.println("count : " + count);
	}
	private static void swapDfs(int array[], int depth,int n ,int r) {
		if(depth == r) {
			count++;
			return; 
		}
		
		for(int i = depth ; i < n ; i++) {
			swap(depth,i,array);
			swapDfs(array,depth+1,n,r);
			swap(depth,i,array);
		}
	}
	
	
	private static void swap(int depth, int i , int array[]) {
		int tmp = array[depth];
		array[depth] = array[i];
		array[i] = tmp;
	}
	
	private static void visitedDfs(int [] array,int [] value, int depth) {
		if(array.length == depth) {
			count++;
			return;
		}
		for(int i =0 ; i< array.length ; i++) {
			if(!visited[i])
			{
				visited[i] = true;
				value[depth] = array[i];
				visitedDfs(array,value,depth+1);
				visited[i] = false;
			}
		}
		
		return ;
	}
	private static void print(int [] array) {
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
