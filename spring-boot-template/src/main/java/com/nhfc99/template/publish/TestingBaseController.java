package com.nhfc99.template.publish;

import com.nhfc99.template.domain.TestingbaseDomain;
import com.nhfc99.template.service.TestingBaseService;
import com.nhfc99.template.vo.TestingBaseUpdateTitleVo;
import com.nhfc99.template.vo.TestingBaseVo;
import com.nhfc99.template.vo.TestingbaseDomainAllVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Api(tags = "检测基地")
@RestController
@RequestMapping("/api/testingBase")
public class TestingBaseController {
    @Autowired
    TestingBaseService testingBaseService;

    @ResponseBody
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功", response = Boolean.class)
    })
    @ApiOperation("新增工作列表")
    @PostMapping("/add")
    public Object insert(@RequestBody TestingBaseVo testingBaseVo) {
        return testingBaseService.insert(testingBaseVo);
    }

    @ResponseBody
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功", response = Boolean.class)
    })
    @ApiOperation("更新信息")
    @PostMapping("/update")
    public Object updateTitle(@RequestBody TestingbaseDomain testingbaseDomain) {
        return testingBaseService.update(testingbaseDomain);
    }

    @ResponseBody
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功", response = Boolean.class)
    })
    @ApiOperation("获取所有数据")
    @PostMapping("/all")
    public ArrayList<TestingbaseDomainAllVo> selectAll() {
        return testingBaseService.selectAll();
    }
}













