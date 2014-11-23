package textedu;

import java.util.HashMap;

public class ExportTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageHandler input = new MessageHandler();
		input.getText("1", "hello");
		input.getText("1", "Jonny");
		input.userMap.get("1").addPoints(1, 5);
		System.out.println(input.userMap);
		
	}

}
