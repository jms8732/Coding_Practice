package greedy;

/*
 * ī��� ��ǳ
 * ���α׷��ӽ� ü������ ������ ����
 */
import java.util.*;
import java.io.*;

public class problem_2891 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		boolean [] destroyed = new boolean[11];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i <S ; i++) {
			destroyed[Integer.parseInt(st.nextToken())] = true;
		}
		
		boolean [] spare = new boolean[11];
		
		st = new StringTokenizer(br.readLine());
		for(int i= 0 ; i< R ; i++) {
			spare[Integer.parseInt(st.nextToken())] = true;
		}
		
		int ban = S;
		for(int i =0 ; i < spare.length ; i++) {
			if(destroyed[i]) {
				//�ļյ� ���
				if(spare[i]) {
					//�ڱ� �ڽ��� ������ ������ ���
					destroyed[i] = false;
					spare[i] = false;
					ban--;
				}else {
					//������ �������� �ʴ� ���
					int left = i -1;
					
					if(left >= 0 && spare[left]) {
						spare[left] = false;
						destroyed[i] = false;
						ban--;
						continue;
					}
					
					int right = i +1;
					
					if(right < destroyed.length && spare[right]) {
						spare[right] = false;
						destroyed[i] = false;
						ban--;
						continue;
					}
				}
			}
		}
		
		System.out.println(ban);
	}
}