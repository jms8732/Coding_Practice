package greedy;

/*
 * ķ��
 * ������, ������ �����ڸ� �̿��Ͽ� ������ �؁�
 * 1) �ް��� �����ϴ� ķ���Ϸ� ������.
 * 2) �� * L�� �����̰� ��� �� �ִ� �ް� �ϼ� �̴�.
 * 3) �������� �߻��� �� �ִµ� �������� L���� ū ���, �����̰� ķ���忡�� �ް��� �� ��� �� �ִٴ� �ǹ��̴�. ����, (�� + 1) * L �� �����̰� ��� �� �ִ� �ް��� �� �̴�. 
 */
import java.io.*;
import java.util.*;

public class problem_4796 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc =1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(l == 0 && p == 0 && v == 0) //���� ����
				break;
			
			int quo = v / p;
			int mod = v % p;
			
			
			if(mod > l) {
				System.out.println("Case " + tc++ + ": " + ((quo+1) * l));
			}else {
				System.out.println("Case " + tc++ + ": " + (quo * l + mod));
			}
			
		}
	}
}
