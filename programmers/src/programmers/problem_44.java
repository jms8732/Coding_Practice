package programmers;
//길찾기 게임 65

import java.util.*;

public class problem_44 {
	static int idx = 0;

	public static void main(String[] args) {
		int[][] tmp = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } };
		int[][] result = solution(tmp);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] solution(int[][] nodeinfo) {
		List<Node> list = new ArrayList<>();
		Node tree = null;
		for (int i = 0; i < nodeinfo.length; i++) {
			int x = nodeinfo[i][0];
			int y = nodeinfo[i][1];
			int number = i + 1;
			list.add(new Node(x, y, number, null, null));
		}

		list.sort(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if (arg0.y > arg1.y) // y로 내림 차순
					return -1;
				else if (arg0.y == arg1.y) {
					if (arg0.x > arg1.x)
						return -1;
					else
						return 1;
				} else
					return 1;
			}

		});
		int preList[] = new int[nodeinfo.length];
		int postList[] = new int[nodeinfo.length];
		tree = buildTree(list);
		preOrder(tree, preList);

		idx = 0;
		postOrder(tree, postList);

		int result[][] = new int[2][];
		result[0] = preList;
		result[1] = postList;

		return result;
	}

	public static void preOrder(Node tree, int[] preList) {
		// 전위 순회 root->left->right
		if (tree == null)
			return;
		preList[idx++] = tree.number;
		preOrder(tree.left, preList);
		preOrder(tree.right, preList);
	}

	public static void postOrder(Node tree, int[] postList) {
		// 후위 순회 left->right->root
		if (tree == null)
			return;

		postOrder(tree.left, postList);
		postOrder(tree.right, postList);
		postList[idx++] = tree.number;

	}

	public static Node buildTree(List<Node> list) {
		Node tree = null;
		for (int i = 0; i < list.size(); i++) {
			// list의 크기 만큼 반복문 수행
			Node tmp = list.get(i);
			if (tree == null)
				tree = tmp; // root
			else {
				Node parent = tree;
				while (true) {
					int childX = tmp.x;
					if (childX > parent.x) { // x값이 부모 보다 클 경우
						if (parent.right == null) {
							parent.right = tmp;
							break;
						} else
							parent = parent.right;
					} else {
						if (parent.left == null) {
							parent.left = tmp;
							break;
						} else
							parent = parent.left;
					}
				}

			}

		}

		return tree;
	}

	public static class Node {
		int x, y, number;
		Node left, right;

		public Node(int x, int y, int number, Node left, Node right) {
			this.x = x;
			this.y = y;
			this.number = number;
			this.left = left;
			this.right = right;
		}
	}
}
