package graph;

import java.util.*;
import java.io.*;

public class problem_1647 {
	static int[] houseNumber;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<house> pq = new PriorityQueue<>(new Comparator<house>() {

			@Override
			public int compare(house arg0, house arg1) {
				// TODO Auto-generated method stub
				if (arg0.cost < arg1.cost)
					return -1;
				else
					return 1;
			}

		});


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			pq.add(new house(s, e, c));
		}

		houseNumber = new int[N];

		for (int j = 1; j < houseNumber.length; j++)
			houseNumber[j] = j;

		kruskal(pq);

		System.out.println(answer);
	}

	private static void kruskal(PriorityQueue<house> pq) {
		int tmp = 0;
		int big = 0;

		while (!pq.isEmpty()) {
			house curHouse = pq.poll();
			int v1 = curHouse.start;
			int v2 = curHouse.end;

			if (union(v1, v2)) {
				tmp += curHouse.cost;
				big = curHouse.cost;
			}

		}

		answer = Math.min(tmp - big, answer);
	}

	private static boolean union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);

		if (p1 == p2)
			return false;

		if (p1 < p2) {
			houseNumber[p2] = p1;
		} else if (p1 > p2) {
			houseNumber[p1] = p2;
		}

		return true;
	}

	private static int find(int parent) {
		if (houseNumber[parent] != parent)
			return find(houseNumber[parent]);

		return parent;
	}

	private static class house {
		int start, end, cost;

		public house(int s, int e, int c) {
			this.start = s;
			this.end = e;
			this.cost = c;

		}
	}
}
