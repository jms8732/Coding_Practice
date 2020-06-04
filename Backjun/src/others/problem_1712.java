package others;

//손익 분기점
import java.util.*;
import java.io.*;
import java.math.*;

public class problem_1712 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BigDecimal A = new BigDecimal(st.nextToken());
		BigDecimal B = new BigDecimal(st.nextToken());
		BigDecimal C = new BigDecimal(st.nextToken());

		if (B.compareTo(C) >= 0) {
			System.out.println(-1);
		} else {
			long left = 1;
			long right = 2100000000;
			BigDecimal m = null;
			while (left <= right) {
				long mid = (left + right) / 2;
				m = new BigDecimal(String.valueOf(mid));

				if (A.add(B.multiply(m)).compareTo(C.multiply(m)) < 0) {
					right = mid - 1;
				} else
					left = mid + 1;
			}
			
			System.out.println(left);
		}

	}
}
