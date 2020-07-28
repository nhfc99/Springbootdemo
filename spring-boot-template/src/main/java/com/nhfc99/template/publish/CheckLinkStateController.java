package com.nhfc99.template.publish;

import com.nhfc99.template.service.CheckLinkStateService;
import com.nhfc99.template.service.SocketClientInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "检测系统socket和websocket连接状态")
@RequestMapping("/api/deviceipinfo")
@Slf4j
public class CheckLinkStateController {
    @Autowired
    CheckLinkStateService checkLinkStateService;

    @GetMapping("/socketinfo")
    @ResponseBody
    @ApiOperation("获取socket连接数以及连接的哪些socket")
    public SocketClientInfoVo getList() {
        SocketClientInfoVo socketClientInfoVo = new SocketClientInfoVo();
        socketClientInfoVo.setSocketsMap(checkLinkStateService.getSocketInfo());
        socketClientInfoVo.setSockets(checkLinkStateService.getSocketInfoName());
        socketClientInfoVo.setWebsockets(checkLinkStateService.webSocketInfo());
        log.info("socketinfo = " + socketClientInfoVo);
        return socketClientInfoVo;
    }
}
