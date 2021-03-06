package programmers;
//카카오 프렌즈 컬러링 북
public class problem_20 {
	static int[] ud = {-1,0,1,0};
	static int[] rl = {0,1,0,-1};
	static boolean[][] visited;
	static int[][] map;
	public static void main(String[] args0) {
		int [][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int [] result  = solution(6,4,picture);
		for(int i : result)
			System.out.print(i + " ");
	}
	 public static int[] solution(int m, int n, int[][] picture) {
		 visited = new boolean[m][n]; //방문 기록 저장
		 map = new int[m][n]; //전체 배열
		 int big = 0 ;
		 int c = 0;
		 int count = 0 ;
		 for(int i = 0 ; i< m ; i++) {
			 for(int j= 0 ; j< n ; j++) {
				 map[i][j] = picture[i][j];
			 }
		 }
		 
		 for(int i = 0 ; i< m ; i++) {
			 for(int j =0 ; j< n ; j++) {
				 if(!visited[i][j] && map[i][j] != 0) {
					 visited[i][j] = true;
					 int tmp  = dfs(i,j,c+1);
					 big = Math.max(big, tmp);
					 count++; //개수 증가
				 }
			 }
		 }
		 
		 int [] result = {count,big};
		 return result; //결과값 반환
	 }
	 
	 public static int dfs(int x, int y,int count) {
		 int tmp = count;
		 for(int i =0 ; i< ud.length  ;i++) {
			 int nx = x + ud[i]; //다음 x값
			 int ny = y + rl[i]; //다음 y값
			 
			 if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[x].length)
				 continue; //범위를 벗어난 경우
			 else {
				 //범위 내
				 if(map[nx][ny] == map[x][y] && !visited[nx][ny]) { //같은 값으면서 방문하지 않는 곳
					 visited[nx][ny] = true;
					 tmp = dfs(nx,ny,tmp +1 ); //다음 좌표
				 }
				 
			 }
		 }
		 
		 return tmp;
	 }
}
