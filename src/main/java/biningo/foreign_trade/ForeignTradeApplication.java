package biningo.foreign_trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ForeignTradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForeignTradeApplication.class, args);
    }

}
