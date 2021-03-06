package others;

//약수들의 합
import java.util.*;

public class problem_9506 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> list =new ArrayList<>();
		int tmp = scanner.nextInt();
		
		while(tmp != -1) {
			list.add(tmp);
			tmp = scanner.nextInt();
		}
		
		for(int i =0 ; i< list.size() ; i++) {
			tmp = list.get(i);
			String answer = makeMeasure(tmp);
			System.out.println(answer);
		}
	}
	
	private static String makeMeasure(int tmp) {
		List<Integer> measure = new ArrayList<>();
		for(int i = tmp-1; i >= 1; i--) {
			if(tmp % i == 0) //약수일 경우
				measure.add(i);
		}
		
		int sum =0 ;
		Collections.sort(measure); //오름차순으로 정렬
		
		for(int i =0 ; i < measure.size() ; i++) sum += measure.get(i);
		
		if(tmp == sum) {
			StringBuilder sb = new StringBuilder();
			sb.append(tmp + " = ");
			for(int i =0 ; i< measure.size() ; i++) {
				sb.append(measure.get(i) + " + ");
			}
			sb.delete(sb.length()-3, sb.length());
			return sb.toString().trim();
		}else
			return tmp + " is NOT perfect.";
	}
	
}
