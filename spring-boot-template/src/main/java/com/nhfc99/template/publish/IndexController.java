package com.nhfc99.template.publish;

import com.nhfc99.template.component.annotations.apirequestlog.APIRequestLog;
import com.nhfc99.template.Vo.UserInfoVo;
import com.nhfc99.template.component.redis.RedisUtil;
import com.nhfc99.template.utils.JSONResult;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.beans.ConstructorProperties;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/nhfc99/publish/index")
public class IndexController {
    private static final Logger logger = getLogger(IndexController.class);

    @Value("${activename}")
    String data;

    @Value("${app.description}")
    String des;

    @Autowired
    RedisUtil redisUtil;

    @APIRequestLog
    @GetMapping("/list")
    @ResponseBody
    public Object list(@RequestParam("name") String name) {
        logger.info("test log");
//        return JSONResult.success(this.des);
        return "asdfasdf";
    }

    @APIRequestLog
    @GetMapping("/testredis")
    public Object testRedis() {
        Object value = redisUtil.get("user");
        if (value == null) {
            logger.info("还没有用户信息");
            redisUtil.set("user", "nhfc99");
            int i = 1/0;
            return JSONResult.failed("没有这样的用户信息");
        } else {
            logger.info("已有用户信息");
            redisUtil.del("user");
            return JSONResult.success(value);
        }
    }

    @ConstructorProperties({"years", "ultimateAnswer"})
    public IndexController() {

    }

    @PostMapping("/data")
    @ResponseBody
    public Object showData(@RequestBody UserInfoVo userInfoVo) {
        return userInfoVo;
    }
}
