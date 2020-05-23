package sorting;

//수 정렬하기 3
import java.util.*;
import java.io.*;

public class problem_1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				if (arg0.length() < arg1.length()) {
					return -1;
				} else if (arg0.length() == arg1.length()) {
					if (arg0.compareToIgnoreCase(arg1) < 0)
						return -1;
					else
						return 1;
				} else
					return 1;
			}

		});

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String tar = br.readLine();
			if (!pq.contains(tar))
				pq.add(tar);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (!pq.isEmpty()) {
			bw.write(pq.poll() + "\n");
		}

		bw.flush();
	}
}
