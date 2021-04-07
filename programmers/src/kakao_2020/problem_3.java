package kakao_2020;

import java.util.Arrays;

/*
 * 자물쇠와 열쇠
 * 풀이 시간: 1시간 이상 소요
 * 구현 문제
 * 정사각형의 경우, 90도 회전할 때 공식이 존재한다 nx = py, ny = (M-1) - px
 * 
 * 배열을 움직일 때, key와 lock의 길이를 가지고 큰 배열을 생성한 후, 
 * lock을 큰 배열의 가운데에 저장하고 key를 가지고 순환시킨다.
 */

public class problem_3 {
	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		boolean result = solution(key, lock);
		System.out.println(result);
	}

	public static boolean solution(int[][] key, int[][] lock) {
		int m = key.length;
		int n = lock.length;
		int bl = 2*m+n-2;
		int[][] bigLock = new int[bl][bl];

		copyArray(key.length,lock,bigLock); //중앙에 자물쇠 설치
		for (int i = 0; i < 4; i++) {
			if (move(key, lock,bigLock))
				return true;
			rotate90(key);
		}

		return false;
	}

	private static void rotate90(int[][] key) {
		int[][] temp = new int[key.length][key.length];

		for (int x = 0; x < key.length; x++) {
			for (int y = 0; y < key.length; y++) {
				int nx = y;
				int ny = (key.length - 1) - x;

				temp[nx][ny] = key[x][y];
			}
		}

		copyArray(temp,key);
	}

	private static boolean move(int[][] key, int[][] lock, int [][] bigLock) {
		
		for(int i =0 ; i<= bigLock.length - key.length ; i++) {
			for(int j =0 ; j <= bigLock.length - key.length ; j++) {
				if(check(i,j,bigLock,lock,key)) {
					return true;
				}
			}
		}

		return false;
	}
	
	private static boolean check(int x, int y,int [][] bigLock, int [][] lock, int [][] key) {
		int [][] temp = new int[bigLock.length][];
		copyArray(bigLock,temp);
		
		for(int i = x; i < x + key.length; i++) {
			for(int j = y; j < y + key.length;  j++) {
				if(temp[i][j] != -1) {
					if(temp[i][j] ==1 && key[i-x][j-y] == 1) //둘다 돌기인경우
						return false;
					else if(key[i-x][j-y] != 0)
						temp[i][j] = key[i-x][j-y];
				}
			}
		}
		
		for(int i = key.length-1; i < key.length-1 + lock.length; i ++) {
			for(int j = key.length-1 ; j < key.length-1 + lock.length ; j++) {
				if(temp[i][j] == 0) //자물쇠에 홈이 존재하는 경우
					return false;
			}
		}
		
		return true;
	}
	
	
	private static void copyArray(int [][] src , int [][] dest) {
		int idx = 0;
		
		for(int[] s : src) {
			dest[idx++] = Arrays.copyOf(s, s.length);
		}
	}
	private static void copyArray(int kl,int [][] src , int [][] dest) {
		for(int [] d : dest) {
			Arrays.fill(d, -1);
		}
		
		for(int i =0 ; i < src.length ; i++) {
			for(int j =0 ; j < src.length ; j++) {
				dest[i+kl-1][j+kl-1] = src[i][j];
			}
		}
		
	//	print(dest);
	}
	private static void print(int [][] array) {
		for(int i =0 ; i < array.length ; i++) {
			for(int j =0 ; j < array.length ; j++) {
				System.out.print(array[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
