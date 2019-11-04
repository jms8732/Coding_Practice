package programmers;

public class test {
	public static void main(String[] args) {
		int result = solution("AAABAAAA");
		System.out.println(result);
	}
	public static int solution(String name) {
        int answer = 0;
        
        int[] arr = nameToArray(name);
        
        int start = startIndex(arr);
        int end = endIndex(arr);
        int beforeZero = beforeZero(arr, start, end);
        int afterZero = afterZero(arr, start, end);
        
        int way = shorterWay(arr, start, end, beforeZero, afterZero);
        for(int i=0; i<arr.length; i++) {
        	answer += arr[i];
        }
        
        answer += way;
        return answer;
    }

	private static int[] nameToArray(String name) {
		int[] arr = new int[name.length()];
		for(int i=0; i<name.length(); i++) {
			arr[i] = name.charAt(i) - 'A';
			if(arr[i] > 13) {
				arr[i] = arr[i] - (2 * (arr[i] - 13));
			}
		}
		return arr;
	}
	
	private static int startIndex(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0) return i;
		}
		return 0;
	}
	
	private static int endIndex(int[] arr) {
		for(int i=arr.length-1; i>0; i--) {
			if(arr[i] > 0) return i;
		}
		return arr.length-1;
	}
	
	private static int beforeZero(int[] arr, int start, int end) {
		
		for(int i=start; i<end; i++) {
			if(arr[i] == 0) {
				return i-1;
			}
		}
		return -1;
	}
	
	private static int afterZero(int[] arr, int start, int end) {
		for(int i=start; i<=end; i++) {
			if(arr[i] == 0) {
				for(int j=i; j<=end; j++) {
					if(arr[j] != 0) {
						return j+1;
					}
				}
			}
		}
		return -1;
	}
	
	private static int shorterWay(int[] arr, int start, int end, int beforeZero, int afterZero) {
		if(beforeZero == -1 || afterZero == -1) {
			return end;
		}else {
			return Math.min(end, (2*beforeZero+arr.length-afterZero)+1);
		}
	}
}
