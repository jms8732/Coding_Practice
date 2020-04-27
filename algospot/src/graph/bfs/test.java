package graph.bfs;

//부분 리스트 자리 바꾸기
import java.util.*;
public class test {
	public static void main(String[] args) {
		List<Integer> val = new ArrayList<>();
		
		for(int i =0 ; i < 4 ; i ++) {
			val.add(i);
		}
		
		for(int i : val)
			System.out.print(i + " ");
		
		
		System.out.println();
		Collections.reverse(val.subList(0, 2));
		
		for(int i : val) {
			System.out.print(i + " ");
		}
		
	}
}
