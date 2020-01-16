package biningo.foreign_trade.entity.goods;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoryName")
    private String categoryName;


//    @OneToMany(fetch = FetchType.LAZY,targetEntity = Commodity.class,mappedBy = "category",
//            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST})
//    private Set<Commodity> commodities = new HashSet<>();



}
