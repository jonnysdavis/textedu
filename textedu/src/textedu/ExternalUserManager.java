package textedu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

public class ExternalUserManager {
	static FileOutputStream fout;
	static ObjectOutputStream oos;
	static FileInputStream fin;
	static ObjectInputStream ois;
	
	public static void saveUser(User toSave) throws IOException {
		String filename = toSave.getNumber();
		fout = new FileOutputStream("UserExports/" + filename);
		oos = new ObjectOutputStream(fout);
		oos.writeObject(toSave);
		fout.close();
	}
	public static void saveAllUsers(HashMap<String, User> toSave) throws IOException {
		//Iterate through all users, check if the name is taken
		java.util.Iterator<Entry<String, User>> iterator = toSave.entrySet().iterator() ;
		while(iterator.hasNext()){
			Entry<String, User> temp = iterator.next();
			saveUser((User) temp);
		}
	}
	public static User getUserFromFile(String number) throws IOException, ClassNotFoundException {
		fin = new FileInputStream("UserExports/" + number);
		ois = new ObjectInputStream(fin);
		return (User) ois.readObject();
	}
	public HashMap<String, User> getAllUsers() throws ClassNotFoundException, IOException {
		HashMap<String, User> toReturn = null;
		File dir = new File("UserExports");
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File child : directoryListing) {
		      User temp = getUserFromFile(child.getName());
		      toReturn.put(temp.getNumber(), temp);
		    }
	}
		  return toReturn;
	}
}

