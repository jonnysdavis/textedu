package textedu;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class MessageHandler {
	private String phonenum = "";
	private String txtmsg = "";
	private String name = "NewUser";
	HashMap<String, User> userMap = new HashMap<String, User>();
	LeaderBoard highScores = new LeaderBoard();
	User currentUser = new User("0");
	String toReturn = "No Response";
	// Inbound = Texts from the user TO textedu
	// Outbound = Texts from textedu TO the user
	String lastInbound = "", lastOutbound = "", lastLastInbound = "",
			lastLastOutbound = "";
	QuizHandler qHand = new QuizHandler();

	public String getText(String phonenum, String txtmsg) {
		String origtxt = new String(txtmsg);
		txtmsg = txtmsg.toLowerCase();
		toReturn = "Whoops, that didn't make sense. Reply with a ? for help.";
		if (userMap.containsKey(phonenum)) {
			// Load useful info to Strings
			currentUser = userMap.get(phonenum);
			lastInbound = currentUser.getLastRecived();
			lastOutbound = currentUser.getLastSent();
			lastLastInbound = currentUser.getLastLastIndound();
			lastLastOutbound = currentUser.getLastLastOutbound();
			phonenum = currentUser.getNumber();
			name = currentUser.getName();
		}

		String intro = "Welcome to textedu, the SMS based quiz game. To get started, reply with your desired username. Make sure it's fewer than 15 characters.";
		if (newUser(phonenum)) {
			userMap.put(phonenum, new User(phonenum));
			toReturn = intro;
		} else if (currentUser.hasActiveQuiz) {
			Quiz current = currentUser.activeQuiz;
			toReturn = qHand.processQuiz(current, txtmsg);
			if (current.isFinished()) {
				currentUser.hasActiveQuiz = false;
				currentUser.addPoints(current.score);
				highScores.updateUsers(currentUser);
			}
		}
		// If the user has no name but exists, they must be responding with
		// their desired name
		else if (currentUser.getName().equalsIgnoreCase("NewUser")) {
			if (uniqueName(txtmsg) && txtmsg.length() < 16
					&& txtmsg.length() > 0) {
				currentUser.setName(origtxt);
				toReturn = "Hi "
						+ txtmsg
						+ "! Reply with ? for instructions. Reply with MATH or GEOGRAPHY for a quiz.";
			} else {
				if (!uniqueName(txtmsg))
					toReturn = (txtmsg + " is taken. Please choose another username. It should be 15 characters or fewer.");
				else {
					toReturn = "Whoops, that's too long for a username. Try again, and make sure your username is 15 characters or fewer";
				}
			}
		} else if (txtmsg.equalsIgnoreCase("?")
				|| txtmsg.equalsIgnoreCase("help")) {
			toReturn = "For a quiz, reply with MATH or GEOGRAPHY. To view your rank, reply with RANK.  To see the top scores, reply with TOP.";
		} else if (txtmsg.contains("challenge")) {
			String[] splited = txtmsg.split("\\s+");
			// The first word was challenge and the username has been used but
			// isnt himself
			if (splited[0].equalsIgnoreCase("challenge")
					&& !uniqueName(splited[1])
					&& (!splited[1].equalsIgnoreCase(currentUser.getName()))) {

			}
		} else if (txtmsg.contains("math")) {
			currentUser.activeQuiz = getQuiz("math");
			toReturn = currentUser.activeQuiz.questionList.get(0).toString();
		} else if (txtmsg.contains("geo")) {
			currentUser.activeQuiz = getQuiz("geo");
			toReturn = currentUser.activeQuiz.questionList.get(0).toString();
		}
		// NEED TO EXPAND: points msg always respond with all points
		else if (txtmsg.contains("point") || txtmsg.contains("level")
				|| txtmsg.contains("score") || txtmsg.contains("rank")) {
			toReturn = highScores.getRank(currentUser);
		}
		else if(txtmsg.contains("top")) {
			toReturn = highScores.getTopScores();
		}
		// Add sent and recieved texts to user arraylist
		currentUser.newInbound(txtmsg);
		currentUser.newOutbound(toReturn);
		return toReturn;

	}

	public Quiz getQuiz(String topic) {
		Quiz temp = new Quiz();
		if (topic.contains("math")) {
			currentUser.hasActiveQuiz = true;
			temp = qHand.createQuiz("math");
		} else if (topic.contains("geo")) {
			currentUser.hasActiveQuiz = true;
			temp = qHand.createQuiz("geo");
		}
		return temp;
	}

	private boolean newUser(String number) {
		if (userMap.containsKey(number)) {
			return false;
		}
		return true;
	}

	private boolean uniqueName(String name) {
		// Iterate through all users, check if the name is taken
		java.util.Iterator<Entry<String, User>> iterator = userMap.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Entry<String, User> temp = iterator.next();
			User current = temp.getValue();
			if (current.getName().equalsIgnoreCase(name)) {
				return false;
			}
		}
		return true;
	}

	public void insertUser(User toAdd) {
		userMap.put(toAdd.getNumber(), toAdd);
	}
}
