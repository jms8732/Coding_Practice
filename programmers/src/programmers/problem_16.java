package programmers;
//완주하지 못한 마라톤
import java.util.*;
public class problem_16 {
	public static void main(String[] args0) {
		String participant[] = {"mislav", "stanko", "mislav", "ana"};
		String completion[] = {  "stanko", "mislav", "ana"};
		String result = solution(participant,completion);
		
		System.out.println(result);
	}
	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();
		String name = null;
		for(int i =0 ; i < participant.length ; i++) {
			int tmp = 0;
			if(map.get(participant[i]) != null) //중복처리
				tmp = map.get(participant[i]);
			map.put(participant[i],tmp+1); //해시 맵에 삽입
		}
		
		for(int i =0 ; i< completion.length; i++) {
			int tmp = map.get(completion[i]); //완주한 사람 이름의 값 가져오기
			tmp -= 1;
			map.put(completion[i], tmp); //변동 된 값 삽입
		}
		
		for(int i =0  ; i< participant.length;  i++) {
			if(map.get(participant[i]) > 0)
				return participant[i];
		}
		
		return name;
	}
}
