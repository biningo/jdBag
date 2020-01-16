package biningo.foreign_trade.service.impl;

import biningo.foreign_trade.entity.goods.Category;
import biningo.foreign_trade.entity.goods.Commodity;
import biningo.foreign_trade.repository.CategoryRepository;
import biningo.foreign_trade.repository.CommodityRepository;
import biningo.foreign_trade.service.GoodsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Resource
    CategoryRepository categoryRepository;
    @Resource
    CommodityRepository commodityRepository;



    //======================分类操作
    @Override
    public List<Category> GetAllCategory() {

//        ValueOperations<String,List<Category>> Cache = redisTemplate.opsForValue();
//        List<Category> categories = Cache.get("categories");
//
//        if(categories==null){
//            List<Category> all = categoryRepository.findAll();
//            Cache.set("categories",all);
//            return all;
//        }
//        else
//            return categories;
        return categoryRepository.findAll();
    }

    @Override
    public Category GetCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category SaveCategory(Category category) {

//        //清除缓存
//        redisTemplate.delete("categories");
//        redisTemplate.delete("goods");

        if(category.getId()==null){
            Category save = categoryRepository.save(category);
            return save;
        }
        else {
            Category old = this.GetCategory(category.getId());
            List<Commodity> goodsByCategory = this.findGoodsByCategory(old.getId());
            old.setCategoryName(category.getCategoryName());
            //同时更新goods
            goodsByCategory.forEach(x->x.setCategoryName(category.getCategoryName()));
            return categoryRepository.save(old);
        }


    }

    @Override
    public boolean DeleteCategory(Long id) {

        //清除缓存
//        redisTemplate.delete("categories");
//        redisTemplate.delete("goods");

        List<Commodity> goods = this.findGoodsByCategory(id);
        goods.forEach(x->x.setCategoryName("other"));
        categoryRepository.deleteById(id);
        return false;
    }






//=======查找商品==========



    @Override
    public List<Commodity> GetAllGoods() {

//        ValueOperations<String,List<Commodity>> Cache = redisTemplate.opsForValue();
//        List<Commodity> goods = Cache.get("goods");
//
//        if(goods==null){
            List<Commodity> goods = commodityRepository.findAll();
            goods.sort(new Comparator<Commodity>() {
                @Override
                public int compare(Commodity o1, Commodity o2) {
                    return o2.getDate().compareTo(o1.getDate());
                }
            });

//            Cache.set("goods",all);
//            return all;
//        }
//        else
            return goods;

    }

    @Override
    public List<Commodity> findGoodsByCategoryName(String categoryName){

//        ValueOperations<String,List<Commodity>> Cache = redisTemplate.opsForValue();
//        List<Commodity> goods = Cache.get("goods");
//        if(goods!=null){
//            return goods.stream().filter(x -> x.getCategoryName().equals(categoryName)).collect(Collectors.toList());
//        }
        return commodityRepository.findByCategoryName(categoryName);
    }

    //分页
    @Override
    public Page<Commodity> findGoodsByCategoryName(String categoryName,int page){
        page = page-1;  //0是第一页
        PageRequest pageRequest = PageRequest.of(page, 12);
        if(categoryName.equals("all")){
            Page<Commodity> result = commodityRepository.findAll(pageRequest);
            return result;
        }
        else{
            Page<Commodity> result = commodityRepository.findByCategoryName(categoryName, pageRequest);
            return result;
        }

    }




    @Override
    public List<Commodity> findGoodsByCategory(Long id) {
        String categoryName = categoryRepository.findById(id).get().getCategoryName();
        return commodityRepository.findByCategoryName(categoryName);
    }

    @Override
    public List<Commodity> findGoodsByRecommend(String categoryName){
        List<Commodity> byCategoryName = this.findGoodsByCategoryName(categoryName);
        return byCategoryName.stream().filter(x->x.isRecommend()).collect(Collectors.toList());
    } //基于ByCategorryName





    @Override
    public Commodity findGoodsById(Long id) {
        return commodityRepository.findById(id).get();
    }





//=======保存商品==========
    @Override
    public Commodity SaveCommodity(Commodity commodity) {


      return commodityRepository.save(commodity);
    }


//=====删除商品==========
    @Override
    public void deleteCommodity(Long id) {

        commodityRepository.deleteById(id);
    }



}
