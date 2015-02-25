package textedu;

public class QuizChallenge {
	Quiz q1;
	Quiz q2;
	String n1;
	String n2;
	
	public QuizChallenge(Quiz toQuiz, String p1, String p2) {
		q1 = toQuiz;
		q2 = toQuiz;
		n1 = p1;
		n2 = p2;
	}
	
	public Quiz getQuiz(String name) {
		if(name.equalsIgnoreCase(n1)) {
			return q1;
		}
		else if(name.equalsIgnoreCase(n2)) {
			return q2;
		}
		return null;
	}
}
