package combination;

//조합 테스트
public class test2 {
	public static void main(String[] args) {
		int [] array= {1,2,3};
		int [] value = new int[2];
		
		System.out.println("중복 없는 조합 : " );
		combination(0,value,array,0);
		
		value = new int[2];
		System.out.println("중복 있는 조합 : " );
		reCombination(0,value,array,0);
	}
	private static void reCombination(int depth, int [] value ,int [] array,int idx) {
		if(depth == value.length) {
			print(value);
			return;
		}
		if(idx == array.length) return;
		
		value[depth] = array[idx];
		reCombination(depth+1,value,array,idx);
		reCombination(depth,value,array,idx+1);
	}
	
	
	private static void combination(int depth, int [] value, int [] array,int next) {
		if(depth == value.length) {
			print(value);
			return;
		}
		
		for(int i = next ; i < array.length ; i++) {
			value[depth] = array[i];
			combination(depth+1,value,array,i+1);
		}
	}
	
	private static void print(int [] value)
	{
		for(int i : value)
			System.out.print(i + " " );
		System.out.println();
	}
}
