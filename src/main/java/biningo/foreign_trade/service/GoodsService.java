package biningo.foreign_trade.service;

import biningo.foreign_trade.entity.goods.Category;
import biningo.foreign_trade.entity.goods.Commodity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GoodsService {

//===============分类相关===========
    List<Category> GetAllCategory();
    Category GetCategory(Long id);
    Category SaveCategory(Category category);
    boolean DeleteCategory(Long id);


    //==============商品相关==============

//查
    Commodity findGoodsById(Long id);
    List<Commodity> GetAllGoods();
    List<Commodity> findGoodsByCategory(Long id);
    List<Commodity> findGoodsByCategoryName(String categoryName);
    Page<Commodity> findGoodsByCategoryName(String categoryName,int page);
    List<Commodity> findGoodsByRecommend(String categoryName);
//增加
    Commodity SaveCommodity(Commodity commodity);  //增加商品

//删除
    void deleteCommodity(Long id);







//    Page<Commodity> findByKeyWords(String keyWords,Pageable pageRequest);  //根据关键词查找
//    Page<Commodity> findByCategory(Long categoryId,Pageable pageRequest); //根据分类查找
//    Page<Commodity> findAll(Pageable pageRequest);



}
