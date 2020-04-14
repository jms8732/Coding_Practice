package search_algorithm;

public class test {
	public static void main(String[] args) {
		
		int b1 = 1<<(3);
		
		int b2 = 1<<3;
		b2 |= 1<<6;
		
		System.out.println(Integer.toBinaryString(b1));
		System.out.println(Integer.toBinaryString(b2));
		
	}
	
}
