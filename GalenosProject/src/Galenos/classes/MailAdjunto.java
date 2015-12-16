/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailAdjunto
{
  private String alerta;
  private String mensaje;
  private String rutaArchivo;
  private String nombreArchivo;

  public void setRutaArchivo(String archivo)
  {
    this.rutaArchivo = archivo;
  }

  public String getRutaArchivo() {
    return this.rutaArchivo;
  }

  public void setNombreArchivo(String nombreArchivo) {
    this.nombreArchivo = nombreArchivo;
  }

  public String getNombreArchivo() {
    return this.nombreArchivo;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public String getMensaje() {
    return this.mensaje;
  }

  public void setAlerta(String alerta) {
    this.alerta = alerta;
  }

  public String getAlerta() {
    return this.alerta;
  }

  public String enviarEmailA()
  {
    try
    {
      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.setProperty("mail.smtp.starttls.enable", "true");
      props.setProperty("mail.smtp.port", "587");
      props.setProperty("mail.smtp.user", "galenos.uc3m@gmail.com");
      props.setProperty("mail.smtp.auth", "true");

      Session session = Session.getDefaultInstance(props, null);

      BodyPart texto = new MimeBodyPart();
      texto.setText(getMensaje());

      System.out.println(getMensaje());
      System.out.println(getRutaArchivo());
      System.out.println(getNombreArchivo());

      BodyPart adjunto = new MimeBodyPart();
      adjunto.setDataHandler(new DataHandler(new FileDataSource(getRutaArchivo())));

      adjunto.setFileName(getNombreArchivo());

      MimeMultipart multiParte = new MimeMultipart();
      multiParte.addBodyPart(texto);
      multiParte.addBodyPart(adjunto);

      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress("gandhi.hernandez.chan@hotmail.es"));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress("galenos.uc3m@gmail.com"));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress("alejandro.rodriguezg@upm.es"));

      message.setSubject("Sending ontologies");

      message.setContent(multiParte);

      Transport t = session.getTransport("smtp");
      t.connect("galenos.uc3m@gmail.com", "100288204");
      t.sendMessage(message, message.getAllRecipients());
      t.close();
      setAlerta("E-Mail Enviado.");
    }
    catch (Exception e)
    {
      setAlerta("Error al enviar el E-Mail");
      e.printStackTrace();
    }
    return getAlerta();
  }
}
