package com.nhfc99.template.publish;

import com.nhfc99.template.domain.SystemcommandDomain;
import com.nhfc99.template.domain.VoicecommandDomain;
import com.nhfc99.template.service.SystemCommandService;
import com.nhfc99.template.vo.DelVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(tags = "系统内部指令")
@RequestMapping("/api/systemcommand")
@RestController
public class SystemCommandController {

    @Autowired
    SystemCommandService systemCommandService;

    @ApiOperation("获取所有指令列表")
    @ApiResponses({
            @ApiResponse(code = 0, message = "列表", response = SystemcommandDomain.class)
    })
    @GetMapping("/all")
    @ResponseBody
    public ArrayList<SystemcommandDomain> selectAll() {
        return systemCommandService.selectAll();
    }

    @ApiOperation("通过id或value获取指令列表")
    @GetMapping("/get")
    @ApiResponses({
            @ApiResponse(code = 0, message = "列表", response = SystemcommandDomain.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "systemcommandDomain", value = "SystemcommandDomain", required = false)
    })
    public Object selectBy(@RequestParam("systemcommandDomain") SystemcommandDomain systemcommandDomain) {
        return systemCommandService.selectBy(systemcommandDomain.getId(), systemcommandDomain.getValue());
    }

    @ApiOperation("添加指令")
    @PostMapping("/add")
    public Object insert(@Validated @RequestBody SystemcommandDomain systemcommandDomain) {
        return systemCommandService.insert(systemcommandDomain);
    }

    @ApiOperation("删除指令")
    @PostMapping("/del")
    public int deleteByPrimaryKey(@Validated @RequestBody DelVo delVo) {
        return systemCommandService.deleteByPrimaryKey(delVo.getId());
    }

    @ApiOperation("更新指定语音的记录")
    @PostMapping("/update")
    public int updateByPrimaryKeySelective(@Validated @RequestBody SystemcommandDomain systemcommandDomain) {
        return systemCommandService.updateByPrimaryKeySelective(systemcommandDomain);
    }
}
