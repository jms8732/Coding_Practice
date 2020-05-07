package programmers2;

//매칭 점수
import java.util.*;

public class problem_28 {
	static Map<String, info> map = new LinkedHashMap<>();

	public static void main(String[] args) {
		String[] pages = {
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>" };
		String word = "Muzi";

		System.out.println(solution(word, pages));
	}

	public static int solution(String word, String[] pages) {
		for (int i = 0; i < pages.length; i++) {
			parsing(pages[i], word);
		}

		int answer = cal();

		return answer;
	}

	// 링크 점수 계산
	private static int cal() {
		Iterator<String> key = map.keySet().iterator();
		int r_idx = 0, idx = 0;
		double result = 0;

		while (key.hasNext()) {
			String k = key.next();

			List<String> outLink = map.get(k).outLink;

			int bp = map.get(k).basepoint;
			int lc = map.get(k).outlinkCount;
			double outpoint = (double) bp / (double) lc;

			for (String out : outLink) {
				if (map.containsKey(out))
					map.get(out).totalPoint += outpoint;
			}

		}

		key = map.keySet().iterator();

		while (key.hasNext()) {
			String k = key.next();

			if (result < map.get(k).basepoint + map.get(k).totalPoint) {
				result = map.get(k).basepoint + map.get(k).totalPoint;
				r_idx = idx;
			}
			idx++;
		}
		return r_idx;
	}

	private static void parsing(String pages, String word) {
		String meta = "meta property=\"og:url\"";
		int contentIdx = pages.indexOf(meta); // 맨처음 나타는 content
		contentIdx += meta.length() + 10; // ontent= 의 길이를 더한다.

		String name = null; // 현재 페이지 이름

		for (int i = contentIdx; i < pages.length(); i++) {
			// 닫는 따옴표 인경우
			if (pages.charAt(i) == '"') {
				name = pages.substring(contentIdx, i);
				break;
			}
		}

		int href_idx = pages.indexOf("a href");
		List<String> outLink = new ArrayList<>();

		// 외부 링크를 찾는다.
		while (href_idx != -1) {
			href_idx += 8;

			for (int i = href_idx; i < pages.length(); i++) {
				if (pages.charAt(i) == '"') {
					String tmp = pages.substring(href_idx, i);
					outLink.add(tmp);
					break;
				}
			}

			href_idx = pages.indexOf("a href", href_idx);
		}

		int baseCount = 0;

		pages = pages.toLowerCase();
		word = word.toLowerCase();

		int idx = pages.indexOf(word);

		while (idx != -1) {
			int pre = idx - 1;
			int next = idx + word.length();

			// 이스케이프 문자들
			char pp = pages.charAt(pre);
			char pn = pages.charAt(next);

			if ((pp < 'a' || pp > 'z') && (pn < 'a' || pn > 'z'))
				baseCount++;

			idx = pages.indexOf(word, next);
		}

		int outlinkCount = outLink.size();

		info inf = new info(baseCount, outlinkCount, outLink);
		map.put(name, inf);
	}

	private static class info {
		List<String> outLink;
		int basepoint, outlinkCount;
		double totalPoint = 0.0;

		public info(int b, int o, List<String> ol) {
			this.basepoint = b;
			this.outlinkCount = o;
			this.outLink = new ArrayList<>(ol);
		}
	}
}
