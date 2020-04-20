package sorting;

//이분 탐색

public class test_2 {
	public static void main(String[] args) { 
		int [] array = {1,2,3,5,6,7,8,9,10};
		//binarySearch(3,array);
		
		int [] array1 = {1,2,3,3,3,5,6,7,8};
		upperBound(4,array1);
		System.out.println();
		
		lowerBound(4,array1);
	}
	
	/*
	 * 배열 범위 내에서 값을 찾는다.
	 * 한번 비교했던 값은 건너뛴다. (left = mid+1), (right = mid-1)
	 * left > right되는 순간은 값이 없다는 것이므로 반복문의 수행은 left <= right까지 진행한다.
	 */
	private static void binarySearch(int target,int [] array) {
		int left =0 ;
		int right = array.length-1;
		int mid =0 ;
		boolean check = false;
		while(left <= right) {
			mid = (left + right) /2;
			
			if(array[mid] == target) {
				check = true;
				break;
			}
			
			if(array[mid]< target)
				left = mid+1;
			else
				right = mid-1;
		}	
		
		if(check)
			System.out.println(array[mid]);
		else
			System.out.println(target + " is not in There");
	}
	
	//찾는 값 바로 뒤에 있는 값을 찾는 upperBound
	private static void upperBound(int target ,int [] array) {
		int left =0 ;
		int right = array.length;
		int mid =0 ;
		
		while(left < right) {
			mid = (left + right) /2;
			print(left,right,mid);
			
			if(array[mid] <= target)
				left = mid+1;
			else
				right = mid;
		}
		
		
		System.out.println("index : " + left + " value : " + array[left]);
	}
	
	//찾는 값과 동일한 값 혹은 그보다 큰 값
	private static void lowerBound(int target ,int [] array) {
		int left =0 ;
		int right = array.length;
		int mid =0 ;
		
		while(left < right) {
			mid = (left+ right) /2;
			print(left,right,mid);
			
			if(array[mid] < target)
				left = mid+1;
			else
				right = mid;
		}
		
		System.out.println("index : " + left + " value : " + array[left]);
	}
	
	private static void print(int left , int right, int mid) {
		System.out.println("left : " + left + ", right : " + right + ", mid : " + mid);
	}
}
