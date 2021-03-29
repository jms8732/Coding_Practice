package others;

/*
 * A�� B
 * �ݴ�� �����Ѵ�. S�� 2���� ��Ģ�� �̿��ؼ� ����� ���� �ƴ� T�� 2���� ��Ģ�� �̿��ؼ� S�� �Ǵ����� �Ǵ��Ѵ�.
 */
import java.util.*;
import java.io.*;

public class problem_12094 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		br.close();
		
		simulation(S,T);

	}

	private static void simulation(String S , String T) {
		StringBuilder sb = new StringBuilder(T);
		while(S.length() != sb.length()) {
			char temp = sb.charAt(sb.length()-1);
			
			sb = sb.deleteCharAt(sb.length()-1);
			if(temp == 'B') {
				//������ ���ڰ� B�� ���
				sb = sb.reverse(); //�����´�.
			}
		}
		
		if(S.equals(sb.toString()))
			System.out.println(1);
		else
			System.out.println(0);
	}
}
