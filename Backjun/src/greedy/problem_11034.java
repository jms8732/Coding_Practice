package greedy;

import java.util.*;
import java.io.*;

/*
 * Ļ�ŷ� ������2
 * �ܰ��� �ִ� �� ������ Ļ�ŷ縦 ��Ȯ�ϰ� ������� �ʾұ� ������ Ļ�ŷ簡 �� �� �ִ� �ִ��� ���Ϸ���
 * Ļ�ŷ� B�� �������� A�� C�� �Ÿ��� ����Ͽ� �ִ� �Ÿ��� ���ϸ� �ȴ�.
 */
public class problem_11034 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = null;
		
		//�׽�Ʈ ���̽��� ��Ȯ�ϰ� �� ������ ������ �ʾ����Ƿ� �ԷµǴ� ���ڿ��� null�� ���, ���ѷ����� �����Ѵ�.
		while (true) {
			if((temp =br.readLine()) == null )
				break;
			String [] split = temp.split(" ");
	
			
			int A = Integer.parseInt(split[0]);
			int B = Integer.parseInt(split[1]);
			int C = Integer.parseInt(split[2]);

			System.out.println(Math.max(B-A-1, C-B-1));
			
		}
	}

}
