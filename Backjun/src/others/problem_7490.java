package others;

/*
 * 0 만들기
 * 아스키 코드 순서대로 하기 위해 ' ' -> '+' -> '-' 순으로 진행한다.
 * Deque를 이용하여 연산을 진행한다.
 */
import java.util.*;
import java.io.*;

public class problem_7490 {
	static char[] op = {' ', '+', '-' };
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());

			char[] array = new char[2 * n - 1];

			char start = '1';
			for (int j = 0; j < array.length; j++) {
				if (j % 2 == 0)
					array[j] = start++;
			}

			simulation(1,array, n);
			bw.newLine();
		}

		br.close();
		bw.flush();
		bw.close();

	}

	private static void simulation(int depth, char[] array, int n) {
		if (depth == array.length) {
			try {
				calculate(array);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return;
		}

		for (int i = 0; i < op.length; i++) {
			array[depth] = op[i];
			simulation(depth + 2, array, n);
		}
	}

	private static void calculate(char [] array) throws IOException {
		int result = 0;
		Deque<String> q = new LinkedList<>();
		
		for(Character c : array)
			q.add(String.valueOf(c));
		
		while(q.size() != 1) {
			int opr1 = Integer.parseInt(q.poll());
			
			while(!q.isEmpty() && q.peek().equals(" ")) {
				q.poll(); //빈칸을 내보낸다.
				opr1 = opr1*10 + Integer.parseInt(q.poll());
			}
			
			if(q.isEmpty()) {
				q.add(String.valueOf(opr1));
				continue;
			}
			
			char op = q.poll().charAt(0);
			
			int opr2 = Integer.parseInt(q.poll());
			
			while(!q.isEmpty() && q.peek().equals(" ")) {
				q.poll(); //빈칸을 내보낸다.
				opr2 = opr2*10 + Integer.parseInt(q.poll());
			}
			
			result = calculateOP(opr1,opr2,op);
			q.addFirst(String.valueOf(result));
		}
		
		if(q.peek().equals("0")) {
			bw.write(array);
			bw.newLine();
		}
	}

	private static int calculateOP(int opr1, int opr2, char op) {
		if (op == '+')
			return opr1 + opr2;
		else
			return opr1 - opr2;
	}
}
