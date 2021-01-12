package greedy;

import java.util.*;
import java.io.*;

//å ����
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
		
		//���� å�� ���� �ڽ��� ���� ������, 3������ ����. �ƴϸ� 2������ ����
		while(!book.isEmpty()) {
			int cBook = book.peek();
			
			//���� å�� ���� �ڽ��� �ִ´�. ���� å�� �տ� ���� 1������ ����.
			int cBox = box.poll();
			if(cBook <= cBox) {
				box.addFirst(cBox -cBook);
				book.poll();
			}else {
				//���� �ڽ��� �ٸ� ������ ġ�� ������, �������� �� ���� �����Ѵ�. ���� �ڽ��� ������ �������� 1������ ����
				box.addLast(cBox);
			}
		}
		
		int ans = 0;
		while(!box.isEmpty())
			ans += box.poll();
		
		System.out.println(ans);
	}

}
