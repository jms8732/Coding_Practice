package programmers;
//Ÿ�� �ѹ�

public class problem_29 {
	static String operator[] = {"+","-"};
	static int count =0;
	public static void main(String[] args) {
		int [] tmp = {1,1,1,1,1};
		int result =solution(tmp,3);
		System.out.println(result);
	}

	public static int solution(int[] numbers, int target) {
		
		dfs(0,numbers,target,0);
		return count;
		
	}
	
	public static void dfs(int idx, int[] numbers , int target, int value) {
		if(idx == numbers.length)
		{
			if(target ==value)
				count +=1;
			return;
		}
		
		for(int i =0 ; i< operator.length ; i++) {
			if(operator[i].equals("+")) { //������ ���
				value += numbers[idx];
				dfs(idx+1, numbers, target,value);
				value -= numbers[idx];
			}else {
				value -= numbers[idx];
				dfs(idx+1,numbers,target,value);
				value += numbers[idx];
			}
		}
	}
}
