package programmers1;
//���

import java.util.Arrays;

public class problem_7 {
	public static void main(String[] args) {
		int [][] tmp = {{2,2}};
		int result = solution(4,3,tmp);
		System.out.println(result);
	}

	public static int solution(int m, int n, int[][] puddles) {
		int [][] map = new int[n+1][m+1];
		
		for(int i =0 ; i < puddles.length ; i++) {
			int x = puddles[i][0];
			int y = puddles[i][1];
			
			map[y][x] = -1; //�� ������ ǥ��
		}
		
		map[1][1] = 1;
		for(int i=1; i < map.length ; i++) {
			for(int j =1 ; j< map[i].length ; j++) {
				if(map[i][j] == -1)
					map[i][j] =0;
				else 
				{
					if(i== 1) {
						map[i][j] += map[i][j-1];
					}else
						map[i][j] = (map[i-1][j] + map[i][j-1])  % 1000000007;
				}
				
			}
		}
		
		return map[n][m];
	}
}
