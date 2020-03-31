package programmers2;

//프로그래밍 3
public class problem_18 {
	
	public static void main(String[] args0) {

		String[] user = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] ban = { "*rodo","*rodo","******" };
		System.out.println(solution(user, ban));
	}

	public static int solution(String[] user_id, String[] banned_id) {
		int count =0;
		for(int i = 1;  i<(1<<user_id.length) ; i++) {
			if(Integer.bitCount(i) == banned_id.length) {
				String[] user = makeStringUser(user_id,Integer.bitCount(i),i);
				
				if(make(0,user,banned_id))
					count++;
			}
		}
		return count;
	}
	
	private static String[] makeStringUser(String [] user, int len , int bit) {
		String [] value = new String[len];
		int idx =0 ;
		for(int i = 0 ; i < user.length ; i++) {
			if((bit & 1<<i) == 1<<i) {
				value[idx++] = user[i];
			}
		}
		
		return value;
	}

	private static boolean make(int depth, String[] user_id, String[] banned_id) {
		if (depth == banned_id.length) {
			if (check(user_id, banned_id)) {
				return true;
			}

			return false;
		}

		for (int i = depth; i < user_id.length; i++) {
			swap(depth,i,user_id);
			if(make(depth + 1, user_id, banned_id))
				return true;
			swap(i, depth, user_id);
		}
		return false;
	}

	static boolean check(String[] value, String[] banned_id) {
		for (int i = 0; i < banned_id.length; i++) {
			if(banned_id[i].length() != value[i].length())
				return false;
			
			for (int j = 0; j < value[i].length(); j++) {
				if (value[i].charAt(j) != banned_id[i].charAt(j))
					if (banned_id[i].charAt(j) != '*')
						return false;
			}
		}

		return true;
	}

	private static void swap(int depth, int i, String[] user_id) {
		String tmp = user_id[depth];
		user_id[depth] = user_id[i];
		user_id[i] = tmp;
	}
}
