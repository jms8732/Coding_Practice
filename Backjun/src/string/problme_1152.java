package string;

//단어의 개수
import java.util.*;
import java.io.*;

public class problme_1152 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		System.out.println(st.countTokens());
	}
}
