package print;

//그대로 출력하기
import java.io.*;

public class problem_11718 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line=br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
