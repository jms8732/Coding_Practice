package programmers;

import java.util.*;
import java.lang.*;
public class problem_18 {
	public static void main(String[] args0) {
		int[] tmp = { 1,2,3,4,5};
		int[] result = solution(tmp);
		for (int i : result)
			System.out.print(i + " ");
	}

	public static int[] solution(int[] answers) {
		int check1 = 0, check2 = 0, check3 = 0;
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] array3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == array1[i % array1.length])
				check1++;
			if (answers[i] == array2[i % array2.length])
				check2++;
			if (answers[i] == array3[i % array3.length])
				check3++;
		}
		Person p1 = new Person(check1,1);
		Person p2 = new Person(check2,2);
		Person p3 = new Person(check3,3);
		
		PriorityQueue <Person> pList = new PriorityQueue<>();
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		Vector<Person> v = new Vector<>();
		while(true) {
			Person tmp = pList.poll();
			int count = tmp.count;
			v.add(tmp);
			if(pList.isEmpty())
				break;
			if(count != pList.peek().count)
				break;
		}
		int [] answer = new int[v.size()];
		for(int i =0 ; i< answer.length;i++) {
			int number = v.get(i).number;
			answer[i] = number;
		}
		
		return answer;
	}
}

class Person implements Comparable<Person>{
	int count, number;
	
	public Person(int count , int number) {
		this.count = count;
		this.number = number;
	}
	@Override
	public int compareTo(Person p) {
		return this.count <= p.count ? 1 : -1;
	}
}
