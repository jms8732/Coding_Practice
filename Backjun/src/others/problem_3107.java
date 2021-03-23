package others;

/*
 * Ipv6
 * 문자열 파싱 및 구현
 */
import java.util.*;

public class problem_3107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String ipv6 = sc.nextLine();

		System.out.println(restoreIpv6(ipv6));
	}

	private static String restoreIpv6(String ipv6) {
		String ret = null;
		String split[] = ipv6.split(":");

		for (int i = 0; i < split.length; i++) {
			if (split[i].length() != 4) {
				// 생략된 부분이 존재
				StringBuilder sb = new StringBuilder(split[i]);
				for (int j = 0; j < 4 - split[i].length(); j++) { // 나머지를 0 으로 채운다.
					sb.insert(0, '0');
				}

				split[i] = sb.toString();
			}
		}

		if (split.length < 8) {
			// 그룹이 8이 되지 않는 경우
			split = fillZeroSplit(split);
		}

		ret = appendString(split);

		return ret;
	}

	private static String[] fillZeroSplit(String[] split) {
		String[] ret = new String[8];

		int ret_idx = 0, split_idx = 0;

		if (split.length == 0) {
			for (int i = 0; i < ret.length; i++) {
				ret[i] = "0000";

			}
		} else {

			while (ret_idx < 8) {
				if (split_idx < split.length && !split[split_idx].equals("0000"))
					ret[ret_idx++] = split[split_idx++];
				else {
					while (ret.length - ret_idx != split.length - split_idx) {
						ret[ret_idx++] = "0000";

						if (split_idx < split.length && split[split_idx].equals("0000"))
							split_idx++;
					}
				}
			}

		}
		return ret;
	}

	private static String appendString(String[] split) {
		StringBuilder sb = new StringBuilder();

		for (String s : split)
			sb.append(s + ":");

		sb = sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
