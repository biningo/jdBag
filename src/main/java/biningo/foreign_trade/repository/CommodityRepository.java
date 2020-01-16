package biningo.foreign_trade.repository;

import biningo.foreign_trade.entity.goods.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;


public interface CommodityRepository extends JpaRepository<Commodity,Long>, JpaSpecificationExecutor<Commodity> {

    List<Commodity> findByCategoryName(String categoryName);
    Page<Commodity> findByCategoryName(String categoryName, Pageable pageable);


}
