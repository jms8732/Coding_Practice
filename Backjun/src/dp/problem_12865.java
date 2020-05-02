package dp;

//����� �賶
import java.util.*;
import java.io.*;

public class problem_12865 {
	static int val[], weight[], N;
	static int cache[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int tw = Integer.parseInt(st.nextToken());
		
		val = new int[N];
		weight = new int[N];
		
		cache = new int[N+1][tw+1];
		
		for(int c [] : cache)
			Arrays.fill(c, -1);
		
		for(int i =0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			val[i] = v;
			weight[i] = w;
		}
		
		System.out.println(pack(0,tw));
	}
	
	/*
	 * �ؼ��� �� �� �ִ� ���� ���� ������ �����ϳ� ���ϳĿ� ���� �޶�����.
	 */
	private static int pack(int cur , int capacity) {
		
		//�� Ž���� ���
		if(cur == N)
			return 0;
		
		if(cache[cur][capacity] != -1)
			return cache[cur][capacity];
		
		//���� ������ �������� ���� ���
		int ret = pack(cur+1,capacity);
		
		//������ ������ ���
		if(weight[cur] <= capacity)
			ret = Math.max(ret, pack(cur+1,capacity- weight[cur])+val[cur]);
		
		
		return cache[cur][capacity] = ret;
	}
}
