package com.nhfc99.template.publish;

import com.nhfc99.template.domain.SystemcommandDomain;
import com.nhfc99.template.service.TestService;
import com.nhfc99.template.vo.StringVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Api(tags = "测试")
@RequestMapping("/api/test")
@RestController
public class TestController {
    @Autowired
    TestService testService;

    @ResponseBody
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功", response = Boolean.class)
    })
    @ApiOperation("发送文本语音指令")
    @PostMapping("/testplay")
    public Object testPlay(@Validated @RequestBody StringVo stringVo) throws IOException, InterruptedException {
        testService.sendMessage(stringVo.getMessage());
        return true;
    }
}
