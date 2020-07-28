package com.nhfc99.template.dao;

import com.nhfc99.template.domain.AreaprojectTunnelinfoTestfaultDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface AreaprojectTunnelinfoTestfaultDomainMapper {

    ArrayList<AreaprojectTunnelinfoTestfaultDomain> selectBy(@Param("ProjectName") String ProjectName,
                                                             @Param("AreaName") String AreaName,
                                                             @Param("TunnelName") String TunnelName);

    /**
     * @mbggenerated 2020-06-23
     */
    int insert(AreaprojectTunnelinfoTestfaultDomain record);

    /**
     * @mbggenerated 2020-06-23
     */
    int insertSelective(AreaprojectTunnelinfoTestfaultDomain record);
}