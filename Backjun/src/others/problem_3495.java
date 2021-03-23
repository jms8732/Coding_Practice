package others;

/*
 * �ƽ�Ű ����
 *  /,\ �� ���� ��� 0.5�� ���ϰ� /�� \�� ���̿� �����ϴ� ��ĭ�� 1�� ���Ѵ�.
 *  \,/ �� ������ �ȵǴ� ��ĭ�� ������ �ʴ´�.
 */
import java.util.*;
import java.io.*;

public class problem_3495 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		char [][] shape=  new char[h][w];
		
		for(int i =0 ; i < h; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < w; j ++) {
				shape[i][j] = tmp.charAt(j);
			}
		}
		
		double ans = 0.0;
		for(int i = 0 ; i <h ; i++) {
			boolean start = false;
			for(int j =0 ; j < w ; j++) {
				if(shape[i][j] == '/' || shape[i][j] == '\\') {
					ans += 0.5;
					
					start = !start;
				}else if(start){
					ans += 1;
				}
			}
		}
		
		System.out.println((int)ans);
	}

}
