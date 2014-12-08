package textedu;

import java.util.ArrayList;

public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String number;
	private String name;
	private boolean hasName = false;
	public ArrayList<String> inbound = new ArrayList<String>();
	public ArrayList<String> outbound = new ArrayList<String>();
	boolean changedSinceLastSave = true;
	private String lastSave = "none";
	private int points = 0;
	private int level = 0;
	public boolean hasHighScore;
	public boolean hasActiveQuiz;
	public Quiz activeQuiz;
	
	// private currentQuiz = new Quiz
	public User(String num) {
		number = num;
		name = "NewUser";
	}

	public String toString() {
		return number + "," + name + "," + hasName + "," + inbound + ","
				+ outbound + "," + points;
	}

	// Point related methods
	public void addPoints(int toAdd) {
		points+=toAdd;
	}

	public int getPoints() {
		return points;
	}

	// Currently holds all messages, will be a memory issue at scale!
	public void newInbound(String msg) {
		inbound.add(msg);
		if (inbound.size() > 5) {
			inbound.remove(0);
		}
	}

	public void newOutbound(String msg) {
		outbound.add(msg);
		if (outbound.size() > 5) {
			outbound.remove(0);
		}
	}

	// Get the most recent sent and recieved messages
	public String getLastSent() {
		if(outbound.size() >= 1) {
		return outbound.get(outbound.size() - 1);
		}
		return "none";
	}

	public String getLastRecived() {
		if(inbound.size() >= 1) {
		return inbound.get(inbound.size()-1);
		}
		return "none";
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
	public String getLastSave() {
		return lastSave;
	}

	public void setLastSave(String temp) {
		lastSave = temp;
	}

	public String getLastLastIndound() {
		if(inbound.size() >= 2) {
			return inbound.get(inbound.size() - 2);
		}else {
			return "none";
		}
	}
	public String getLastLastOutbound() {
		if(inbound.size() >= 2) {
			return outbound.get(outbound.size() - 2);
		}else {
			return "none";
		}
	}

	public int getLevel() {
		return level;
	}

}
