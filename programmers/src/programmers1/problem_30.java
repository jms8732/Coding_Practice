package programmers1;

//�Ҽ� ã��
public class problem_30 {
	public static void main(String[] args) {
		System.out.println(solution(10));
	}
	public static int solution(int n) {
		int count =0;
		boolean [] array =new boolean[n+1];
		
		//�����佺�׳׽� ü
		for(int i = 2;  i<= n ; i++) {
			if(!array[i]) {
				count++;
				for(int j = i ; j <= n ; j +=i)
					array[j] = true;
			}
		}
		
		return count;
	}
}
