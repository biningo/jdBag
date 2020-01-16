package biningo.foreign_trade.service;

import biningo.foreign_trade.entity.other.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    public Optional<Message> GetMessage(Long id);

    public List<Message> GetAll();

    public boolean SaveMessage(Message message);



    public boolean DeleteMessage(Long id);

}
