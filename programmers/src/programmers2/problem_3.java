package programmers2;

//���� ������ �Ǻ�
public class problem_3 {
	public static void main(String[] args) {
		long result = solution(100);
		System.out.println(result);
	}
	public static long solution(long n) {
		double value = (double)Math.sqrt(n); //������
		int in = (int)Math.sqrt(n);
		
		
		
		if((value - in) == 0) {
			//������ �� ���
			return (long)Math.pow(value+1, 2);
		}else
			return -1;
	}
}
