package biningo.foreign_trade.controller.ControllerAdvice;

import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class BadController {

    @ExceptionHandler(MailException.class)
    @ResponseBody
    public String EmailNotSend(MailException e){
        System.out.println(e.getMessage());
        return "Bad";
    }

}
