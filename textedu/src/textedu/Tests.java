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
}