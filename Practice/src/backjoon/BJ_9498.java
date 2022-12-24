package backjoon;
import java.util.Scanner;

public class BJ_9498 {

	public static void main(String[] args) {
		int score;
		String grade;
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();

		switch (score / 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		System.out.println(grade);
		scanner.close();
	}
}
