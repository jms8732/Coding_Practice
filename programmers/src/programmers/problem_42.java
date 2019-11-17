package programmers;

//[1차 캐시] 80점 
import java.util.*;

public class problem_42 {
	public static void main(String[] args) {
		String [] tmp = {"Jeju", "Pangyo","NewYork", "LA","SanFrancisco" ,"Seoul","Rome", "Paris", "Jeju", "NewYork", "Rome"};
		int result = solution(5,tmp);
		System.out.println(result);
	}

	public static int solution(int cacheSize, String[] cities) {
		List<String> list = new ArrayList<>();
		int time =0 ;
		
		if(cacheSize ==0)
			return cities.length * 5;
		
		for(int i =0 ; i< cities.length; i++) {
			if(list.isEmpty()) { //캐시가 비었을 경우
				list.add(cities[i]);
				time +=5;
			}else {
				//캐시가 다 차있는 경우
				boolean check = false;
				int idx =0 ;
				for(int j =0 ; j< list.size(); j++) {
					idx =j ;
					String t1 = list.get(j).toLowerCase();
					String t2 = cities[i].toLowerCase();
					if(t1.equals(t2)) {
						check = true;
						break;
					}
				}
				String tmp = null;
				if(check) {
					//값이 있는 경우
					tmp = list.get(idx);
					time += 1;
				}
				else {
					//값이 없는 경우
					tmp = cities[i];
					time += 5;
				}
				if(list.size() == cacheSize)
					list.remove(idx);
				list.add(0,tmp);
			}
		}
		return time;
	}
}
