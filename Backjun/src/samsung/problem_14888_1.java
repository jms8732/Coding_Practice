package samsung;

//연산자 끼워 넣기
import java.util.*;
import java.io.*;

public class problem_14888_1 {
	static int big = 0, small = Integer.MAX_VALUE;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		int[] tmp = new int[4];
		int size = 0;
		for (int i = 0; i < 4; i++) {
			int t = Integer.parseInt(st.nextToken());
			size += t;
			tmp[i] = t;
		}

		char[] op = new char[size];
		int idx = 0;
		for (int i = 0; i < tmp.length; i++) {
			char t = ' ';
			if (i == 0) {
				t = '+';
			} else if (i == 1)
				t = '-';
			else if (i == 2)
				t = '*';
			else
				t = '/';

			for (int j = 0; j < tmp[i]; j++) {
				op[idx++] = t;
			}
		}
		permutation(0,size,op);
		System.out.println(big);
		System.out.println(small);
	}

	private static void permutation(int depth, int size, char[] op) {
		if (depth == size) {
			int result = cal(op);
			big = Math.max(big, result);
			small = Math.min(small, result);
			return;
		}

		for (int i = depth; i < size; i++) {
			swap(depth, i, op);
			permutation(depth + 1, size, op);
			swap(i, depth, op);
		}
	}
	
	private static int cal(char [] op) {
		Deque<Integer> dq = new LinkedList<>(list);
		
		for(int i =0 ; i < op.length ; i++) {
			int opr1 = dq.pollFirst();
			int opr2 = dq.pollFirst();
			
			int result = cal(opr1,opr2,op[i]);
			dq.addFirst(result);
		}
		
		return dq.poll();
	}
	
	private static int cal(int opr1, int opr2, char op) {
		int result =0;
		switch(op) {
		case '+':
			result = opr1 + opr2;
			break;
		case '-':
			result = opr1- opr2;
			break;
		case '*':
			result = opr1 * opr2;
			break;
		case '/':
			if(opr1 >= 0) {
				result = opr1/opr2;
			}else {
				result = Math.abs(opr1)/opr2;
				result *= -1;
			}
		}
		
		return result;
	}

	private static void swap(int depth, int i, char[] op) {
		char tmp = op[depth];
		op[depth] = op[i];
		op[i] = tmp;

	}
}
