package com.nhfc99.template.publish;

import com.nhfc99.template.service.SecondService;
import com.nhfc99.template.utils.JSONResult;
import com.nhfc99.template.vo.SecondProgramInfoVo;
import com.nhfc99.template.vo.SecondTestingBaseVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "2屏接口模块")
@RequestMapping("/api/second")
public class SecondController {

    @Autowired
    SecondService secondService;

    @ApiOperation("当前data指定项目部的数据信息")
    @GetMapping("/programInfo")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data", dataType = "String", paramType = "query", required = false, value = "项目名称")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "正常返回数据 SecondProgramInfoVo", response = SecondProgramInfoVo.class)
    })
    public Object getProgramInfo(@RequestParam("data") String data) {
        if (data.length() == 0) {
            return JSONResult.failed("请输入项目名称");
        }
        return secondService.getProgramInfo(data);
    }

    @ApiOperation("检测基地基础信息")
    @GetMapping("/testingBase")
    @ResponseBody
    @ApiResponses({
            @ApiResponse(code = 0, message = "正常返回数据 SecondTestingBaseVo", response = SecondTestingBaseVo.class)
    })
    public SecondTestingBaseVo getTestingBase() {
        return secondService.getTestingBase();
    }
}