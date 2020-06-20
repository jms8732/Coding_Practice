package greedy;

//멀티탭 스케줄링
import java.util.*;
import java.io.*;

public class problem_1700 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Set<Integer> multi_tap = new HashSet<>();

		int plug_out = 0;

		for (int i = 0; i < K; i++) {
			int cur = list.get(i);
			
			if(multi_tap.size() < N) {
				multi_tap.add(cur);
				continue;
			}
			
			if(multi_tap.contains(cur))
				continue;
			
			int total_dist = -1;
			int tar= 0;
			for(int cc : multi_tap) {
				int dist = 0;
				for(int j = i +1 ; j< K ; j++) {
					if(cc == list.get(j))
						break;
					dist++;
				}
				
				if(total_dist < dist) {
					total_dist = dist;
					tar = cc;
				}
			}
			
			multi_tap.remove(tar);
			multi_tap.add(cur);
			plug_out++;

		}

		System.out.println(plug_out);
	}
}
