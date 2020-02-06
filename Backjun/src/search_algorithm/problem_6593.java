package search_algorithm;

//��� ����
import java.io.*;
import java.util.*;

public class problem_6593 {
	static int L, R,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0)
				break;

			char[][][] build = new char[L][R][C];
			int[][][] board = new int[L][R][C];
			boolean[][][] visited = new boolean[L][R][C];

			int startX= 0, startY=0, startZ=0;
			
			for (int i = 0; i < L; i++) {
				for (int k = 0; k < R; k++) {
					String tmp = br.readLine();
					for (int j = 0; j < tmp.length(); j++) {
						char t = tmp.charAt(j);
						if(t == 'S') {
							startZ = i;
							startX = k;
							startY = j;
						}
						build[i][k][j] = t;
					}
				}
				br.readLine();
			}
			
			bfs(startX,startY,startZ,build,visited,board);
		}
	}

	private static void bfs(int startX,int startY, int startZ,
			char[][][] build, boolean[][][] visited, int[][][] board) {
		
		Queue<List<Integer>> queue = new LinkedList<>();
		
		int ud[] = {-1,0,1,0};
		int rl[] = {0,1,0,-1};
		
		int ud2[] = {-1,1};
		//�������ϻ��� 6���� �̵� ����
		
		List<Integer> tmp = new ArrayList<>();
		tmp.add(startZ);
		tmp.add(startX);
		tmp.add(startY);
		
		queue.add(tmp);
		
		String answer = "Trapped!";
		while(!queue.isEmpty()) {
			List<Integer> cur = queue.poll();
			int cz = cur.get(0);
			int cx = cur.get(1);
			int cy = cur.get(2);
			
			if(build[cz][cx][cy] == 'E') {
				answer = "Escaped in " + board[cz][cx][cy] + " minute(s).";
				break;
			}
			
			if(!visited[cz][cx][cy]) {
				//���� ���� �湮���� �ʾҴٸ�
				int sec = board[cz][cx][cy];
				visited[cz][cx][cy] = true;
				
				//����
				for(int i =0 ; i< 2; i ++) {
					int nz = cz + ud2[i];
					int nx = cx;
					int ny = cy;
					
					if(nz < 0 || nz >= L || nx<0 || nx >= R || ny < 0 || ny >= C || visited[nz][nx][ny]
							||build[nz][nx][ny] == '#')
						continue;
					
					List<Integer> nTmp = new ArrayList<>();
					nTmp.add(nz);
					nTmp.add(nx);
					nTmp.add(ny);
					
					board[nz][nx][ny] = sec +1;
					queue.add(nTmp);
				}
				
				//��������
				for(int i =0 ; i < 4 ; i++) {
					int nz = cz;
					int nx = cx + ud[i];
					int ny = cy + rl[i];
					
					if(nz < 0 || nz >= L || nx<0 || nx >= R || ny < 0 || ny >= C || visited[nz][nx][ny]
							|| build[nz][nx][ny] == '#')
						continue;
					
					List<Integer> nTmp = new ArrayList<>();
					nTmp.add(nz);
					nTmp.add(nx);
					nTmp.add(ny);
					
					board[nz][nx][ny] = sec +1;
					queue.add(nTmp);
					
				}
			}
		}
		
		System.out.println(answer);
	}
}
