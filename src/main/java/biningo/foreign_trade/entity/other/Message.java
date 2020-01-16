package biningo.foreign_trade.entity.other;

import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String contact;

    private String date;

    @Column(length = 10000)
    private String content;


    private String visit;


}
