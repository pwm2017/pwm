package it.unirc.pwm.eureca.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class InvioEmail 
{
	public static void invioEmail(
			String mittente, 
			String password, 
			String destinatario,
			String oggetto,
			String messaggio)
	{

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(mittente, password);
			}
		});

		try 
		{

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mittente));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(destinatario));
			message.setSubject(oggetto);
			message.setText(messaggio);

			Transport.send(message);

			System.out.println("Done");

		} 
		catch (MessagingException e) 
		{
			throw new RuntimeException(e);
		}
	}

}
