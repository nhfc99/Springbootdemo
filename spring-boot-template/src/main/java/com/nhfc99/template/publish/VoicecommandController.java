package com.nhfc99.template.publish;

import com.nhfc99.template.domain.VoicecommandDomain;
import com.nhfc99.template.service.VoicecommandService;
import com.nhfc99.template.utils.JSONResult;
import com.nhfc99.template.vo.DelVo;
import com.nhfc99.template.vo.VoiceSystemCommandVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(tags = "语音指令和内部指令对应处理")
@RestController
@RequestMapping("/api/voicecommand")
public class VoicecommandController {

    @Autowired
    VoicecommandService voicecommandService;

    @ApiOperation("获取所有的语音和内部指定对照表")
    @GetMapping("/all")
    @ApiResponses({
            @ApiResponse(code = 0, message = "返回List<VoiceSystemCommandVo>", response = VoiceSystemCommandVo.class)
    })
    public ArrayList<VoiceSystemCommandVo> selectAll() {
        return voicecommandService.selectAll();
    }

    @ApiOperation("获取指定语音的记录")
    @GetMapping("/getbyvcommand")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vcommand", value = "传入语音指令", required = true, paramType = "query", dataType = "String")
    })
    public ArrayList<VoiceSystemCommandVo> selectByVCommand(@RequestParam("vcommand") String vcommand) {
        return voicecommandService.selectByVCommand(vcommand);
    }

    @ApiOperation("更新指定语音的记录")
    @PostMapping("/update")
    public int updateByPrimaryKeySelective(@Validated @RequestBody VoicecommandDomain record) {
        return voicecommandService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation("删除指定语音的记录")
    @PostMapping("/del")
    public int deleteByPrimaryKey(@Validated @RequestBody DelVo delVo) {
        return voicecommandService.deleteByPrimaryKey(delVo.getId());
    }

    @ApiOperation("添加语音的记录")
    @PostMapping("/add")
    public int insert(@Validated @RequestBody VoicecommandDomain record) {
        return voicecommandService.insert(record);
    }

    @ApiOperation("添加语音和内部指令的记录")
    @PostMapping("/addvs")
    public Object insertAndSystem(@Validated @RequestBody VoiceSystemCommandVo record) {
        int number = voicecommandService.insertVoiceSystemCommand(record);
        if (number == 0) {
            return JSONResult.failed("指令已存在");
        }
        return true;
    }
}
