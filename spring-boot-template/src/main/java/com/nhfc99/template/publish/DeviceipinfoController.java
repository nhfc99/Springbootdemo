package com.nhfc99.template.publish;

import com.nhfc99.template.config.VRDeviceType;
import com.nhfc99.template.domain.DeviceipinfoDomain;
import com.nhfc99.template.service.DeviceipinfoService;
import com.nhfc99.template.utils.JSONResult;
import com.nhfc99.template.vo.DelVo;
import com.nhfc99.template.vo.DeviceipinfoVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Api(tags = "设备ip管理")
@RestController
@RequestMapping("/api/deviceipinfo")
public class DeviceipinfoController {
    @Autowired
    DeviceipinfoService deviceipinfoService;

    @ApiOperation("插入IP信息")
    @ResponseBody
    @PostMapping("/addinfo")
    @ApiResponses({
            @ApiResponse(code = 0, message = "返回成功", response = boolean.class)
    })
    public Object insert(@RequestBody DeviceipinfoVo deviceipinfoVo) {
        if (deviceipinfoVo.getName().compareTo(VRDeviceType.kVoice) == 0 ||
                deviceipinfoVo.getName().compareTo(VRDeviceType.kPlay) == 0) {
            DeviceipinfoDomain deviceipinfoDomain = new DeviceipinfoDomain();
            deviceipinfoDomain.setName(deviceipinfoVo.getName());
            deviceipinfoDomain.setIp(deviceipinfoVo.getIp());
            deviceipinfoDomain.setPort(deviceipinfoVo.getPort());
            return deviceipinfoService.insert(deviceipinfoDomain);
        }
        return JSONResult.result(1, "设备名称:只能传递voice、play", false);
    }

    @ApiOperation("获取所有的IP信息")
    @ResponseBody
    @GetMapping("/getall")
    @ApiResponses({
            @ApiResponse(code = 0, message = "返回成功", response = DeviceipinfoDomain.class)
    })
    public ArrayList<DeviceipinfoDomain> selectAll() {
        return deviceipinfoService.selectAll();
    }

    @ApiOperation("更新指定的ip")
    @ResponseBody
    @PostMapping("/update")
    @ApiResponses({
            @ApiResponse(code = 0, message = "返回成功", response = boolean.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceipinfoDomain", dataType = "DeviceipinfoDomain", paramType = "body", dataTypeClass = DeviceipinfoDomain.class, required = true)
    })
    public Object update(@RequestBody DeviceipinfoDomain deviceipinfoDomain) {
        return deviceipinfoService.update(deviceipinfoDomain);
    }

    @ApiOperation("删除指定的ip")
    @ResponseBody
    @PostMapping("/delete")
    @ApiResponses({
            @ApiResponse(code = 0, message = "返回成功", response = boolean.class)
    })
    public int delete(@RequestBody DelVo delVo) {
        return deviceipinfoService.delete(delVo.getId());
    }
}
