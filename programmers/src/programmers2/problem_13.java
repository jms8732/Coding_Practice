package programmers2;

//[3차] 방금 그곡
import java.util.*;

public class problem_13 {
	static int MAX = 0;
	static String answer = "";

	public static void main(String[] args) {
		String m = "ABC";
		String[] infos = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };

		String result = solution(m, infos);
		System.out.println(result);
	}

	public static String solution(String m, String[] musicinfos) {

		m = makeString(m);

		for (int i = 0; i < musicinfos.length; i++) {
			String[] split = musicinfos[i].split(",");

			String startTime = split[0];
			String endTime = split[1];

			int totalMinutes = calculate(startTime, endTime);

			String title = split[2];
			String melody = split[3];

			search(totalMinutes, melody, m, title);
		}

		if (answer == "")
			return "(None)";
		else
			return answer;
	}

	private static String makeString(String pattern) {
		pattern = pattern.replaceAll("A#", "a");
		pattern = pattern.replaceAll("C#", "c");
		pattern = pattern.replaceAll("D#", "d");
		pattern = pattern.replaceAll("F#", "f");
		pattern = pattern.replaceAll("G#", "g");

		return pattern;
	}

	private static void search(int tm, String melody, String pattern, String title) {
		// 시간이 길이보다 큰 경우
		StringBuilder sb = new StringBuilder();
		melody = makeString(melody);
		
		int div = tm / melody.length();
		int mol = tm % melody.length();

		for (int i = 0; i < div; i++) {
			sb.append(melody);
		}

		sb.append(melody.substring(0, mol));

		if (sb.toString().contains(pattern)) {
			if (MAX < tm) {
				MAX = tm;
				answer = title;
			}
		}
	}

	private static int calculate(String st, String et) {
		String [] split;
		split = st.split(":");
		int startH = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
		split = et.split(":");
		int endH = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
		
		return Math.abs(endH -startH);
	}

}
