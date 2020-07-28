package com.nhfc99.template.dao;

import com.nhfc99.template.domain.VoicecommandDomain;
import com.nhfc99.template.vo.VoiceSystemCommandVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface VoicecommandDomainMapper {
    /**
     *
     * @mbggenerated 2020-06-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2020-06-18
     */
    int insert(VoicecommandDomain record);

    /**
     *
     * @mbggenerated 2020-06-18
     */
    int insertSelective(VoicecommandDomain record);

    /**
     * 插入语音和内部指令的记录
     * @param record
     * @return
     */
    int insertSelectiveVoiceSystemCommandVo(VoiceSystemCommandVo record);

    /**
     *
     * @mbggenerated 2020-06-18
     */
    VoicecommandDomain selectByPrimaryKey(Long id);

    /**
     * 获取所有记录
     * @return
     */
    ArrayList<VoiceSystemCommandVo> selectAll();

    /**
     * 通过vcommand
     * @return
     */
    ArrayList<VoiceSystemCommandVo> selectByVCommand(String vcommand);

    /**
     *
     * @mbggenerated 2020-06-18
     */
    int updateByPrimaryKeySelective(VoicecommandDomain record);

    /**
     *
     * @mbggenerated 2020-06-18
     */
    int updateByPrimaryKey(VoicecommandDomain record);
}