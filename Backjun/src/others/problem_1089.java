package others;

/*
 * 스타트링크 타워
 * 단순한 집합을 구할 경우, 시간 초과가 발생한다. *경우의 수 10억개 
 * 총합, 평균을 구하는 방법에 포커스를 맞춰서 진행한다.
 */

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class problem_1089 {
	static String[] light_prints = { "###...#.###.###.#.#.###.###.###.###.###",
			"#.#...#...#...#.#.#.#...#.....#.#.#.#.#", "#.#...#.###.###.###.###.###...#.###.###",
			"#.#...#.#.....#...#...#.#.#...#.#.#...#", "###...#.###.###...#.###.###...#.###.###" };

	static long sum;
	static int count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[][] lights = new char[5][4 * n - 1];

		for (int i = 0; i < lights.length; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < lights[i].length; j++) {
				lights[i][j] = tmp.charAt(j);
			}
		}

		double result = calculateAvg(lights, n);
		DecimalFormat format=  new DecimalFormat("#.#####");
		System.out.println(format.format(result));
	}

	private static double calculateAvg(char[][] input, int n) {
		
		List<Integer> list[] = new ArrayList[n];
		
		for(int i =0 ; i <list.length ; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < input[0].length; i += 4) {
			collectNumber(list[i / 4], i, input);
		}

		return makeValue(list);
	}
	
	

	private static double makeValue(List<Integer> list [] ) {
		long size = 1; //경우의 수
		long temp =0L ;
		for(int i =0 ; i < list.length ; i++) {
			size *= list[i].size();
		}
		
		for(int i= 0 ; i < list.length ; i++) {
			for(int  v: list[i]) {
				temp += v * Math.pow(10, list.length-i-1) * (size / list[i].size());
			}
		}
		
		if(size == 0)
			return -1;
		
		return (double)temp / size;
	}

	private static void collectNumber(List<Integer> list, int start, char[][] input) {
		boolean[][] v2 = new boolean[5][3];
		for (int k = 0; k < input.length; k++) {
			for (int j = start; j < start + 3; j++) {
				if (input[k][j] == '#')
					v2[k][j-start] = true;
			}
		}
		
		for (int i = 0; i < light_prints[0].length(); i += 4) {
			boolean[][] v1 = new boolean[5][3];

			for (int k = i; k < i + 3; k++) {
				for (int j = 0; j < light_prints.length; j++) {
					if (light_prints[j].charAt(k) == '#')
						v1[j][k - i] = true;
				}
			}

			if (compare(v1, v2)) {
				list.add(i / 4);
			}
		}
	}

	private static boolean compare(boolean[][] src, boolean[][] tar) {
		for (int i = 0; i < src.length; i++) {
			for (int j = 0; j < src[i].length; j++) {
				if (src[i][j] == false && tar[i][j] == true)
					return false;
			}
		}

		return true;
	}
}
