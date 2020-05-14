package string;

//»ó¼ö
import java.util.*;
import java.io.*;

public class problem_2908 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder opr1 = new StringBuilder(st.nextToken());
		StringBuilder opr2 = new StringBuilder(st.nextToken());
		
		opr1 = opr1.reverse();
		opr2 = opr2.reverse();
		
		if(Integer.parseInt(opr1.toString()) > Integer.parseInt(opr2.toString())) {
			System.out.println(opr1.toString());
		}else
			System.out.println(opr2.toString());
	}
}
