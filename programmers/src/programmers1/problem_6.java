package programmers1;

//베스트 엘범, 53점, 7개 틀림

import java.util.*;

public class problem_6 {
	public static void main(String[] args) {
		String tmp [] = {"classic","pop","classic","classic","pop","jazz"};
		int t[] = {500,600,150,800,2500,300};
		int [] result = solution(tmp,t);
		for(int i : result)
			System.out.print(i + " ");
	}

	public static int[] solution(String[] genres, int[] plays) {
		Map<String,Integer> map = new HashMap<>(); //장르와 누적 재생 횟수 저장
		Map<Integer,PriorityQueue<Node>> map1 = new HashMap<>();
		for(int i =0 ; i< genres.length ; i++) {
			String genre = genres[i]; //장르
			int play=  plays[i]; //플레이 횟수
			
			if(map.get(genre) == null) {
				//처음 등록이라면
				map.put(genre, play);
			}else
			{
				int tmp = map.get(genre);
				map.put(genre, tmp+play); //갱신
			}
		}
		
		List<Node> list = new LinkedList<>();
		
		for(int i =0 ; i< genres.length ; i++) {
			
			int genre = map.get(genres[i]);
			int play = plays[i];
			
			if(map1.get(genre) == null)
			{
				PriorityQueue<Node> tmpList = new PriorityQueue<>(new Comparator<Node>() {

					@Override
					public int compare(Node o1, Node o2) {
						// TODO Auto-generated method stub
						if(o1.play < o2.play) //플레이수로 내림차순
							return 1;
						else if(o1.play == o2.play)
						{
							if(o1.idx < o2.idx) //인덱스로 오름차순
								return -1;
							else
								return 1;
						}else
							return -1;
					}
					
				});
				tmpList.add(new Node(play,i));
				map1.put(genre, tmpList);
			}
			else {
				PriorityQueue<Node> tmpList = map1.get(genre);
				tmpList.add(new Node(play,i));
				map1.put(genre, tmpList);
			}
		}
		
		Iterator it = map1.keySet().iterator();
		List<Integer> keyList = new LinkedList<>();
		
		while(it.hasNext()) {
			int tmp = (int)it.next();
			keyList.add(tmp);
		}
		
		keyList.sort(Collections.reverseOrder()); //내림차순으로 정렬
		Vector<Integer> v = new Vector<>();
		
		for(int i =0 ; i< keyList.size(); i++) {
			PriorityQueue<Node> tmpList = map1.get(keyList.get(i));//리스트를 가져온다.
			int idx = 0;
			
			while(!tmpList.isEmpty()) {
				if(idx == 2)
					break;
				v.add(tmpList.poll().idx);
				idx++;
			}
		}
		
		int tmp [] = new int[v.size()];
		for(int i =0 ; i< v.size() ; i++) {
			tmp[i] = v.get(i);
		}
		return tmp;
	}
	
	private static class Node{
		int play; //플레이 횟수
		int idx; //고유번호
		public Node(int p ,int i) {
			this.play = p;
			this.idx = i;
		}
	}
}
