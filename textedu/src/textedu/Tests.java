package textedu;

import java.io.IOException;

import org.junit.* ;

import static org.junit.Assert.* ;

public class Tests {
	@Test
	public void testDuplicateUser() {
		MessageHandler demo = basicUserBase();
		demo.getText("3", "jonny");
		demo.getText("3", "jonny");
		assertTrue(demo.userMap.get("3").getName().equalsIgnoreCase("NewUser"));
	}
	@Test
	public void testSaveUser() throws IOException, ClassNotFoundException {
		MessageHandler demo = basicUserBase();
		ExternalUserManager manager = new ExternalUserManager();
		demo.getText("test", "test");
		demo.getText("test", "test");
		User temp = demo.userMap.get("test");
		String correct = temp.toString();
		manager.saveUser(temp);
		demo.userMap.remove("test");
		assertFalse(demo.userMap.containsKey("test"));
		assertFalse(demo.userMap.containsValue(temp));
		manager.saveUser(temp);
		User getUser = manager.getUserFromFile("test");
		assertTrue(getUser.toString().equalsIgnoreCase(correct));
		demo.insertUser(getUser);
		assertTrue(demo.userMap.containsKey("test"));
	}
	
	public MessageHandler basicUserBase() {
		MessageHandler demo = new MessageHandler();
		demo.getText("1", "jonny");
		demo.getText("1", "jonny");
		demo.getText("2", "sarah");
		demo.getText("2", "sarah");
		return demo;
	}
	public MessageHandler basicUserBaseWithScores() {
		MessageHandler demo = new MessageHandler();
		demo.getText("1", "jonny");
		demo.getText("1", "jonny");
		demo.getText("2", "sarah");
		demo.getText("2", "sarah");
		demo.getText("3", "jake");
		demo.getText("3", "jake");
		demo.getText("4", "nate");
		demo.getText("4", "nate");
		demo.getText("5", "fred");
		demo.getText("5", "fred");
		demo.getText("6", "alex");
		demo.getText("6", "alex");
		//do 100 quizzes for each user
		int count = 0;
		while (count<5) {
			for(int x = 0; x<100; x++) {
				demo.getText(Integer.toString(count), "math");
				for(int y = 0; y<4; y++) {
					demo.getText(Integer.toString(count), "a");
				}
				
			}
			count++;
		}
		return demo;
	}
	
}