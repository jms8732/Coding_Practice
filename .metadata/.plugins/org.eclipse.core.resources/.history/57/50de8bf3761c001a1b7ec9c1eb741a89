package combination;

//1·Î ¸¸µé±â
import java.util.*;

public class problem_1463 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if(arg0.count < arg1.count)
					return -1;
				else
					return 1;
			}
			
		});

		int N = scanner.nextInt();

		if (N % 2 == 0) {
			// 2·Î ³ª´² ¶³¾îÁö´Â °æ¿ì
			int tmp = N;
			tmp /= 2;
			queue.add(new Node(1,tmp));
		}
		if (N % 3 == 0) {
			// 3À¸·Î ³ª´² ¶³¾îÁö´Â °æ¿ì
			int tmp = N;
			tmp /= 3;
			queue.add(new Node(1,tmp));
		}
		
		int tmp =N;
		tmp -= 1;
		queue.add(new Node(1,tmp));
		
		int small = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Node nTmp = queue.poll();
			if (nTmp.value == 1) {
				small = nTmp.count;
				break;
			}
			if (nTmp.value % 2 == 0) {
				// 2·Î ³ª´² ¶³¾îÁö´Â °æ¿ì
				int t = nTmp.value;
				t /= 2;
				queue.add(new Node(nTmp.count + 1, t));
			}
			if (nTmp.value % 3 == 0) {
				// 3À¸·Î ³ª´² ¶³¾îÁö´Â °æ¿ì
				int t = nTmp.value;
				t /= 3;
				queue.add(new Node(nTmp.count + 1, t));
			} 
			int t = nTmp.value;
			t -= 1;// 1·Î »«´Ù.

			queue.add(new Node(nTmp.count + 1, t));
		}

		System.out.println(small);
	}

	private static class Node {
		int count, value;

		public Node(int c, int v) {
			this.count = c;
			this.value = v;

		}
	}
}
