package com.nhfc99.template.dao;

import com.nhfc99.template.domain.TunneltestlinedetailDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TunneltestlinedetailDomainMapper {
    /**
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbggenerated 2020-05-27
     */
    int insert(TunneltestlinedetailDomain record);

    /**
     * @mbggenerated 2020-05-27
     */
    int insertSelective(TunneltestlinedetailDomain record);

    /**
     * @mbggenerated 2020-05-27
     */
    TunneltestlinedetailDomain selectByPrimaryKey(String id);

    /**
     * 通过项目编号、隧道编号
     *
     * @param projectInfoId
     * @param tunnelInfoId
     * @return
     */
    TunneltestlinedetailDomain selectBy(@Param("projectInfoId") String projectInfoId,
                                        @Param("tunnelInfoId") String tunnelInfoId);

    /**
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(TunneltestlinedetailDomain record);

    /**
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(TunneltestlinedetailDomain record);
}