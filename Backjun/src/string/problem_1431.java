package string;

//시러얼 번호
import java.util.*;
import java.io.*;

public class problem_1431 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}

		list.sort(new Comparator<String>() {

			// 정렬
			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				if (arg0.length() < arg1.length()) {
					return -1;
				} else if (arg0.length() == arg1.length()) {
					int v1 = cal(arg0);
					int v2 = cal(arg1);

					if (v1 < v2)
						return -1;
					else if (v1 == v2) {
						if(arg0.compareTo(arg1) < 0)
							return -1;
						else
							return 1;
					} else
						return 1;
				} else
					return 1;
			}

		});
		
		for(String val : list)
			System.out.println(val);
	}

	private static int cal(String val) {
		int result = 0;
		for (int i = 0; i < val.length(); i++) {
			if (val.charAt(i) >= '0' && val.charAt(i) <= '9') {
				result += val.charAt(i) - '0';
			}
		}

		return result;
	}
}
