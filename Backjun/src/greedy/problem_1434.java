package greedy;

import java.util.*;
import java.io.*;

//책 정리
public class problem_1434 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Deque<Integer> box=  new LinkedList<>();
		Queue<Integer> book = new LinkedList<>();
		
		st =new StringTokenizer(br.readLine());
		
		for(int i =0 ; i < N ; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
	
		for(int i =0 ; i < M ; i++)
			book.add(Integer.parseInt(st.nextToken()));
		
		//현재 책이 현재 박스에 들어가지 않으면, 3번으로 간다. 아니면 2번으로 간다
		while(!book.isEmpty()) {
			int cBook = book.peek();
			
			//현재 책을 현재 박스에 넣는다. 다음 책을 손에 집고 1번으로 간다.
			int cBox = box.poll();
			if(cBook <= cBox) {
				box.addFirst(cBox -cBook);
				book.poll();
			}else {
				//현재 박스를 다른 쪽으로 치운 다음에, 테이프로 못 열게 봉인한다. 다음 박스를 앞으로 가져오고 1번으로 간다
				box.addLast(cBox);
			}
		}
		
		int ans = 0;
		while(!box.isEmpty())
			ans += box.poll();
		
		System.out.println(ans);
	}

}
