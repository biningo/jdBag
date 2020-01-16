package biningo.foreign_trade.service.impl;

import biningo.foreign_trade.entity.other.Message;
import biningo.foreign_trade.repository.MessageRepository;
import biningo.foreign_trade.service.MessageService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    MessageRepository messageRepository;

    @Override
    public Optional<Message> GetMessage(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> GetAll() {


        List<Message> all = messageRepository.findAll();
        all.sort(new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });
        return all;
    }

    @Override
    public boolean SaveMessage(Message message) {


        if(message.getId()==null)  //新的留言
            messageRepository.save(message);
        else {  //已经阅读了
            Message msg = messageRepository.findById(message.getId()).get();
            msg.setVisit("已读");
            messageRepository.save(msg);
        }
        return true;
    }




    @Override
    public boolean DeleteMessage(Long id) {
        messageRepository.deleteById(id);
        return true;
    }
}
