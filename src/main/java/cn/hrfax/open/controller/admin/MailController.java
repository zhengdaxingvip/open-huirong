package cn.hrfax.open.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mail")
@Controller
public class MailController {



    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/send")
    @ResponseBody
    public void send() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("smallfatter@yeah.net");
        msg.setBcc();
        msg.setTo("huangdaosheng@hrfax.cn");
        msg.setSubject("Java技术栈投稿");
        msg.setText("技术分享");
        try {
            javaMailSender.send(msg);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
