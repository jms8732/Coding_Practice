package greedy;

//이분 탐색 테스트
import java.util.*;

public class binary_search_test {
	public static void main(String[] args) {
		int [] array = {1,2,2,3,3,3,4,6,7};
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		//binary_search(array,n);
		
		lower_bound(array,n);
		upper_bound(array,n);
	}
	
	//왼쪽부터 검색 시작
	private static void lower_bound(int [] array , int target) {
		int left= 0, right = array.length;
		int mid = 0;
		while(left < right) {
			mid = (left + right) / 2;
			
			if(array[mid] >= target)
				right = mid;
			else
				left = mid +1;
		}
		
		System.out.println("lower bound : " + array[left]);
	}
	
	//오른쪽부터 검색 시작
	private static void upper_bound(int [] array, int target) {
		int left = 0, right = array.length;
		int mid=0;
		
		while(left < right) {
			mid = (left + right)/ 2;
			
			if(array[mid] <= target)
				left = mid+1;
			else
				right = mid;
		}
		
		System.out.println("upper bound : " + array[left]);
	}
	
	
	private static void binary_search(int [] array , int target) {
		int left = 0;
		int right = array.length-1;
		
		int mid = 0;
		
		while(left <= right) {
			mid = (left + right ) / 2;
			if(array[mid] == target)
				break;
			
			if(array[mid] > target)
				right = mid -1 ;
			else
				left = mid +1;
		}
		
		System.out.println("binary search : " + array[mid]);
	}
}
