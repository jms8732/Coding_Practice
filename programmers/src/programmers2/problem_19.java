package programmers2;

import java.util.*;

//호텔 방 배정
public class problem_19 {
	static Set<Long> occupied;
	static TreeSet<Long> nextRoom;

	public static void main(String[] args0) {
		long k = 5;
		long[] room = { 1, 1, 1, 1, 1 };

		for (long i : solution(k, room))
			System.out.print(i + " ");
	}

	public static long[] solution(long k, long[] room_number) {
		occupied = new LinkedHashSet<>();
		nextRoom = new TreeSet<Long>();

		for (int i = 0; i < room_number.length; i++) {
			findRoom(room_number[i], k);
		}

		long[] answer = new long[occupied.size()];
		Iterator<Long> it = occupied.iterator();
		int idx = 0;

		while (it.hasNext()) {
			answer[idx++] = it.next();
		}

		return answer;
	}

	private static void findRoom(long number, long k) {
		if (occupied.contains(number)) {
			// 현재 원하는 방이 차 있는 경우
			findCloseRoom(number, k);
		} else {
			// 현재 원하는 방이 비어있는 경우
			occupied.add(number);

			if (nextRoom.contains(number))
				nextRoom.remove(number);

			if (!occupied.contains(number + 1))
				nextRoom.add(number + 1);
		}
	}

	private static void findCloseRoom(long number, long k) {
		long tmp = nextRoom.ceiling(number);
		
		nextRoom.remove(tmp);

		if (!occupied.contains(tmp + 1)) {
			nextRoom.add(tmp + 1);
		}

		occupied.add(tmp);
	}

}
