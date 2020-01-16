package biningo.foreign_trade.controller;

import biningo.foreign_trade.entity.other.Poster;
import biningo.foreign_trade.service.impl.OtherServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OtherController {

    @Resource
    OtherServiceImpl otherService;

    @RequestMapping("/poster/save")
    public void SavePoster(Poster poster){

        otherService.SavePoster(poster);

    }

    @RequestMapping("/poster/all")
    public List<Poster> GetPoster(){

        return otherService.GetPoster();
    }

}
