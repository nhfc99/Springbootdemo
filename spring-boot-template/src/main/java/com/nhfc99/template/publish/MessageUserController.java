package com.nhfc99.template.publish;

import com.nhfc99.template.domain.MessageUserDomain;
import com.nhfc99.template.service.MessageUserService;
import com.nhfc99.template.vo.DelVo;
import com.nhfc99.template.vo.MessageUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Api(tags = "用户信息")
@RestController
@RequestMapping("/api/messageuser")
public class MessageUserController {
    @Autowired
    MessageUserService messageUserService;

    @ApiOperation("返回信息用户列表")
    @GetMapping("/all")
    @ApiResponses({
            @ApiResponse(code = 0, message = "返回信息用户列表", response = MessageUserDomain.class)
    })
    public ArrayList<MessageUserDomain> getAll() {
        return messageUserService.selectAll();
    }

    @ApiOperation("新增用户信息")
    @PostMapping("/insert")
    @ApiResponses({
            @ApiResponse(code = 0, message = "返回是否新增成功", response = boolean.class)
    })
    public Object insert(@Valid @RequestBody MessageUserVo messageUserVo) {
        MessageUserDomain messageUserDomain = new MessageUserDomain();
        messageUserDomain.setName(messageUserVo.getName());
        messageUserDomain.setPhone(messageUserVo.getPhone());
        return messageUserService.insert(messageUserDomain);
    }

    @ApiOperation("删除用户信息")
    @PostMapping("/del")
    @ApiResponses({
            @ApiResponse(code = 0, message = "返回是否删除成功", response = boolean.class)
    })
    public Object delete(@Valid @RequestBody DelVo delVo) {
        return messageUserService.delete(delVo.getId());
    }

    @ApiOperation("发送短信给某个用户")
    @ResponseBody
    @PostMapping("/sendsms")
    public Object sendsms(@RequestBody ArrayList<Long> ids) {
        ArrayList<MessageUserDomain> messageUserDomain = messageUserService.selectByIds(ids);
        return "发送成功";
    }
}

















