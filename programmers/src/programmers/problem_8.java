package programmers;
//�ֽ� ����
public class problem_8 {
	public static void main(String[] args) {
		int []t  = {1, 2, 3, 2, 3};
		int [] result = solution(t);
		for(int tt : result) {
			System.out.print(tt + " ");
		}
	}
	public static int[] solution(int[] prices) {
		int[] array = new int[prices.length];
		for(int i = 0; i < prices.length ; i++) {
			for(int j = i+1 ; j <prices.length ; j++) {
				if(prices[j] < prices[i]) { //���� ���� ���� ������ ���� ���
					array[i] = j-i; //�� �ִ´�.
					break;
				}
				else
					array[i] = j-i;
			}
		}
		
		return array;
	}
	
}
