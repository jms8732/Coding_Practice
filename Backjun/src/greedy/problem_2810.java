package greedy;

import java.util.*;

/*
 * 컵 홀더
 * brute force를 할 경우, 2^50 => 시간 초과 발생
 * 1. N <= 50이므로 충분히 재귀를 이용하여 컵홀더가 부착된 좌석을 만들  수 있다. 따라서, 재귀를 이용하여 컵 홀더가 부착된 좌석을 만든다
 * 2. 반복문을 순회가면서 차지한 컵 홀더를 표기한 후, 차지된 컵 홀더의 수를 센다.
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
