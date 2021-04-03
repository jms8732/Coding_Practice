package programmers2;

import java.util.Arrays;

/*
 * 스티커 모으기(2)
 * DP 유형의 문제
 */
public class problem_41 {
	 public int solution(int sticker[]) {
	        int [] dp1 = new int[sticker.length];
	        int [] dp2 = new int[sticker.length];
	        
	     
	        //길이가 3 이하인 경우 처리, 안할 시 TC에서 런타임 에러 발생
	        if(sticker.length <= 3) {
	        	return Arrays.stream(sticker).max().getAsInt();
	        }
	        
	        //첫번째 스티커를 땔 경우
	        dp1[0] = dp1[1] = sticker[0];
	        
	        //두번째 스티커를 땔 경우
	        dp2[0] = 0;
	        dp2[1] = sticker[1];
	        
	        
	        for(int i = 2; i < sticker.length-1 ; i++) {
	        	dp1[i] = Math.max(dp1[i-2]+sticker[i], dp1[i-1]);
	        	dp2[i] = Math.max(dp2[i-2]+sticker[i],dp2[i-1]);
	        }
	        
	        //마지막일 경우, 첫번째 스티커를 떼었을 경우, 마지막 스티커를 뗄 수 없기에 따로 처리한다
	        int last = sticker.length-1;
	        
	        dp1[last] = Math.max(dp1[last-2], dp1[last-1]);
	        dp2[last] = Math.max(dp2[last-2]+sticker[last], dp2[last-1]);
	        
	        return Math.max(dp1[last], dp2[last]);
	        
	    }
}
