package programmers2;

import java.util.Arrays;

/*
 * ��ƼĿ ������(2)
 * DP ������ ����
 */
public class problem_41 {
	 public int solution(int sticker[]) {
	        int [] dp1 = new int[sticker.length];
	        int [] dp2 = new int[sticker.length];
	        
	     
	        //���̰� 3 ������ ��� ó��, ���� �� TC���� ��Ÿ�� ���� �߻�
	        if(sticker.length <= 3) {
	        	return Arrays.stream(sticker).max().getAsInt();
	        }
	        
	        //ù��° ��ƼĿ�� �� ���
	        dp1[0] = dp1[1] = sticker[0];
	        
	        //�ι�° ��ƼĿ�� �� ���
	        dp2[0] = 0;
	        dp2[1] = sticker[1];
	        
	        
	        for(int i = 2; i < sticker.length-1 ; i++) {
	        	dp1[i] = Math.max(dp1[i-2]+sticker[i], dp1[i-1]);
	        	dp2[i] = Math.max(dp2[i-2]+sticker[i],dp2[i-1]);
	        }
	        
	        //�������� ���, ù��° ��ƼĿ�� ������ ���, ������ ��ƼĿ�� �� �� ���⿡ ���� ó���Ѵ�
	        int last = sticker.length-1;
	        
	        dp1[last] = Math.max(dp1[last-2], dp1[last-1]);
	        dp2[last] = Math.max(dp2[last-2]+sticker[last], dp2[last-1]);
	        
	        return Math.max(dp1[last], dp2[last]);
	        
	    }
}
