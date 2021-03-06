package samsung;
//주사위 굴리기

import java.io.*;
import java.util.*;

public class problem_14499 {
	static int[][] map;
	static int[] dice;
	static int diceX, diceY; // 주사위 좌표
	static int x, y;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		dice = new int[6]; // 주사위
		try {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map = new int[x][y]; // 맵 생성
			// 주사위 좌표 설정
			diceX = Integer.parseInt(st.nextToken());
			diceY = Integer.parseInt(st.nextToken());
			int operation = Integer.parseInt(st.nextToken()); // 명령어 수
			for (int i = 0; i < x; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < y; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // map에 값 설정
				}
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < operation; i++) {
				// 명령
				int where = Integer.parseInt(st.nextToken()); // 방향
				// 방향에 따른 위치 변경
				int nx =0, ny = 0;
				switch (where) {
				case 1: {
					// 동
					ny = diceY + 1;
					nx = diceX;
					break;
				}
				case 2: {
					// 서
					ny = diceY - 1;
					nx =diceX;
					break;
				}
				case 3: {
					// 북
					nx = diceX - 1;
					ny =diceY;
					break;
				}
				case 4: {
					// 남
					nx = diceX + 1;
					ny = diceY;
					break;
				}
				}
				
				if(isPossible(nx,ny))
				{
					//범위 내에 존재 할 경우
					moveDice(nx,ny,where);
					System.out.println(dice[4]);
					diceX = nx;
					diceY = ny;
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isPossible(int nx, int ny) {
		if (nx >= x || ny >= y|| nx < 0 || ny < 0) // 외각일 경우
			return false;
		return true;
	}
	public static void moveDice(int x,int y, int where) {
		/*
		 * dice[0] = 앞, dice[1]= 뒤, dice[2]= 왼, dice[3]=오, dice[4]= 위,dice[5]= 밑
		 */
		Deque<Integer> queue = new ArrayDeque<>();
		int first=0,second=0,thrid=0,forth=0;
		switch(where) {
		case 1:
		{
			//동
			first = 5;
			second = 2;
			thrid = 4;
			forth = 3;
			break;
		}
		case 2:
		{
			//서
			first = 5;
			second = 3;
			thrid = 4;
			forth = 2;
			break;
		}
		case 3:
		{
			//상
			first = 5;
			second = 0;
			thrid = 4;
			forth = 1;
			break;
		}
		case 4:{
			//하
			first = 5;
			second = 1;
			thrid = 4;
			forth = 0;
			break;
		}
		}
		queue.add(dice[first]);
		queue.add(dice[second]);
		queue.add(dice[thrid]);
		queue.add(dice[forth]);
		
		swap(queue); //순환
		save(first,second,thrid,forth,queue); //순환된 값 저장
		if(map[x][y] == 0)
		{//이동한 칸에 쓰여 있는 수가 0일 경우, 주사위 바닥면에 쓰여 있는 수가 칸에 복사
			map[x][y] = dice[5];
		}else {
			//아닌 경우, 칸에 쓰여 있는 수가 주사위의 바닥면에 복사되며, 칸에 쓰여 있는 수는 0이된
			dice[5] = map[x][y];
			map[x][y] = 0;
		}
	}
	public static void swap(Deque<Integer> queue) {
		int last = queue.pollLast();
		queue.addFirst(last);
	}
	public static void save(int f1, int s, int t, int f4, Deque<Integer> queue) {
		//순환된 값 저장
		dice[f1]=queue.pollFirst();
		dice[s] = queue.pollFirst();
		dice[t]= queue.pollFirst();
		dice[f4]= queue.poll();
	}
	

}