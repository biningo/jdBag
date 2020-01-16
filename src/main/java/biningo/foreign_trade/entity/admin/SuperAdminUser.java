package biningo.foreign_trade.entity.admin;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ConfigurationProperties(prefix = "admin")
@Data
public class SuperAdminUser implements Serializable {
    private String password;
    private String username;

}
