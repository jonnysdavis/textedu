package textedu;

import java.util.ArrayList;

public class LeaderBoard {
	
	ArrayList<User> mostPoints = new ArrayList<User>(); //Category 0
	ArrayList<User> mostPointsMath = new ArrayList<User>();
	
	public void processScore(User currentUser, int category, int pointCount) {
		ArrayList<User> categoryInUse = null;
		if(category == 0) {
			categoryInUse = mostPoints;
		}
		else if(category == 1) {
			categoryInUse = mostPointsMath;
		}
		//Only erase leaders when the board has more than 5 people
		if(categoryInUse.size() < 5) {
			categoryInUse.add(currentUser);
		}
		else {
			//If the score is bigger than the smallest high score, the smallest gets replaced
			if(categoryInUse.get(categoryInUse.size()).getPoints(category) < pointCount){
				categoryInUse.set(categoryInUse.size(), currentUser);
				categoryInUse = sortByScore(categoryInUse, category);
			}
		}
	}

	private ArrayList<User> sortByScore(ArrayList<User> categoryInUse, int category) {
		//Bubble sort on the arraylist of scores
		for(int x = 0; x<categoryInUse.size(); x++) {
			for(int y = 1; y<categoryInUse.size()-1; y++) {
				if(categoryInUse.get(y-1).getPoints(category) > categoryInUse.get(y).getPoints(category)){
				User temp = categoryInUse.get(y-1);
				categoryInUse.set(y-1, categoryInUse.get(y));
				categoryInUse.set(y, temp);
			}
		}
	}
	return categoryInUse;
}
}