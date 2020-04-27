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
		Collections.sort(sorted); // ���� ���� ����
		q.add(sorted);

		map.put(sorted, 0); // ������

		while (!q.isEmpty()) {
			List<Integer> cur = q.poll();
			int count = map.get(cur); // ���� ������ Ƚ��

			for (int i = 0; i < cur.size(); i++) {
				for (int j = i + 2; j <= cur.size(); j++) {
					List<Integer> tmp = new ArrayList<>(cur);
					Collections.reverse(tmp.subList(i, j)); // �κ� ����Ʈ �ٲٱ�

					// ���� �ٲ� ����Ʈ�� map�� �������� ���� ���
					if (!map.containsKey(tmp)) {
						map.put(tmp, count + 1);
						q.add(tmp); // BFS�� �����ϱ� ���� ť�� �ִ´�.
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
