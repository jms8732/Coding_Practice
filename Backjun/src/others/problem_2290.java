package others;

//LCD Test
import java.util.*;

public class problem_2290 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());

		int S = Integer.parseInt(st.nextToken());
		String n = st.nextToken();

		for (int i = 0; i < 2 * S + 3; i++) {
			makeLCD(n, i, S);
		}
	}

	private static void makeLCD(String n, int height, int S) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n.length(); i++) {
			char tmp = n.charAt(i);
			switch (tmp) {
			case '1':
				if ((height >= 1 && height <= S) || (height >= S + 2 && height <= 2 * S + 1)) {
					for (int j = 0; j <= S; j++)
						sb.append(" ");

					sb.append("|");
				} else {
					for (int j = 0; j <= S + 1; j++)
						sb.append(" ");
				}
				break;

			case '2':
				if ((height >= 1 && height <= S)) {
					for (int j = 0; j <= S; j++)
						sb.append(" ");

					sb.append("|");
				} else if (height >= S + 2 && height <= 2 * S + 1) {
					sb.append("|");
					for (int j = 0; j <= S; j++)
						sb.append(" ");

				} else {
					sb.append(" ");
					for (int j = 0; j < S; j++) {
						sb.append("-");
					}
					sb.append(" ");
				}
				break;

			case '3':
				if ((height >= 1 && height <= S) || (height >= S + 2 && height <= 2 * S + 1)) {
					for (int j = 0; j <= S; j++)
						sb.append(" ");

					sb.append("|");
				} else {
					sb.append(" ");
					for (int j = 0; j < S; j++) {
						sb.append("-");
					}
					sb.append(" ");
				}
				break;
			case '4':
				if ((height >= 1 && height <= S)) {
					sb.append("|");
					for (int j = 0; j < S; j++)
						sb.append(" ");
					sb.append("|");

				} else if (height >= S + 2 && height <= 2 * S + 1) {
					for (int j = 0; j <= S; j++)
						sb.append(" ");

					sb.append("|");
				} else if(height == S+1){
					sb.append(" ");
					for (int j = 0; j < S; j++) {
						sb.append("-");
					}
					sb.append(" ");
				}else {
					for (int j = 0; j <= S+1; j++)
						sb.append(" ");
				}
				break;
				
			case '5':
				if ((height >= 1 && height <= S)) {
					sb.append("|");
					for (int j = 0; j <= S; j++)
						sb.append(" ");
				} else if (height >= S + 2 && height <= 2 * S + 1) {
					for (int j = 0; j <= S; j++)
						sb.append(" ");

					sb.append("|");
				} else {
					sb.append(" ");
					for (int j = 0; j < S; j++) {
						sb.append("-");
					}
					sb.append(" ");
				}
				break;
			case '6':
				if ((height >= 1 && height <= S)) {
					sb.append("|");
					for (int j = 0; j <= S; j++)
						sb.append(" ");
				} else if (height >= S + 2 && height <= 2 * S + 1) {
					sb.append("|");
					for (int j = 0; j < S; j++)
						sb.append(" ");
					sb.append("|");
				} else {
					sb.append(" ");
					for (int j = 0; j < S; j++) {
						sb.append("-");
					}
					sb.append(" ");
				}
				break;
			case '7':
				if ((height >= 1 && height <= S) || (height >= S + 2 && height <= 2 * S + 1)) {
					for (int j = 0; j <= S; j++)
						sb.append(" ");

					sb.append("|");
				} else if(height == 0){
					sb.append(" ");
					for (int j = 0; j < S; j++) {
						sb.append("-");
					}
					sb.append(" ");
				}else {
					for (int j = 0; j <= S+1; j++)
						sb.append(" ");
				}
				break;
			case '8':
				if ((height >= 1 && height <= S)) {
					sb.append("|");
					for (int j = 0; j < S; j++)
						sb.append(" ");
					sb.append("|");

				} else if (height >= S + 2 && height <= 2 * S + 1) {
					sb.append("|");
					for (int j = 0; j < S; j++)
						sb.append(" ");
					sb.append("|");
				} else {
					sb.append(" ");
					for (int j = 0; j < S; j++) {
						sb.append("-");
					}
					sb.append(" ");
				}
				break;
			case '9':
				if ((height >= 1 && height <= S)) {
					sb.append("|");
					for (int j = 0; j < S; j++)
						sb.append(" ");
					sb.append("|");
					
				} else if (height >= S + 2 && height <= 2 * S + 1) {
					for (int j = 0; j <= S; j++)
						sb.append(" ");
					sb.append("|");
				} else {
					sb.append(" ");
					for (int j = 0; j < S; j++) {
						sb.append("-");
					}
					sb.append(" ");
				}
				break;
			case '0':
				if ((height >= 1 && height <= S)) {
					sb.append("|");
					for (int j = 0; j < S; j++)
						sb.append(" ");
					sb.append("|");

				} else if (height >= S + 2 && height <= 2 * S + 1) {
					sb.append("|");
					for (int j = 0; j < S; j++)
						sb.append(" ");
					sb.append("|");
				} else if(height == 0 || height == 2*S+2){
					sb.append(" ");
					for (int j = 0; j < S; j++) {
						sb.append("-");
					}
					sb.append(" ");
				}
				else {
					for (int j = 0; j <= S+1; j++)
						sb.append(" ");
				}
				break;
			}
			sb.append(" ");
		}

		System.out.println(sb.toString());
	}
}
