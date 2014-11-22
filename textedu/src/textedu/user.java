package textedu;

import java.util.ArrayList;

public class user {
	private String number;
	private String name;
	private boolean hasName = false;
	//Holds users points, each spot being a different category.
	//Points awarded based on how you score on a quiz
	private ArrayList<Integer> points = new ArrayList<Integer>();
	//private currentQuiz = new Quiz
	public user(String i, String newname) {
		number = i;
		name = newname;
	}
	public user(String i) {
		number = i;
		name = "NewUser";
	}
	
	
	
	
	
	
	
	
	//Set and Get Methods
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList getLevel() {
		return points;
	}
	public int getLevel(int x) {
		if(x>points.size()) {
			return 0;
		}
		return points.get(x);
	}
	public void levelUp(int x){
		points.set(x, points.get(x)+1);
	}
}
