package api.utilities;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {
    public static void sendEmail(String user, String password, String toAddress, String subject, String body) {
        Properties properties = new Properties();
		/*
		 * properties.put("mail.smtp.host", host); 
		 * properties.put("mail.smtp.port", port); 
		 * properties.put("mail.smtp.auth", "true");
		 * properties.put("mail.smtp.starttls.enable", "true");
		 */
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };

        Session session = Session.getInstance(properties, auth);
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject(subject);
            
            // Set HTML message content
            System.out.println("Final HTML in Email: "+body);
            message.setContent(body, "text/html");

            Transport.send(message);
            message.setSubject("Test Email");
            message.setText("This is a test email sent from Java.");
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

