package biningo.foreign_trade.repository;

import biningo.foreign_trade.entity.goods.Commodity;
import biningo.foreign_trade.entity.other.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MessageRepository extends JpaRepository<Message,Long>, JpaSpecificationExecutor<Message> {

}
