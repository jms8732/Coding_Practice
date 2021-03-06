package programmers1;
//배달

import java.util.*;

public class problem_21 {
	static int count;

	public static void main(String[] args) {
		int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, 
				{ 5, 2, 2 }, { 1, 4, 2 }, 
				{ 5, 3, 1 }, { 5, 4, 2 }
				};
		int result = solution(5, road, 3);
		System.out.println(result);
	}
	
	public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int dist[] = new int[N]; //마을의 거리
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if(arg0.weight < arg1.weight)
					return -1;
				else
					return 1;
			}
        	
        });
        List<Node> list[] = new ArrayList[N];
        
        for(int i =0 ; i < N ; i++) list[i] = new ArrayList<>();
        
        for(int i =0 ; i< road.length ; i++) {
        	int s = road[i][0]-1;
        	int f= road[i][1]-1;
        	int w = road[i][2];
        
        	//양방향이기 때문에 양쪽에다 넣는다.
        	list[f].add(new Node(s,w));
        	list[s].add(new Node(f,w));
        }
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new Node(0,0));
        
        while(!pq.isEmpty())
        {
        	Node tmp = pq.poll();
        	int current= tmp.cur;
        	
        	for(Node next : list[current]) {
        		int nextIdx = next.cur;
        		if(dist[nextIdx] > dist[current] + next.weight) {
        			dist[nextIdx] =dist[current]+next.weight;
        			pq.add(new Node(nextIdx,dist[nextIdx]));
        		}
        		
        	}
        }
        
        
        for(int i =0 ; i< dist.length ; i++)
        	if(dist[i] <= K)
        		answer++;
        
        
        return answer;
    }
	private static class Node {
		int cur = 0;
		int weight = 0;

		public Node(int current, int weight) {
			this.cur = current;
			this.weight = weight;
		}
	}
}
