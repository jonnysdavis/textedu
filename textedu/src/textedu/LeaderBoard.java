package textedu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class LeaderBoard {
	
	ArrayList<SimpleUser> userScores = new ArrayList<SimpleUser>();
	
	public LeaderBoard() {
		
	}
	
	private void addUser(User u) {
		userScores.add(new SimpleUser(u));
		Collections.sort((List<SimpleUser>) userScores);
	}
	
	public void updateUsers(User u) {
		SimpleUser su = new SimpleUser(u);
		if (!userScores.contains(su)) {
			addUser(u);
		} else {
			userScores.remove(su);
			userScores.add(su);
		}
		Collections.sort((List<SimpleUser>) userScores);
	} 
	
	public String getRank(User u) {
		String toReturn = "";
		for (int i = 0; i < userScores.size(); i++) {
			if (userScores.get(i).equals(u)) {
				int rank = i + 1;
				int rankPrev = i;
				
				if (rankPrev == 0) {
					toReturn += "Rank: " + rankPrev + " " + userScores.get(i-1).getName() + " " + userScores.get(i-1).getScore() + "\n";
				}
				toReturn += "Rank: " + rank + " " + userScores.get(i).getName() + " " + userScores.get(i).getScore();
			}
		}
		
		return toReturn;
	}
	
	public int getNumUsersInLeaderboard() {
		return userScores.size();
	}
	
	
	public String getTopScores() {
		String top = "";
		int sizeTo = 5;
		if (userScores.size() < sizeTo) {
			sizeTo = userScores.size();
		}
		top += "Top sizeTo Scores:\n";
		for (int i = 1; i <= sizeTo; i++) {
			top += userScores.get(i-1).getName() + " " + userScores.get(i-1).getScore() + "\n";
		}
		
		return top;
	}
	
	
	private class SimpleUser implements Comparable {
		private String name;
		private int score;
		
		public SimpleUser(User u) {
			name = u.getName();
			score = u.getPoints();
		}
		
		public String getName() {
			return name;
		}
		
		public int getScore() {
			return score;
		}
		
		public boolean equals(User u) {
			if (name.equalsIgnoreCase(u.getName())) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean equals(SimpleUser u) {
			if (name.equalsIgnoreCase(u.getName())) {
				return true;
			} else {
				return false;
			}
		}

		public int compareTo(Object o) {
			SimpleUser other = (SimpleUser) o;
			return ((Integer) other.getScore()).compareTo((Integer) score);
		}
	}
	
	
}