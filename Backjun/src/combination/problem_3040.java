package combination;

//�鼳 ���ֿ� �ϰ� ������
import java.util.*;

public class problem_3040 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int [] array = new int[9];
		int [] answer = new int[7];
		for(int i =0 ; i< array.length ; i ++) array[i] = scanner.nextInt();
		
		int depth=0,next =0;
		dfs(depth,next,answer,array);
		
	}
	
	private static void dfs(int depth , int next , int[] answer, int[] array) {
		if(depth == answer.length) {
			int sum =0 ;
			for(int i =0 ; i< answer.length ; i++)
				sum += answer[i];
			
			if(sum == 100)
			{
				print(answer);
				System.exit(0);
			}
			
			return;
		}
		
		for(int i =next ; i < array.length ; i++) {
			answer[depth] = array[i];
			dfs(depth+1,i+1,answer,array);
		}
	}
	
	
	private static void print(int [] answer){
		for(int i =0 ; i< answer.length ; i++)
			System.out.println(answer[i]);
	}
}
