package search_algorithm;

public class test {
	public static void main(String[] args) {
		int bit = Integer.parseInt("01111101",2);
		int tmp = bit & 1<<0;
		bit = bit >> 1;
		bit |= 128*tmp;
		
		System.out.println("bit : " + Integer.toBinaryString(bit) );
	}
}
