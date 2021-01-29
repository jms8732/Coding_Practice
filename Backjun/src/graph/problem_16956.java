package graph;

/*
 * ����� ��
 * ��Ÿ���� �ּ� ������ ���ϴ� ���� �ƴ� ���밡 ���� ��� ���� ���ϰ� ��Ÿ���� ġ�� ���� ������ �����̴�.
 * ����, �ݴ�� ���븦 ��Ÿ���� ���δ� ������� �����Ѵ�.
 */

import java.util.*;
import java.io.*;

public class problem_16956 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		Queue<Point> wolves = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				if (tmp.charAt(j) == 'W')
					wolves.add(new Point(i, j));
				map[i][j] = tmp.charAt(j);
			}
		}

		
		if(surroundWall(wolves,map,N,M)) {
			//���븦 �߽����� ������ ��Ÿ���� ģ ���
			System.out.println(1);
			for(int i= 0 ; i < N ; i++) {
				for(int j =0 ; j  < M ; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}else
			System.out.println(0);
	}
	
	private static boolean surroundWall(Queue<Point> wolves, char [][] map, int N , int M) {
		// ���븦 �߽����� ��Ÿ���� ģ��.
		while (!wolves.isEmpty()) {
			Point cur = wolves.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];
				
				//�迭 ���� ���� ���
				if(nx <0 || nx >= N || ny < 0 || ny >= M)
					continue;
				
				//������ �� ������ ���, ��Ÿ���� ģ��.
				if(map[nx][ny] == '.')
					map[nx][ny] = 'D';
				
				//�ٷ� ���� ���� ������ ���
				if(map[nx][ny] == 'S')
					return false;
			}
		}
		
		return true;
	}

	private static class Point {
		int x, y;

		public Point(String x, String y) {
			this.x = Integer.parseInt(x);
			this.y = Integer.parseInt(y);
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
