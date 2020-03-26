package programmers2;


public class test {
	public static void main(String[] args) {
		int [] array = {1,2,3,4};
		
		for(int i =1 ; i <= array.length ; i++) {
			int [] tmp = new int[i];
			
			permutation(0,0,array,tmp);
		}
	}
	
	private static void permutation(int depth ,int next, int [] array , int [] tmp) {
		if(depth == tmp.length) {
			for(int i= 0 ; i < tmp.length ; i++) {
				System.out.print(tmp[i] + " " );
			}
			System.out.println();
			
			return;
		}
		
		for(int i = next ; i < array.length ; i++) {
			tmp[depth] = array[i];
		
			permutation(depth+1,i+1,array,tmp);
		
		}
	}

}
