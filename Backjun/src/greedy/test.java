package greedy;

public class test {
	public static void main(String[] args) {
		for(int i = 0 ; i< 10000;i++) {
			System.out.print(0);
		}
		
		System.out.println();
		
		for(int i = 0 ; i< 10000;i++) {
			if(i % 5 == 0)
				System.out.print(1);
			else
				System.out.print(0);
		}
		

		
	}
}
