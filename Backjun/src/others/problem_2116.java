package others;

/*
 * �ֻ��� �ױ�
 * O(6N) => O(N)�� �ð� ���⵵
 * ù �ֻ����� �ظ��� ���� ��, ��Ģ�� ���� �ֻ����� �׾� �ø��µ� ȸ���� ����̾���. 
 * �� �ֻ����� ȸ���� �����ϹǷ� ���������� ������ ���� �� ���� ū ���� ���ϸ� �ȴ�.
 */
import java.util.*;
import java.io.*;

public class problem_2116 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] dices = new int[n][];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dices[i] = new int[6];
			for (int j = 0; j < 6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		
		for(int i = 0 ; i< dices[0].length; i++) {
			int down_idx = findDownIdx(dices[0][i],dices[0]);
			int up_idx = findUpIdx(down_idx);
			
			int max_val = findMaxValue(dices[0],down_idx,up_idx);
			max_val += pileDices(dices,n,dices[0][up_idx]);
			
			ans = Math.max(ans, max_val);
		}

		System.out.println(ans);
	}

	private static int pileDices(int[][] dices, int n, int upNumber) {
		int ret = 0;

		for (int i = 1; i < n; i++) {
			int down_idx = findDownIdx(upNumber, dices[i]); // ���� �������� �ϴ� �ֻ����� �Ʒ� �ε���
			int up_idx = findUpIdx(down_idx);
			
			int max_val = findMaxValue(dices[i],down_idx,up_idx);
			
			ret += max_val;
			upNumber = dices[i][up_idx];
		}
		
		return ret;
	}
	
	private static int findMaxValue(int [] dice, int d, int u) {
		int max = 0;
		
		for(int i =0 ; i < dice.length ; i++) {
			if(d != i && u != i) {
				//��, �Ʒ� �ε����� �ƴ� ���
				max = Math.max(max, dice[i]);
			}
		}
		
		return max;
	}

	private static int findUpIdx(int downIdx) {
		if (downIdx == 0 || downIdx == 5) {
			if (downIdx == 0)
				return 5;
			return 0;
		}
		if (downIdx == 1 || downIdx == 3) {
			if (downIdx == 1)
				return 3;
			return 1;
		}
		if (downIdx == 2 || downIdx == 4) {
			if (downIdx == 2)
				return 4;
			return 2;
		}

		return 0;
	}

	private static int findDownIdx(int target, int[] dices) {
		for (int i = 0; i < dices.length; i++) {
			if (target == dices[i])
				return i;
		}

		return -1;
	}
}
