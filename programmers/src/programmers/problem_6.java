package programmers;

import java.util.*;

//��ų Ʈ��
public class problem_6 {
	static Queue<Character> queue = new LinkedList<>();

	public static void main(String[] args) {
		String[] tmp = { "BACDE", "CBADF", "AECB", "BDA" };
		int result = solution("CBD", tmp);
		System.out.println(result);
	}

	public static int solution(String skill, String[] skill_trees) {
		int totalCount = 0;
		for(int i = 0; i < skill_trees.length ; i++) {
			int skillIdx= 0;
			boolean check = false;
			for(int  j = 0 ; j < skill_trees[i].length(); j++) {
				for(int k = 0 ; k < skill.length() ; k++) {
					if(skill.charAt(k) == skill_trees[i].charAt(j))
					{ //���ڰ� ����
						if(skillIdx ==k )
							skillIdx++; //���ڵ� ���� ��ųƮ�� ������ �´ٸ�
						else
							check = true;
					}
				}
			}
			if(!check)
				totalCount++;
			
		}
		return totalCount;
	}
}