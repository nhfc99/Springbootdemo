package com.nhfc99.template.publish;

import com.nhfc99.template.service.ThirdTunnelInfoService;
import com.nhfc99.template.utils.JSONResult;
import com.nhfc99.template.vo.SecondProgramInfoVo;
import com.nhfc99.template.vo.ThirdTunnelInfoVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "3屏接口模块")
@RequestMapping("/api/third")
public class ThirdController {

    @Autowired
    ThirdTunnelInfoService thirdTunnelInfoService;

    @ApiOperation("当前data指定隧道的数据信息")
    @GetMapping("/tunnelInfo")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data", dataType = "String", paramType = "query", required = false, value = "项目名称")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "正常返回数据 SecondProgramInfoVo", response = SecondProgramInfoVo.class)
    })
    public Object getThirdTunnelInfo(@RequestParam("data") String data) {
        if (data.length() == 0) {
            return JSONResult.failed("请输入项目名称");
        }
        return thirdTunnelInfoService.getThirdTunnelInfo(data);
    }
}
