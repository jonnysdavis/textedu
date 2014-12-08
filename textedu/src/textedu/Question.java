package textedu;
import java.util.ArrayList;

public class Question{

	String prompt;
	int corrAnsIndex;
	ArrayList<String> answers;
	
	public Question(){
		prompt = new String();
		corrAnsIndex = -1;
		answers = new ArrayList<String>();
	}
	
	public void setPrompt(String prompt){
		this.prompt = prompt;
	}
	
	public int getCorrectAnswer(){
		return corrAnsIndex;
	}
	
	public void setCorrectAnswer(int corrAnsIndex){
		this.corrAnsIndex = corrAnsIndex;
	}
	
	public ArrayList<String> getAnswers(){
		return answers;		
	}
	
	public void setAnswers(ArrayList<String> answers){
		this.answers = answers;
	}
	
	public String toString(){
		String toReturn = prompt;
		toReturn += "\na. " + answers.get(0) + "\n";
		toReturn += "b. " + answers.get(1) + "\n";
		toReturn += "c. " + answers.get(2) + "\n";
		toReturn += "d. " + answers.get(3);
		return toReturn;		
	}
}
