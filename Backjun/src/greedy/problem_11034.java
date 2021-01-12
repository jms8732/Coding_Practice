package greedy;

import java.util.*;
import java.io.*;

/*
 * 캥거루 세마리2
 * 외각에 있는 두 마리의 캥거루를 명확하게 명시하지 않았기 때문에 캥거루가 뛸 수 있는 최댓값을 구하려면
 * 캥거루 B를 기준으로 A와 C의 거리를 계산하여 최대 거리를 구하면 된다.
 */
public class problem_11034 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = null;
		
		//테스트 케이스가 정확하게 몇 개인지 나오지 않았으므로 입력되는 문자열이 null인 경우, 무한루프를 종료한다.
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
