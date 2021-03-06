package programmers1;

//기지국 설치
import java.util.*;

public class problem_24 {
	public static void main(String[] args) {
		int n = 16;
		int[] stations = {4};
		int w=2 ;
		int result = solution(n, stations, w);
		System.out.println(result);
	}

	   public static int solution(int n ,int [] stations, int w) {
			int answer =0 ;
			
			int start = 1;
			for(int i =0 ; i< stations.length ; i++) {
				int point = stations[i];
				int left = point-w-1; //현재 포인트의 전파 밖위치
				int right = point+ w+1; 
				
				if(left >= start) {
					int blockCount = left - start +1; //전파가 닿지 않는 블록의 수
					int tmp = blockCount / (2*w+1);
					if(blockCount % (2*w+1) != 0)
						answer++;
					answer += tmp; //개수 더하기
				}
				start = right; //다음 시작 위치
			}
			if(start <= n) {
				int blockCount = n - start +1; //전파가 닿지 않는 블록의 수
				int tmp = blockCount / (2*w+1);
				if(blockCount % (2*w+1) != 0)
					answer++;
				answer += tmp; //개수 더하기
			}
			
			return answer;
		}
}
