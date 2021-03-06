package programmers;

//여행 경로 75점
//맨처음 집합을 이용
import java.util.*;

public class problem_46 {
	public static void main(String[] args) {
		String[][] tmp = { { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" } };
		String[] result = solution(tmp);
		for (String s : result)
			System.out.print(s + " ");
	}

	public static String[] solution(String[][] tickets) {
		List<Node> totalList = new ArrayList<>();

		String[] result = new String[tickets.length + 1];

		for (int i = 0; i < tickets.length; i++) {
			String depart = tickets[i][0];
			String dest = tickets[i][1];
			totalList.add(new Node(depart, dest, null, result, 0));
		}

		totalList.sort(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) { // 목적지로 정렬
				// TODO Auto-generated method stub
				if (o1.destination.compareTo(o2.destination) < 0)
					return -1;
				else
					return 1;
			}

		});

		List<Node> headList = new ArrayList<>();

		for (int i = 0; i < totalList.size(); i++) {
			String depart = totalList.get(i).departure;
			String dest = totalList.get(i).destination;

			if (depart.equals("ICN")) {
				List<Node> tmpList = new ArrayList<>(totalList);
				for (int j = 0; j < tmpList.size(); j++) {
					if (depart.equals(tmpList.get(j).departure) && dest.equals(tmpList.get(j).destination)) {
						tmpList.remove(j);
						break;
					}
				}
				headList.add(new Node(depart, dest, tmpList, result, 0));
			}
		}

		headList.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) { // 목적지를 대상으로 오름차순 정렬
				// TODO Auto-generated method stub
				if (o1.destination.compareTo(o2.destination) < 0)
					return -1;
				else
					return 1;
			}

		});

		Queue<Node> queue = new LinkedList<>();
		Node last = null;

		for (int k = 0; k < headList.size(); k++) {
			queue.add(headList.get(k));

			while (!queue.isEmpty()) {
				Node tmp = queue.poll();
				String depart = tmp.departure;
				String dest = tmp.destination;
				List<Node> restNode = tmp.restNode;

				if (restNode.isEmpty()) {
					last = tmp;
					break;
				}

				for (int i = 0; i < restNode.size(); i++) {
					// 다음 행선지
					String nextDepart = restNode.get(i).departure;
					String nextDest = restNode.get(i).destination;

					if (dest.equals(nextDepart)) {
						// 목적지와 출발지가 같은 경우
						List<Node> tmpList = new ArrayList<>(restNode);
						tmpList.remove(i);
						int idx = tmp.idx;
						String[] ttmp = tmp.result;
						ttmp[idx] = depart;
						queue.add(new Node(nextDepart, nextDest, tmpList, ttmp, idx + 1));
					}
				}
			}
			if (last != null) { //마지막은 순회가 안됬기 때문에 넣어준다.
				result = last.result;
				result[last.idx] = last.departure;
				result[last.idx + 1] = last.destination;
				boolean check = false;
				for (String t : result) {
					if (t == null) {
						check = true;
						break;
					}
				}
				if (!check)
					return result;
			}
		}
		return null;
	}

	public static class Node {
		String departure;
		String destination;
		List<Node> restNode;
		String[] result;
		int idx = 0;

		public Node(String depart, String dest, List<Node> rest, String[] result, int idx) {
			this.departure = depart;
			this.destination = dest;
			this.restNode = rest;
			this.result = new String[result.length];
			System.arraycopy(result, 0, this.result, 0, result.length);
			this.idx = idx;
		}
	}
}
