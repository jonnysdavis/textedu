package textedu;

import java.util.ArrayList;

public class User implements java.io.Serializable{
	
	private String number;
	private String name;
	private boolean hasName = false;
	private ArrayList<String> inbound = new ArrayList<String>();
	private ArrayList<String> outbound = new ArrayList<String>();
	boolean changedSinceLastSave = true;
	//Holds users points, each spot being a different category.
	//Points awarded based on how you score on a quiz
	//The 0th index is their total points
	private ArrayList<Integer> points = new ArrayList<Integer>();
	//private currentQuiz = new Quiz
	public User(String num) {
		number = num;
		name = "NewUser";
		points.add(0);
		points.add(0);
		points.add(0);
		points.add(0);
		points.add(0);
	}
	public String toString() {
		return number + "," + name + "," + hasName + "," + inbound + "," + outbound + "," + points;
	}
	
	
	//Point related methods
	public void addPoints(Integer category, Integer toAdd) {
		//Add to rolling total of all points, then update category
		points.set(0, (toAdd + points.get(0)));
		points.set(category, (toAdd + points.get(category)));
	}

	public int getPoints(Integer category) {
		return points.get(category);
	}
	// Currently holds all messages, will be a memory issue at scale!
	public void newInbound(String msg) {
		inbound.add(msg);
	}

	public void newOutbound(String msg) {
		outbound.add(msg);
	}
	//Get the most recent sent and recieved messages
	public String getLastSent() {
		return outbound.get(outbound.size());
	}

	public String getLastRecived() {
		return inbound.get(inbound.size());
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
	public int getPoints(int x) {
		if(x>points.size()) {
			return 0;
		}
		return points.get(x);
	}
}
