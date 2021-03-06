package bitmask;

//집합
import java.util.*;
import java.io.*;

public class problem_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int M = Integer.parseInt(br.readLine());
		int set = 0;
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int tmp = 0;
			if (op.equals("all") || op.equals("empty"))
				tmp = 19;
			else
				tmp = Integer.parseInt(st.nextToken()) - 1;

			if (op.equals("add") && (set & (1<<tmp)) != (1<<tmp)) {
				// 덧셈 연산
				set |= (1 << tmp);
			} else if (op.equals("remove") && (set & (1<<tmp)) == (1<<tmp)) {
				// 제거 연산
				set &= ~(1 << tmp);
			} else if (op.equals("check")) {
				if ((set & (1 << tmp)) == (1<<tmp)) {
					bw.write("1");
				} else
					bw.write("0");
				bw.newLine();
			} else if (op.equals("toggle")) {
				// x가 있으면 x를 제거, 없으면 x를 추가
				if ((set & (1 << tmp)) == (1<<tmp)) {
					set &= ~(1 << tmp);
				} else
					set |= (1 << tmp);
			} else if (op.equals("all")) {
				set = (1<<tmp) | ~(1<<tmp);
			} else {
				set = (1<<tmp) & ~(1<<tmp);
			}
		}
		bw.flush();
	}
}
