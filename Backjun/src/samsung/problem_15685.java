package samsung;
//�巡�� Ŀ��

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

			List<Integer> list = new ArrayList<>();
			list.add(x);
			list.add(y);

			List<List<Integer>> totalList = new ArrayList<>();
			totalList.add(list);

			switch (d) {
			case 0:
				x += 1;
				break;
			case 1:
				y -= 1;
				break;
			case 2:
				x -= 1;
				break;
			case 3:
				y += 1;
				break;
			}

			list = new ArrayList<>();
			list.add(x);
			list.add(y);

			totalList.add(list);

			start(g, totalList);
		}
		checkSquare();
	}
	private static void checkSquare() {
		int count =0;
		for(int i =0 ; i<= 100 ; i++) {
			for(int j =0 ; j<= 100 ; j++) {
				List<Integer> first = new ArrayList<>();
				first.add(i);
				first.add(j);
				
				List<Integer> second = new ArrayList<>();
				second.add(i+1);
				second.add(j);
				
				List<Integer> third = new ArrayList<>();
				third.add(i);
				third.add(j+1);
				
				List<Integer> fourth = new ArrayList<>();
				fourth.add(i+1);
				fourth.add(j+1);
				
				if(set.contains(first) && set.contains(second)
						&& set.contains(third) && set.contains(fourth))
					count++;
			}
		}
		
		System.out.println(count);
	}

	private static void start(int g, List<List<Integer>> list) {

		for (int i = 0; i < g; i++) {
			int idx = list.size() - 1;
			List<Integer> top = list.get(idx);
			int pivotX = top.get(0);
			int pivotY = top.get(1);

			int moveIdx = idx - 1;

			while (moveIdx >= 0) {
				List<Integer> tmp = list.get(moveIdx--);
				int x = tmp.get(0);
				int y = tmp.get(1);

				x -= pivotX;
				y -= pivotY;

				int rotateX = y * -1;
				int rotateY = x;

				List<Integer> tmpList = new ArrayList<>();
				tmpList.add(pivotX + rotateX);
				tmpList.add(pivotY + rotateY);

				list.add(tmpList);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			set.add(list.get(i));
		}
	}
}
