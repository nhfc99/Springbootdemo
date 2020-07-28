package com.nhfc99.template.dao;

import com.nhfc99.template.domain.TunneltestfaultmessageDomain;

public interface TunneltestfaultmessageDomainMapper {
    /**
     *
     * @mbggenerated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insert(TunneltestfaultmessageDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int insertSelective(TunneltestfaultmessageDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    TunneltestfaultmessageDomain selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKeySelective(TunneltestfaultmessageDomain record);

    /**
     *
     * @mbggenerated 2020-05-27
     */
    int updateByPrimaryKey(TunneltestfaultmessageDomain record);
}