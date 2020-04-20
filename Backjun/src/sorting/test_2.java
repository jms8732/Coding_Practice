package sorting;

//�̺� Ž��

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
	 * �迭 ���� ������ ���� ã�´�.
	 * �ѹ� ���ߴ� ���� �ǳʶڴ�. (left = mid+1), (right = mid-1)
	 * left > right�Ǵ� ������ ���� ���ٴ� ���̹Ƿ� �ݺ����� ������ left <= right���� �����Ѵ�.
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
	
	//ã�� �� �ٷ� �ڿ� �ִ� ���� ã�� upperBound
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
	
	//ã�� ���� ������ �� Ȥ�� �׺��� ū ��
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
