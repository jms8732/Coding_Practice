package greedy;

/*
 * ���� ����
 * �ִ��� ���� ������ �Ա� ���ؼ��� �����̰� ������ �Դ� ������ ���԰� �Ĵ� ������ ������ ���, �� �Ծ�� �Ѵ�.
 */

import java.util.*;
import java.io.*;

public class problem_14720 {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int []store=  new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for(int i =0 ; i <N ; i++) {
			store[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] order = {0,1,2};
		int pos =0 ;
		int ans = 0;
		for(int i =0 ; i < N ; i++) {
			if(store[i] == order[pos % order.length]) {
				pos++;
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}

}
