package biningo.foreign_trade.controller;

import biningo.foreign_trade.entity.other.Message;
import biningo.foreign_trade.service.impl.MessageServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

    @Resource
    MessageServiceImpl messageService;


    //所有留言 按时间排序
    @RequestMapping("/overview")
    public List<Message> OverView(){

        return messageService.GetAll(); //按时间排序
    }



    @RequestMapping("/save")
    public boolean Save(Message message){

        message.setVisit("未读");
        DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        message.setDate(format);
        return messageService.SaveMessage(message);
    }



    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public boolean Delete(Long id){

        messageService.DeleteMessage(id);
        return true;
    }




}
