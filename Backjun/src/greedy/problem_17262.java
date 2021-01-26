package greedy;

/*
 * 팬덤이 넘쳐 흘러
 * 가장 일찍 하교한 시간 - 가장 늦게 등교한 시간
 */
import java.util.*;
import java.io.*;

public class problem_17262 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		PriorityQueue<Size> pq = new PriorityQueue<>();
		
		for(int i= 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			pq.add(new Size(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		
		while(!pq.isEmpty()) {
			Size cur = pq.poll();
			
			min = Math.min(min, cur.end);
			max = Math.max(max, cur.start);
		}
		
		if(max - min < 0)
			System.out.println(0);
		else
			System.out.println(max - min);
		
	}

	private static class Size implements Comparable<Size>{
		int start, end;

		public Size(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Size arg0) {
			// TODO Auto-generated method stub
			if(this.start < arg0.start)
				return -1;
			else if(this.start == arg0.start) {
				return Integer.compare(this.end, arg0.end);
			}else
				return 1;
		}
		
		
	}
}
