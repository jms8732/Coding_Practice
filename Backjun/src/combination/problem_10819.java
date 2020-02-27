package combination;

import java.util.*;
import java.io.*;

//���̸� �ִ��
public class problem_10819 {
	static int big = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] array= new int[N];
		
		for(int i =0 ; i < N ; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int depth = 0;
		int[] answer= new int[N];
		permutation(depth,array,answer);
		System.out.println(big);
	}
	private static void permutation(int depth, int[] array, int [] answer) {
		if(depth == array.length) {
			int tmp =0;
			for(int i =0 ; i< answer.length ; i++) {
				int cur = i;
				int next = i+1;
				if(cur < answer.length && next < answer.length) {
					//�������� ������ ���
					tmp += Math.abs(answer[cur] - answer[next]);
				}
			}
			
			big = Math.max(big, tmp);
			
			return;
		}
		
		for(int i = depth ; i < array.length; i ++) {
			answer[depth] = array[i];
			swap(depth,i,array);
			permutation(depth+1,array,answer);
			swap(i,depth,array);
		}
	}
	private static void swap(int depth, int i, int[] array) {
		int tmp = array[i];
		array[i] = array[depth];
		array[depth] = tmp;
	}
}
