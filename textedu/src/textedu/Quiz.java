package textedu;
import java.util.ArrayList;

public class Quiz {
	static final int numQuestions = 4;
	
	int score=0;
	ArrayList<Question> questionList;
	int currQuestion = 0;
	boolean finished;
	
	public Quiz(){
		score = 0;
		currQuestion = 0;
		finished = false;
		questionList = new ArrayList<Question>();
	}
	
	public void addQuestion(Question q){
		questionList.add(q);
	}
	
	public boolean isFinished(){
		return finished;
	}
	
	public void update(boolean result){
		currQuestion += 1;
		if(currQuestion == numQuestions)
			finished = true;
		
		if(result)
			score++; //have not implemented bonus
		else{
			//TODO if wrong
		}
		
		
	}
	
	public String toString(){
		return "You received " + score + " points.";
	}
}
