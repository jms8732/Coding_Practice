package search_algorithm;

//시험 성적
import java.util.*;

public class problem_9498 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		char grade = 'A';

		if (90 <= score && score <= 100)
			grade = 'A';
		else if (80 <= score && score <= 89)
			grade = 'B';
		else if (70 <= score && score <= 79)
			grade = 'C';
		else if(60 <= score && score <= 69)
			grade = 'D';
		else
			grade ='F';
		
		System.out.println(grade);
	}
}
