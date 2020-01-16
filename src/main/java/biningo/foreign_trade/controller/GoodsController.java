package biningo.foreign_trade.controller;

import biningo.foreign_trade.entity.goods.Category;
import biningo.foreign_trade.entity.goods.Commodity;
import biningo.foreign_trade.service.impl.GoodsServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    GoodsServiceImpl goodsService;



    //============分类操作============
    @RequestMapping("/categories")
    public List<Category> GetCategories(){

        return goodsService.GetAllCategory();
    }
    @RequestMapping("/savecategory")
    public Category Save(Category category){

        return goodsService.SaveCategory(category);
    }
    @RequestMapping("deletecategory")
    public boolean DeleteCategory(Long id){
        goodsService.DeleteCategory(id);
        return true;
    }


    //======商品操作============
    @RequestMapping("/goods")
    List<Commodity> GetAllGoods(){


        return goodsService.GetAllGoods();
    }

    @RequestMapping("/goods/recommend")
    List<Commodity> GetGoodsByRecommend(String category){

       return goodsService.findGoodsByRecommend(category);
    }

    @RequestMapping("/goods/bycategory")
    Page<Commodity> GetGoodsByCategory(HttpServletResponse response, String category, int page){

        Page<Commodity> result = goodsService.findGoodsByCategoryName(category, page);


        return result;  //totalPages content
    }



    @RequestMapping("/goods/byid")
    Commodity GetGoodsById(Long id){

        return goodsService.findGoodsById(id);
    }

    @RequestMapping("/savegoods")
    Commodity SaveCommodity(Commodity commodity){
        DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        commodity.setDate(format);
        return goodsService.SaveCommodity(commodity);
    }

    @RequestMapping("/deletegoods")
    public boolean DeleteGoods(Long id){
        goodsService.deleteCommodity(id);
        return true;
    }













}
