package biningo.foreign_trade;

import biningo.foreign_trade.entity.goods.Category;
import biningo.foreign_trade.entity.goods.Commodity;
import biningo.foreign_trade.entity.other.Message;
import biningo.foreign_trade.repository.CategoryRepository;
import biningo.foreign_trade.repository.CommodityRepository;
import biningo.foreign_trade.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@SpringBootTest
@EnableTransactionManagement
class ForeignTradeApplicationTests {

    @Autowired
    CommodityRepository commodityRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    MessageRepository messageRepository;

    @Test
    @Transactional
    @Rollback(false)
    void contextLoads() {



    }

}
