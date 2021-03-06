package sorting;

//위상 정렬 연습
import java.util.*;
import java.io.*;

/*
 * 위상 정렬의 순서는 아래와 같다.
 * 1) 들어오는 간선이 없는 정점을 큐에 넣는다.
 * 2) 정점 개수 만큼 이 행동을 반복한다.
 *  2-1) 큐의 front 원소를 빼서 그 정점에서 나가는 간선을 모두 삭제
 *  2-2) 이 때, 삭제하면서 들어온느 간선이 0이 되는 새로운 정점이 생기면 그것들을 큐에 넣는다.
 * 3) 이 때, 큐에서 빼내는 정점 순서가 위상 정렬 결과이다.
 * 
 */
public class test {
	static List<Integer> list[];
	static int[] indegree;

	public static void main(String[] args) {
		list = new ArrayList[7];
		indegree = new int[7];

		for (int i = 0; i < list.length; i++)
			list[i] = new ArrayList<>();
		list[0].add(1);
		list[0].add(4);

		list[1].add(2);
		list[4].add(5);

		list[2].add(3);
		list[3].add(5);
		list[5].add(6);

		// 각각의 정점에 대해 진입차수를 구하기
		for (int i = 0; i < list.length; i++) {
			List<Integer> tmp = list[i];

			for (int j = 0; j < tmp.size(); j++) {
				indegree[tmp.get(j)] += 1;
			}
		}

		Queue<Integer> queue = new LinkedList<>();

		// 진입 차수가 0인 지점을 넣기
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.add(i);
		}
		
		int [] answer = new int[7];
		boolean check = true;
		//위상 정렬
		for(int j =0 ; j < indegree.length ; j++) {
			int current = queue.poll();
			answer[j] = current +1;
			
			for (int i = 0; i < list[current].size(); i++) {
				indegree[list[current].get(i)] -= 1;
				
				if(indegree[list[current].get(i)] == 0) {
					queue.add(list[current].get(i));
				}
				
				//행여나 연결된 노드의 사이클이 있을 경우
				if(queue.isEmpty()) {
					check = false;
					break;
				}
				
			}
		}
		
		if(check) {
			for(int i : answer)
				System.out.print(i + " ");
		}else
			System.out.println("Circle is happened");
	}
}
