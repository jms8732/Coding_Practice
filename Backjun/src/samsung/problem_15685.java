package samsung;
//드래곤 커브

import java.util.*;
import java.io.*;

public class problem_15685 {
	static Set<List<Integer>> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;

		set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			// 현재 좌표를 넣는다.
			List<Integer> tmp = new ArrayList<>();
			tmp.add(x);
			tmp.add(y);

			// 임시적으로 좌표를 저장할 Set변수
			Set<List<Integer>> sTmp = new HashSet<>();
			sTmp.add(tmp);

			int nx = 0, ny = 0;

			// 세대만큼 반복문을 진행한다
			for (int j = 0; j <= g; j++) {
				int size = sTmp.size();

				if (size != 1)
					size -= 1;
				
				// 이전 세대의 내용
				while (size >= 1) {
					switch (d) {
					case 0:
						nx = x + 1;
						ny = y;
						d = 1;
						break;
					case 1:
						ny = y - 1;
						nx = x;
						d = 2;
						break;
					case 2:
						nx = x - 1;
						ny = y;
						d = 3;
						break;
					case 3:
						ny = y + 1;
						nx = x;
						d = 0;
						break;
					}

					tmp = new ArrayList<>();
					tmp.add(nx);
					tmp.add(ny);

					sTmp.add(tmp);

					x = nx;
					y = ny;
					size -= 1;
				}

			}
			addSet(sTmp);
		}

		checkCount();
	}
	private static void addSet(Set<List<Integer>> sTmp) {
		Iterator<List<Integer>> it = sTmp.iterator();
		
		while(it.hasNext()) {
			set.add(it.next());
		}
	}
	
	private static void checkCount() {
		int count = 0;
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {

				List<Integer> f = new ArrayList<>();
				f.add(i);
				f.add(j);

				List<Integer> s = new ArrayList<>();
				s.add(i);
				s.add(j + 1);

				List<Integer> t = new ArrayList<>();
				t.add(i + 1);
				t.add(j);

				List<Integer> ft = new ArrayList<>();
				ft.add(i + 1);
				ft.add(j + 1);

				// 네 점이 다 있는 정사각형을 찾았을 경우,
				if (set.contains(f) && set.contains(s) && set.contains(t) && set.contains(ft))
					count++;
			}
		}

		System.out.println(count);
	}
}
