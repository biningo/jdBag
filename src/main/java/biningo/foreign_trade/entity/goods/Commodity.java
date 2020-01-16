package biningo.foreign_trade.entity.goods;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "commodity")
//商品
@Data
public class Commodity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name="date")
    private String date;

    @Column(name = "summary",length = 10000)
    private String summary; //概要文字

    @Column(name = "mainImage")
    private String mainImage;  //主要展示图片  以中文逗号分隔

    @Column(name = "detailImage")
    private String detailImage; //详情图片

//    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Category.class,optional = true,
//            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST})
//    @JoinColumn(name = "category_id",referencedColumnName = "id")
//    @JsonIgnoreProperties(value = "commodities")
//    private Category category;
    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "recommend")
    private boolean recommend;  //是否是推荐


}
