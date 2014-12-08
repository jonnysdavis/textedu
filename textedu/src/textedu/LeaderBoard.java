package textedu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class LeaderBoard {
	List<User> topScores = new ArrayList<User>();

	public LeaderBoard(HashMap<String, User> userMap) {
		// Creates the leaderboard from a userMap
		java.util.Iterator<Entry<String, User>> iterator = userMap.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Entry<String, User> temp = iterator.next();
			User current = temp.getValue();
			int userPoints = current.getPoints();
			for (int x = 0; x < topScores.size(); x++) {
				if (userPoints > topScores.get(x).getPoints()) {
					topScores.add(current);
					topScores = sortByScore(topScores);
				}
			}
		}

	}
	
	public LeaderBoard() {
		// TODO Auto-generated constructor stub
	}
	
	private boolean addScore(User toAdd) { //NOT COMPLETE
		if(topScores.size() < 5 && (!topScores.contains(toAdd))) {
			topScores.add(toAdd);
			return true;
		}
		return false;
	}
	private List<User> sortByScore(List<User> topScores2) {
		// Bubble sort on the arraylist of scores
		for (int x = 0; x < topScores2.size(); x++) {
			for (int y = 1; y < topScores2.size() - 1; y++) {
				if (topScores2.get(y - 1).getPoints() > topScores2.get(y)
						.getPoints()) {
					User temp = topScores2.get(y - 1);
					topScores2.set(y - 1, topScores2.get(y));
					topScores2.set(y, temp);
				}
			}
		}
		if (topScores2.size() > 5)
			topScores2 = topScores2.subList(0, 5);
		return topScores2;
	}
	
	public String toString() {
		String board = "";
		int y = 1;
		for(User x : topScores) {
			board+=y + ". " + x.getName() + ": " + x.getPoints() + "\n";
			y++;
		}
		return board;
	}
}