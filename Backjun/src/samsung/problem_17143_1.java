package samsung;

//³¬½Ã¿Õ
import java.util.*;
import java.io.*;

public class problem_17143_1 {
	static int R, C;
	static fish[][] f;
	static int ud[] = { -1, 1, 0, 0 };
	static int rl[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());
		f = new fish[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				f[i][j] = new fish();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			f[x][y].shark.add(new shark(d, s, z));
		}

		simulation();
	}

	private static void simulation() {
		int answer = 0;

		for (int i = 0; i < C; i++) {
			answer += fishing_shark(i);
			move_shark();
		}

		System.out.println(answer);
	}

	private static void move_shark() {
		fish[][] tmp = new fish[R][C];
		for(int i =0 ; i < R ; i++) {
			for(int j =0 ; j <C;  j++) {
				tmp[i][j] = new fish();
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!f[i][j].shark.isEmpty()) {
					move(tmp, i, j);
				}
			}
		}

		eat_shark(tmp);
	}

	private static void eat_shark(fish[][] tmp) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (tmp[i][j].shark.size() >= 2) {
					Collections.sort(tmp[i][j].shark, new Comparator<shark>() {

						@Override
						public int compare(shark o1, shark o2) {
							// TODO Auto-generated method stub
							if (o1.z > o2.z)
								return -1;
							else
								return 1;
						}

					});
					
					shark big = tmp[i][j].shark.get(0);
					tmp[i][j].shark.clear();
					tmp[i][j].shark.add(big);
				}
			}
		}
		
		copyArray(tmp,f);
		//print();
	}
	private static void copyArray(fish[][] src ,fish[][] dest) {
		int idx =0 ;
		for(fish t[] : src) {
			System.arraycopy(t,0, dest[idx++], 0, t.length);
		}
	}
	
	private static void print() {
		for(int i= 0 ; i <R ; i++) {
			for(int j=0 ; j < C; j++) {
				if(f[i][j].shark.isEmpty())
					System.out.print(0+ " ");
				else
					System.out.print("(" + f[i][j].shark.get(0).d + "," + f[i][j].shark.get(0).z + ")" + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void move(fish[][] tmp, int x, int y) {
		shark cur = f[x][y].shark.get(0);
		int speed = cur.s;
		int mod = 0;

		if (cur.d == 1 || cur.d == 2) {
			mod = speed % (2 * R - 2);
		} else {
			mod = speed % (2 * C - 2);
		}
		
		while (mod > 0) {
			int nx = x + ud[cur.d - 1];
			int ny = y + rl[cur.d - 1];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
				if (cur.d == 1)
					cur.d = 2;
				else if (cur.d == 2)
					cur.d = 1;
				else if (cur.d == 3)
					cur.d = 4;
				else
					cur.d = 3;

				continue;
			}

			mod -= 1;
			x = nx;
			y = ny;
		}

		tmp[x][y].shark.add(new shark(cur.d, cur.s, cur.z));
	}

	private static int fishing_shark(int y) {
		for (int i = 0; i < R; i++) {
			if (!f[i][y].shark.isEmpty()) {
				int val = f[i][y].shark.get(0).z;
				f[i][y].shark.clear();
				
				return val;
			}
		}

		return 0;
	}

	private static class shark {
		int d, s, z;

		public shark(int d, int s, int z) {
			this.d = d;
			this.s = s;
			this.z = z;
		}
	}

	private static class fish {
		List<shark> shark;

		public fish() {
			shark = new ArrayList<>();
		}
	}
}
