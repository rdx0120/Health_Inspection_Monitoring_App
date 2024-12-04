/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmail11;


import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author CHETAN
 */
public class SendEmail {
    static boolean  done = false;
    private static String femail = "";
    private static String pass = "";
    //===================================Without Attchment===========================================
    
    public static int SimpleSendEmail(String senderMail,String senderPass,String toemail, String Subject, String message) {
        femail = senderMail;
        pass = senderPass;
        String to = toemail;
        String subject = Subject;
        String messageText = message;

        boolean sessionDebug = false;
// Create some properties and get the default Session.
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "" + 587);
        props.setProperty("mail.smtp.starttls.enable", "true");

        Session session = createSmtpSession();
// Set debug on the Session so we can see what is going on
// Passing false will not echo debug info, and passing true
// will.        
        session.setDebug(sessionDebug);
        try {
// Instantiate a new MimeMessage and fill it with the
// required information.
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(femail));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);
            
            //  Send the complete message parts
            msg.setContent(messageText,"text/html");
// Hand the message to the default transport service
// for delivery.
            Transport.send(msg);
            done = true;
            System.out.println("Mail Send successfully");
            return 1;
            
        } catch (MessagingException mex) {
            done = false;
            System.out.println("Mail Dose Not Send.....");
            return 0;
        }
    }

    //=============================* FOR ATTACHMENT *==============================================
    
     public static int SimpleSendEmail(String sender, String senderPassword, String toemail, String Subject, String message, String Attachment) {
        femail = sender;
        pass = senderPassword;
        String to = toemail;
        String subject = Subject;
        String messageText = message;
        boolean sessionDebug = false;

        Session session = createSmtpSession();
// Set debug on the Session so we can see what is going on
// Passing false will not echo debug info, and passing true will.        
        session.setDebug(sessionDebug);
        try {
// Instantiate a new MimeMessage and fill it with the required information.
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(femail));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
// Hand the message to the default transport service for delivery.
            MimeBodyPart messagePart = new MimeBodyPart();
            messagePart.setText(messageText);
            //
            // Set the email attachment file
            //
//            MimeBodyPart attachmentPart = new MimeBodyPart();
//            FileDataSource fileDataSource = new FileDataSource(Attachment) {
//                @Override
//                public String getContentType() {
//                    return "application/octet-stream";
//                }
//            };
//            attachmentPart.setDataHandler(new DataHandler(fileDataSource));
//            attachmentPart.setFileName(fileDataSource.getName());

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messagePart);
//            multipart.addBodyPart(attachmentPart);
            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("Email Send Successfully.!!!");
            done = true;
            return 1;
        } catch (MessagingException mex) {
            System.out.println("Email does not Send.!!!");
            done = false;
            return 0;
        }
    }
    
//===============================================================================================    

    public static Session createSmtpSession() {
        final Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "" + 587);
        props.setProperty("mail.smtp.starttls.enable", "true");

        return Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(femail, pass);
            }
        });
    }
   
    
    public static void main(String args[])
    {
        String path= "C:\\Users\\CHETAN\\Desktop\\as.png";
        int i = SendEmail.SimpleSendEmail("vitmumbai17@gmail.com","project17","ningesh1406@gmail.com", "hi", "i am auto hgjgj","");
    }
}
