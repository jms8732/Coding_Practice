package others;

public class test {
	public static void main(String[] args) {
		for(int i =1 ; i < (1<<4); i++) {
			for(int j= 0 ; j < 4; j ++) {
				if((i & 1<<j ) == 1<<j)
					System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
