//For more info see: http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
//You need activation.jar, smtp.jar, and mailapi.jar in your classpath for this to work.
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
public class SendMail {
public static void main(String[] args) throws MessagingException {
new SendMail().run();
}
private void run() throws MessagingException {
Message message = new MimeMessage(getSession());
message.addRecipient(RecipientType.TO, new InternetAddress("rakesh09uf@gmail.com"));
message.addFrom(new InternetAddress[] { new InternetAddress("rbrakesh4@gmail.com") });
message.setSubject("the subject");
message.setContent("the body", "text/plain");
Transport.send(message);
}
private Session getSession() {
Authenticator authenticator = new Authenticator();
Properties properties = new Properties();
properties.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
properties.setProperty("mail.smtp.auth", "true");
properties.setProperty("mail.smtp.host", "smtp.gmail.com");
properties.setProperty("mail.smtp.port", "25");
return Session.getInstance(properties, authenticator);
}
private class Authenticator extends javax.mail.Authenticator {
private PasswordAuthentication authentication;
public Authenticator() {
String username = "rbrakesh4@gmail.com";
String password = "";
authentication = new PasswordAuthentication(username, password);
}
protected PasswordAuthentication getPasswordAuthentication() {
return authentication;
}
}
}