package greedy;

//��� ��� ����
import java.util.*;
import java.io.*;

public class problem_2828 {
	public static void main(String[] args)throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int min_box = 1;
		int max_box = min_box + (M-1);
		
		int J = Integer.parseInt(br.readLine());
		
		int move = 0;
		for(int i =0 ; i < J ; i++) {
			int line = Integer.parseInt(br.readLine());
			
			//���� ���� ���
			
			if(min_box > line || line > max_box) {
				if(max_box < line) {
					//������ �����ϴ� ���
					int diff = line - max_box;
					move+= diff;
					
					max_box += diff;
					min_box += diff;
				}else {
					int diff = min_box - line;
					move += diff;
					max_box -= diff;
					min_box -= diff;
				}
			}
		}
		
		System.out.println(move);
	}
}
