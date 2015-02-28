package textedu;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
import java.util.ArrayList;
import java.util.List;
 
public class TwilioTesting {
 
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "123";
  public static final String AUTH_TOKEN = "123";
 
  public static void main(String[] args) throws TwilioRestException {
    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
 
    // Build a filter for the MessageList
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("Body", "Twilio says hi"));
    params.add(new BasicNameValuePair("To", "+12404212522"));
    params.add(new BasicNameValuePair("From", "+12408550496"));
 
    MessageFactory messageFactory = client.getAccount().getMessageFactory();
    Message message = messageFactory.create(params);
    System.out.println("Message SID:" + message.getSid());
  }
  
}
