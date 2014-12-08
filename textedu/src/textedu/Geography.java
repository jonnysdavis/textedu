package textedu;
import java.util.ArrayList;

public class Geography extends Subject{
	
	ArrayList<String> choices;
	
	public Question generateQuestion(){
		ArrayList<String> choices =  new ArrayList<String>();
		Question q = new Question();
		q.setPrompt("What is the capital of the United States?");
		choices.add("Washington D.C.");
		choices.add("Paris");
		choices.add("London");
		choices.add("Beijing");
		q.setAnswers(choices);
		q.setCorrectAnswer(0);
		return q;
	}	
	
}
