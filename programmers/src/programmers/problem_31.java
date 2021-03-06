package programmers;
//섬 연결하기
import java.util.*;

public class problem_31 {
	public static void main(String[] args) {
		int[][] tmp = { { 1, 7, 12 }, { 1, 4, 28 }, { 1, 2, 67 }, { 1, 5, 17 }, { 2, 4, 24 }, { 2, 5, 62 },
				{ 3, 5, 20 }, { 3, 6, 37 }, { 4, 7, 13 }, { 5, 6, 45 }, { 5, 7, 73 } };
		int result = solution(7, tmp);
		System.out.println(result);
	}

	public static int solution(int n, int[][] costs) {
		List<NNode> queue = new ArrayList<>();
		for (int i = 0; i < costs.length; i++) {
			NNode nn = new NNode(costs[i][0], costs[i][1], costs[i][2]);
			queue.add(nn);
		}
		queue.sort(new Comparator<NNode>() {// 오름 차순으로 정렬
			@Override
			public int compare(NNode arg0, NNode arg1) {
				// TODO Auto-generated method stub
				if (arg0.cost > arg1.cost)
					return 1;
				else if (arg0.cost < arg1.cost)
					return -1;
				else
					return 0;
			}
		});
		int[] circle = new int[n + 1];
		int idx = 0;
		for (int i = 0; i < circle.length; i++) {
			circle[i] = i;
		}
		int totalCost = 0;
		for (int i = 0; i < queue.size(); i++) {
			NNode nTmp = queue.get(i);
			int b = nTmp.b;
			int a = nTmp.a;
			
			if(union(circle,a,b))
				totalCost += nTmp.cost;
			
			
		}

		return totalCost;
	}
	public static boolean union(int circle[],int a,int b) {
		a = find(circle,a);
		b = find(circle,b);
		
		if(a == b)
			return false;
		else {
			if(a>b)
				circle[a] = b;
			else
				circle[b] = a;
		}
		return true;
	}
	public static int find(int[] circle, int idx) {
		if (idx == circle[idx])
			return circle[idx];
		return find(circle, circle[idx]);
	}
}

class NNode {
	int a, b, cost;

	public NNode(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}

}
