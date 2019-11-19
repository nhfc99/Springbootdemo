package com.nhfc99.template.Publish;

import com.nhfc99.template.Vo.UserInfoVo;
import org.slf4j.Logger;
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

    @GetMapping("/list")
    @ResponseBody
//    public PR list(@RequestParam("name") String name) {
//        logger.info("test log");
//        return PR.ok("成功");
//    }
    public Object list(@RequestParam("name") String name) {
        logger.info("test log");
//        return PR.ok(this.des);
//        Map<String, String> map = new HashMap();
//        map.put("key", "value");
//        return map;
        return this.des;
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
