package combination;

//일곱 난쟁이

import java.util.*;

public class problem_2309 {
	static int N = 9;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue<Node> queue = new LinkedList<>(); // BFS를 이용하기 위한 큐
		int[] height = new int[N];

		for (int i = 0; i < N; i++)
			height[i] = scanner.nextInt(); // 키 배열에 값 삽입

		for (int i = 0; i < N; i++) {
			int tmpH = height[i];
			int[] tmpArray = new int[N - 1];
			int[] list = new int[7];
			int idx = 0 ;
			list[idx] = tmpH;
			for (int j = 0; j < N; j++) {
				if (tmpH != height[j])
					tmpArray[idx++] = height[j];
			}
			
			queue.add(new Node(tmpH,tmpArray,0,list));
		}
		int [] result = null ;
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			
			if(current.count == 7) {
				//일곱 난쟁이의 키를 다 더한 경우
				if(current.sumHeight == 100) {
					result = current.list;
					break;
				}
			}
			else {
				int len = current.height.length;
				for (int i = 0; i < len; i++) {
					int tmpH = current.height[i];
					int[] tmpArray = new int[len-1];
					int [] list = current.list;
					list[current.count] = tmpH;
					int idx =0 ;
					for (int j = 0; j < len; j++) {
						if (tmpH != current.height[j])
							tmpArray[idx++] = current.height[j];
					}
					queue.add(new Node(current.sumHeight+ tmpH,tmpArray,current.count,list));
				}
			}
		}
		
		Arrays.sort(result);
		for(int i : result)
			System.out.println(i);
	}

	private static class Node {
		int sumHeight;
		int[] height;
		int count;
		int [] list;
		public Node(int sh, int[] h, int c, int [] list) {
			this.sumHeight = sh;
			height = new int[h.length];
			System.arraycopy(h, 0, height, 0, h.length);
			this.count = c+1;
			this.list=  new int[7];
			System.arraycopy(list, 0, this.list, 0, list.length);
		}
	}
}
