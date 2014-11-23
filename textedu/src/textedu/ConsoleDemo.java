//This class simulates the program through console based input
//When run, you are prompted for the phone number then the text message
//The live version will use Twilio instead of console input

package textedu;

import java.util.Scanner;

public class ConsoleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageHandler demo = new MessageHandler();
		Scanner in = new Scanner(System.in);
		String phonenum = "", txtmsg = "";
		while (!txtmsg.equalsIgnoreCase("-1")) {
			System.out.print("--------------------\n#: ");
			phonenum = in.nextLine();
			System.out.print("Message: ");
			txtmsg = in.nextLine();
			System.out.println();
			if (txtmsg.equalsIgnoreCase("printmap")) {
				System.out.println(demo.userMap);
			} else {
				System.out.println(demo.getText(phonenum, txtmsg));
			}
		}
	}
}
