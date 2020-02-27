package bruteForce;

//���� ����
import java.util.*;
import java.io.*;

public class problem_10972 {
	static boolean np = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] array = new int[N];

		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int value = array[0];
		boolean check = false;
		for (int i = 1; i < N; i++) {
			if (value > array[i]) {
				value = array[i];
			} else {
				check = true;
				break;
			}
		}

		// ������ ������ �ƴ� ���
		if (check) {
			permutation(array);
		} else
			System.out.println(-1);

	}

	private static void permutation(int[] array) {
		boolean visited[] = new boolean[array.length];
		Arrays.fill(visited, true);
		int idx = array.length - 1;
		boolean check = false;
		while (true) {
			int cur = array[idx];
			visited[cur - 1] = false;
			for (int i = cur; i < array.length; i++) {
				if (!visited[i]) {
					check = true;
					break;
				}
			}
			if (check) {
				for(int i = array[idx] ; i < visited.length ; i++) {
					if(!visited[i]) {
						visited[i] = true;
						array[idx] = i+1;
						break;
					}
				}
				
				for (int i = idx+1; i < array.length; i++) {
					for(int j =0 ; j< visited.length ; j++) {
						if(!visited[j]) {
							visited[j] = true;
							array[i]= j+1;
							break;
						}
					}
					
				}
				break;
			}

			idx--;

		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}
