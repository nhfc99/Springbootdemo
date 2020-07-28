package com.nhfc99.template.service;

import com.nhfc99.template.dao.SystemcommandDomainMapper;
import com.nhfc99.template.dao.VoicecommandDomainMapper;
import com.nhfc99.template.domain.SystemcommandDomain;
import com.nhfc99.template.domain.VoicecommandDomain;
import com.nhfc99.template.vo.VoiceSystemCommandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class VoicecommandService {
    @Autowired
    VoicecommandDomainMapper voicecommandDomainMapper;

    @Autowired
    SystemcommandDomainMapper systemcommandDomainMapper;

    public ArrayList<VoiceSystemCommandVo> selectAll() {
        return voicecommandDomainMapper.selectAll();
    }

    public ArrayList<VoiceSystemCommandVo> selectByVCommand(String vcommand) {
        return voicecommandDomainMapper.selectByVCommand(vcommand);
    }

    public int updateByPrimaryKeySelective(VoicecommandDomain record) {
        return voicecommandDomainMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteByPrimaryKey(Long id) {
        return voicecommandDomainMapper.deleteByPrimaryKey(id);
    }

    public int insert(VoicecommandDomain record) {
        return voicecommandDomainMapper.insertSelective(record);
    }

    @Transactional
    public int insertVoiceSystemCommand(VoiceSystemCommandVo record) {
        ArrayList<VoiceSystemCommandVo> voiceSystemCommandVos =
                voicecommandDomainMapper.selectByVCommand(record.getVcommand());
        if (voiceSystemCommandVos.size() > 0) {//语音指令已经存在
            return 0;
        }

        //通过系统指令名称获取一下系统指令在不在，如果存在直接放入id即可，否则新增一条
        SystemcommandDomain systemcommandDomain = null;
        ArrayList<SystemcommandDomain> systemcommandDomains =
                systemcommandDomainMapper.selectBy(null, record.getScommand());
        if (systemcommandDomains.size() > 0) {
            systemcommandDomain = systemcommandDomains.get(0);
        } else {
            systemcommandDomain = new SystemcommandDomain();
            systemcommandDomain.setValue(record.getScommand());
            systemcommandDomain.setMem(record.getSysmem());
            systemcommandDomainMapper.insertSelective(systemcommandDomain);
        }

        VoicecommandDomain voicecommandDomain = new VoicecommandDomain();
        voicecommandDomain.setVcommand(record.getVcommand());
        voicecommandDomain.setSid(String.valueOf(systemcommandDomain.getId()));
        voicecommandDomain.setMem(record.getVoicemem());
        return voicecommandDomainMapper.insertSelective(voicecommandDomain);
    }
}
