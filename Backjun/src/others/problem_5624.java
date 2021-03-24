package others;

/*
 * ���� ��
 * A+B+C=X
 * A+B = X - C�� ������ �̿��Ͽ� ������ �����Ѵ�.
 * ���� X-C�� ���� �̹� �湮�� ���� �ִٴ� �ǹ̴� ������ ����� X�� ���� �� �ִٴ� �ǹ̿� �����ϴ�.
 */
import java.util.*;
import java.io.*;

public class problem_5624 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] array = new int[n];
		
		for(int i =0 ; i < n ; i ++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int mid = 200000;
		boolean [] visited =new boolean[mid*2+1];
		
		int ans =0 ;
		for(int i =0 ; i < n ; i++) {
			for(int j =0 ; j < i ; j++) {
				if(visited[array[i] - array[j] + mid]) {
					ans++;
					break;
				}
			}
			
			for(int j =0 ; j <= i ; j++) {
				visited[array[i] + array[j] + mid ] = true;
			}
			
		}
		
		System.out.println(ans);
	}

}
