package biningo.foreign_trade.repository;

import biningo.foreign_trade.entity.goods.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryRepository extends JpaRepository<Category,Long>, JpaSpecificationExecutor<Category> {
}
