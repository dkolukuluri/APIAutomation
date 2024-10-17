package api.utilities;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
 
public class EmailSender {
 
    public void sendEmailWithReport() {
        // Email configuration
    	String from = "dkolukuluri@bmg360.com";
        String to = "dkolukuluri@bmg360.com";
        String host = "smtp.gmail.com"; // Your SMTP host (e.g., smtp.gmail.com for Gmail)
        //String username = "durgasatishkolukuluri@outlook.com"; // SMTP Username
        String password = "qzsaiqqiwvhjjoci"; // SMTP Password
        // Set properties for the email session
        Properties properties = System.getProperties();
        		// properties props = new Properties();
        properties.put("mail.smtp.auth", "true");  
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587"); // or "465" for SSL
        properties.put("mail.smtp.starttls.enable", "true");
        
        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        
        session.setDebug(true);
 
        try {
            // Compose the email
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Allure Report: Test Execution Results");
 
            // Create a multipart message for email body and attachment
            Multipart multipart = new MimeMultipart();
 
            // Add HTML report content in the email body
            MimeBodyPart htmlPart = new MimeBodyPart();
            String reportHtml = new String(Files.readAllBytes(Paths.get("allure-report/index.html")));
            htmlPart.setContent(reportHtml, "text/html");
            multipart.addBodyPart(htmlPart);
 
            // Optionally, attach the report folder or specific files (like screenshots)
/*            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filePath = "allure-report.zip";  // Path to your zipped Allure report or a specific file
            attachmentPart.attachFile(new File(filePath));
            multipart.addBodyPart(attachmentPart);*/
 
            // Add multipart content to the message
            message.setContent(multipart);
 
            // Send the message
            Transport.send(message);
 
            System.out.println("Email sent successfully with Allure report!");
 
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }
}