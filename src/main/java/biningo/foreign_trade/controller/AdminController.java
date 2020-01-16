package biningo.foreign_trade.controller;

import biningo.foreign_trade.entity.admin.SuperAdminUser;
import net.bytebuddy.utility.RandomString;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Resource
    SuperAdminUser adminUser;

    @Resource
    RedisTemplate redisTemplate;

    @RequestMapping(value="/login",method = {RequestMethod.POST})
    public String Login( HttpServletResponse response, SuperAdminUser adminUser){


        if(this.adminUser.equals(adminUser)){

            String token= RandomString.make(20);
            redisTemplate.opsForValue().set("token",token,7, TimeUnit.DAYS);

            return token;
        }else{
            response.setStatus(401);
            return "";
        }


    }


    @RequestMapping(value = "/check")  //获取token返回给前端  前端验证是否过期
    public String getToken(HttpServletResponse response){

        String t = (String) redisTemplate.opsForValue().get("token");
//        System.out.println(t);
        if(t==null){
            response.setStatus(401);
            return "";
        }else{
            return t;
        }

    }







}
