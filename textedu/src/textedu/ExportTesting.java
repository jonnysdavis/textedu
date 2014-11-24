package textedu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class ExportTesting {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		MessageHandler input = new MessageHandler();
		input.getText("1", "hello");
		input.getText("1", "Jonny");
		input.userMap.get("1").addPoints(1, 5);
		saveUser(input.userMap.get("1"));
		//Print map
		System.out.println("Before clearing: " + input.userMap);
		input.userMap.clear();
		System.out.println("After clearing: " + input.userMap);
		//Insert user back in
		input.insertUser(getUserFromFile("1"));
		System.out.println("After re-adding: " + input.userMap);
		
	}
	public static void saveUser(User toSave) throws IOException {
		String filename = toSave.getNumber();
		FileOutputStream fout = new FileOutputStream("UserExports/" + filename);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(toSave);
	}
	public static User getUserFromFile(String number) throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream("UserExports/" + number);
		ObjectInputStream ois = new ObjectInputStream(fin);
		return (User) ois.readObject();
	}

}
