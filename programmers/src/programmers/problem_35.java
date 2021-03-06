package programmers;
//[1차] 비밀지도

import java.util.*;

public class problem_35 {
	public static void main(String[] args) {
		int []arr1 = {9,20,28,18,11};
		int []arr2 = {30,1,21,17,28};
		String[] result= solution(5,arr1,arr2);
		
		for(String t : result) {
			System.out.println(t);
		}
		
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] result = new String[n];
		String[] result1 = new String[n];
		String[] result2 = new String[n];
		for (int i = 0; i < arr1.length; i++) {
			String tmp = Integer.toBinaryString(arr1[i]);
			if(tmp.length() != n) {
				int remain = n - tmp.length();
				for(int j =0 ; j< remain ; j++) {
					tmp = "0".concat(tmp);
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) == '1') // 벽일 경우
					sb.append("#");
				else
					sb.append(" ");
			}
			result1[i] = sb.toString();
		}
		for (int i = 0; i < arr2.length; i++) {
			String tmp = Integer.toBinaryString(arr2[i]);
			StringBuilder sb = new StringBuilder();
			if(tmp.length() != n) {
				int remain = n - tmp.length();
				for(int j =0 ; j< remain; j++) {
					tmp = "0".concat(tmp);
				}
			}

			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) == '1')
					sb.append("#");
				else
					sb.append(" ");
			}
			result2[i] = sb.toString();
		}

		for (int i = 0; i < arr1.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < result1[i].length(); j++) {
				if (result1[i].charAt(j) == '#' || result2[i].charAt(j) == '#')
					sb.append("#");
				else
					sb.append(" ");
			}
			result[i] = sb.toString();
		}
		
		return result;
	}
}
