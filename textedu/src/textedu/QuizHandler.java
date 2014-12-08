package textedu;

public class QuizHandler {
	Geography geo = new Geography();
	Mathematics m = new Mathematics();

	public String processQuiz(Quiz q, String txtmsg) {
		int answer = parseTextToAnswer(txtmsg);
		int correct = q.questionList.get(q.currQuestion).getCorrectAnswer();
		if (answer == correct) {
			q.update(true);
		} else {
			q.update(false);
		}
		return getNext(q);
	}

	public Quiz createQuiz(String subject) {
		Quiz temp = new Quiz();
		if (subject.contains("math")) {
			temp.addQuestion(m.generateQuestion());
			temp.addQuestion(m.generateQuestion());
			temp.addQuestion(m.generateQuestion());
			temp.addQuestion(m.generateQuestion());
		} else if (subject.contains("geo")) {
			temp.addQuestion(geo.generateQuestion());
			temp.addQuestion(geo.generateQuestion());
			temp.addQuestion(geo.generateQuestion());
			temp.addQuestion(geo.generateQuestion());
		}
		return temp;
	}

	public String getNext(Quiz q) {
		if (q.isFinished()) {
			return q.toString();
		} else {
			return q.questionList.get(q.currQuestion).toString();
		}
	}

	public int parseTextToAnswer(String txtmsg) {
		// Looks for the first instance of a char a b c or d
		for (int x = 0; x < txtmsg.length(); x++) {
			char current = txtmsg.charAt(x);
			if (current == 'a' || current == 'A') {
				x = txtmsg.length() + 1;
				return 0;
			} else if (current == 'b' || current == 'B') {
				x = txtmsg.length() + 1;
				return 1;
			} else if (current == 'c' || current == 'C') {
				x = txtmsg.length() + 1;
				return 2;
			} else if (current == 'd' || current == 'D') {
				x = txtmsg.length() + 1;
				return 3;
			}
		}
		// Only returns e if there response has no valid answers in it
		return 5;
	}
}
