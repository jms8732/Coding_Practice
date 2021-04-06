package kakao_2021;

/*
 * 광고 삽입
 * 우선, 계산을 편하기 하기 위해서 시간을 초로 맞춘다.
 * 그 후, 구간합을 이용하여 가장 빠르면서 누적 수가 많은 시작지점을 찾는다.
 */
import java.util.*;

public class problem_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String logs[] = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29",
				"01:37:44-02:02:30" };
		String play = "02:03:55";
		String adv = "00:14:15";

		System.out.println(solution(play, adv, logs));
	}

	public static String solution(String play_time, String adv_time, String[] logs) {
		int[] time = new int[60 * 60 * 100];

		int play = convert(play_time);
		int adv = convert(adv_time);

		for (int i = 0; i < logs.length; i++) {
			int[] ct = convertTime(logs[i]);

			int logs_start = ct[0];
			int logs_end = ct[1];

			// 해당 구간의 시청자 수
			for (int j = logs_start; j < logs_end; j++)
				time[j]++;
		}

		long max = 0;
		long sum = 0;

		
		//0~광고 시작길이까지 구간합을 구한다.
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < adv; i++) {
			q.add(time[i]);
			sum += time[i];
		}

		max = sum;
		int start = 0; //가장 빠른 시작 위치
		
		/*
		 * 큐를 이용한 투포인터
		 *
		 * 구간 합을 구할 때, 길이가 정해져 있는 것을 생각한다.
		 * 즉, 0~adv의 길이까지는 합을 구한뒤, 다음부터는 뒤에 값을 하나 더하고 앞의 값을 하나씩 빼는 방식으로 진행하면
		 * O(n) 시간 내에 해결이 가능하다. => 라빈카프와 유사한 방법
		 */
		for (int i = adv; i < play; i++) {
			sum += time[i];
			q.add(time[i]);
			sum -= q.poll();

			if (max < sum) {
				max = sum;
				start = i - adv + 1;
			}
		}

		return convertSecToString(start);
	}

	//sec -> string
	private static String convertSecToString(int start) {
		String hour = String.format("%02d", start / 3600);
		String minute = String.format("%02d", (start % 3600) / 60);
		String sec = String.format("%02d", ((start % 3600) % 60));

		return hour + ":" + minute + ":" + sec;
	}

	private static int[] convertTime(String time) {
		String[] split = time.split("-");

		int[] ret = new int[2];
		for (int i = 0; i < 2; i++) {
			ret[i] = convert(split[i]);
		}

		return ret;
	}

	//string -> sec
	private static int convert(String time) {
		String[] split = time.split(":");
		int ret = 0;

		int[] t = { 3600, 60, 1 };
		for (int i = 0; i < split.length; i++) {
			ret += Integer.parseInt(split[i]) * t[i];
		}

		return ret;
	}
}
