package textedu;

import java.util.ArrayList;

public class User {
	private String number;
	private String name;
	private boolean hasName = false;
	private ArrayList<String> inbound = new ArrayList<String>();
	private ArrayList<String> outbound = new ArrayList<String>();
	
	//Holds users points, each spot being a different category.
	//Points awarded based on how you score on a quiz
	private ArrayList<Integer> points = new ArrayList<Integer>();
	//private currentQuiz = new Quiz
	public User(String number) {
		number = number;
		name = "NewUser";
	}
	
	
	
	// Point related methods
	public void addPoints(Integer category, Integer toAdd) {
		points.set(category, (toAdd + points.get(category)));
	}

	public int getPoints(Integer category) {
		return points.get(category);
	}
	// Set and Get Methods
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
	public ArrayList getPoints() {
		return points;
	}
	public int getLevel(int x) {
		if(x>points.size()) {
			return 0;
		}
		return points.get(x);
	}
}
