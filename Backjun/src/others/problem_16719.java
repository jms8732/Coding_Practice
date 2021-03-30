package others;

/*
 * ZOAC
 * �������� �䱸�ϴ� ��� ������ �����ϸ� �ȴ�. �ڼ��� �� �Ʒ� �ּ� ����
 */
import java.util.*;

public class problem_16719 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		simulation(line.toCharArray());

		sc.close();
	}

	private static void simulation(char[] array) {
		int len = 0;
		
		//���������� ���� ���� ���ڿ��� �����ϴ� �迭
		boolean finalCheck[] = new boolean[array.length];

		//1���� �����Ͽ� �迭�� ���̱��� ������ ����.
		while (++len <= array.length) {
			boolean[] temp = Arrays.copyOf(finalCheck, finalCheck.length); //������ ������� �迭�� �� �Ҵ�
			String first = null; //����� �� ���ڿ� �Ҵ�
			for(int i =0 ; i < array.length ; i++) {
				if(!temp[i]) {
					temp[i] = true;
					String t = makeString(array,temp);
					
					//���� ���̿� �´� ���ڿ��� ����鼭 ������ ��
					if(first == null) {
						first = t;
						System.arraycopy(temp, 0, finalCheck, 0, temp.length);
					}else {
						if(t.compareToIgnoreCase(first) < 0) {
							first = t;
							System.arraycopy(temp, 0, finalCheck, 0, temp.length);
						}
					}
					
					temp[i] = false;
				}
			}
			
			//���� ���̿� ���������� ���� ���� ���ڿ� ���
			print(array,finalCheck);
		}
	}

	
	private static void print(char[] array,  boolean [] check) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < check.length ; i++) {
			if(check[i])
				sb.append(array[i]);
		}
		System.out.println(sb.toString());
	}
	private static String makeString(char[] array, boolean[] check) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (check[i])
				sb.append(array[i]);
		}

		return sb.toString();
	}
}
