package textedu;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;


public class messageHandler {

	private static Scanner scanInput;
	static String phonenum;
	static String msg = "";
	static HashMap<String, user> userMap = new HashMap<String, user>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanInput = new Scanner(System.in);
		
		while(!msg.equalsIgnoreCase("-1")) {
		System.out.print("#: ");
		phonenum = scanInput.nextLine();
		System.out.print("Message: ");
		msg = scanInput.nextLine();
		
		if(newUser(phonenum)){
			userMap.put(phonenum, new user(phonenum));
			System.out.println("Intro. Pick a username");
			continue;
		}
		
		//If the user has no name but exists, they must be responding with their desired name
		else if(userMap.get(phonenum).getName().equalsIgnoreCase("NewUser")) {
			if(uniqueName(msg)) {
				userMap.get(phonenum).setName(msg);
				System.out.println(msg + ", welcome to textedu");
			}
			else {
				System.out.println(msg + " is taken. Please choose another username.");
			}
			continue;
		}
		}
		
	}

	private static boolean newUser(String number) {
		if (userMap.containsKey(number)) {
			return false;
		}
		return true;
	}
	
	private static boolean uniqueName(String name) {
		//Iterate through all users, check if the name is taken
		java.util.Iterator<Entry<String, user>> iterator = userMap.entrySet().iterator() ;
        while(iterator.hasNext()){
           Entry<String, user> temp = iterator.next();
           user current = temp.getValue();
           if(current.getName().equalsIgnoreCase(name)) {
        	  return false;
           }
        }
        return true;
	}
}
