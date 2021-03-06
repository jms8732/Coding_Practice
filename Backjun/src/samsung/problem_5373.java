package samsung;

//큐빙
import java.util.*;
import java.io.*;

public class problem_5373 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int i = 0; i < testCase; i++) {
			char[][] U = { { 'w', 'w', 'w' }, { 'w', 'w', 'w' }, { 'w', 'w', 'w' } };
			char[][] D = { { 'y', 'y', 'y' }, { 'y', 'y', 'y' }, { 'y', 'y', 'y' } };
			char[][] B = { { 'o', 'o', 'o' }, { 'o', 'o', 'o' }, { 'o', 'o', 'o' } };
			char[][] L = { { 'g', 'g', 'g' }, { 'g', 'g', 'g' }, { 'g', 'g', 'g' } };
			char[][] R = { { 'b', 'b', 'b' }, { 'b', 'b', 'b' }, { 'b', 'b', 'b' } };
			char[][] F = { { 'r', 'r', 'r' }, { 'r', 'r', 'r' }, { 'r', 'r', 'r' } };

			int k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				String tmp = st.nextToken();
				char dim = tmp.charAt(0);
				char direction = tmp.charAt(1);

				rotation(U, D, B, L, R, F, dim, direction);
			}
			print(U);
			System.out.println();
		}
	}

	private static void print(char[][] U) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(U[i][j]);
			}
			System.out.println();
		}
	}

	// 회전
	private static void rotation(char[][] U, char[][] D, char[][] B, char[][] L, char[][] R, char[][] F, char dim,
			char direction) {
		char[][] array = null;
		switch (dim) {
		case 'U':
			array = U;
			break;
		case 'D':
			array = D;
			break;
		case 'B':
			array = B;
			break;
		case 'L':
			array = L;
			break;
		case 'R':
			array = R;
			break;
		case 'F':
			array = F;
			break;

		}
		// 현재 돌릴려는 면을 90도 회전을 먼저 시킨다.
		rotation_angle(array, direction);

		rotation_otherDim(U, D, B, L, R, F, dim, direction);

	}

	// 기준면을 대상으로 연결돼 있는 면들을 가져온 후, 회전
	private static void rotation_otherDim(char[][] U, char[][] D, char[][] B, char[][] L, char[][] R, char[][] F,
			char d, char direction) {
		switch (d) {
		case 'U':
			char[] ub = { B[0][2], B[0][1], B[0][0] };
			char[] ur = { R[0][2], R[0][1], R[0][0] };
			char[] uf = { F[0][2], F[0][1], F[0][0] };
			char[] ul = { L[0][2], L[0][1], L[0][0] };

			rotation_Dim(U, D, B, L, R, F, ub, ur, uf, ul, d, direction);

			break;
		case 'D':
			char[] db = { F[2][0], F[2][1], F[2][2] };
			char[] dr = { R[2][0], R[2][1], R[2][2] };
			char[] df = { B[2][0], B[2][1], B[2][2] };
			char[] dl = { L[2][0], L[2][1], L[2][2] };

			rotation_Dim(U, D, B, L, R, F, db, dr, df, dl, d, direction);
			break;
		case 'L':
			char[] lu = { U[0][0], U[1][0], U[2][0] };
			char[] lf = { F[0][0], F[1][0], F[2][0] };
			char[] ld = { D[0][0], D[1][0], D[2][0] };
			char[] lb = { B[2][2], B[1][2], B[0][2] };

			rotation_Dim(U, D, B, L, R, F, lu, lf, ld, lb, d, direction);
			break;
		case 'R':
			char[] ru = { U[2][2], U[1][2], U[0][2] };
			char[] rb = { B[0][0], B[1][0], B[2][0] };
			char[] rd = { D[2][2], D[1][2], D[0][2] };
			char[] rf = { F[2][2], F[1][2], F[0][2] };

			rotation_Dim(U, D, B, L, R, F, ru, rb, rd, rf, d, direction);
			break;
		case 'F':
			char[] fu = { U[2][0], U[2][1], U[2][2] };
			char[] fr = { R[0][0], R[1][0], R[2][0] };
			char[] fd = { D[0][2], D[0][1], D[0][0] };
			char[] fl = { L[2][2], L[1][2], L[0][2] };

			rotation_Dim(U, D, B, L, R, F, fu, fr, fd, fl, d, direction);
			break;
		case 'B':
			char[] bu = { U[0][2], U[0][1], U[0][0] };
			char[] bl = { L[0][0], L[1][0], L[2][0] };
			char[] bd = { D[2][0], D[2][1], D[2][2] };
			char[] br = { R[2][2], R[1][2], R[0][2] };

			rotation_Dim(U, D, B, L, R, F, bu, bl, bd, br, d, direction);
			break;
		}

	}

	private static void rotation_Dim(char[][] U, char[][] D, char[][] B, char[][] L, char[][] R, char[][] F, char[] u,
			char[] r, char[] d, char[] l, char dim, char direction) {
		char[][] array = { u, r, d, l };
		int idx = 0;
		char[] cur = null;
		switch (direction) {
		case '-':
			idx = 0;
			cur = array[idx--];
			while (true) {
				idx = Math.floorMod(idx, 4);
				if (idx == 0)
					break;
				char[] next = array[idx];
				array[idx--] = cur;
				cur = next;
			}
			array[idx % 4] = cur;
			break;
		case '+':
			idx = 0;
			cur = array[idx++];
			while (true) {
				if (idx == 4)
					break;
				char[] next = array[idx];
				array[(idx++) % 4] = cur;
				cur = next;
			}
			array[idx % 4] = cur;
			break;
		}

		switch (dim) {
		case 'U':
			B[0][2] = array[0][0];
			B[0][1] = array[0][1];
			B[0][0] = array[0][2];

			R[0][2] = array[1][0];
			R[0][1] = array[1][1];
			R[0][0] = array[1][2];

			F[0][2] = array[2][0];
			F[0][1] = array[2][1];
			F[0][0] = array[2][2];

			L[0][2] = array[3][0];
			L[0][1] = array[3][1];
			L[0][0] = array[3][2];
			break;
		case 'D':
			F[2][0] = array[0][0];
			F[2][1] = array[0][1];
			F[2][2] = array[0][2];

			R[2][0] = array[1][0];
			R[2][1] = array[1][1];
			R[2][2] = array[1][2];

			B[2][0] = array[2][0];
			B[2][1] = array[2][1];
			B[2][2] = array[2][2];

			L[2][0] = array[3][0];
			L[2][1] = array[3][1];
			L[2][2] = array[3][2];
			break;
		case 'L':
			U[0][0] = array[0][0];
			U[1][0] = array[0][1];
			U[2][0] = array[0][2];

			F[0][0] = array[1][0];
			F[1][0] = array[1][1];
			F[2][0] = array[1][2];

			D[0][0] = array[2][0];
			D[1][0] = array[2][1];
			D[2][0] = array[2][2];

			B[2][2] = array[3][0];
			B[1][2] = array[3][1];
			B[0][2] = array[3][2];

			break;
		case 'R':
			U[2][2] = array[0][0];
			U[1][2] = array[0][1];
			U[0][2] = array[0][2];

			B[0][0] = array[1][0];
			B[1][0] = array[1][1];
			B[2][0] = array[1][2];

			D[2][2] = array[2][0];
			D[1][2] = array[2][1];
			D[0][2] = array[2][2];

			F[2][2] = array[3][0];
			F[1][2] = array[3][1];
			F[0][2] = array[3][2];

			break;
		case 'F':
			U[2][0] = array[0][0];
			U[2][1] = array[0][1];
			U[2][2] = array[0][2];

			R[0][0] = array[1][0];
			R[1][0] = array[1][1];
			R[2][0] = array[1][2];

			D[0][2] = array[2][0];
			D[0][1] = array[2][1];
			D[0][0] = array[2][2];

			L[2][2] = array[3][0];
			L[1][2] = array[3][1];
			L[0][2] = array[3][2];
			break;
		case 'B':
			U[0][2] = array[0][0];
			U[0][1] = array[0][1];
			U[0][0] = array[0][2];

			L[0][0] = array[1][0];
			L[1][0] = array[1][1];
			L[2][0] = array[1][2];

			D[2][0] = array[2][0];
			D[2][1] = array[2][1];
			D[2][2] = array[2][2];

			R[2][2] = array[3][0];
			R[1][2] = array[3][1];
			R[0][2] = array[3][2];
			break;

		}
	}

	private static void rotation_angle(char[][] dim, char direction) {
		switch (direction) {
		case '-':
			for (int i = 0; i < 2; i++) {
				int startX = i;
				int startY = 0;
				int nx = 0, ny = 0;
				char cur = dim[startX][startY];
				while (true) {
					nx = 2 - startY;
					ny = startX;

					char next = dim[nx][ny];
					dim[nx][ny] = cur;
					cur = next;
					startX = nx;
					startY = ny;

					if (startX == i && startY == 0)
						break;
				}
			}
			break;
		case '+':
			for (int i = 0; i < 2; i++) {
				int startX = 0;
				int startY = i;
				int nx = 0, ny = 0;
				char cur = dim[startX][startY];
				while (true) {
					nx = startY;
					ny = 2 - startX;

					char next = dim[nx][ny];
					dim[nx][ny] = cur;
					cur = next;
					startX = nx;
					startY = ny;

					if (startX == 0 && startY == i)
						break;
				}
			}
			break;
		}

	}
}
