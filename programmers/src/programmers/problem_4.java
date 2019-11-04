package programmers;

//다리위를 지나는 트럭
import java.util.*;

public class problem_4 {
	static Queue<Truck> waitingTruck = new LinkedList<>();
	static Queue<Truck> goingTruck = new LinkedList<>();

	public static void main(String[] args) {
		int[] t = {10,10,10,10,10,10,10,10,10,10};
		int result = solution(100, 100, t);
		System.out.println(result);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weight) {
		for (int i = 0; i < truck_weight.length; i++) {
			Truck t = new Truck(1, truck_weight[i]);
			waitingTruck.add(t); // 현재 대기중인 트럭 삽입
		}
		int totalSec = 0;
		while ((!waitingTruck.isEmpty()) || (!goingTruck.isEmpty())) {
			totalSec++;
			// 현재 대기중인 트럭과 지나고 있는 트럭이 모두 없을 경우 반복문 종료
			
			if (!waitingTruck.isEmpty()) {
				Truck tmp = waitingTruck.peek();
				if (tmp.weight <= weight) {
					goingTruck.add(tmp); // 진행 중인 트럭에 추가
					waitingTruck.poll(); // 대기중인 트럭에서 제거
					weight -= tmp.weight; // 현재 다리가 버틸 수 있는 무게
				}
			}
			if (!goingTruck.isEmpty()) {
				for (Truck tmp : goingTruck) {
					tmp.location += 1;  // 현재 위치에서 1 증가

				}
				Truck tmp = goingTruck.peek();
				if (tmp.location > bridge_length) {
					weight += tmp.weight; // 진행중인 트럭이 없어지므로 다리가 버틸 수 있는 무게가 증가
					goingTruck.poll(); // 다리길이보다 클 경우 제거
				}
			}
			
		}
		return totalSec;
	}
}

class Truck {
	int location;
	int weight;

	public Truck(int location, int weight) {
		this.location = location;
		this.weight = weight;
	}
}