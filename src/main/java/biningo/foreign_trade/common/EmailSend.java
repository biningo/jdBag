package biningo.foreign_trade.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSend {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMsg(String email,String sendSubject,String sendText) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 邮件发送者，这里不能随便填写，必须是真实的发送邮件的邮箱名称
        mailMessage.setFrom("m19884605250@163.com");
        // 邮件接受者
        mailMessage.setTo(email);
        // 邮件主题
        mailMessage.setSubject(sendSubject);
        // 邮件内容
        mailMessage.setText(sendText);
        // 发送邮件
        mailSender.send(mailMessage);
    }

}
