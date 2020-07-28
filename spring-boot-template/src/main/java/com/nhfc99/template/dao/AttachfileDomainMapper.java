package com.nhfc99.template.dao;

import com.nhfc99.template.domain.AttachfileDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface AttachfileDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(AttachfileDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(AttachfileDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    AttachfileDomain selectByPrimaryKey(String id);

    /**
     * 附件列表
     * @param dataInfoIds
     * @return
     */
    ArrayList<AttachfileDomain> selectByDataInfoId(ArrayList<String> dataInfoIds);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(AttachfileDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(AttachfileDomain record);
}