package greedy;

import java.util.*;

/*
 * �� Ȧ��
 * brute force�� �� ���, 2^50 => �ð� �ʰ� �߻�
 * 1. N <= 50�̹Ƿ� ����� ��͸� �̿��Ͽ� ��Ȧ���� ������ �¼��� ����  �� �ִ�. ����, ��͸� �̿��Ͽ� �� Ȧ���� ������ �¼��� �����
 * 2. �ݺ����� ��ȸ���鼭 ������ �� Ȧ���� ǥ���� ��, ������ �� Ȧ���� ���� ����.
 */
public class problem_2810 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String seats = sc.next();
		String cupHolderSeats = attachCupHolder(seats, 0);

		boolean[] occupied = new boolean[cupHolderSeats.length()];

		for (int i = 1; i < cupHolderSeats.length(); i++) {
			if (cupHolderSeats.charAt(i) == 'S') {
				int left = i - 1;
				int right = i + 1;
				if (!occupied[left]) {
					occupied[left] = true;
					continue;
				}

				if (!occupied[right]) {
					occupied[right] = true;
					continue;
				}
			}else if(cupHolderSeats.charAt(i) == 'L') {
				int left = i -1;
				int right = i+2;
				
				if(!occupied[left]) {
					occupied[left] = true;
				}
				
				if(!occupied[right]) {
					occupied[right] = true;
				}
				
				i++;
			}
		}
		
		int ans =0 ;
		for(boolean b : occupied) {
			if(b)
				ans++;
				
		}
		
		System.out.println(ans);
	}

	private static String attachCupHolder(String seats, int idx) {
		if (idx == seats.length())
			return "*";

		StringBuilder sb = new StringBuilder();

		if (seats.charAt(idx) == 'S') {
			sb.append("*S");
			sb.append(attachCupHolder(seats, idx + 1));
		} else {
			sb.append("*LL");
			sb.append(attachCupHolder(seats, idx + 2));
		}

		return sb.toString();
	}

}
