package textedu;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;


public class MessageHandler {
	static String phonenum;
	static String txtmsg = "";
	static HashMap<String, User> userMap = new HashMap<String, User>();
	
	public String getText(String phonenum, String txtmsg) {
		String txtMsgLowercase = txtmsg.toLowerCase();
		User currentUser = new User("1");
		String toReturn = "No Response";
		if(userMap.containsKey(phonenum)) {
			currentUser = userMap.get(phonenum);
		}
		if(newUser(phonenum)){
			userMap.put(phonenum, new User(phonenum));
			toReturn = "Intro. Pick a username";
		}
		//If the user has no name but exists, they must be responding with their desired name
		else if(currentUser.getName().equalsIgnoreCase("NewUser")) {
			if(uniqueName(txtmsg)) {
				currentUser.setName(txtmsg);
				toReturn = (txtmsg + ", welcome to textedu. Instructions.");
			}
			else {
				toReturn = (txtmsg + " is taken. Please choose another username.");
			}
		}
		else if(txtmsg.equalsIgnoreCase("?") || txtmsg.equalsIgnoreCase("help")) {
			toReturn = (getHelp());
		}
		//NEED TO EXPAND: points msg always respond with all points
		else if(txtMsgLowercase.contains("points")) {
			toReturn =  currentUser.getPoints().toString();
		}
		//Add sent and recieved texts to user arraylist
		currentUser.newInbound(txtmsg);
		currentUser.newOutbound(toReturn);
		return toReturn;
		}

	private static boolean newUser(String number) {
		if (userMap.containsKey(number)) {
			return false;
		}
		return true;
	}
	private static String getHelp() {
		return "Instructions.";
	}
	
	private static boolean uniqueName(String name) {
		//Iterate through all users, check if the name is taken
		java.util.Iterator<Entry<String, User>> iterator = userMap.entrySet().iterator() ;
        while(iterator.hasNext()){
           Entry<String, User> temp = iterator.next();
           User current = temp.getValue();
           if(current.getName().equalsIgnoreCase(name)) {
        	  return false;
           }
        }
        return true;
	}
}
