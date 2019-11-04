package programmers;
//ž
public class problem_2 {
	static int [] map = {3, 9, 9, 3, 5, 7, 2};
	public static void main(String[] args) {
		int[] result = f();
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
	static int[] f() {
		int [] tmp;
		tmp = new int[map.length];
		for(int i = map.length-1 ; i >= 1 ; i--) {
			for(int j = i-1 ; j >= 0 ; j --) {
				if(map[i] < map[j]) {
					tmp[i] = j+1;
					break;
				}
			}
		}
		return tmp;
	}
	
}
