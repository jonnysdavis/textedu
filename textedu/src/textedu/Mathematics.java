package textedu;

import java.util.ArrayList;
import java.util.Random;

public class Mathematics extends Subject {

	int x, y, ans, operation, min, max, incorrectAns, pos;
	String prompt;

	public Mathematics() {
		x = -1;
		y = -1;
		ans = -1;
		operation = -1;
		min = -1;
		max = -1;
		incorrectAns = -1;
		pos = -1;
		prompt = new String();
	}

	public Question generateQuestion() {
		ArrayList<String> choices = new ArrayList<String>();
		int temp = -1;

		operation = (int) (Math.random() * 4);
		if (operation == 0) {
			x = 2 + (int) (Math.random() * 99);
			y = 2 + (int) (Math.random() * 99);

			ans = x + y;
			prompt = "What is " + x + " + " + y + "?";
		} else if (operation == 1) {
			x = 2 + (int) (Math.random() * 99);
			y = 2 + (int) (Math.random() * 99);

			if (x < y) {
				temp = y;
				y = x;
				x = temp;
			}

			ans = x - y;
			prompt = "What is " + x + " - " + y + "?";
		} else if (operation == 2) {
			x = 2 + (int) (Math.random() * 14);
			y = 2 + (int) (Math.random() * 14);

			ans = x * y;
			prompt = "What is " + x + " * " + y + "?";
		} else {
			x = 2 + (int) (Math.random() * 14);
			ans = 2 + (int) (Math.random() * 14);

			y = x * ans;
			prompt = "What is " + y + " / " + x + "?";
		}

		min = (int) (.8 * ans);
		max = (int) (1.2 * ans);
		while (choices.size() < 3) {
			incorrectAns = min + (int) (Math.random() * max);
			if (!choices.contains(Integer.toString(incorrectAns))
					&& incorrectAns != ans) {
				choices.add(Integer.toString(incorrectAns));
			}
		}
		Random generator = new Random();
		int i = generator.nextInt(3);
		choices.add(i, Integer.toString(ans));
		Question q = new Question();
		q.setPrompt(prompt);
		q.setAnswers(choices);
		q.setCorrectAnswer(i);
		return q;
	}
}
