package greedy;

//Àú¿ï
import java.util.*;
import java.io.*;

public class problem_2438 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] val = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(val);

		int weight = val[0];
		
		if(weight != 1)
			System.out.println(1);
		else {
			for(int i = 1 ; i < val.length ; i++) {
				if(Math.abs(weight - val[i]) <= 1) {
					weight += val[i];
				}else {
					if(weight - val[i] >= 0)
						weight += val[i];
					else
						break;
				}
			}
			
			System.out.println(weight+1);
		}
	}
}
