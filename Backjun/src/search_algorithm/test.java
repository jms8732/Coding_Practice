package search_algorithm;

public class test {
	public static void main(String[] args) {
		
		int [] array = {1,2,3,4};
		int [] w = array.clone();
		
		w[2] = 6;
		
		for(int i : array)
			System.out.println(i);
		
		for(int i : w)
			System.out.println(i);
	}
	
}
