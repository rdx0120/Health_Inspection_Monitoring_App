package sendmail11;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SimpleSendEmail {

//    private static String femail = "vitmumbai17@gmail.com";
        private static String femail = "";
//    private static String pass = "project17";
        private static String pass = "";
    boolean done = false;
    
    public static void main(String args[]){
    //	sendEmailThread sendEmail = new sendEmailThread("manjunathwagadari26@gmail.com", "hi", "i am");
        String path= "C:\\Users\\CHETAN\\Desktop\\as.png";
        sendEmailThread sendEmail = new sendEmailThread("vitmumbai17@gmail.com","project17","manjunathwagadai26@gmail.com", "hi", "i am auto",path);
        
        Thread t = new Thread(sendEmail);
        t.start();
    }

    
    //=================================================================================
    public SimpleSendEmail(String toemail, String Subject, String message) {
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
        } catch (MessagingException mex) {
            done = false;
            System.out.println("Mail Dose Not Send.....");
        }
    }

    
    //================================================================================================
    
    public SimpleSendEmail(String senderMail,String senderPass,String toemail, String Subject, String message) {
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
        } catch (MessagingException mex) {
            done = false;
            System.out.println("Mail Dose Not Send.....");
        }
    }

    
    
    
    //=============================* FOR ATTACHMENT *==============================================
    public SimpleSendEmail(String toemail, String Subject, String message, String Attachment) {
        String to = toemail;
        String subject = Subject;
        String messageText = message;
        boolean sessionDebug = false;

        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "" + 587);
        props.setProperty("mail.smtp.starttls.enable", "true");

        Session session = createSmtpSession();
        session.setDebug(sessionDebug);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(femail));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
// Hand the message to the default transport service
// for delivery.
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
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messagePart);
//            multipart.addBodyPart(attachmentPart);
            System.out.println("Mail Send successfully");
            msg.setContent(Attachment, "text/html");

            Transport.send(msg);
            done = true;
        } catch (MessagingException mex) {
            done = false;
            System.out.println("Mail Dose Not Send.....");
        }
    }

//=============================* FOR ATTACHMENT *==============================================
    
    public SimpleSendEmail(String sender, String senderPassword, String toemail, String Subject, String message, String Attachment) {
        femail = sender;
        pass = senderPassword;
        String to = toemail;
        String subject = Subject;
        String messageText = message;
        boolean sessionDebug = false;

        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "" + 587);
        props.setProperty("mail.smtp.starttls.enable", "true");

        Session session = createSmtpSession();
        session.setDebug(sessionDebug);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(femail));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
// Hand the message to the default transport service
// for delivery.
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
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messagePart);
//            multipart.addBodyPart(attachmentPart);
            System.out.println("Mail Send successfully");
            msg.setContent(Attachment, "text/html");

            Transport.send(msg);
            done = true;
        } catch (MessagingException mex) {
            done = false;
            System.out.println("Mail Dose Not Send.....");
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
}