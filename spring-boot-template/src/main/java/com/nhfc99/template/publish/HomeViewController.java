package com.nhfc99.template.publish;

import com.nhfc99.template.pojo.DataCalculatDomain;
import com.nhfc99.template.pojo.VrstaffExtaDomain;
import com.nhfc99.template.service.AreaprojecttunnelinfotestfaultService;
import com.nhfc99.template.service.HomeViewService;
import com.nhfc99.template.vo.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;

@RestController
@Api(tags = "首页接口模块")
@RequestMapping("/api/home")
public class HomeViewController {
    @Autowired
    HomeViewService homeViewService;

    @Autowired
    AreaprojecttunnelinfotestfaultService areaprojecttunnelinfotestfaultService;

    @ApiOperation("工程检测中心基础信息 - 接口1")
    @GetMapping("baseInfo")
    @ResponseBody
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "正常返回数据 HomeTestingCenterVo", response = HomeTestingCenterVo.class)
    })
    public HomeTestingCenterVo baseInfo() {
        HomeTestingCenterVo homeTestingCenterVo = homeViewService.getData();
        //临时处理
        ArrayList<VrstaffExtaDomain> staff = homeTestingCenterVo.staff;
        for (VrstaffExtaDomain vrstaffExtaDomain :
                staff) {
            vrstaffExtaDomain.details = "{\"face\":\"/videos/person.mp4\",\"company\":\"中铁十二局集团第二工程有限公司工程检测中心\",\"jobs\":[\"工程检测中心总经理\",\"注册结构工程师\",\"探地地质雷达工程师\",\"隧道岩土工程师\"],\"political\":\"中共党员\",\"sex\":\"男\",\"nativeplace\":\"黑龙江\",\"birthday\":\"1986年05月06日\",\"idcard\":\"123456789123456789\",\"university\":\"黑龙江工程学院/土木工程系\",\"certificateid\":\"1566656541613\",\"workhistory\":[{\"times\":\"2019-2020\",\"history\":\"中铁十二局集团第二工程有限公司工程检测中心质量检测员\"},{\"times\":\"2019-2020\",\"history\":\"中铁十二局集团第二工程有限公司工程检测中心质量检测员\"},{\"times\":\"2019-2020\",\"history\":\"中铁十二局集团第二工程有限公司工程检测中心质量检测员\"},{\"times\":\"2019-2020\",\"history\":\"中铁十二局集团第二工程有限公司工程检测中心质量检测员\"}],\"evaluation\":\"值班人员要自觉树立从事安保工作的光荣感和责任心,注意培养爱岗敬业的职业精神,无私无畏的道德、品行,主动热情的服务意识,精明强悍的防卫本领,努力做有道德、守纪律、肯奉献的值班人员。门卫值班人员在自觉、自律的基础上,必须接受相关的专业培训方可上岗。要珍惜岗位,钻研业务,除能胜任日常的门卫安保工作外,还应正确保管和使用消防器材、警务器具等,要具备一定的安保救防知识和应对突发事件的能力。门卫值班人员要坚持文明值班,树立良好形象。注意保持仪容仪表的端庄整洁和值班室的卫生,严禁在值班室内吸烟。要注意文明用语、微笑服务。必须认真履行职责,加强责任感,保持警惕,按时上岗,不得擅自离岗,做到在岗期间不迟到、不早退、不打瞌睡、不串岗闲聊、不干私活、不会私客、不准与行内外人员发生争执、谩骂,动粗斗殴。日常保卫实施24小时值班,值班人员必须认真做好值班记录,做好交接班手续。及时发现各种事故隐患,在工作时间不得喝酒和聚众娱乐,如有急事应提前跟领导汇报经批准后方可替岗,严禁空岗或漏岗现象发生。门卫值班人员要严格执行支行各项制度,如:《来人登记制度》、《车辆进出登记制度》等,对因公来行人员,要使用礼貌用语,热情接待,对不熟悉人员车辆到访,可向来访人员询问后给受访人员电话通知,确认后方可进入。对私自擅入人员,要坚持原则,坚决劝阻,把好大门,对个别社会闲杂人员混入支行,要坚决制止,切实维护支行正常工作秩序。门卫值班人员要加强行内办公场所巡视,特别是夜间巡逻,要注意各类门窗、电器、水电煤开关的关闭。要及时做好巡视记录及整改工作,要确保安全无事故。住宅小区保安员岗位职责 1、负责住宅区内值勤巡逻任务，着装整齐，值勤中不准擅离岗位、不准嬉笑打闹，不准看书报杂志、吃东西、睡觉或进行其它与值勤职责无关的事。 2、保安人员实行24小时值勤巡逻及大门的守卫工作，认真做好交接班签验手续，交接班时移交清楚，责任明确。 3、负责小区消防设施及公用设施的监护与督查，区内治安案件的处理和处罚，涉及违法的案件及时移交公安机关处理; 4、负责对住宅区内机动车停车场的管理，做到文明值勤、合理收费、值班守时、服务规范; 5、认真检查出入车辆，指挥车辆按规定位置停放，不准乱停乱放，确保通道畅通无阻，避免造成交通堵塞。\",\"skills\":[{\"title\":\"美国劳雷SR-3000\",\"img\":\"imgs/p10/30a12fdb-4962-4241-89a1-4a36ee8c2520.png\",\"explain\":\"这个团队的名声、专业技能才信誉都是无可匹敌的。<br>IT'S A TEAM UNRIVALLED IN STATURE,EXPERTISE AND CREDIBILITY.\"},{\"title\":\"美国劳雷SR-3000\",\"img\":\"imgs/p10/30a12fdb-4962-4241-89a1-4a36ee8c2520.png\",\"explain\":\"这个团队的名声、专业技能才信誉都是无可匹敌的。<br>IT'S A TEAM UNRIVALLED IN STATURE,EXPERTISE AND CREDIBILITY.\"},{\"title\":\"美国劳雷SR-3000\",\"img\":\"imgs/p10/30a12fdb-4962-4241-89a1-4a36ee8c2520.png\",\"explain\":\"这个团队的名声、专业技能才信誉都是无可匹敌的。<br>IT'S A TEAM UNRIVALLED IN STATURE,EXPERTISE AND CREDIBILITY.\"},{\"title\":\"美国劳雷SR-3000\",\"img\":\"imgs/p10/30a12fdb-4962-4241-89a1-4a36ee8c2520.png\",\"explain\":\"这个团队的名声、专业技能才信誉都是无可匹敌的。<br>IT'S A TEAM UNRIVALLED IN STATURE,EXPERTISE AND CREDIBILITY.\"}],\"certificates\":[{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"}],\"honors\":[{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"},{\"title\":\"勘查设计注册工程师\",\"img\":\"imgs/p10/20200626141100.png\",\"issueunit\":\"交通运输部质量工程监督局\",\"time\":\"2019年10月\"}]}";
        }
        return homeTestingCenterVo;
    }

    @ApiOperation("标杆项目部TOP3 - 接口2")
    @GetMapping("benchmarkProject")
    @ResponseBody
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "正常返回数据 ArrayList<HomeBenchmarkProjectVo>", response = HomeBenchmarkProjectVo.class)
    })
    public ArrayList<HomeBenchmarkProjectVo> benchmarkProject() {
        return homeViewService.getBenchmarkProject();
    }

    @ApiOperation("项目部及所辖隧道名称列表 - 接口3")
    @GetMapping("programsAndTunnels")
    @ResponseBody
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "正常返回数据对象 HomeProgramsAndTunnelsVo", response = HomeProgramsAndTunnelsVo.class)
    })
    public HomeProgramsAndTunnelsVo programsAndTunnels() {
        return homeViewService.programsAndTunnels();
    }

    @ApiOperation("项目地图坐标 - 接口4")
    @GetMapping("/programCoordinates")
    @ResponseBody
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "正确返回数据对象 HomeProgramCoordinatesVo", response = HomeProgramCoordinatesVo.class)
    })
    public HomeProgramCoordinatesVo programCoordinates() {
        return homeViewService.programCoordinates();
    }

    @ApiOperation("当前range范围内的隧道质量数据统计 - 接口5")
    @GetMapping("/qualitystatistics")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", dataType = "int", paramType = "query", required = true, value = "类型：1.项目名称 2.隧道名称 3.全国区域 4.其他区域名称"),
            @ApiImplicitParam(name = "data", dataType = "String", paramType = "query", required = false, value = "根据类型填写的数据值")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "正常返回数据 HomeQualityStatisticsVo", response = HomeQualityStatisticsVo.class)
    })
    public Object qualityStatistics(@RequestParam("type") int type, @RequestParam(value = "data", required = false) String data) {
        return areaprojecttunnelinfotestfaultService.qualityStatistics(type, data);
    }

    @ApiOperation("当前range范围内的隧道质量数据统计 - 接口6")
    @GetMapping("/qualityStatisticsForArea")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", dataType = "int", paramType = "query", required = true, value = "类型：1.全国区域 2.其他区域名称"),
            @ApiImplicitParam(name = "data", dataType = "String", paramType = "query", required = false, value = "根据类型填写的数据值")
    })
    public Object qualityStatisticsForArea(@RequestParam("type") int type, @RequestParam(value = "data", required = false) String data) {
        return areaprojecttunnelinfotestfaultService.qualityStatisticsForArea(type, data);
    }
}
