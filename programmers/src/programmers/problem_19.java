package programmers;

//체육복 25점 -> 41.7점(반환값 수정) -> 소스코드 바꿈 66.6점 -> 조건 추가 83.3
import java.util.*;

public class problem_19 {
	public static void main(String[] args) {
		int[] lost = { 3,4,5,6 };
		int[] reserver = { 29,30};
		int result = solution(30, lost, reserver);
		System.out.println(result);
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		boolean[] have = new boolean[n + 1];
		int[] total = new int[n + 1];
		int big = 0;
		Arrays.fill(total, 1); // 1로 값 채우기

		for (int i = 0; i < lost.length; i++) {
			total[lost[i]] = 0; // 잃어 버린 인덱스의 값을 0으로 설정
		}
		for (int i = 0; i < reserve.length; i++) {
			have[reserve[i]] = true; // 여분의 옷을 가지고 있는 인덱스를 true
		}
		total[0] = 0;
		int[] tmp = new int[n + 1];
		int j = 1; // 처음은 우측
		boolean[] tmpHave = new boolean[n + 1];
		for (int k = 0; k < 3; k++) {
			System.arraycopy(total, 0, tmp, 0, (n + 1)); // 배열 복사
			System.arraycopy(have, 0, tmpHave, 0, (n + 1));
			if (k < 2) {
				for (int i = 1; i <= n; i++) {
					if (tmpHave[i]) {
						// 여분의 체육복이 있는 경우
						if (tmp[i] == 0) {// 자기 자신이 없는 경우
							tmp[i] = 1;
							tmpHave[i] = false;
						}else if(i+j < tmp.length && !tmpHave[i+j] && tmp[i+j] == 0) {
							//그 나머지 경우
							tmpHave[i] = false;
							tmp[i+j] =1;
						}
					} 
				}
			} else {
				for (int i = 1; i <= n; i++) {
					// 양쪽으로 건내줄 경우
					if (tmpHave[i]) {
						if (tmp[i] == 0) {
							tmp[i] = 1;
							tmpHave[i] = false;
						}else if(!tmpHave[i-1] && tmp[i-1] == 0) {
							tmp[i-1] =1;
							tmpHave[i] = false;
						}else if(i+j < tmp.length &&!tmpHave[i+1] && tmp[i+1] == 0) {
							tmp[i+1] =1;
							tmpHave[i] =false;
						}
					}
				}
			}

			int count = 0; // 1의 개수를 센다
			for (int i = 1; i < tmp.length; i++) {
				if (tmp[i] == 1)
					count++;
			}
			big = Math.max(big, count);
			j *= -1; // 다음은 좌측
		}

		return big;
	}
}
