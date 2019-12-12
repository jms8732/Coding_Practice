package combination;

//1, 2, 3 ���ϱ�
import java.io.*;
import java.util.*;

public class problem_9095 {
	static int[] array;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			array = new int[3];
			// 1,2,3�� �����ϴ� �迭
			array[0] = 1;
			array[1] = 2;
			array[2] = 3;

			for (int i = 0; i < N; i++) {
				int count =0 ;
				int target = Integer.parseInt(br.readLine());
				for (int j= 0; j < array.length; j++) {
					count += dfs(target, array[j]);
				}
				System.out.println(count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int dfs(int target, int current) {
		int count = 0; // ���� ����

		if (current >= target) {
			if (current == target)
				return 1;
			return 0;
		}

		for (int i = 0; i < array.length; i++) {
			count += dfs(target, current + array[i]);

		}

		return count;
	}
}
