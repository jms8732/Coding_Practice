package kakao_2021;

/*
 * ���� ����
 * �켱, ����� ���ϱ� �ϱ� ���ؼ� �ð��� �ʷ� �����.
 * �� ��, �������� �̿��Ͽ� ���� �����鼭 ���� ���� ���� ���������� ã�´�.
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

			// �ش� ������ ��û�� ��
			for (int j = logs_start; j < logs_end; j++)
				time[j]++;
		}

		long max = 0;
		long sum = 0;

		
		//0~���� ���۱��̱��� �������� ���Ѵ�.
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < adv; i++) {
			q.add(time[i]);
			sum += time[i];
		}

		max = sum;
		int start = 0; //���� ���� ���� ��ġ
		
		/*
		 * ť�� �̿��� ��������
		 *
		 * ���� ���� ���� ��, ���̰� ������ �ִ� ���� �����Ѵ�.
		 * ��, 0~adv�� ���̱����� ���� ���ѵ�, �������ʹ� �ڿ� ���� �ϳ� ���ϰ� ���� ���� �ϳ��� ���� ������� �����ϸ�
		 * O(n) �ð� ���� �ذ��� �����ϴ�. => ���ī���� ������ ���
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
