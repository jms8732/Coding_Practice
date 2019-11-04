package programmers;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
//[1차] 추석 트레픽, brute force 40.9점(시간 단위 안바꿧을때) => 45.5점
import java.util.*;

public class problem_11 {
	public static void main(String[] args) {
		String[] tmp = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		int result = solution(tmp);
		System.out.println(result);
	}

	public static int solution(String[] lines) {
		int[] dp = new int[lines.length];
		for(int i = 0 ; i < lines.length ; i++) {
			String outerTmp[] = lines[i].split(" ");
			String outerTime = outerTmp[1];
			String outerSec = outerTmp[2].replace("s", ""); //s제거
			
			String outerTimeTmp [] = outerTime.split(":");
			
			//시간 변환
			double outerT = 3600 * Double.parseDouble(outerTimeTmp[0]) +
					60 * Double.parseDouble(outerTimeTmp[1]) + Double.parseDouble(outerTimeTmp[2]);

			double outerS = Double.parseDouble(outerSec);
			double section  = outerT + 1;
			for(int j =i  ; j < lines.length ; j++) {
				String innerTmp[] = lines[j].split(" ");
				String innerTime = innerTmp[1];
				String innerSec = innerTmp[2].replace("s", "");
				String innerTimeTmp [] = innerTime.split(":");
				
				//시간 변환
				double innerT = 3600 * Double.parseDouble(innerTimeTmp[0]) + 
						60 * Double.parseDouble(innerTimeTmp[1]) + Double.parseDouble(innerTimeTmp[2]);
				double innerS = Double.parseDouble(innerSec);
				
				double tmp = innerT - innerS + 0.001;
				
				if(section > tmp)
					dp[i]+= 1;
				
			}
		}
		int big = 0;
		for(int i : dp) //최댓값 구하기
			big = Math.max(i, big);
		
		return big;
	}
}
