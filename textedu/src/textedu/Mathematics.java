package textedu;
import java.util.ArrayList;

public class Mathematics extends Subject {

	int x, y, ans, operation;
	String prompt;

	public Mathematics() {
		x = -1;
		y = -1;
		ans = -1;
		operation = -1;
	}

	public Question generateQuestion(){
		ArrayList<String> choices = new ArrayList<String>();
		int temp = -1;
		
		operation = (int)(Math.random() * 4);
		if(operation == 0){
			x = 2 + (int)(Math.random() * 99);
			y = 2 + (int)(Math.random() * 99);
			
			ans = x + y;
			prompt = "What is " + x + " + " + y + "?";
		}
		else if(operation == 1){
			x = 2 + (int)(Math.random() * 99);
			y = 2 + (int)(Math.random() * 99);
			
			if(x < y){
				temp = y;
				y = x;
				x = temp;
			}
			
			ans = x - y;			
			prompt = "What is " + x + " - " + y + "?";
		}
		else if(operation == 2){
			x = 2 + (int)(Math.random() * 14);
			y = 2 + (int)(Math.random() * 14);
			
			ans = x * y;
			prompt = "What is " + x + " * " + y + "?"; 
		}else{
			x = 2 + (int)(Math.random() * 14);
			ans = 2 + (int)(Math.random() * 14);
			
			y = x * ans;
			prompt = "What is " + y + " / " + x + "?";
		}
		
		
		
		Question q = new Question();
		q.setPrompt("What is 2 + 2?");
		choices.add("2");
		choices.add("3");
		choices.add("4");
		choices.add("5");
		q.setAnswers(choices);
		q.setCorrectAnswer(2);
		return q;
	}
}
