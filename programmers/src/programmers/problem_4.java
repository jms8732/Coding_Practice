package programmers;

//�ٸ����� ������ Ʈ��
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
			waitingTruck.add(t); // ���� ������� Ʈ�� ����
		}
		int totalSec = 0;
		while ((!waitingTruck.isEmpty()) || (!goingTruck.isEmpty())) {
			totalSec++;
			// ���� ������� Ʈ���� ������ �ִ� Ʈ���� ��� ���� ��� �ݺ��� ����
			
			if (!waitingTruck.isEmpty()) {
				Truck tmp = waitingTruck.peek();
				if (tmp.weight <= weight) {
					goingTruck.add(tmp); // ���� ���� Ʈ���� �߰�
					waitingTruck.poll(); // ������� Ʈ������ ����
					weight -= tmp.weight; // ���� �ٸ��� ��ƿ �� �ִ� ����
				}
			}
			if (!goingTruck.isEmpty()) {
				for (Truck tmp : goingTruck) {
					tmp.location += 1;  // ���� ��ġ���� 1 ����

				}
				Truck tmp = goingTruck.peek();
				if (tmp.location > bridge_length) {
					weight += tmp.weight; // �������� Ʈ���� �������Ƿ� �ٸ��� ��ƿ �� �ִ� ���԰� ����
					goingTruck.poll(); // �ٸ����̺��� Ŭ ��� ����
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