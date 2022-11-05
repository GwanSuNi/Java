package choiceFormat테스트;

import java.text.ChoiceFormat;

public class ChoiceFormatEx1 {

	public static void main(String[] args) {
		double limits[] = { 50, 60, 70, 80, 90 }; // 오름차순이여야 함
		String grades[] = { "E", "D", "C", "B", "A" }; // limits와 개수가 같아야함 -> HashMap	

		int scores[] = { 100, 90, 89, 52, 60, 72 };

		ChoiceFormat form = new ChoiceFormat(limits, grades);

		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]+ ":" + form.format(scores[i]) );
		}

	}

}
