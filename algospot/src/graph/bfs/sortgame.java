package graph.bfs;

//Sorting game
import java.util.*;
import java.io.*;

public class sortgame {
	static HashMap<List<Integer>, Integer> map = new HashMap<>();
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int len = Integer.parseInt(br.readLine());

			List<Integer> val = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < len; j++) {
				val.add(Integer.parseInt(st.nextToken()));
			}

			val = convert(val);
			System.out.println(sorting(val));
		}
	}

	private static int sorting(List<Integer> val) {
		Queue<List<Integer>> q = new LinkedList<>();

		List<Integer> sorted = new ArrayList<>(val);
		Collections.sort(sorted); // 오름 차순 정렬
		q.add(sorted);

		map.put(sorted, 0); // 시작점

		while (!q.isEmpty()) {
			List<Integer> cur = q.poll();
			int count = map.get(cur); // 현재 변경한 횟수

			for (int i = 0; i < cur.size(); i++) {
				for (int j = i + 2; j <= cur.size(); j++) {
					List<Integer> tmp = new ArrayList<>(cur);
					Collections.reverse(tmp.subList(i, j)); // 부분 리스트 바꾸기

					// 현재 바꾼 리스트가 map에 존재하지 않을 경우
					if (!map.containsKey(tmp)) {
						map.put(tmp, count + 1);
						q.add(tmp); // BFS를 수행하기 위해 큐에 넣는다.
					}

				}
			}
		}

		
		return map.get(val);
	}
	
	private static List<Integer> convert(List<Integer> val){
		List<Integer> result = new ArrayList<>();
		
		for(int i =0 ; i < val.size() ; i++) {
			int big =0;
			for(int j =0 ; j < val.size() ; j++) {
				if(val.get(i) > val.get(j))
					big++;
			}
			result.add(big);
		}
		
		return result;
	}
}
