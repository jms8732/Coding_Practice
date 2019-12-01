package programmers1;

//2020 kakao 자물쇠와 열쇠 81점

public class problem_8 {
	public static void main(String[] args) {
		int [][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int [][] lock = {{1,1,0},{1,1,0},{1,0,1}};
		
		boolean result = solution(key,lock);
		System.out.println(result);
	}

	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		int count =0 ;//lock의 홈의 갯수
		
		for(int i =0 ; i< lock.length ;i++) {
			for(int j =0 ; j< lock[i].length ; j++)
				if(lock[i][j] == 0)
					count++;
		}
		
		for(int i = 0 ; i< 4 ; i++) {
			//회전 횟수
			for(int j = -key.length+1 ; j< lock.length ; j++) {
				for(int k = -key.length+1 ; k < lock.length ; k++) {
					if(isPossible(j,k,key,lock,count)) {
						answer = true;
						return answer;
					}
						
				}
			}
			key = rotation(key);
		}
		
		return answer;
	}

	public static int[][] rotation(int [][] key) {
		int [][] tmp = new int[key.length][key.length];
		int idx = 0;
		
		for(int i =0 ; i< key.length ; i++) {
			for(int j =0 ; j< key[i].length ; j++) {
				if(key[i][j] == 1) {
					//90 degree rotation
					int nx = j;
					int ny = (key.length - 1 - i);
					tmp[nx][ny] = 1;
				}
			}
		}
		
		return tmp;
	}
	/*
	 * 자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를 여는데 영향을 주지 않지만,
	 * 자물쇠 영역내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며 열쇠의 돌기와 자물쇠의 돌기가 만나서는 안된다.
	 * 또한 자물쇠의 모든 홈을 채워 비어있는 곳이 없어야 자물쇠를 열 수 있습니다.
	 */
	public static boolean isPossible(int x, int y, int[][] key, int [][] lock,int count) {
		for(int i =0 ; i< key.length ; i++) {
			for(int j = 0 ; j< key.length ; j++) {
				int tmpX = x+i, tmpY = y + j; //좌표
				if(tmpX < 0 || tmpY < 0 || tmpX >= lock.length || tmpY >= lock.length)
					continue; //범위를 벗어 난 경우
				
				//자물쇠 영역내
				if(key[i][j] == 1 && lock[tmpX][tmpY] == 1)
					return false; //둘 다 돌기가 만나는 경우
				if(key[i][j] == 1 && lock[tmpX][tmpY] == 0)
					count--; //열쇠의 돌기와 자물쇠의 홈
			}
		}
		if(count == 0)
			return true;
		return false;
	}
}


