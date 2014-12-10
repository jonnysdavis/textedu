package textedu;

import java.util.ArrayList;

public class Geography extends Subject{
	
	int typeOfQuestion, loc, incorrectLoc, pos;
	String prompt, ans, incorrectAns;

	String[] countries = {"United States of America", "United Kingdom", "China", "France", "Russia", "Japan", "Belgium", "Switzerland", "Argentina", "Brazil", "India", "Pakistan", "South Korea", "Chile", "Mexico", "Iran", "Austria", "Spain", "Germany", "Italy", "Ghana", "Egypt", "Kenya", "Ethiopia", "Indonesia", "Malaysia", "Australia", "New Zealand", "Canada", "Kazakhstan", "Hungary", "Sweden", "Denmark", "Nigeria", "Norway", "Portugal", "Morocco", "Syria", "Senegal", "Tanzania"};
	String[] capitals = {"Washington D.C.", "London", "Beijing", "Paris", "Moscow", "Tokyo", "Brussels", "Bern", "Buenos Aires", "Brasilia", "New Delhi", "Islamabad", "Seoul", "Santiago", "Mexico City", "Tehran", "Vienna", "Madrid", "Berlin", "Rome", "Accra", "Cairo", "Nairobi", "Addis Ababa", "Jakarta", "Kuala Lumpur", "Canberra", "Wellington", "Ottawa", "Astana", "Budapest", "Stockholm", "Copenhagen", "Lagos", "Oslo", "Lisbon", "Rabat", "Damascus", "Dakar", "Dodoma"};

	public Geography() {
		typeOfQuestion = -1;
		loc = -1;
		incorrectLoc = -1;
		pos = -1;
		prompt = new String();
	}

	public Question generateQuestion(){
		ArrayList<String> choices = new ArrayList<String>();
		loc = (int)(Math.random() * 40);
		
		typeOfQuestion = (int)(Math.random() * 2);
		if(typeOfQuestion == 0){
			prompt = capitals[loc] + " is the capital of what country?";
			ans = countries[loc];
			
			while(choices.size() < 3){
				incorrectLoc = (int)(Math.random() * 40);
				if(incorrectLoc != loc && !choices.contains(countries[incorrectLoc])){
					choices.add(countries[incorrectLoc]);
				}
			}
		}
		else{
			prompt = "What is the capital of " + countries[loc] + "?";
			ans = capitals[loc];
			
			while(choices.size() < 3){
				incorrectLoc = (int)(Math.random() * 40);
				if(incorrectLoc != loc && !choices.contains(capitals[incorrectLoc])){
					choices.add(capitals[incorrectLoc]);
				}
			}
		}

		pos = (int)(Math.random() * 4);	
		choices.add(pos, ans);	
		
		Question q = new Question();
		q.setPrompt(prompt);
		q.setAnswers(choices);
		q.setCorrectAnswer(pos);
		return q;
	}	
}
