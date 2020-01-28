package samsung_Atype;

//야구공
import java.util.*;
import java.io.*;

public class problem_17281 {
	static int inning;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		inning = Integer.parseInt(br.readLine());
		Node[] players = new Node[9];
		List[] tmpList = new ArrayList[9];

		for (int i = 0; i < tmpList.length; i++)
			tmpList[i] = new ArrayList<>();

		for (int i = 0; i < inning; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < tmpList.length; j++) {
				tmpList[j].add(Integer.parseInt(st.nextToken()));
			}
		}

		// 1번째 선수는 4번 타자이므로
		players[3] = new Node(tmpList[0], 0);
		int idx = 1;
		// 선수들에 관한 정보 저장
		for (int i = 0; i < players.length; i++) {
			if (i != 3)
				players[i] = new Node(tmpList[idx], idx++);
		}
		int depth = 0;
		long start = System.currentTimeMillis();
		dfs(depth, players);
		long end = System.currentTimeMillis();
		
		System.out.println(answer);
		System.out.println("time : " + (end-start)/1000.0);
	}

	private static void dfs(int depth, Node[] players) {
		if (depth == players.length) {

			int value = 0;
			Queue<Node> player = new LinkedList<>();

			for (int i = 0; i < players.length; i++)
				player.add(players[i]);

			for (int i = 0; i < inning; i++) {
				value += startGame(player, i);
			}
			answer = Math.max(value, answer);

			//print(players);
			return;
		}

		for (int i = depth; i < players.length; i++) {
			swap(depth, i, players);
			dfs(depth + 1, players);
			swap(i, depth, players);
		}
	}

	private static void print(Node[] players) {
		for (int i = 0; i < players.length; i++) {
			System.out.print(players[i].number + " ");
		}
		System.out.println();
	}

	private static int startGame(Queue<Node> player, int inning) {
		int point = 0;
		int outCount = 0;
		Queue<Integer> ground = new LinkedList<>(); // 야구 그라운드를 뜻한다.

		// 아웃 카운트가 3이 되면 다음 이닝으로 넘어간다.
		while (outCount != 3) {
			Node currentPlayer = player.poll();
			int action = currentPlayer.innings.get(inning);

			if (action == 0) {
				outCount += 1;
			} else if (action == 4) {
				if (!ground.isEmpty()) {
					point += ground.size();
					ground.clear();
				}
				point++;
			} else {
				if (!ground.isEmpty()) {
					int n = ground.size();
					for (int i = 0; i < n; i++) {
						int a = ground.poll();
						a += action;
						if (a >= 4)
							point++;
						else
							ground.add(a);
					}
				}
				ground.add(action);
			}
			player.add(currentPlayer);
		}

		return point;

	}

	private static void swap(int depth, int i, Node[] players) {
		if (depth != 3 && i != 3) {
			Node tmp = players[depth];
			players[depth] = players[i];
			players[i] = tmp;
		}

	}

	private static class Node {
		List<Integer> innings;
		int number;

		public Node(List<Integer> in, int n) {
			this.innings = new ArrayList<>(in);
			this.number = n;
		}
	}

}
