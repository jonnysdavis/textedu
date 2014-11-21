package maps;

import java.util.ArrayList;

public class user {
	private int number;
	private String name;
	//Holds users points, each spot being a different category.
	//Points awarded based on how you score on a quiz
	private ArrayList<Integer> points = new ArrayList<Integer>();
	private currentQuiz = new Quiz();
	private int setupStep;
	public user(int i, String newname) {
		number = 1;
		name = newname;
	}
	
	
	
	
	//Set and Get Methods
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
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
