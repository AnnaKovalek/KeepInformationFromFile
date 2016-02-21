package Test;


import org.apache.commons.mail.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateSendMail {

    public boolean init(String path) {
        boolean flag = true;
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("ykresp@gmail.com", "2687484a"));
            email.setTLS(true);
            email.setFrom("ykresp@gmail.com");
            //
            email.setSubject("TrueConf report " + data());

            //
            email.setMsg("Hello World");
            email.attach(attach(path));
            email.addTo("anna.kovalek@gmail.com");
            email.send();
        } catch (EmailException ex) {
            ex.printStackTrace();
            flag = false;
        } finally {
            return flag;
        }
    }

    private EmailAttachment attach(String path) {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(path);
        return attachment;
    }

    private String data() {
        Date date = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd_MM_yyyy");
        return format1.format(date);

    }

}
