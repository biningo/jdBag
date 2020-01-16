package biningo.foreign_trade.config;

//编码问题


import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.MySQL8Dialect;

public class MysqlConfig extends MySQL8Dialect {
    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
